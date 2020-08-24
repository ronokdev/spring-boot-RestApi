package com.ronok.springweb.restapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.ronok.springweb.restapi.entities.Product;
import com.ronok.springweb.restapi.repos.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest
public class ProductRestControllerMvcTest
{
    public static final int PRODUCT_ID = 1;
    public static final String PRODUCT_STRING_NAME = "Macbook";
    public static final String PRODUCT_DESCRIPTION = "This is the new macbook";
    public static final int PRODUCT_PRICE = 5000;
    public static final String PRODUCT_URL = "/products/";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductRepository productRepository;

    @Test
    public void testFindAll() throws Exception
    {
        Product product = buildProduct();
        List<Product> products = Arrays.asList(product);
        when(productRepository.findAll()).thenReturn(products);

        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();


        mockMvc.perform(get(PRODUCT_URL))
                .andExpect(status().isOk())
                .andExpect(content().json(objectWriter.writeValueAsString(products)));

    }

    @Test
    public void testCreateProduct() throws Exception
    {
        Product product = buildProduct();
        when(productRepository.save(any())).thenReturn(product);

        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();

        mockMvc.perform(post(PRODUCT_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectWriter.writeValueAsString(product)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectWriter.writeValueAsString(product)));
    }

    @Test
    public void testUpdateProduct() throws Exception
    {
        Product product = buildProduct();
        product.setPrice(11000);

        when(productRepository.save(any())).thenReturn(product);

        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();

        mockMvc.perform(put(PRODUCT_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectWriter.writeValueAsString(product)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectWriter.writeValueAsString(product)));
    }

    @Test
    public void testDeleteProduct() throws Exception
    {
        doNothing().when(productRepository).deleteById(PRODUCT_ID);   // we are using doNothing() as delete method is void

        mockMvc.perform(delete(PRODUCT_URL+PRODUCT_ID)).andExpect(status().isOk());
    }


    private Product buildProduct()
    {
        Product product = new Product();
        product.setId(PRODUCT_ID);
        product.setName(PRODUCT_STRING_NAME);
        product.setDescription(PRODUCT_DESCRIPTION);
        product.setPrice(PRODUCT_PRICE);
        return product;
    }
}
