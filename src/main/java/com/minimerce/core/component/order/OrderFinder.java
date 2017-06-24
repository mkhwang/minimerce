package com.minimerce.core.component.order;

import com.minimerce.core.domain.order.Order;
import com.minimerce.core.domain.order.OrderRepository;
import com.minimerce.core.object.order.FindOrderRequest;
import com.minimerce.core.support.exception.MinimerceException;
import com.minimerce.core.support.response.ErrorCode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Created by gemini on 20/04/2017.
 */
@Component
public class OrderFinder {
    private final OrderRepository orderRepository;

    @Inject
    public OrderFinder(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order findOrder(Long clientId, FindOrderRequest request) {
        Order order = find(clientId, request);
        if(null == order) throw new MinimerceException(ErrorCode.NOT_FOUND_ORDER);
        return order;
    }

    private Order find(Long clientId, FindOrderRequest request) {
        if(request.isFindByOrderId()) return orderRepository.findByClientIdAndId(clientId, request.getOrderId());
        else return orderRepository.findByClientIdAndClientOrderId(clientId, request.getClientOrderId());
    }

    public Page<Order> findOrders(Long clientId, Long customerId, Pageable page) {
        return orderRepository.findByClientIdAndCustomerId(clientId, customerId, page);
    }
}
