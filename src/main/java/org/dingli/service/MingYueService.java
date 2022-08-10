package org.dingli.service;

import org.dingli.entity.MingYueUser;
import reactor.core.publisher.Mono;

/**
 * @author
 */
public interface MingYueService {

    /**
     * 查询
     *
     * @param userId
     * @return
     */
    MingYueUser queryUserById(Long userId);
}
