package com.example.Document.Collaboration.services;

import com.example.Document.Collaboration.DTO.DocumentRequest;
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
    private final DocumentRepository documentRepository;
    private final UserRepository userRepository;

    public DocumentServiceImpl(DocumentRepository documentRepository, UserRepository userRepository) {
        this.documentRepository = documentRepository;
        this.userRepository = userRepository;
    }


    @Override
    public DocumentRequest saveDocument(Document document , Long user_id) {
        User user = userRepository.findById(user_id).orElseThrow();
        document.setUser(user);
        Document savedDocument = documentRepository.save(document);
        return  new DocumentRequest(
                savedDocument.getId(),
                savedDocument.getTitle(),
                savedDocument.getContent(),
                savedDocument.getUser().getId()
        );
    }

    @Override
    public List<Document> getDocuments() {
        return documentRepository.findAll();
    }
}
