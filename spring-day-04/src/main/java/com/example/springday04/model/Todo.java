package com.example.springday04.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Todo {
    private Integer id;
    private String title;
    private Boolean status;
}
