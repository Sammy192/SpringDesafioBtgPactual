package tech.buildrun.btgpactual.orderms.services;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.buildrun.btgpactual.orderms.controllers.dto.OrderResponse;
import tech.buildrun.btgpactual.orderms.entities.OrderEntity;
import tech.buildrun.btgpactual.orderms.entities.OrderItem;
import tech.buildrun.btgpactual.orderms.listener.dto.OrderCreatedEvent;
import tech.buildrun.btgpactual.orderms.listener.dto.OrderItemEvent;
import tech.buildrun.btgpactual.orderms.repositories.OrderRepository;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

import java.math.BigDecimal;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Transactional
    public void save(OrderCreatedEvent event) {
        OrderEntity entity = new OrderEntity();

        //event.itens().stream().map(i -> entity.getItems().add(new OrderItem(i.produto(), i.quantidade(), i.preco()))).collect(Collectors.toList());

        for (OrderItemEvent orderItem : event.itens()) {
            entity.getItems().add(new OrderItem(orderItem.produto(), orderItem.quantidade(), orderItem.preco()));
        }
        entity.setOrderId(event.codigoPedido());
        entity.setCustomerId(event.codigoCliente());
        entity.setTotal(entity.getTotalOrder());

        orderRepository.save(entity);
    }

    @Transactional(readOnly = true)
    public Page<OrderResponse> findAllByCustomerId(Long customerId, PageRequest pageRequest) {
        Page<OrderEntity> orders = orderRepository.findAllByCustomerId(customerId, pageRequest);

        return orders.map(OrderResponse::fromEntity);
    }

    @Transactional(readOnly = true)
    public BigDecimal findTotalOnOrdersByCustomerId(Long customerId) {
        var aggregations = Aggregation.newAggregation(
                match(Criteria.where("customerId").is(customerId)),
                group().sum("total").as("total")
        );

        var response = mongoTemplate.aggregate(aggregations, "tb_orders", Document.class);

        return new BigDecimal(response.getUniqueMappedResult().get("total").toString());
    }
}
