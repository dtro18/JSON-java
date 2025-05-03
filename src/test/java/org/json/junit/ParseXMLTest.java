package org.json.junit;

import static org.junit.Assert.assertNotEquals;

import java.io.StringReader;

import org.json.JSONObject;
import org.json.JSONPointer;
import org.json.XML;
import org.junit.Test;
public class ParseXMLTest {

    @Test
    public void searchXMLtoJSON() {
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
        
        // Pointer points to an actual element
        StringReader reader1 = new StringReader(xmlStr);
        JSONPointer pointer1 = new JSONPointer("/contact/address/street/");
        JSONObject actualJson1 = XML.toJSONObject(reader1, pointer1);
        String expectedString1 = "{\"street\":\"Ave of Nowhere\"}";
        JSONObject expectedJson1 = new JSONObject(expectedString1);
        Util.compareActualVsExpectedJsonObjects(actualJson1,expectedJson1);

        // Pointer points to a jsonobject
        StringReader reader2 = new StringReader(xmlStr);
        JSONPointer pointer2 = new JSONPointer("/contact/");
        JSONObject actualJson2 = XML.toJSONObject(reader2, pointer2);
        String expectedString2 = "{\"contact\":{\"nick\":\"Crista\",\"address\":{\"zipcode\":92614,\"street\":\"Ave of Nowhere\"},\"name\":\"Crista Lopes\"}}";
        JSONObject expectedJson2 = new JSONObject(expectedString2);
        Util.compareActualVsExpectedJsonObjects(actualJson2,expectedJson2);
    
        // Pointer points to an invalid path
        StringReader reader3 = new StringReader(xmlStr);
        JSONPointer pointer3 = new JSONPointer("/contact/address/street123123123/");
        JSONObject actualJson3 = XML.toJSONObject(reader3, pointer3);
        String expectedString3 = "{\"street\":\"Ave of Nowhere\"}";
        JSONObject expectedJson3 = new JSONObject(expectedString3);
        assertNotEquals(actualJson3,expectedJson3);

        String xmlString2 = 
            "<?xml version=\"1.0\"?>\n"+ 
            "<catalog>\n" +
            "  <book id=\"bk101\">\n" +
            "    <author>Author 1</author>\n" +
            "    <title>Book 1</title>\n" +
            "  </book>\n" +
            "  <book id=\"bk102\">\n" +
            "    <author>Author 2</author>\n" +
            "    <title>Book 2</title>\n" +
            "  </book>\n" +
            "</catalog>\n";

        // Pointer points to a JSONArray
        StringReader reader4 = new StringReader(xmlString2);
        JSONPointer pointer4 = new JSONPointer("/catalog/book/");
        JSONObject actualJson4 = XML.toJSONObject(reader4, pointer4);
        String expectedString4 = "{\"book\":{\"author\":\"Author 1\",\"id\":\"bk101\",\"title\":\"Book 1\"}}";
        JSONObject expectedJson4 = new JSONObject(expectedString4);
        System.out.println(actualJson4);
        Util.compareActualVsExpectedJsonObjects(actualJson4,expectedJson4);
    }

    @Test
    public void replaceXMLtoJSON() {

        String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+
        "<contact>\n"+
        "  <nick>Crista </nick>\n"+
        "  <name>Crista Lopes</name>\n" +
        "  <address>\n" +
        "    <street>Ave of Nowhere</street>\n" +
        "    <zipcode>92614</zipcode>\n" +
        "  </address>\n" +
        "</contact>";
        // Successful replacement given a valid path
        JSONObject replacement1 = XML.toJSONObject("<street>Ave of the Arts</street>\n");
        JSONObject actualJson1 = XML.toJSONObject(new StringReader(xmlString), new JSONPointer("/contact/address/street/"), replacement1); 
        String expectedString1 = "{\"contact\":{\"nick\":\"Crista\",\"address\":{\"zipcode\":92614,\"street\":\"Ave of the Arts\"},\"name\":\"Crista Lopes\"}}";
        System.out.println(actualJson1);
        JSONObject expectedJson1 = new JSONObject(expectedString1);
        Util.compareActualVsExpectedJsonObjects(actualJson1,expectedJson1);
        
        // Unsuccessful replacement given invalid path (no replacement takes place)
        JSONObject replacement2 = XML.toJSONObject("<street>Ave of the Arts</street>\n");
        JSONObject actualJson2 = XML.toJSONObject(new StringReader(xmlString), new JSONPointer("/contact/address/street/"), replacement2); 
        String expectedString2 = "{\"contact\":{\"nick\":\"Crista\",\"address\":{\"zipcode\":92614,\"street\":\"Ave of the Arts\"},\"name\":\"Crista Lopes\"}}";
        JSONObject expectedJson2 = new JSONObject(expectedString2);
        Util.compareActualVsExpectedJsonObjects(actualJson2,expectedJson2);


    }
}
