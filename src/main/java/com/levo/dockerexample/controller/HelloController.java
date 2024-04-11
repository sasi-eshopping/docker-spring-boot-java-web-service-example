package com.levo.dockerexample.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.io.*;
@RestController
@RequestMapping("docker-java-app")
public class HelloController {
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
	File file = new File(
            "/data/testfile.txt");
 
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
