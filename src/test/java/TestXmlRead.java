import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * 解析xml文件的测试类
 * Created by Administrator on 2016/11/9.
 */
public class TestXmlRead {
    @Test
    public void testDom() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File("src/main/resource/value.xml"));
        Element root = doc.getDocumentElement();
        System.out.println(root.getNodeName());

        NodeList list = root.getChildNodes();
        for (int i = 0; i < list.getLength(); i++) {
            System.out.println("content:" + list.item(i).getTextContent());
        }
    }
}
