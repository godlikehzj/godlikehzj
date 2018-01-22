package com.godlikehzj.dubbo.provider;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(value = "provider.xml")
public class DubboConfig {
}
