package com.ronok.springweb.restapi.batch;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class Reader implements ItemReader<String>
{
    private String[] name = {"Ronok","koushika","ratul"};
    private int count;

    @Override
    public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException
    {
        if(count<name.length)
        {
            return name[count++];
        }
        else
        {
            count = 0;
        }

        return null;
    }

}
