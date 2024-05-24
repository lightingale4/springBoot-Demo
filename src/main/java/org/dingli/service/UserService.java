package org.dingli.service;

/**
 * @author Administrator
 */
public interface UserService {

    /**
     * add users
     *
     * @param name
     * @param age
     * @param hobbies
     * @return
     */
    String add(String name, Integer age, String hobbies);


    /**
     * getId
     *
     * @param id
     * @return
     */
    String getName(String id);


    /**
     * 获取
     *
     * @return
     */
    OrderService getOrderService();
}
