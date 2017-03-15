package com.op.customer;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CustomerBootstrap
{
    public static void main(String[] args) {
        new SpringApplicationBuilder(CustomerBootstrap.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }
}
