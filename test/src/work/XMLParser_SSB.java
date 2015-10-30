package work;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class XMLParser_SSB implements NamespaceContext {

	static List<String> msgType = null;
	static List<String> text = null;
	public static void main(String[] args) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		// check if factory is namespace aware
		factory.setNamespaceAware(true);
		DocumentBuilder builder = null;
		Document doc = null;
		File file = null;
		File fileout = null;
		String folder = "src/work/xmls";

		try {
			//Scanner sc = new Scanner(new File("src/work/test23Oct.txt"), "UTF-8");
			List filesToProcess=getListOfFiles(folder);
			fileout = new File("src/work/out.txt");
			FileWriter fw = new FileWriter(fileout.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			for (int j = 0; j < filesToProcess.size(); j++) {

				file = (File) filesToProcess.get(j);

				builder = factory.newDocumentBuilder();
				doc = builder.parse(file);
				// Create XPathFactory object
				XPathFactory xpathFactory = XPathFactory.newInstance();

				// Create XPath object
				XPath xpath = xpathFactory.newXPath();

				xpath.setNamespaceContext(new XMLParser_SSB());

				getMsgType(doc, xpath);

				getMsgText(doc, xpath);

				//bw.append("------------------------------------------------------Message:"+j+"--------------------------------------------------------------------------------\n");

				for(int i=0; i<text.size(); i++){
					//System.out.println("Text: "+msgType.get(0)+","+text.get(i));


					if (!fileout.exists()) {
						fileout.createNewFile();
					}
					//bw.append(msgType.get(0)+","+text.get(i)+"\n");
					bw.append(text.get(i)+"\n");

				}



			}
			bw.close();

			File folderName = new File(folder);
			for(File filein: folderName.listFiles()) filein.delete();
			

			try {
				FileReader fr;
				File fileFinal = new File("src/work/finalRouted.txt");
				File fileManual = new File("src/work/finalManual.txt");
				FileWriter fw2;
			
				fr = new FileReader(fileout.getAbsoluteFile());
				fw = new FileWriter(fileFinal.getAbsoluteFile());
				fw2 = new FileWriter(fileManual.getAbsoluteFile());
				BufferedReader br = new BufferedReader(fr);
				bw = new BufferedWriter(fw);
				BufferedWriter bw2 = new BufferedWriter(fw2);
				String data = "", str1="", str2="", str3="";

				while(br.readLine()!=null){
					data = br.readLine();
					System.out.println(data);
					if(data.startsWith("Routed from")){
						str3 = data.substring(data.lastIndexOf('(')+1, data.lastIndexOf(')'));
						data = data.substring(0, data.lastIndexOf("("));
						str2 = data.substring(data.lastIndexOf('[')+1, data.lastIndexOf(']'));
						data = data.substring(0, data.lastIndexOf("[")-1);
						str1 = data.substring(data.indexOf('[')+1, data.indexOf(']'));
						
						data="";
						bw.append(str1+","+str2+","+str3+"\n");
					}
					else {
						str2 = data.substring(data.lastIndexOf('[')+1, data.lastIndexOf(']'));
						data = data.substring(0, data.lastIndexOf("[")-1);
						str1 = data.substring(data.indexOf('[')+1, data.indexOf(']'));
						
						data="";
						bw2.append(str1+","+str2+"\n");
					}
					
				}
				br.close();
				bw.close();
				bw2.close();

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ParserConfigurationException | SAXException | IOException  e) {
			e.printStackTrace();
		} 

	}

	private static void getMsgText(Document doc, XPath xpath) {
		// TODO Auto-generated method stub
		text = new ArrayList<String>();
		try {
			//create XPathExpression object
			//String strToComp = "/:Message/:Instance/:Intervention[:Name = 'Instance routed' or :Name = 'Instance completed']/:Text/text()";
			String strToComp = "/:Message/:Instance/:Intervention[:Name = 'Instance routed' ]/:Text/text()";
			XPathExpression expr =
					xpath.compile(strToComp);
			//evaluate expression result on XML document
			NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
			for (int i = 0; i < nodes.getLength(); i++){
				text.add(nodes.item(i).getNodeValue());
			}
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
	}

	private static void getMsgType(Document doc, XPath xpath) {
		// TODO Auto-generated method stub
		msgType = new ArrayList<String>();
		try {
			//create XPathExpression object
			String strToComp = "/:Message/:Type/text()";
			XPathExpression expr =
					xpath.compile(strToComp);
			//evaluate expression result on XML document
			NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
			for (int i = 0; i < nodes.getLength(); i++){
				msgType.add(nodes.item(i).getNodeValue());
			}
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getNamespaceURI(String prefix) {
		// TODO Auto-generated method stub
		if (prefix == null) throw new NullPointerException("Invalid Namespace Prefix");
		else if ("".equals(prefix)){
			return "urn:swift:saa:xsd:messaging";
		}
		else{
			return XMLConstants.NULL_NS_URI;
		}
	}
	@Override
	public String getPrefix(String namespaceURI) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator getPrefixes(String namespaceURI) {
		// TODO Auto-generated method stub
		return null;
	}

	public static List getListOfFiles(String folderName){
		File[] listOfContents;
		List listOfFiles=new ArrayList();

		File folder = new File(folderName);
		if(!folder.isDirectory()){
			//LOGGER.error(folderName +" is not a folder");
			return null;
		}else{
			listOfContents=folder.listFiles();
			for (int i = 0; i < listOfContents.length; i++) {
				if(listOfContents[i].isFile()){
					/* do not take file with extension .inProgress */
					listOfFiles.add(listOfContents[i]);
				}
			}
			return listOfFiles;
		}
	}
}
