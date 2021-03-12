package com.dioneybecker.beerinventoryservice.config;

import com.netflix.appinfo.AmazonInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;



@EnableDiscoveryClient
@Configuration
public class ServiceDiscovery {

    @Bean
    @Autowired
    @Profile("awsdev")
    public EurekaInstanceConfigBean eurekaInstanceConfigBean(InetUtils inetUtils) {
        EurekaInstanceConfigBean config = new EurekaInstanceConfigBean(inetUtils);
        AmazonInfo info = AmazonInfo.Builder.newBuilder().autoBuild("eureka");
        config.setHostname(info.get(AmazonInfo.MetaDataKey.publicHostname));
        config.setIpAddress(info.get(AmazonInfo.MetaDataKey.publicIpv4));
        config.setDataCenterInfo(info);
        return config;      
    }
    
}

