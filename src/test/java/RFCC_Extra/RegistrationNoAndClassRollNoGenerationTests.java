package RFCC_Extra;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationNoAndClassRollNoGenerationTests {

//	LoginPageAdmin loginPage;
//	HomePageAdmin homePage;
//	
//	InputStream dataIs;
//	JSONObject loginUsers;
	
	public static WebDriver driver;
	
//	@BeforeClass
//	public void beforeClass() throws Exception{
//		try {
//			String dataFileName = "data/loginUsers.json";
//			dataIs = getClass().getClassLoader().getResourceAsStream(dataFileName);
//			JSONTokener tokener = new JSONTokener(dataIs);
//			loginUsers = new JSONObject(tokener);
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//			throw e;
//		}
//		finally {
//			if (dataIs != null) {
//				dataIs.close();
//			}
//		}
//	}
	
	@AfterClass
	public void afterClass() {
}
	@BeforeMethod
	public void beforeMethod(Method m) throws Exception {
		
		//driver = initializeDriverBFT("UrlAtlasAdmin");
		System.out.println("\n" + "*****Starting Test : " +  m.getName() + "\n");
	}
	@AfterMethod
	public void afterMethod() {
	}
	
	@Test()
	public void RegistrationNo_And_Class_RollNo_Generation() throws IOException, Exception
	{
//		loginPage = new LoginPageAdmin(driver);
//		
//		homePage = loginPage.login(loginUsers.getJSONObject("AtlasAdminLogin").getString("userName"), 
//				loginUsers.getJSONObject("AtlasAdminLogin").getString("password"));
		
		System.out.println("Academic-> POST ADMISSION -> Registration No. and Class Roll No. Generation");
		driver.get("https://atlasuniversityuat.mastersofterp.in/academic/iitmsvErXAtHO7yX5lKuozSI1zEPgIPLsATV1QsUYtcth2n/cpUiduPJ2+5kVE07zqDVi?enc=M1EsHDAeRhaekcwzmtddkty++tS9kET6yIL6juG3LWw=");
		
		Thread.sleep(2000);
		System.out.println("click on Admission Batch - 2022-2023");
	    driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlAdmBatch-container")).click();
	    driver.findElement(By.xpath("//span/span/input")).sendKeys("2022-2023");
	    driver.findElement(By.xpath("//span/span/input")).sendKeys(Keys.ENTER);
	    
	    Thread.sleep(2000);
	    System.out.println("click on School/Institute Name - ATLAS INSOFE School of Data Science - MUMBAI");
	    driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlClgname-container")).click();
	    driver.findElement(By.xpath("//span/span/input")).sendKeys("ATLAS INSOFE School of Data Science - MUMBAI");
	    driver.findElement(By.xpath("//span/span/input")).sendKeys(Keys.ENTER);
	    
	    Thread.sleep(2000);
	    System.out.println("click on Degree - Bachelor of Science in Hons");
	    driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlDegree-container")).click();
	    driver.findElement(By.xpath("//span/span/input")).sendKeys("Bachelor of Science in Hons");
	    driver.findElement(By.xpath("//span/span/input")).sendKeys(Keys.ENTER);
	    
	    Thread.sleep(2000);
	    System.out.println("click on Programme/Branch - Artificial Intelligence & Machine Learning");
	    driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlBranch-container")).click();
	    driver.findElement(By.xpath("//span/span/input")).sendKeys("Artificial Intelligence & Machine Learning");
	    driver.findElement(By.xpath("//span/span/input")).sendKeys(Keys.ENTER);
	    
	    Thread.sleep(2000);
	    System.out.println("click on Year - First Year");
	    driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlyear-container")).click();
	    driver.findElement(By.xpath("//span/span/input")).sendKeys("First Year");
	    driver.findElement(By.xpath("//span/span/input")).sendKeys(Keys.ENTER);
	    
	    Thread.sleep(2000);
	    System.out.println("click on Admission Type - Regular");
	    driver.findElement(By.xpath("//div[@id='ctl00_ContentPlaceHolder1_divAdType']/span/span/span")).click();
	    driver.findElement(By.xpath("//span/span/input")).sendKeys("Regular");
	    driver.findElement(By.xpath("//span/span/input")).sendKeys(Keys.ENTER);
	    
	    Thread.sleep(2000);
	    System.out.println("click on Sort By option 1 - ByStudentName");
	    driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlsort-container")).click();
	    driver.findElement(By.xpath("//span/span/input")).sendKeys("ByStudentName");
	    driver.findElement(By.xpath("//span/span/input")).sendKeys(Keys.ENTER);
	    
	    Thread.sleep(2000);
	    System.out.println("click on Show Button");
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnShow")).click();
	}
	}