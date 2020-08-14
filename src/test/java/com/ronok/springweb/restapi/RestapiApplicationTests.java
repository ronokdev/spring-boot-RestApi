package com.ronok.springweb.restapi;

import com.ronok.springweb.restapi.entities.Product;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RestapiApplicationTests {
	@Value("${producttestapi.servic.url}")
	private String productapiurl;

	@Test
	public void testGetProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject(productapiurl+"3",Product.class);
		assertNotNull(product);
		assertEquals("Xioami",product.getName());

	}


	@Test
	public void testCreateProduct()
	{
		RestTemplate restTemplate = new RestTemplate();
		Product product = new Product();
		product.setName("Samsung");
		product.setDescription("This is Samsung Phone");
		product.setPrice(70000);
		Product newProduct = restTemplate.postForObject(productapiurl,product,Product.class);

		assertNotNull(newProduct);
		assertNotNull(newProduct.getId());
		assertEquals("Samsung",newProduct.getName());

		restTemplate.delete(productapiurl+newProduct.getId());



	}

	@Test
	public void updateProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject(productapiurl+"3",Product.class);
		product.setPrice(35000);

		restTemplate.put(productapiurl,product);

	}


	// Test Batch
	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job job;

	@Test
	public void testBatch() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException
	{
		JobParameters jobParameters = new JobParametersBuilder().addLong("time",System.currentTimeMillis()).toJobParameters();
		jobLauncher.run(job,jobParameters);
	}

}
