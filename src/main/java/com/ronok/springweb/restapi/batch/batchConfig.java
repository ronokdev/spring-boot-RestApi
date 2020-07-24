package com.ronok.springweb.restapi.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class batchConfig
{

    private StepBuilderFactory stepBuilderFactory;
    private JobBuilderFactory jobBuilderFactory;

    @Bean
    public Job job()
    {
        return jobBuilderFactory.get("job_1")
                .incrementer(new RunIdIncrementer()) //create a new ID for every JOB
                .listener(myJobListener()) //
                .start(step())
                .build(); // create a new JOB
    }

    @Bean
    public Step step()
    {
        return stepBuilderFactory.get("step_1")
                .<String,String>chunk(1)
                .reader(reader())
                .writer(writer())
                .processor(processor())
                .build();
    }


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
