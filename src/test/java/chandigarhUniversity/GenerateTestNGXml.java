package chandigarhUniversity;

import java.io.FileWriter;
import java.io.IOException;

public class GenerateTestNGXml {
    public static void main(String[] args) {
        String[] testClasses = {
            "com.example.tests.LoginTest",
            "com.example.tests.RegistrationTest",
            "com.example.tests.ProductSearchTest"
        };

        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        xmlBuilder.append("<suite name=\"Selenium Test Suite\" verbose=\"1\" parallel=\"false\">\n");

        for (int i = 0; i < testClasses.length; i++) {
            xmlBuilder.append("  <test name=\"Test ").append(i + 1).append(": ").append(testClasses[i].split("\\.")[3]).append("\">\n");
            xmlBuilder.append("    <classes>\n");
            xmlBuilder.append("      <class name=\"").append(testClasses[i]).append("\" />\n");
            xmlBuilder.append("    </classes>\n");
            xmlBuilder.append("  </test>\n");
        }

        xmlBuilder.append("</suite>");

        try (FileWriter writer = new FileWriter("suite1.xml")) {
            writer.write(xmlBuilder.toString());
            System.out.println("TestNG XML generated successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
