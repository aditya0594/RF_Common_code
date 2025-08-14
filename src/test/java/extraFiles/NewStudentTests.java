package extraFiles;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewStudentTests {
	//public class NewStudentTests extends BaseClass {

//	LoginPageAdmin loginPage;
//	HomePageAdmin homePage;
//	
//	InputStream dataIs;
//	JSONObject loginUsers;
	
	public static WebDriver driver;
	


//@BeforeClass
//public void beforeClass() throws Exception {
//	try {
//		String dataFileName = "data/loginUsers.json";
//		dataIs = getClass().getClassLoader().getResourceAsStream(dataFileName);
//		JSONTokener tokener = new JSONTokener(dataIs);
//		loginUsers = new JSONObject(tokener);
//	}catch (Exception e) {
//		e.printStackTrace();
//		throw e;
//	} finally {
//		if (dataIs != null) {
//			dataIs.close();
//		}
//	}
//}

@AfterClass
public void afterClass() {
}
	
@BeforeMethod
public void beforeMethod(Method m) throws Exception{
	
	//driver = initializeDriverBFT("UrlAtlasAdmin");
	
	System.out.println("\n" + "******Starting Test: " + m.getName() + "*****" + "\n");
}
 
@AfterMethod
public void afterMethod() {
}

@Test()

public void User_able_to_create_New_Student() throws IOException, Exception {
	
//	loginPage = new LoginPageAdmin(driver);
//	
//	homePage = loginPage.login(loginUsers.getJSONObject("AtlasAdminLogin").getString("userName"), 
//			loginUsers.getJSONObject("AtlasAdminLogin").getString("password"));
	
	System.out.println("Click on Academic-> Admission Process -> New Student");
	driver.get("https://atlasuniversityuat.mastersofterp.in/academic/iitmsHE7+PocJtP77i+RKyYAFL1KA4TruUcaX86+8wKLgyGr9mJgSEO37kedQaTpNl8+t8qpPKiHLBiBE1cUEZJw63w==?enc=3Q2Y1k5BriJsFcxTY7ebQr2NsscpaMS40nFIhyqHwSo=");
	
//    driver.findElement(By.id("ctl00_repLinks_ctl01_lbLink")).click();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSearchStu")).click();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtStudentfullName")).click();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtStudentfullName")).clear();
    System.out.println("Enter Name of the Student (as per 10th marksheet)");
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtStudentfullName")).sendKeys("SUJATA AWTHAVNE");
    Thread.sleep(1000);
    
    //Unique every time
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtStudMobile")).clear();
    System.out.println("Enter  Student Mobile No.");
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtStudMobile")).sendKeys("8149914401");
    Thread.sleep(1000);
    //Unique every time
    
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtParentmobno")).clear();
    System.out.println("Enter  Parent Mobile No.");
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtParentmobno")).sendKeys("8149914475");
    Thread.sleep(1000);
    
    //Unique every time
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtStudEmail")).clear();
    System.out.println("Enter Personal EmailID");
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtStudEmail")).sendKeys("vishaldhande12@gmail.com");
    //Unique every time
    
    Thread.sleep(2000);
    System.out.println("Select State");
    driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlstate-container")).click();
    driver.findElement(By.xpath("//span/span/input")).clear();
    driver.findElement(By.xpath("//span/span/input")).sendKeys("MAHARASHTRA");
    driver.findElement(By.xpath("//span/span/input")).sendKeys(Keys.ENTER);
    Thread.sleep(2000);
    
//    System.out.println("Select City");
//    driver.findElement(By.xpath("//div[@id='ctl00_ContentPlaceHolder1_divCity']/span/span/span/i")).click();
//    System.out.println("Select City Nagpur");
//    driver.findElement(By.xpath("//span/span/input")).sendKeys(Keys.DOWN);
//    driver.findElement(By.xpath("//span/span/input")).clear();
//    driver.findElement(By.xpath("//span/span/input")).sendKeys("nag");
//    driver.findElement(By.xpath("//span/span/input")).sendKeys(Keys.ENTER);
    Thread.sleep(1000);
    System.out.println("Select Gender");
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_rdoFemale")).click();
    
    Thread.sleep(2000);
    System.out.println("Select School/Institute - ATLAS INSOFE School of Data Science");
    driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlSchool-container")).click();
    driver.findElement(By.xpath("//span/span/input")).sendKeys("ATLAS INSOFE School of Data Science");
    driver.findElement(By.xpath("//span/span/input")).sendKeys(Keys.ENTER);
    Thread.sleep(2000);
    
    System.out.println("Select Degree - Bachelor of Science in Hons");
    driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlDegree-container")).click();
    driver.findElement(By.xpath("//span/span/input")).sendKeys("Bachelor of Science in Hons");
    driver.findElement(By.xpath("//span/span/input")).sendKeys(Keys.ENTER);
    
    Thread.sleep(2000);
    System.out.println("Select Branch / Programme - Artificial Intelligence & Machine Learning");
    driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlBranch-container")).click();
    driver.findElement(By.xpath("//span/span/input")).sendKeys("Artificial Intelligence & Machine Learning");
    driver.findElement(By.xpath("//span/span/input")).sendKeys(Keys.ENTER);
    Thread.sleep(2000);
    
    System.out.println("Select Admission Type Regular");
    driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlAdmType-container")).click();
    driver.findElement(By.xpath("//span/span/input")).sendKeys("Regular");
    driver.findElement(By.xpath("//span/span/input")).sendKeys(Keys.ENTER);
    Thread.sleep(2000);
    
    System.out.println("Select Category OBC");
    driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlAllotedCat-container")).click();
    driver.findElement(By.xpath("//span/span/input")).sendKeys("OBC");
    driver.findElement(By.xpath("//span/span/input")).sendKeys(Keys.ENTER);
    Thread.sleep(2000);
    
    System.out.println("Select Payment Type OBC");
    driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlPaymentType-container")).click();
    driver.findElement(By.xpath("//span/span/input")).sendKeys("OBC");
    driver.findElement(By.xpath("//span/span/input")).sendKeys(Keys.ENTER);
    Thread.sleep(2000);
    
//    Thread.sleep(2000);
//    scrollIntoView(null, 0, 1200);
//    System.out.println("Click on Submit");
//    driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSave")).click();
//    Thread.sleep(2000);
//    
//    acceptAlert();
	
}
}
