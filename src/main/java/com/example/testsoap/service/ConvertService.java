package com.example.testsoap.service;

import org.springframework.stereotype.Service;

@Service
public class ConvertService {
    public String convertXml(String xml) {
        return xml + "converted";
    }
}
