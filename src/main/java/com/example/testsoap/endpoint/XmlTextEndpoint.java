package com.example.testsoap.endpoint;

import com.example.testsoap.config.Config;
import com.example.testsoap.service.ConvertService;
import com.test_soap.GetConvertedXmlRequest;
import com.test_soap.GetConvertedXmlResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@Log4j2
public class XmlTextEndpoint {
    private ConvertService service;

    @Autowired
    public void setService(ConvertService service) {
        this.service = service;
    }

    @PayloadRoot(namespace = Config.NAMESPACE_URI, localPart = "getConvertedXmlRequest")
    @ResponsePayload
    public GetConvertedXmlResponse getData(@RequestPayload GetConvertedXmlRequest request) throws Exception {
        GetConvertedXmlResponse response = new GetConvertedXmlResponse();
        try {
            response.setConvertedXmlText(service.convertXml(request.getSourceXmlText()));
        } catch (Exception e) {
            throw new Exception("Exception in soap application");
        }

        log.info("Успешно!");
        return response;
    }
}
