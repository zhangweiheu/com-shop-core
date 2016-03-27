package com.shop.core.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by 36kr on 16/1/28.
 */
@Configuration
@EnableAutoConfiguration
@Import({MyBatisConfiguration.class})
@ComponentScan(basePackageClasses = {com.shop.core.dao.Pkg.class, com.shop.core.service.Pkg.class})
public class CoreApplication {
}
