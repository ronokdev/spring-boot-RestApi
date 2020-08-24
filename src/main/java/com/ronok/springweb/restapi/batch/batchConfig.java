//package com.ronok.springweb.restapi.batch;
//
//import com.ronok.springweb.restapi.entities.Product;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.item.ItemProcessor;
//import org.springframework.batch.item.ItemReader;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
//import org.springframework.batch.item.database.JdbcBatchItemWriter;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
//import org.springframework.batch.item.file.mapping.DefaultLineMapper;
//import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class batchConfig
//{
//    @Autowired
//    private JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    private StepBuilderFactory stepBuilderFactory;
//
//    @Autowired
//    DataSource dataSource;
//
//    @Bean
//    public Step step()
//    {
//        return stepBuilderFactory.get("step_1").
//                <Product,Product>chunk(3).
//                reader(reader()).
//                processor(processor()).
//                writer(writer()).
//                build();
//    }
//
//    @Bean
//    public Job job()
//    {
//        return jobBuilderFactory.get("job_1").
//                incrementer(new RunIdIncrementer()).
//                start(step()).
//                build();
//    }
//
//    @Bean
//    public ItemReader<Product> reader()
//    {
//        FlatFileItemReader<Product> flatFileItemReader =  new FlatFileItemReader<>(); // Responsible for Reading from the CSV
//        flatFileItemReader.setResource(new ClassPathResource("db_seeds/product.csv"));
//
//        DefaultLineMapper<Product> defaultLineMapper =  new DefaultLineMapper<>(); // Responsible for mapping each line of the CSV file to a Product Object
//
//        DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer(); // Responsible for reading each token separated by COMA(delimiter)
//        delimitedLineTokenizer.setNames("id","name","description","price");
//
//        BeanWrapperFieldSetMapper<Product> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<>(); // Responsible for getting the value from the CSV & setting to respective Class.
//        beanWrapperFieldSetMapper.setTargetType(Product.class);
//
//        defaultLineMapper.setLineTokenizer(delimitedLineTokenizer);
//        defaultLineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);
//
//        flatFileItemReader.setLineMapper(defaultLineMapper);
//
//        return flatFileItemReader;
//    }
//
////    @Bean
//    public ItemProcessor<Product,Product> processor()
//    {
//        return (p)->
//        {
//            p.setPrice(p.getPrice()-p.getPrice()*10/100);
//            return p;
//        };
//    }
//
//    @Bean
//    public ItemWriter<Product> writer()
//    {
//        JdbcBatchItemWriter<Product> jdbcBatchItemWriter = new JdbcBatchItemWriter<>();
//        jdbcBatchItemWriter.setDataSource(dataSource);
//        jdbcBatchItemWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Product>());
//        jdbcBatchItemWriter.setSql("INSERT INTO product(id,name,description,price) VALUES (:id,:name,:description,:price)");
//        return jdbcBatchItemWriter;
//    }
//
////    @Bean
////    public DataSource dataSource()
////    {
////        DriverManagerDataSource dataSource = new DriverManagerDataSource();
////        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
////        dataSource.setUrl("jdbc:mysql://localhost:3306/spring_rest_test");
////        dataSource.setUsername("root");
////        dataSource.setPassword("");
////        return dataSource;
////    }
//
//}
