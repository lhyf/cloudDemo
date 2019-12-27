package org.lhyf.cloud;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

import java.util.Iterator;

/**
 * @author yangfan
 * @date 2019/12/27 11:23
 * @Description
 */
public class MyApplicationContextInitializer implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {

        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        MutablePropertySources propertySources = environment.getPropertySources();

        Iterator<PropertySource<?>> iterator = propertySources.iterator();
        while (iterator.hasNext()){
            PropertySource<?> propertySource = iterator.next();
            Object source = propertySource.getSource();
            System.out.println(propertySource);
        }

    }
}
