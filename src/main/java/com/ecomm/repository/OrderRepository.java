package com.ecomm.repository;


import com.ecomm.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
   List<Order> findOrderByUserId(long userId);
   List<Order> findOrderByProductId(long productId);


}
