package com.kat.gestibanque;
import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinalProjectGestiBanqueApplication{

    public static String uploadDirectory = System.getProperty("user.dir") + File.separator + "src\\main\\resources\\static\\uploads";
	public static void main(String[] args) {
		new File(uploadDirectory).mkdir();
		
		SpringApplication.run(FinalProjectGestiBanqueApplication.class, args);
		
	}

}
