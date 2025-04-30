package com.example.Document.Collaboration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@SpringBootApplication
public class DocumentCollaborationApplication {

	@RequestMapping("/")
	public String home(){
		return "Document Colabs";

	}

	public static void main(String[] args) {
		SpringApplication.run(DocumentCollaborationApplication.class, args);
	}

}
