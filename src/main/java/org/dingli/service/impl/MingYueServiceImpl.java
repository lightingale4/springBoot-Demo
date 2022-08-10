package org.dingli.service.impl;


import java.util.HashMap;
import java.util.Map;

import org.dingli.entity.MingYueUser;
import org.dingli.service.MingYueService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/** @author Strive */
@Service
public class MingYueServiceImpl implements MingYueService {

    /** 模拟用户存储 */
    private static final Map<Long, MingYueUser> USER_MAP = new HashMap<Long, MingYueUser>();

    static {
        USER_MAP.put(1L, MingYueUser.builder().userId(1L).username("mingyue").build());
    }

    /**
     * 根据用户ID查询用户信息
     *
     * @param userId 用户ID
     * @return 用户信息
     */
    @Override
    public MingYueUser queryUserById(Long userId) {
        return USER_MAP.get(userId);
    }
}
