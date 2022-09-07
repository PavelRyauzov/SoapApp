package com.example.testsoap.endpoint;

import com.example.testsoap.service.ConvertService;
import com.test_soap.GetConvertedXmlRequest;
import com.test_soap.GetConvertedXmlResponse;
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

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getConvertedXmlRequest")
    @ResponsePayload
    public GetConvertedXmlResponse getData(@RequestPayload GetConvertedXmlRequest request) {
        GetConvertedXmlResponse response = new GetConvertedXmlResponse();
        response.setConvertedXmlText(service.convertXml(request.getSourceXmlText()));
        return response;
    }
}
