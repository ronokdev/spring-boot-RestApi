package com.ronok.springweb.restapi.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@Entity
public class Product implements Serializable
{
    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @NotNull(message = "Name Can Not Be NULL")
    public String name;
    @Size(max = 100)
    public String description;
    @Min(value = 1,message = "Price Must Be Grater than 1")
    public int price;
}
