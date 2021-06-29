package ba.unsa.etf.rs;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;

public class OpenFile {
    public void zapisi(File file) {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        Document document = null;

        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            // document = documentBuilder.newDocument();
        } catch (ParserConfigurationException err) {
            err.printStackTrace();
        }
    }
}
