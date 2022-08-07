package com.example.springday05.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Todo")
public class Todo {
    @Id
    private Integer id;
    private String title;
    private Boolean status;
}
