package tech.buildrun.btgpactual.orderms.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import tech.buildrun.btgpactual.orderms.entities.OrderEntity;

public interface OrderRepository extends MongoRepository<OrderEntity, Long> {
}
