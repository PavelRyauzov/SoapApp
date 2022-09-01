package com.example.testsoap.endpoint;

import com.example.testsoap.gen.ConverterRequest;
import com.example.testsoap.gen.ConverterResponse;
import com.example.testsoap.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class XmlTextEndpoint {
    private static final String NAMESPACE_URI = "localhost:8080/springsoap/gen";

    private TestRepository repository;

    @Autowired
    public void setRepository(TestRepository repository) {
        this.repository = repository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "converterRequest")
    @ResponsePayload
    public ConverterResponse getData(@RequestPayload ConverterRequest request) {
        ConverterResponse response = new ConverterResponse();
        response.setConvertedXmlText(repository.find(request.getSourceXmlText()));

        return response;
    }
}
