package org.dingli.controller;

import com.alibaba.fastjson.JSON;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.dingli.Vo.UpmsMessageModel;
import org.dingli.aop.User;
import org.dingli.config.ExtRocketMqTemplate;
import org.dingli.service.UserService;
import org.dingli.common.CommonResult;
import org.dingli.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Resource
    UserService userService;

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Resource
    User user;


    @PostMapping("/addUser")
    public String addUser(@RequestBody UserDto userEntity) {
        return userService.add(userEntity.getName(), userEntity.getAge(), userEntity.getHobbies());
    }

    @GetMapping("/getName/{id}")
    public CommonResult<Object> getName(@PathVariable("id") String id) {
        int i = 1 / 0;
        System.out.println(i);
        return CommonResult.success(userService.getName(id));
    }

    @GetMapping("/testAop")
    public Boolean testAop() {
        // 创建一个生产者，并指定一个组名
        UpmsMessageModel model = new UpmsMessageModel();
        model.setUsername("leo");
        model.setPassWord("123");
        model.setMobile("18913302156");
        model.setEmail("839074670@qq.com");
        sendMessage(model);
        log.info("单向发送消息");
        return true;
    }

    private void sendMessage(UpmsMessageModel model) {
        String msgBody = JSON.toJSONString(model);
        DefaultMQProducer producer = new DefaultMQProducer("csm-produce-group",false);
        // 指定Namesrv地址，如果是集群则以分号隔开，例如："name-server1:9876;name-server2:9876"
        producer.setNamesrvAddr("101.35.195.250:9876");
        producer.setSendMsgTimeout(30000);
        try {
            // 启动生产者
            producer.start();
            // 创建一条消息，指定Topic，Tag和消息体
            org.apache.rocketmq.common.message.Message msg = new org.apache.rocketmq.common.message.Message("test02" /* Topic */,
                    "TagA" /* Tag */,
                    (msgBody).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
            );   //（3）
            // 发送消息
            SendResult sendResult = producer.send(msg);

            // 打印发送结果
            System.out.printf(msgBody, sendResult);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭生产者
            producer.shutdown();
        }
    }

    @GetMapping("/testAop2")
    public Boolean testConsumer2() {
        UpmsMessageModel model = new UpmsMessageModel();
        model.setUsername("leo");
        model.setPassWord("123");
        model.setMobile("18913302156");
        model.setEmail("839074670@qq.com");
        Message<String> msgs = MessageBuilder.withPayload(JSON.toJSONString(model))
                //设置消息KEYS,一般是数据的唯一ID,主要用于在仪表盘中方便搜索
                .setHeader("KEYS", "测试")
                .build();
        //给消息打上射手的标签。主题+tag，中间用“:”分隔,主要是用于消息的过滤，比如说在消费的时候，只消费ess标签下的消息
        /*extRocketMqTemplate.sendOneWay("test01:TagA", msgs);*/
        rocketMQTemplate.convertAndSend("test02:TagA", "Hello Word");
        log.info("单向发送消息" + model.toString());
        return true;
    }
}