package com.minimerce.component.order;

import com.minimerce.domain.order.Order;
import com.minimerce.domain.order.detail.OrderDetail;
import com.minimerce.object.order.OrderRequest;
import com.minimerce.support.exception.UnsaleableProductException;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by gemini on 01/04/2017.
 */
@Component
public class OrderMaker {
    private final OrderDetailMaker orderDetailMaker;

    @Inject
    public OrderMaker(OrderDetailMaker orderDetailMaker) {
        this.orderDetailMaker = orderDetailMaker;
    }

    public Order make(Long clientId, OrderRequest request) throws UnsaleableProductException {
        List<OrderDetail> details = orderDetailMaker.make(clientId, request.getCustomerId(), request.getDetails());
        if(request.getPrice() != getPrice(details)) throw new RuntimeException("상품의 가격이 일치하지 않습니다.");

        Order order = new Order();
        order.setClientId(clientId);
        order.setClientOrderId(request.getClientOrderId());
        order.setCustomerId(request.getCustomerId());
        order.setOrderedAt(request.getOrderedAt());
        order.setPrice(request.getPrice());
        order.setDealIds(buildDealIds(details));
        order.setTitle(buildTitle(details));
        order.addDetails(details);
        return order;
    }

    private int getPrice(List<OrderDetail> details) {
        return details.stream().mapToInt(e -> e.getPrice()).sum();
    }

    private String buildTitle(List<OrderDetail> details) {
        return null;
    }

    private String buildDealIds(List<OrderDetail> details) {
        return null;
    }
}
