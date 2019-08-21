package com.yw.share;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShareController {
    private final Logger logger = Logger.getLogger(getClass());
    @Autowired
    private DiscoveryClient client;
    @RequestMapping(value = "/share")
    public String share() {
        //ServiceInstance instance = client.getLocalServiceInstance();//已不向后兼容
        logger.info("被调用了");
        return "这是分享服务";

    }

}
