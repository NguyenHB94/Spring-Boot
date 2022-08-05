package com.example.springday04;

import com.example.springday04.model.Todo;

import java.util.ArrayList;
import java.util.List;

public class FakeDB {
    public static List<Todo> todoList = new ArrayList<>(List.of(
            new Todo(247,"Đi đá bóng", false),
            new Todo(230, "Làm bài tập", true),
            new Todo(963, "Đi chơi với bạn bè", true),
            new Todo(917, "Công việc mới", false)
    ));
}
