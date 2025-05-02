package org.json.junit;

import java.io.StringReader;

import org.json.*;
import org.junit.Test;
public class ParseXMLTest {

    @Test
    public void parseXMLTest() {
        String xmlStr = 
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+
            "<contact>\n"+
            "  <nick>Crista </nick>\n"+
            "  <name>Crista Lopes</name>\n" +
            "  <address>\n" +
            "    <street>Ave of Nowhere</street>\n" +
            "    <zipcode>92614</zipcode>\n" +
            "  </address>\n" +
            "</contact>";
        
        String searchPath = "contact/nick";
    
        JSONObject json = XML.toJSONObject(new StringReader(xmlStr), new JSONPointer("/contact/address/street/"));
        JSONObject replacement = XML.toJSONObject("<street>Ave of the Arts</street>\n");
        System.out.println("Given replacement: " + replacement);
        JSONObject jobj = XML.toJSONObject(new StringReader(xmlStr), new JSONPointer("/contact/address/street/"), replacement);
        System.out.println(jobj); 

    }
}
