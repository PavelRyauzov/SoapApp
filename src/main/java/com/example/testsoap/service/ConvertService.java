package com.example.testsoap.service;

import org.springframework.stereotype.Service;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class ConvertService {
    public String convertXml(String xml) {

        TransformerFactory factory = TransformerFactory.newInstance();

        try(InputStream is = getClass().getClassLoader().getResourceAsStream("testXsl.xsl")) {
            Source xslt = new StreamSource(is);
            Transformer transformer = factory.newTransformer(xslt);
            Source source = new StreamSource(new StringReader(xml));
            Writer writer = new StringWriter();
            transformer.transform(source, new StreamResult(writer));
            return writer.toString();
        } catch (TransformerException | IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
