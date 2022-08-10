package org.dingli.handler;

import lombok.RequiredArgsConstructor;
import org.dingli.entity.MingYueUser;
import org.dingli.service.MingYueService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/** @author ding.li */
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class MingYueUserController {

    private final MingYueService mingYueUserService;


    @GetMapping("/{userId}")
    public Mono<MingYueUser> queryUserById(@PathVariable Long userId) {
        return Mono.just(mingYueUserService.queryUserById(userId));
    }

}
