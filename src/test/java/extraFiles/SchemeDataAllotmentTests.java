package extraFiles;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SchemeDataAllotmentTests {

//	LoginPageAdmin loginPage;
//	HomePageAdmin homePage;
//	
//	InputStream dataIs;
//	JSONObject loginUsers;
	
	public static WebDriver driver;
	
	@BeforeClass
//	public void beforeClass() throws Exception{
//		try {
//			String dataFileName = "data/loginUsers.json";
//			dataIs = getClass().getClassLoader().getResourceAsStream(dataFileName);
//			JSONTokener tokener = new JSONTokener(dataIs);
//			loginUsers = new JSONObject(tokener);
//			}
//		catch (Exception e) {
//		e.printStackTrace();
//		throw e;
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
		
		System.out.println("\n" + "*******Starting Test : " + m.getName() + "*******" + "\n");
	}
	
	@AfterMethod
	public void afterMethod() {
}
	
	@Test()

	public void User_able_to_Create_Scheme_Data_Scheme_Allotment() throws IOException, Exception
	{
//		loginPage = new LoginPageAdmin(driver);
//		
//		homePage = loginPage.login(loginUsers.getJSONObject("AtlasAdminLogin").getString("userName"),
//				loginUsers.getJSONObject("AtlasAdminLogin").getString("password"));
		
		System.out.println("Academic-> POST ADMISSION -> Scheme Data -> Scheme Allotment");
		driver.get("https://atlasuniversityuat.mastersofterp.in/academic/iitmsVm7APjlVCdtt3V6WQ42nbvMCn90P3DofVTHJpZSIfhKULXOdDMmAngAvbOfnkFh6?enc=NX6ksWYoKz8LyeoRDPuA+V/90fAjPz3AR3jOuh3Yd3U=");
		
		Thread.sleep(2000);
		System.out.println("click on page Scheme Allotment");
		driver.findElement(By.linkText("Scheme Allotment")).click();
		
		Thread.sleep(2000);
		System.out.println("select  School/Institute - ATLAS INSOFE School of Data Science - MUMBAI");
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlCollege-container")).click();
		driver.findElement(By.xpath("//span/span/input")).sendKeys("ATLAS INSOFE School of Data Science - MUMBAI");
		driver.findElement(By.xpath("//span/span/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		System.out.println("select Degree - Bachelor of Science in Hons");
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlDegree-container")).click();
		driver.findElement(By.xpath("//span/span/input")).sendKeys("Bachelor of Science in Hons");
		driver.findElement(By.xpath("//span/span/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		System.out.println("Programme/Branch - Artificial Intelligence & Machine Learning");
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlBranch1-container")).click();
		driver.findElement(By.xpath("//span/span/input")).sendKeys("Artificial Intelligence & Machine Learning");
		driver.findElement(By.xpath("//span/span/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		System.out.println("Admission Batch - 2022-2023");
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlAdmBatch-container")).click();
		driver.findElement(By.xpath("//span/span/input")).sendKeys("2022-2023");
		driver.findElement(By.xpath("//span/span/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		System.out.println("Select Semester - I");
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlSemester1-container")).click();
		driver.findElement(By.xpath("//span/span/input")).sendKeys("I");
		driver.findElement(By.xpath("//span/span/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		System.out.println("Click on SHOW STUDENT");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnShowStudent")).click();
		
		Thread.sleep(2000);
		System.out.println("Select Branch for Scheme -Artificial Intelligence & Machine Learning");
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlBranchForScheme-container")).click();
		driver.findElement(By.xpath("//span/span/input")).sendKeys("Artificial Intelligence & Machine Learning");
		driver.findElement(By.xpath("//span/span/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		System.out.println("select Scheme/Path");
		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlScheme-container")).click();
		driver.findElement(By.xpath("//span/span/input")).sendKeys("B.Sc Hons-Artificial Intelligence & Machine Learning-2022-23-Digital Technology (NEW SCHEME)");
		driver.findElement(By.xpath("//span/span/input")).sendKeys(Keys.ENTER);
		
		//WebElement scroll = driver.findElement(By.className("navbar-nav  mr-auto"));
		//scrollIntoView(scroll, 0, 500);
		
//		Thread.sleep(2000);
//		System.out.println("Enter Name in Search box");
//		driver.findElement(By.xpath("//*[@id=\"tblStudentList_filter\"]/label/input")).sendKeys("Karl Sequeira");
//		
//		Thread.sleep(2000);
//		System.out.println("Select Student List");
//		driver.findElement(By.name("ctl00$ContentPlaceHolder1$lvStudents$ctrl1$cbRow")).click();
//		
//		Thread.sleep(2000);
//		System.out.println("click on ALLOT SCHEME");
//		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnAssignSch")).click();
		
	}
}