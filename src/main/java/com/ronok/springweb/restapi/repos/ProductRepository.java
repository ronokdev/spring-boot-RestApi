package com.ronok.springweb.restapi.repos;

import com.ronok.springweb.restapi.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product,Integer>
{

}
