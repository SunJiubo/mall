package com.nineboy.seckill.configura;

import com.nineboy.seckill.interceptor.LoginRequiredInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class WendaWebConfiguration extends WebMvcConfigurerAdapter {

    @Autowired
    LoginRequiredInterceptor loginRequiredInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(loginRequiredInterceptor).addPathPatterns("/user/*");
        super.addInterceptors(registry);
    }
}

//@Component
//public class WendaWebConfiguration extends WebMvcConfigurationSupport {
//    @Autowired
//    PassportInterceptor passportInterceptor;
//
//    @Autowired
//    LoginRequiredInterceptor loginRequiredInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(passportInterceptor);
//        registry.addInterceptor(loginRequiredInterceptor).addPathPatterns("/user/*");
//        super.addInterceptors(registry);
//    }
//
//}
