package work;

import java.io.File;
import java.io.FileReader;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stax.StAXSource;
import javax.xml.transform.stream.StreamResult;

public class XmlSplit {

	public static void main(String [] args) throws Exception {
		XMLInputFactory xif = XMLInputFactory.newInstance();
        XMLStreamReader xsr = xif.createXMLStreamReader(new FileReader("src/work/test23Oct.xml"));
        xsr.nextTag(); // Advance to Message element

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = tf.newTransformer();
        int val= 0;
        System.out.println("Splitting xmls...");
        while(xsr.nextTag() == XMLStreamConstants.START_ELEMENT) {
            val = val+1;
			File file = new File("src/work/xmls/Message" + val + ".xml");
            t.transform(new StAXSource(xsr), new StreamResult(file));
        }
        System.out.println("Splitting complete!");
	}

}