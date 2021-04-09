package com.lambdaschool.piggybank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.json.GsonBuilderUtils;

@SpringBootApplication
public class PiggybankApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(PiggybankApplication.class, args);
    }

}
