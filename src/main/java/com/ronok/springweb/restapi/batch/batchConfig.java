package com.ronok.springweb.restapi.batch;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class batchConfig
{
    @Bean
    public Reader reader()
    {
        return new Reader();
    }

    @Bean
    public Writer writer()
    {
        return new Writer();
    }

    @Bean
    public Processor processor()
    {
        return new Processor();
    }

    @Bean
    public MyJobListener myJobListener()
    {
        return new MyJobListener();
    }
}
