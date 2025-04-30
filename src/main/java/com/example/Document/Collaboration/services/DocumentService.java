package com.example.Document.Collaboration.services;

import com.example.Document.Collaboration.DTO.DocumentRequest;
import com.example.Document.Collaboration.models.Document;
import com.example.Document.Collaboration.models.User;

import java.util.List;

public interface DocumentService {

    DocumentRequest saveDocument(Document document, Long user_id);
    List<Document> getDocuments();
}
