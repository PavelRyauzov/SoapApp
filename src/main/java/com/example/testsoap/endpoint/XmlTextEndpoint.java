package com.example.testsoap.endpoint;

import com.example.testsoap.gen.ConverterRequest;
import com.example.testsoap.gen.ConverterResponse;
import com.example.testsoap.service.ConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class XmlTextEndpoint {
    private static final String NAMESPACE_URI = "http://www.test-soap.com/";
    private ConvertService service;

    @Autowired
    public void setService(ConvertService service) {
        this.service = service;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "converterRequest")
    @ResponsePayload
    public ConverterResponse getData(@RequestPayload ConverterRequest request) {
        ConverterResponse response = new ConverterResponse();
        response.setConvertedXmlText(service.convertXml(request.getSourceXmlText()));
        return response;
    }
}
