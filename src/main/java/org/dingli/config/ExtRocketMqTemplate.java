package org.dingli.config;


import org.apache.rocketmq.spring.annotation.ExtRocketMQTemplateConfiguration;
import org.apache.rocketmq.spring.core.RocketMQTemplate;

/**
 * rocketMq
 *
 * @author
 */
@ExtRocketMQTemplateConfiguration(nameServer = "${rocketmq.name-server}",
        group = "${rocketmq.producers.group}")
public class ExtRocketMqTemplate extends RocketMQTemplate {

}
