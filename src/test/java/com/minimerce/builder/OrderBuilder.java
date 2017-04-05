package com.minimerce.builder;

import com.google.common.collect.Lists;
import com.minimerce.domain.order.Order;
import com.minimerce.domain.order.detail.OrderDetail;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by gemini on 04/04/2017.
 */
public final class OrderBuilder {
    protected Long id = 1L;
    protected LocalDateTime createdAt = LocalDateTime.now();
    protected LocalDateTime updatedAt = LocalDateTime.now();
    private Long clientId = 1L;
    private Long clientOrderId = 1L;
    private Long customerId = 1L;
    private String title = "Test Order";
    private int price = 5000;
    private String dealIds = "1,2";
    private LocalDateTime orderedAt = LocalDateTime.now();
    public List<OrderDetail> details = Lists.newArrayList(OrderDetailBuilder.anOrderDetail().build());

    private OrderBuilder() {
    }

    public static OrderBuilder anOrder() {
        return new OrderBuilder();
    }

    public OrderBuilder withClientId(Long clientId) {
        this.clientId = clientId;
        return this;
    }

    public OrderBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public OrderBuilder withClientOrderId(Long clientOrderId) {
        this.clientOrderId = clientOrderId;
        return this;
    }

    public OrderBuilder withCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public OrderBuilder withCustomerId(Long customerId) {
        this.customerId = customerId;
        return this;
    }

    public OrderBuilder withUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public OrderBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public OrderBuilder withPrice(int price) {
        this.price = price;
        return this;
    }

    public OrderBuilder withDealIds(String dealIds) {
        this.dealIds = dealIds;
        return this;
    }

    public OrderBuilder withOrderedAt(LocalDateTime orderedAt) {
        this.orderedAt = orderedAt;
        return this;
    }

    public OrderBuilder withDetails(List<OrderDetail> details) {
        this.details = details;
        return this;
    }

    public Order build() {
        Order order = new Order();
        order.setClientId(clientId);
        order.setId(id);
        order.setClientOrderId(clientOrderId);
        order.setCreatedAt(createdAt);
        order.setCustomerId(customerId);
        order.setUpdatedAt(updatedAt);
        order.setTitle(title);
        order.setPrice(price);
        order.setDealIds(dealIds);
        order.setOrderedAt(orderedAt);
        order.addDetails(details);
        return order;
    }
}
