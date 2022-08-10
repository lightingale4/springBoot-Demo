package org.dingli.service.impl;

import org.dingli.service.OrderService;
import org.dingli.entity.OrderEntity;
import org.springframework.stereotype.Service;

/**
 * @author ding.li
 */
@Service
public class OrderServiceImpl implements OrderService {


    @Override
    public void addOrder(OrderEntity order) {
        System.out.println("增加订单");
    }
}
