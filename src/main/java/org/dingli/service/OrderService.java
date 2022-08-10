package org.dingli.service;

import org.dingli.entity.OrderEntity;

/**
 * @author ding.li
 *
 */
public interface OrderService {
    /**
     * 添加order
     * @param order
     */
    void addOrder(OrderEntity order);
}
