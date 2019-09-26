package ru.job4j.sql;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParser extends DefaultHandler {

    private int sum;

    public int getSum() {
        return sum;
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes attributes) {
        if ("entry".equals(qName)) {
            sum += Integer.parseInt(attributes.getValue("field"));
        }
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        super.endElement(namespaceURI, localName, qName);
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }
}
