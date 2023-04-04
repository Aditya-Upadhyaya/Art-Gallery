package com.ecommerce.springboot.dto;

import java.util.Set;

import com.ecommerce.springboot.entity.Address;
import com.ecommerce.springboot.entity.Customer;
import com.ecommerce.springboot.entity.Order;
import com.ecommerce.springboot.entity.OrderItem;

import lombok.Data;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;

}
