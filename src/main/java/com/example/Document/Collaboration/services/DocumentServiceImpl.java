package com.example.Document.Collaboration.services;

import com.example.Document.Collaboration.models.Document;
import com.example.Document.Collaboration.models.User;
import com.example.Document.Collaboration.repositories.DocumentRepository;
import com.example.Document.Collaboration.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    DocumentRepository documentRepository;

    @Override
    public Document saveDocument(Document document) {
        return documentRepository.save(document);
    }

    @Override
    public List<Document> getDocuments() {
        return documentRepository.findAll();
    }
}
