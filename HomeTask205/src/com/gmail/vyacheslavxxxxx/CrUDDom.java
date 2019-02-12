package com.gmail.vyacheslavxxxxx;

import java.io.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class CrUDDom {
    private static int idlastStudent = 0;

    public static void main(String[] args) {
        System.out.println("------------Xml parse using DOM---------");

        outputXML("./src/Groups.xml");
        modifyXML("./src/Groups.xml", "./src/GroupsModified.xml");
        System.out.println("------------Xml parse using  MOD-DOM---------");
        outputXML("./src/GroupsModified.xml");
    }

    private static void outputXML(String fPath) {
        try {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = db.parse(new File(fPath));
            Node rootNode = doc.getDocumentElement();

            for (int i = 0; i < rootNode.getChildNodes().getLength(); i++) {
                Node childNode = rootNode.getChildNodes().item(i);

                switch (childNode.getNodeName()) {
                case "group_name":
                    System.out.println("|Group name =  " + childNode.getTextContent());
                    break;

                case "student":
                    outputStudentInfo(childNode);
                    break;
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException exc) {
            exc.printStackTrace();
        }
    }

    private static void modifyXML(String fPathSrc, String fPathDst) {
        try {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = db.parse(new File(fPathSrc));
            Node rootNode = doc.getDocumentElement();

            addStudent(doc, rootNode, "Ivan", "Ivanov");
            addStudent(doc, rootNode, "Petr", "Petrov");

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(new DOMSource(doc), new StreamResult(new FileOutputStream(new File(fPathDst))));
        } catch (ParserConfigurationException | IOException | SAXException | TransformerException exc) {
            exc.printStackTrace();
        }
    }

    private static void outputStudentInfo(Node studentNode) {
        Node childNode;
        System.out.println("_______________________________________________________________");
        int id = Integer.parseInt(studentNode.getAttributes().item(0).getTextContent());
        System.out.println("|id         =  " + id);
        idlastStudent = id > idlastStudent ? id : idlastStudent;
        for (int i = 0; i < studentNode.getChildNodes().getLength(); i++) {
            childNode = studentNode.getChildNodes().item(i);

            switch (childNode.getNodeName()) {

            case "first_name":
                System.out.printf("|first name =  %-7s ", childNode.getTextContent());
                break;

            case "last_name":
                System.out.printf("|last name  = %-25s |%n", childNode.getTextContent());
                break;
            }
        }
    }

    private static void addStudent(Document doc, Node rootNode, String name, String last_name) {
        Node studentNode = doc.createElement("student");
        Node firstNameNode = doc.createElement("first_name");
        Node lastNameNode = doc.createElement("last_name");

        firstNameNode.setTextContent(name);
        lastNameNode.setTextContent(last_name);

        ((Element) studentNode).setAttribute("id", ++idlastStudent +"");
        studentNode.appendChild(firstNameNode);
        studentNode.appendChild(lastNameNode);

        rootNode.appendChild(studentNode);

        Node childNode;
        for (int i = 0; i < rootNode.getChildNodes().getLength(); i++) {
            childNode = rootNode.getChildNodes().item(i);

        }
    }

}