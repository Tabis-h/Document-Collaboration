package com.example.Document.Collaboration.controllers;

import com.example.Document.Collaboration.models.Document;
import com.example.Document.Collaboration.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/documents")
public class DocumentController {

    private final DocumentService documentService;
    @Autowired
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping

    public Document saveDocument(@RequestBody Document document){
        return documentService.saveDocument(document);
    }

    @GetMapping
    public List<Document> getDocument(){
        return documentService.getDocuments();
    }

}
