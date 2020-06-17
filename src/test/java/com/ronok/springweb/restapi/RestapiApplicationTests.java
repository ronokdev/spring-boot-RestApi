package com.ronok.springweb.restapi;

import com.ronok.springweb.restapi.entities.Product;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RestapiApplicationTests {

	@Test
	public void testGetProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject("http://localhost:8080/springbootapi/products/3",Product.class);
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
		Product newProduct = restTemplate.postForObject("http://localhost:8080/springbootapi/products/",product,Product.class);

		assertNotNull(newProduct);
		assertNotNull(newProduct.getId());
		assertEquals("Samsung",newProduct.getName());

		restTemplate.delete("http://localhost:8080/springbootapi/products/"+newProduct.getId());



	}

	@Test
	public void updateProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject("http://localhost:8080/springbootapi/products/3",Product.class);
		product.setPrice(980000);

		restTemplate.put("http://localhost:8080/springbootapi/products/",product);

	}

}
