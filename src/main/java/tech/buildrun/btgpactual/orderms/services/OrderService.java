package tech.buildrun.btgpactual.orderms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.buildrun.btgpactual.orderms.entities.OrderEntity;
import tech.buildrun.btgpactual.orderms.entities.OrderItem;
import tech.buildrun.btgpactual.orderms.listener.dto.OrderCreatedEvent;
import tech.buildrun.btgpactual.orderms.listener.dto.OrderItemEvent;
import tech.buildrun.btgpactual.orderms.repositories.OrderRepository;

import java.math.BigDecimal;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

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
}
