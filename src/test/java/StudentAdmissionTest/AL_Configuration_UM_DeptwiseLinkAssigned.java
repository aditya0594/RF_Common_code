package StudentAdmissionTest;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utility.BaseClass;

public class AL_Configuration_UM_DeptwiseLinkAssigned extends BaseClass {

    public AL_Configuration_UM_DeptwiseLinkAssigned(WebDriver rdriver) {
        driver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    By Showbtn = By.xpath("//input[@id='ctl00_ContentPlaceHolder1_btnShow']");

    public void deptWiseLinked(String StudentName) throws InterruptedException {
        System.out.println("Going on the Configuration");
        WebElement configurationMove =  driver.findElement(By.linkText("Configuration"));
        Actions action = new Actions(driver);
        action.moveToElement(configurationMove).perform();
        System.out.println("click  on the User Management");
        driver.findElement(By.linkText("User Management")).click();
        driver.findElement(By.linkText("Dept. Wise Link Assign")).click();
       // loader();
        System.out.println( "select user type : ");
        driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlUser-container")).click();
        driver.findElement(By.xpath("//span/span/input")).sendKeys("Student");
        driver.findElement(By.xpath("//span/span/input")).sendKeys(Keys.ENTER);
        Thread.sleep(1000);


        driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlDegree-container")).click();
        driver.findElement(By.xpath("//span/span/input")).sendKeys("Bachelor of Architecture");
        driver.findElement(By.xpath("//span/span/input")).sendKeys(Keys.ENTER);
        Thread.sleep(1000);


        driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlBranch-container")).click();
        driver.findElement(By.xpath("//span/span/input")).sendKeys("Architecture");
        driver.findElement(By.xpath("//span/span/input")).sendKeys(Keys.ENTER);
        Thread.sleep(1000);

        driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlSemester-container")).click();
        driver.findElement(By.xpath("//span/span/input")).sendKeys("I");
        Thread.sleep(500);
        driver.findElement(By.xpath("//span/span/input")).sendKeys(Keys.ENTER);



        System.out.println("Click on the show button");
        clickBy(Showbtn);


        By submitbtn = By.xpath("//input[@id='ctl00_ContentPlaceHolder1_btnSubmit']");
        By searchString = By.xpath("//input[@class='form-control form-control-sm']");
        By CheckboxforSelect = By.xpath("//input[contains(@id,'ctl00_ContentPlaceHolder1_lvDetail_ctrl')]");


        System.out.println("Enter the student name  : "+ StudentName);
        sendKeysBy(searchString,StudentName);
       // waitForVisibilityBy(CheckboxforSelect);
        clickBy(CheckboxforSelect);

        By ExpandAcademic = By.linkText("Academic");
        By studentReletedExpand = By.xpath("//a[@id='ctl00_ContentPlaceHolder1_tvLinksn225']//img[contains(@alt,'Expand')]");
        By studentRelated = By.linkText("Student Related");
        By studentInformation = By.linkText("Student Information");
        By studentInformationcheck = By.xpath("//a[text()='Student Information']/preceding-sibling::input[@type='checkbox']");
       driver.findElement(By.xpath("//a[@id='ctl00_ContentPlaceHolder1_tvLinkst52']")).click();
        // Get all expandable menu items (with '+')

        Thread.sleep(2000);

        WebElement studentRelatedWeb = driver.findElement(studentRelated);
        Actions actions = new Actions(driver);

        actions.moveToElement(studentRelatedWeb).click().perform();

        WebElement studentInformationele =  driver.findElement(studentInformation);
       // WebElement checkboxStudentInformation  = driver.findElement(By.id("ctl00_ContentPlaceHolder1_tvLinksn231CheckBox"));
        actions.moveToElement(studentInformationele);
        Thread.sleep(1000);
        action.click(driver.findElement(studentInformationcheck)).perform();


       // actions.click(checkboxStudentInformation).perform();
        clickBy(submitbtn);
        Thread.sleep(1000);


        Alert alert = driver.switchTo().alert();
        String Expected_Msg = "Record Saved Successfully.";
        String Actual_Msg = alert.getText();
        System.out.println(Actual_Msg = Expected_Msg);
        Thread.sleep(3000);
        Assert.assertEquals(Actual_Msg, Expected_Msg, "Actual and Expected Msg matched");
        alert.accept();


    }

}
