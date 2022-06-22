package org.dingli.Service;

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
