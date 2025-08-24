package StudentAdmissionTest.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utility.BaseClass;

import java.io.IOException;

public class AL_Configuration_UM_BulkStudentIUserCreation_StudentFlow_Flow_05 extends BaseClass {
    public AL_Configuration_UM_BulkStudentIUserCreation_StudentFlow_Flow_05(WebDriver rdriver) {
        driver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    public void User_able_to_Bulk_Student_User_Creation(String StudentName) throws IOException, Exception {

//		loginPage = new LoginPageAdmin(driver);
//
//		homePage = loginPage.login(loginUsers.getJSONObject("AtlasAdminLogin").getString("userName"),
//				loginUsers.getJSONObject("AtlasAdminLogin").getString("password"));
        System.out.println("Academic-> USER MANAGEMENT -> Bulk Student User Creation -> Create Student Login");
        //	driver.get("https://atlasuniversityuat.mastersofterp.in/administration/iitms8HN+3fBCXVPmJDM0d1d7XlWcvMHz0X06ApQA5qZ7G38PyNdKCYetZ599tEVpgGef?enc=3Q2Y1k5BriJsFcxTY7ebQnwG7koRzid376GIlp0v99k=");
        System.out.println("Going on the Configuration");
        WebElement configurationMove =  driver.findElement(By.linkText("Configuration"));
        Actions action = new Actions(driver);
        action.moveToElement(configurationMove).perform();
        System.out.println("click  on the User Management");
        driver.findElement(By.linkText("User Management")).click();
        System.out.println("Click on the Bulk Student User Creation ");
        driver.findElement(By.linkText("Bulk Student User Creation")).click();
        System.out.println( "Click on the Create Student Login ");
        driver.findElement(By.xpath("//a[normalize-space()='Create Student Login']")).click();
        Thread.sleep(2000);
        System.out.println("Select the Admission Batch 2024-2025");
        driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlAdmBatch-container")).click();
        driver.findElement(By.xpath("//span/span/input")).sendKeys("2024-25");
        driver.findElement(By.xpath("//span/span/input")).sendKeys(Keys.ENTER);

        Thread.sleep(2000);
        System.out.println("click on School/Institute - Crescent School of Architecture - Chennai");
        driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlColg-container")).click();
        driver.findElement(By.xpath("//span/span/input")).sendKeys("Crescent School of Architecture - Chennai");
        driver.findElement(By.xpath("//span/span/input")).sendKeys(Keys.ENTER);

        Thread.sleep(2000);
        System.out.println("click on Degree - Bachelor of Architecture");
        driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlDegree-container")).click();
        driver.findElement(By.xpath("//span/span/input")).sendKeys("Bachelor of Architecture");
        driver.findElement(By.xpath("//span/span/input")).sendKeys(Keys.ENTER);

        Thread.sleep(2000);
        System.out.println("click on Programme/Branch - Architecture");
        driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlBranch-container")).click();
        driver.findElement(By.xpath("//span/span/input")).sendKeys("Architecture");
        driver.findElement(By.xpath("//span/span/input")).sendKeys(Keys.ENTER);

        Thread.sleep(2000);
        System.out.println("click on Semester - I");
        driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddSemester-container")).click();
        driver.findElement(By.xpath("//span/span/input")).sendKeys("I");
        driver.findElement(By.xpath("//span/span/input")).sendKeys(Keys.TAB);



//				Thread.sleep(2000);
//				System.out.println("click on Radio Button - Password Same As Registration No.");
//				driver.findElement(By.id("ctl00_ContentPlaceHolder1_rdRegPass")).click();

        Thread.sleep(2000);
        System.out.println("click on Show button");
        driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_btnShow']")).click();

        Thread.sleep(2000);
        System.out.println("click on SearchBox and Enter Name - Yuvika Varma");
        driver.findElement(By.xpath("//*[@id=\"tblStudents_filter\"]/label/input")).sendKeys(StudentName);

        Thread.sleep(2000);
        System.out.println("click on Student List Table Grid - Yuvika Varma");
        //driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvStudents_ctrl0_chkRow")).click();
        //driver.findElement(By.name("ctl00$ContentPlaceHolder1$lvStudents$ctrl108$chkRow")).click();
        System.out.println("Select searched student ");
        driver.findElement(By.xpath("(//input[contains(@id,'ctl00_ContentPlaceHolder1_lvStudents_ctr')])[1]")).click();

        Thread.sleep(2000);
        System.out.println("click on Create Login");
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnCreateLogin")).click();
        Thread.sleep(2000);
        Alert alert =  driver.switchTo().alert();
        String Expected_Msg = "Students Login Created Successfully";
        String Actual_Msg = alert.getText();
        Assert.assertEquals(Actual_Msg , Expected_Msg );
        System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
        alert.accept();



    }

}
