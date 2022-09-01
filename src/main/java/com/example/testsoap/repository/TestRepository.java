package com.example.testsoap.repository;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Repository
public class TestRepository {
    private static final Map<String, String> data = new HashMap<>();

    @PostConstruct
    public void initData() {
        data.put("1", "One");
        data.put("2", "Two");
        data.put("3", "Three");
    }

    public String find(String value) {
        return data.get(value);
    }
}
