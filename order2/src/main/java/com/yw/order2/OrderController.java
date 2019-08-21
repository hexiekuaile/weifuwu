package com.yw.order2;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    private final Logger logger = Logger.getLogger(getClass());
    @Qualifier("eurekaRegistration")
    @Autowired
    private Registration registration;  // 服务注册

    @Autowired
    private DiscoveryClient client; // 服务发现客户端

    @Value("${server.port}")
    String port;    //通过这种方式也能获取注册服务的信息
    @Value("${spring.application.name}")
    String serverid;

    @RequestMapping(value = "/order")
    public String order() {
        logger.info("==" + registration.getInstanceId());//registration可以获取注册服务的信息
        logger.info("==被调用了,port:"+port+",serverid: "+serverid);
        return "这是订单2服务 ,port:"+port+",serverid: "+serverid;

    }

}
