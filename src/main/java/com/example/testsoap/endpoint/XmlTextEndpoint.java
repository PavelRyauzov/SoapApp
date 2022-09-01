package com.example.testsoap.endpoint;

import com.example.testsoap.gen.ConverterResponse;
import com.example.testsoap.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class XmlTextEndpoint {
    private static final String NAMESPACE_URI = "http://www.test-soap.com/";

    private TestRepository repository;

    @Autowired
    public void setRepository(TestRepository repository) {
        this.repository = repository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "ConverterRequest")
    @ResponsePayload
    public ConverterResponse getData(String value) {
        ConverterResponse response = new ConverterResponse();
        response.setConvertedXmlText(repository.find(value));

        return response;
    }
}
