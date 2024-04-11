package com.levo.dockerexample.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import java.io.*;
@RestController
@RequestMapping("docker-java-app")
public class HelloController {
	@Value("${file.path}")
	private String filepath;
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() throws Exception{
	File file = new File(filepath);
 
        // Note:  Double backquote is to avoid compiler
        // interpret words
        // like \test as \t (ie. as a escape sequence)
 
        // Creating an object of BufferedReader class
        BufferedReader br
            = new BufferedReader(new FileReader(file));
 
        // Declaring a string variable
        String st;
        StringBuilder sb1 = new StringBuilder("This file content: "); 
        while ((st = br.readLine()) != null)
	{
            // Print the string
            System.out.println(st);
            sb1.append(String.valueOf(st));
       }
		return "docker-java-app is up and running: " + sb1;
	}

}
