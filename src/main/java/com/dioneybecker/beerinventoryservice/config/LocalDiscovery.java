package com.dioneybecker.beerinventoryservice.config;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("awsdev")
@EnableDiscoveryClient
@Configuration
public class LocalDiscovery {
    
}
