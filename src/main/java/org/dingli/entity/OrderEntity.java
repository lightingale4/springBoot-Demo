package org.dingli.entity;

import java.util.Date;

/**
 * @author Administrator
 */
public class OrderEntity {

    private static final long serialVersionUID = -1L;

    private Long id = 12345678L;

    private Date orderDate = new Date();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
