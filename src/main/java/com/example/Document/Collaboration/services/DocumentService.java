package com.example.Document.Collaboration.services;

import com.example.Document.Collaboration.models.Document;

import java.util.List;

public interface DocumentService {

    Document saveDocument(Document document);
    List<Document> getDocuments();
}
