package extraFiles;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//public class BulkStudentUserCreation extends BaseClass {
public class BulkStudentUserCreation  {

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
//		}catch (Exception e) {
//			e.printStackTrace();
//			throw e;
//		} finally {
//			if (dataIs != null) {
//				dataIs.close();
//			}
//		}
//	}
	
	@AfterClass
	public void afterClass() {
	}
	
	@BeforeMethod
//	public void beforeMethod(Method m) throws Exception{
//		
//		driver = initializeDriverBFT("UrlAtlasAdmin");
//		
//		System.out.println("\n" + "*****Starting Test: " + m.getName() + "******" + "\n");
//	}
	
	@AfterMethod
	public void afterMethod() {
	}
	
	
	@Test()
	
	public void User_able_to_Bulk_Student_User_Creation() throws IOException, Exception {
		
//		loginPage = new LoginPageAdmin(driver);
//		
//		homePage = loginPage.login(loginUsers.getJSONObject("AtlasAdminLogin").getString("userName"),
//				loginUsers.getJSONObject("AtlasAdminLogin").getString("password"));
				
				System.out.println("Academic-> USER MANAGEMENT -> Bulk Student User Creation -> Create Student Login");
				driver.get("https://atlasuniversityuat.mastersofterp.in/administration/iitms8HN+3fBCXVPmJDM0d1d7XlWcvMHz0X06ApQA5qZ7G38PyNdKCYetZ599tEVpgGef?enc=3Q2Y1k5BriJsFcxTY7ebQnwG7koRzid376GIlp0v99k=");
				
				System.out.println("click on Page Create Student Login");
				driver.findElement(By.linkText("Create Student Login")).click();
				
				Thread.sleep(2000);
				System.out.println("Select the Admission Batch 2022-2023");
				driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlAdmBatch-container")).click();
				driver.findElement(By.xpath("//span/span/input")).sendKeys("2022-2023");
				driver.findElement(By.xpath("//span/span/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(2000);
				System.out.println("click on School/Institute - ATLAS ISME School of Management Entrepreneurship - MUMBAI");
				driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlColg-container")).click();
				driver.findElement(By.xpath("//span/span/input")).sendKeys("ATLAS ISME School of Management Entrepreneurship - MUMBAI");
				driver.findElement(By.xpath("//span/span/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(2000);
				System.out.println("click on Degree - Bachelor of Business Administration");
				driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlDegree-container")).click();
				driver.findElement(By.xpath("//span/span/input")).sendKeys("Bachelor of Business Administration");
				driver.findElement(By.xpath("//span/span/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(2000);
				System.out.println("click on Programme/Branch - Bachelor of Business Administration");
				driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlBranch-container")).click();
				driver.findElement(By.xpath("//span/span/input")).sendKeys("Bachelor of Business Administration");
				driver.findElement(By.xpath("//span/span/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(2000);
				System.out.println("click on Semester - I");
				driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddSemester-container")).click();
				driver.findElement(By.xpath("//span/span/input")).sendKeys("I");
				driver.findElement(By.xpath("//span/span/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(2000);
				System.out.println("click on Radio Button - Password Same As Registration No.");
				driver.findElement(By.id("ctl00_ContentPlaceHolder1_rdRegPass")).click();
				
				Thread.sleep(2000);
				System.out.println("click on Show button");
				driver.findElement(By.name("ctl00$ContentPlaceHolder1$btnShow")).click();
				
				Thread.sleep(2000);
				System.out.println("click on SearchBox and Enter Name - Yuvika Varma");
				driver.findElement(By.xpath("//*[@id=\"tblStudents_filter\"]/label/input")).sendKeys("Yuvika Varma");
				
				Thread.sleep(2000);
				System.out.println("click on Student List Table Grid - Yuvika Varma");
				//driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvStudents_ctrl0_chkRow")).click();
				//driver.findElement(By.name("ctl00$ContentPlaceHolder1$lvStudents$ctrl108$chkRow")).click();
				if(!driver.findElement(By.name("ctl00$ContentPlaceHolder1$lvStudents$ctrl108$chkRow")).isSelected()) 
				{
				  driver.findElement(By.name("ctl00$ContentPlaceHolder1$lvStudents$ctrl108$chkRow")).click();
				}
				
				Thread.sleep(2000);
				System.out.println("click on Create Login");
				driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnCreateLogin")).click();
				
				//acceptAlert();
				
	}
}
