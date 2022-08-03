package com.example.springday03;

import com.example.springday03.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class FakeDB {
    public static List<Customer> database = new ArrayList<>(List.of(
            new Customer(1, "Xuan", "1 HaLong", "012345678"),
            new Customer(2, "Ha", "2 HaLong", "022345678"),
            new Customer(3, "Thu", "3 HaLong", "032345678"),
            new Customer(4, "Dong", "4 HaLong", "042345678"),
            new Customer(5, "Hoa", "5 HaLong", "052345678"),
            new Customer(6, "Binh", "6 HaLong", "062345678"),
            new Customer(7, "Hanh", "7 HaLong", "072345678"),
            new Customer(8, "Phuc", "8 HaLong", "082345678")
    ));
}
