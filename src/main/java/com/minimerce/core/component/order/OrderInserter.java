package com.minimerce.core.component.order;

import com.minimerce.core.domain.order.Order;
import com.minimerce.core.domain.order.OrderRepository;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Created by gemini on 23/05/2017.
 */
@Component
public class OrderInserter {
    private final OrderRepository orderRepository;

    @Inject
    public OrderInserter(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order insert(Order order) {
        return orderRepository.save(order);
    }
}
