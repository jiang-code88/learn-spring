package com.learn._04_advanced._04_bean_lifecycle.conf;

import com.learn._04_advanced._04_bean_lifecycle.bean.prototypeBean.PrototypeBean;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class PrototypeBeanConfiguration {

    @Bean(initMethod = "open", destroyMethod = "close")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public PrototypeBean prototypeBean(){
        PrototypeBean prototypeBean = new PrototypeBean();
        prototypeBean.setName("prototypeBean");
        return prototypeBean;
    }
}
