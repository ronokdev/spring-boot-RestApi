package com.ronok.springweb.restapi.batch;

import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class Writer implements ItemWriter<String>
{

    @Override
    public void write(List<? extends String> items) throws Exception
    {
        System.out.println("inside write");
        System.out.println("writting data: "+items);
    }
}
