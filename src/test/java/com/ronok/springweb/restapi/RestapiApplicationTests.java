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

}
