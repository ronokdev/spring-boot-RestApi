package com.ronok.springweb.restapi.controllers;

import com.ronok.springweb.restapi.entities.Product;
import com.ronok.springweb.restapi.repos.ProductRepository;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductRestController
{
    @Autowired
    ProductRepository productRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductRestController.class);

    @ApiOperation(value="Retrieves All the Products",
            notes = "A list of Product",
            response = Product.class,
            responseContainer = "List",
            produces = "application/json")
    @RequestMapping(value = "/products/",method = RequestMethod.GET)
    public List<Product> getProducts()
    {
        return productRepository.findAll();
    }

    @RequestMapping(value = "/products/{id}",method = RequestMethod.GET)
    @Transactional(readOnly = true)
    @Cacheable("product-cache")
    public Product getProduct(@PathVariable("id") int id)
    {
        return productRepository.findById(id).get();
    }

    @RequestMapping(value = "/products/",method = RequestMethod.POST)
    public Product createProduct(@Valid @RequestBody Product product)
    {
        return productRepository.save(product);
    }

    @RequestMapping(value = "/products/",method = RequestMethod.PUT)
    public Product updateProduct(@RequestBody Product product)
    {
        return productRepository.save(product);
    }

    @RequestMapping(value = "/products/{id}",method = RequestMethod.DELETE)
    @CacheEvict("product-cache")
    public void deleteProduct(@PathVariable("id") int id)
    {
        LOGGER.info("Deleting the Product with ID : "+id);
        productRepository.deleteById(id);
    }
}
