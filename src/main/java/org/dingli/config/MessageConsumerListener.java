package org.dingli.config;


import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.dingli.JsonUtil.JsonUtil;
import org.dingli.Vo.SaveOrUpdateUserVO;
import org.dingli.Vo.UpmsMessageModel;
import org.springframework.stereotype.Component;


/**
 * 消息监听
 *
 * @author
 */
@Component
@RocketMQMessageListener(consumerGroup = "csm-consumer-group", topic = "test02", consumeMode = ConsumeMode.ORDERLY)
@Slf4j
public class MessageConsumerListener implements RocketMQListener<String> {


    @Override
    public void onMessage(String message) {

        UpmsMessageModel jsonToBean = JsonUtil.getJsonToBean(message, UpmsMessageModel.class);
        SaveOrUpdateUserVO saveOrUpdateUserVO = new SaveOrUpdateUserVO();
        saveOrUpdateUserVO.setUsername(jsonToBean.getUsername());
        saveOrUpdateUserVO.setPassWord(jsonToBean.getPassWord());
        saveOrUpdateUserVO.setMobile(jsonToBean.getMobile());
        saveOrUpdateUserVO.setEmail(jsonToBean.getEmail());

        System.out.println("测试消费:" + saveOrUpdateUserVO.toString());
    }
}
