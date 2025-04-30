package com.example.Document.Collaboration.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DocumentRequest {

    private Long id;
    private String title;
    private String content;
    private Long user_id;
}
