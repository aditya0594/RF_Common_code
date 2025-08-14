package utility;

import static org.testng.Assert.fail;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PDFUtility extends BaseClass{

	public PDFUtility(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

    public void renamePDF(String oldFilePath, String newFilePath) {
        File oldFile = new File(oldFilePath);
        File newFile = new File(newFilePath);

        if (oldFile.exists()) {
            boolean renamed = oldFile.renameTo(newFile);
            if (renamed) {
                System.out.println("PDF renamed successfully.");
            } else {
                System.out.println("Failed to rename PDF.");
            }
        } else {
            System.out.println("Original PDF file not found.");
        }
    }

	public boolean readPDF(String filename,String teststring) throws IOException,InterruptedException {

		Thread.sleep(5000);
	    Path relativePath = Paths.get("DownloadPDFs/"+filename+".pdf");
        String absolutePath = relativePath.toAbsolutePath().toString();

		PDDocument document = PDDocument.load(new File(absolutePath));
		if (!document.isEncrypted()) {
			PDFTextStripper stripper = new PDFTextStripper();
			String text = stripper.getText(document);
			//System.out.println("Text: " + text);
			//String searchString = teststring; //////// Enrollment No. : 170101601014
			if (text.contains(teststring))
				System.out.println("Given string is present in the provided pdf: " + teststring);
				return true;
			}
			System.out.println("Given string is not present");
			Assert.fail("Condition check failed.");
			return false;
	}

	public void downloadPDF(WebDriver driver, String filename) throws AWTException, InterruptedException,IOException {
//		new ProcessBuilder("AutoIT/PrintPDF.exe").start();
//		Thread.sleep(15000);
//		Thread.sleep(4000);
//		renamePDF("DownloadPDFs/AutoIT/Saved_Print.pdf", "DownloadPDFs/"+filename+".pdf");
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000); // Wait for the save dialog to appear

		Thread.sleep(2000);
		Path relativePath = Paths.get("DownloadPDFs/"+filename+".pdf");
		String absolutePath = relativePath.toAbsolutePath().toString();
		// choose_btn.sendKeys(absolutePath);

		StringSelection stringSelection = new StringSelection(absolutePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		//Thread.sleep(3000);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(7000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(7000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	public void downloadPDF_autoit() throws InterruptedException, IOException {

			String autoItExe = "AutoIT/PrintPDF.exe";
			Runtime.getRuntime().exec(autoItExe);
			System.out.println(" Print to PDF automation completed.");
	}



	public static boolean downloadAndVerifyPDF(String pdfUrl, String saveDir, String fileName, String expectedText) {
		boolean result = false;
		File dir = new File(saveDir);
		if (!dir.exists()) dir.mkdirs();
		String filePath = saveDir + File.separator + fileName + ".pdf";

		HttpURLConnection connection = null;
		try {
			URL url = new URL(pdfUrl);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("User-Agent", "Mozilla/5.0");
			connection.connect();

			String contentType = connection.getContentType();
			System.out.println("Content-Type: " + contentType);

			if (contentType == null || !contentType.toLowerCase().contains("pdf")) {
				System.out.println("The URL did not return a PDF. Content-Type: " + contentType);
				// Save the response for debugging
				try (InputStream in = connection.getInputStream();
					 FileOutputStream fos = new FileOutputStream(filePath + ".debug")) {
					byte[] buffer = new byte[4096];
					int bytesRead;
					while ((bytesRead = in.read(buffer)) != -1) {
						fos.write(buffer, 0, bytesRead);
					}
				}
				return false;
			}

			// Download PDF
			try (InputStream in = connection.getInputStream();
				 FileOutputStream fos = new FileOutputStream(filePath)) {
				byte[] buffer = new byte[4096];
				int bytesRead;
				while ((bytesRead = in.read(buffer)) != -1) {
					fos.write(buffer, 0, bytesRead);
				}
			}

			// Validate PDF header
			File pdfFile = new File(filePath);
			try (FileInputStream fis = new FileInputStream(pdfFile)) {
				byte[] header = new byte[4];
				if (fis.read(header) != 4 || !new String(header).equals("%PDF")) {
					System.out.println("Downloaded file is not a valid PDF (missing %PDF header).");
					return false;
				}
			}

			// Parse PDF
			try (FileInputStream fis = new FileInputStream(pdfFile);
				 PDDocument document = PDDocument.load(fis)) {
				PDFTextStripper pdfStripper = new PDFTextStripper();
				String pdfText = pdfStripper.getText(document);
				System.out.println("PDF Content:\n" + pdfText);
				if (pdfText.contains(expectedText)) {
					System.out.println("PDF content verification passed!");
					result = true;
				} else {
					System.out.println("PDF content verification failed!");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null) connection.disconnect();
		}
		return result;
	}
}
