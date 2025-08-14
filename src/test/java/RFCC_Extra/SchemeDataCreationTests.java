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


public class SchemeDataCreationTests  {

//	LoginPageAdmin loginPage;
//	HomePageAdmin homePage;
//	
//	InputStream dataIs;
//	JSONObject loginUsers;
//	
	public static WebDriver driver;
//	
//	@BeforeClass
//	public void beforeClass() throws Exception{
//		try {
//			String dataFileName = "data/loginUsers.json";
//			dataIs = getClass().getClassLoader().getResourceAsStream(dataFileName);
//			JSONTokener tokener = new JSONTokener(dataIs);
//			loginUsers = new JSONObject(tokener);
//			}
//			catch (Exception e) {
//			e.printStackTrace();
//			throw e;
//			}
//			finally {
//				if (dataIs != null) {
//					dataIs.close();
//			}
//		}
//	}
	
	@AfterClass
	public void afterClass() {
	}
	
	@BeforeMethod
	public void beforeMethod(Method m) throws Exception {
		
		//driver = initializeDriverBFT("UrlAtlasAdmin");
		
		System.out.println("\n" + "*******Starting Test: " + m.getName() + "*********" + "\n");
	}
	
	@AfterMethod
	public void afterMethod() {
	}
	
	@Test()
	
	public void User_able_to_Create_Scheme_Data_Scheme_Creation() throws IOException, Exception
	{
//		loginPage = new LoginPageAdmin(driver);
//		
//		homePage = loginPage.login(loginUsers.getJSONObject("AtlasAdminLogin"). getString("userName"),
//				loginUsers.getJSONObject("AtlasAdminLogin").getString("password"));
		
		System.out.println("Academic-> POST ADMISSION -> Scheme Data -> Scheme Creation");
		driver.get("https://atlasuniversityuat.mastersofterp.in/academic/iitmsVm7APjlVCdtt3V6WQ42nbvMCn90P3DofVTHJpZSIfhKULXOdDMmAngAvbOfnkFh6?enc=NX6ksWYoKz8LyeoRDPuA+V/90fAjPz3AR3jOuh3Yd3U=");
		
		System.out.println("click on page Scheme Creation");
		driver.findElement(By.linkText("Scheme Creation")).click();
		
		Thread.sleep(2000);
		System.out.println("Select on Degree - Master of Business Administration");
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlDegreeNo-container")).click();
		driver.findElement(By.xpath("//span/span/input")).sendKeys("Master of Business Administration");
		driver.findElement(By.xpath("//span/span/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		System.out.println("Select Department - Media & Communication");
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlDept-container")).click();
		driver.findElement(By.xpath("//span/span/input")).sendKeys("Media & Communication");
		driver.findElement(By.xpath("//span/span/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		System.out.println("Select Branch / Programme - Digital Marketing & Advertising");
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlBranch-container")).click();
		driver.findElement(By.xpath("//span/span/input")).sendKeys("Digital Marketing & Advertising");
		driver.findElement(By.xpath("//span/span/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		System.out.println("Select Admission Batch");
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlBatchNo-container")).click();
		driver.findElement(By.xpath("//span/span/input")).sendKeys("2013-14");
		driver.findElement(By.xpath("//span/span/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		System.out.println("Select Scheme Type");
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlSchemeType-container")).click();
		driver.findElement(By.xpath("//span/span/input")).sendKeys("New Scheme");
		driver.findElement(By.xpath("//span/span/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		System.out.println("Select Grade/Marks");
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlgrademarks-container")).click();
		driver.findElement(By.xpath("//span/span/input")).sendKeys("Grade");
		driver.findElement(By.xpath("//span/span/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		System.out.println("Select Pattern Name");
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlPatternName-container")).click();
		driver.findElement(By.xpath("//span/span/input")).sendKeys("B.Com Hon Pattern");
		driver.findElement(By.xpath("//span/span/input")).sendKeys(Keys.ENTER);
		
		
//		System.out.println("Click on Edit SCHEME LIST");
//		driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvScheme_ctrl0_btnEdit")).click();
		
		Thread.sleep(2000);
		System.out.println("Click on Submit");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit")).click();
		
		//acceptAlert();
	}
	}
