package com.ronok.springweb.restapi.controllers;

import com.ronok.springweb.restapi.entities.Product;
import com.ronok.springweb.restapi.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductRestController
{
    @Autowired
    ProductRepository productRepository;

    @RequestMapping(value = "/products/",method = RequestMethod.GET)
    public List<Product> getProducts()
    {
        return productRepository.findAll();
    }

    @RequestMapping(value = "/products/{id}",method = RequestMethod.GET)
    public Product getProduct(@PathVariable("id") int id)
    {
        return productRepository.findById(id).get();
    }

    @RequestMapping(value = "/products/",method = RequestMethod.POST)
    public Product createProduct(@RequestBody Product product)
    {
        return productRepository.save(product);
    }

    @RequestMapping(value = "/products/",method = RequestMethod.PATCH)
    public Product updateProduct(@RequestBody Product product)
    {
        return productRepository.save(product);
    }

    @RequestMapping(value = "/products/{id}",method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable("id") int id)
    {
        productRepository.deleteById(id);
    }
}
