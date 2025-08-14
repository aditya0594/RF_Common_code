package RFCCAcademic;

import java.io.File;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utility.BaseClass;

public class SL_Academic_SR_StudentInformation extends BaseClass
{
    public SL_Academic_SR_StudentInformation(WebDriver rdriver) {
        driver = rdriver;
        PageFactory.initElements(rdriver, this);
    }
    
    // WebElement locators using FindBy annotations
    @FindBy(linkText = "Student Related")
    private WebElement studentRelated;
    
    @FindBy(linkText = "Student Information")
    private WebElement studentInformation;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_txtStudMobile")
    private WebElement mobileNo;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_txtBirthPlace")
    private WebElement birthplace;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_ddlNationality")
    private WebElement nationality;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_ddlReligion")
    private WebElement religen;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_txtAddharCardNo")
    private WebElement adharcard;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_txtABCCId")
    private WebElement abcID;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_btnPhotoUpload")
    private WebElement uploadbtn;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit")
    private WebElement saveContinuebtn;  
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_txtPermAddress")
    private WebElement addressdetails;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_ddlPermCountry")
    private WebElement country;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_ddlPermState")
    private WebElement state;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_ddlPdistrict")
    private WebElement district;
    
    @FindBy(id = "ddlPermCity")
    private WebElement city;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_txtPermPIN")
    private WebElement pincode;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_lvBinddata_ctrl0_btnSubmit")
    private WebElement upload10th;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_lvBinddata_ctrl1_btnSubmit")
    private WebElement upload12th;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_lvBinddata_ctrl2_btnSubmit")
    private WebElement uploadAdharcard;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_lvBinddata_ctrl3_btnSubmit")
    private WebElement uploadaddressperticular;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_lvBinddata_ctrl3_btnSubmit")
    private WebElement medicalrecod;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_lvBinddata_ctrl5_btnSubmit")
    private WebElement communitycertificate;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_lvBinddata_ctrl6_btnSubmit")
    private WebElement conductcertificate;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_lvBinddata_ctrl9_btnSubmit")
    private WebElement uploadjointdeclaration;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_lvBinddata_ctrl10_btnSubmit")
    private WebElement uploadJointUndertaking;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_lvBinddata_ctrl11_btnSubmit")
    private WebElement uploadJointUndertakingTamil;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_lvBinddata_ctrl13_btnSubmit")
    private WebElement uploadotherdocuments;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_lvBinddata_ctrl14_btnSubmit")
    private WebElement uploadphotograph;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_lvBinddata_ctrl15_btnSubmit")
    private WebElement uploadprofielofstudent;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_lvBinddata_ctrl16_btnSubmit")
    private WebElement uploadtransfercertificate;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_btnSave") 
    private WebElement nextContinue;

	public SL_Academic_SR_StudentInformation loginPage() throws InterruptedException {

		System.out.println("Enter UserName ->  210011601001"); //100 -> Student
		driver.findElement(By.id("txt_username")).sendKeys("210011601001");  
		//191291601067

		System.out.println("Enter Password  -> Admin@12345");
		driver.findElement(By.id("txt_password")).sendKeys("Admin@12345");
		// Thread.sleep(2000);

		// captchaHandle();
		System.out.println("Enter Master Captcha -> UAT - >RFC123 || Live -> RFC@123");
		driver.findElement(By.id("txtcaptcha")).sendKeys("4321");

		//Thread.sleep(2000);
		System.out.println("Press Login Button");
		driver.findElement(By.id("btnLogin")).click();
		
		Thread.sleep(1000);
		try
		{
			WebElement skipButton = driver.findElement(By.className("introjs-skipbutton"));
			if (skipButton != null && skipButton.isDisplayed())
			{
				skipButton.click();
				System.out.println("Click on Skip Notice / News");
			}
			else
			{
				System.out.println("Skip Button is not Prescent");
			}
			
			//check weather the Notice Modal is present or not
			Thread.sleep(1000);
			WebElement closeButton = driver.findElement(By.xpath("//*[@id=\"noticemodal\"]/div/div/div[1]/button/span"));
			if (closeButton != null && closeButton.isDisplayed())
			{
				closeButton.click();
				System.out.println("Click on close button of, Notice Modal");
			}
			else
			{
				System.out.println("Notice Modal close button is not prescent");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Something went wrong");
		}
		return this;

	}
	
	
    public SL_Academic_SR_StudentInformation clickStudentRelated() {
        System.out.println("Click on Student Related");
        studentRelated.click();
        return this;
    }
    
 
    public SL_Academic_SR_StudentInformation clickStudentInformation() {
        System.out.println("Click on Student Information");
        studentInformation.click();
        return this;
    }
    
    public SL_Academic_SR_StudentInformation Enter_MobileNo() {
        System.out.println("Enter Mobile number > 9766698645");
        mobileNo.clear();
        mobileNo.sendKeys("9766698645");
        return this;
    }
    
    public SL_Academic_SR_StudentInformation Enter_BirthPlace() {
        System.out.println("Enter Birth Place > Nagpur");
        birthplace.clear();
        birthplace.sendKeys("Nagpur");
        return this;
    }
    

    public SL_Academic_SR_StudentInformation Select_Nationality() {
        String criteria = "Indian";
        System.out.println("Search Criteria -> " + criteria);
        Select criteriaSelect = new Select(nationality);
        criteriaSelect.selectByVisibleText(criteria);
        return this;
    }                             
    

    public SL_Academic_SR_StudentInformation Select_Religion() {
        String branch = "Islam";
        System.out.println("BRANCH -> " + branch);
        Select branchSelect = new Select(religen);
        branchSelect.selectByVisibleText(branch);
        return this;
    }
    

    public SL_Academic_SR_StudentInformation Enter_AdharCard() {
        System.out.println("Enter Adhar Card > 746095564190");
        adharcard.clear();
        adharcard.sendKeys("746095564190");
        return this;
    }
    
    public SL_Academic_SR_StudentInformation Enter_ABC_ID() {
        System.out.println("Enter_ABC_ID > RFCC 11");
    	js.executeScript("arguments[0].scrollIntoView();",nationality);
        abcID.clear();
        abcID.sendKeys("RFCC 11");
        return this;
    }
    

    public SL_Academic_SR_StudentInformation Upload_Photo() throws InterruptedException {
        System.out.println("Upload photo");
    	js.executeScript("arguments[0].scrollIntoView();",saveContinuebtn);

        File uploadFile1 = new File(".\\src\\test\\resources\\documentsForTesting\\MalePic.jpg");
        WebElement fileInput = driver.findElement(By.id("ctl00_ContentPlaceHolder1_fuPhotoUpload"));
        fileInput.sendKeys(uploadFile1.getAbsolutePath());
        threadWait1();
        uploadbtn.click();
        
        Thread.sleep(2000); 
        Alert alert =  driver.switchTo().alert();
        String Expected_Msg = "Photo uploaded Successfully!!"; 
        String Actual_Msg = alert.getText();
        Assert.assertEquals(Actual_Msg , Expected_Msg );
        System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
        alert.accept();
        return this;
    }
    
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public SL_Academic_SR_StudentInformation Click_SaveContinueBtn() {
        System.out.println("Click Save and Continue Btn");
		js.executeScript("arguments[0].click();", saveContinuebtn);
        return this;
    }

    // Address Details
    
    public SL_Academic_SR_StudentInformation Click_AddressDetails() {
        System.out.println("Click on Address Details");
        addressdetails.sendKeys("At post Pimpi Chichwad behind bus stand");
        return this;
    }
    
    public SL_Academic_SR_StudentInformation Enter_Country() {
    	String criteria = "INDIA";
        System.out.println("Enter Country -> " + criteria);
        Select criteriaSelect = new Select(country);
        criteriaSelect.selectByVisibleText(criteria);
        return this;
    }
    
    public SL_Academic_SR_StudentInformation Enter_State() {
    	String criteria = "Maharashtra";
        System.out.println("Enter State -> " + criteria);
        Select criteriaSelect = new Select(state);
        criteriaSelect.selectByVisibleText(criteria);
        return this;
    }
    
    public SL_Academic_SR_StudentInformation Enter_District() {
    	String criteria = "Pune";
        System.out.println("Enter District -> " + criteria);
        Select criteriaSelect = new Select(district);
        criteriaSelect.selectByVisibleText(criteria);
        return this;
    }
    
    public SL_Academic_SR_StudentInformation Enter_City() {
    	String criteria = "Pune";
        System.out.println("Enter City -> " + criteria);
        Select criteriaSelect = new Select(city);
        criteriaSelect.selectByVisibleText(criteria);
        return this;
    }
    
    public SL_Academic_SR_StudentInformation Enter_PinCode() {
    	String criteria = "440215";
        System.out.println("Enter Pin Code -> " + criteria);
        pincode.clear();
        pincode.sendKeys(criteria);
        return this;
    }
    
    // Document Upload
    
    public SL_Academic_SR_StudentInformation Upload_10th_Marksheet() throws InterruptedException {
        System.out.println("Upload_10th_Marksheet");
        File uploadFile1 = new File(".\\src\\test\\resources\\documentsForTesting\\HSC_MARKSHEET.jpg");
        WebElement fileInput = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvBinddata_ctrl0_fuFile"));
        fileInput.sendKeys(uploadFile1.getAbsolutePath());
        threadWait1();
        upload10th.click();
        
        Thread.sleep(2000); 
        Alert alert =  driver.switchTo().alert();
        String Expected_Msg = "Document Uploaded Successfully.... !"; 
        String Actual_Msg = alert.getText();
        Assert.assertEquals(Actual_Msg , Expected_Msg );
        System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
        alert.accept();
        return this;
    }
    
    public SL_Academic_SR_StudentInformation Upload_12th_Marksheet() throws InterruptedException {
        System.out.println("Upload_12th_Marksheet");
        File uploadFile1 = new File(".\\src\\test\\resources\\documentsForTesting\\HSC_MARKSHEET.jpg");
        WebElement fileInput = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvBinddata_ctrl1_fuFile"));
        fileInput.sendKeys(uploadFile1.getAbsolutePath());
        threadWait1();
        upload12th.click();
        
        Thread.sleep(2000); 
        Alert alert =  driver.switchTo().alert();
        String Expected_Msg = "Document Uploaded Successfully.... !"; 
        String Actual_Msg = alert.getText();
        Assert.assertEquals(Actual_Msg , Expected_Msg );
        System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
        alert.accept();
        return this;
    }
    
    
    public SL_Academic_SR_StudentInformation Upload_AdharCard() throws InterruptedException {
        System.out.println("Upload_AdharCard");
        File uploadFile1 = new File(".\\src\\test\\resources\\documentsForTesting\\ADHAR_CARD.jpg");
        WebElement fileInput = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvBinddata_ctrl2_fuFile"));
        fileInput.sendKeys(uploadFile1.getAbsolutePath());
        threadWait1();
        uploadAdharcard.click();
        
        Thread.sleep(2000); 
        Alert alert =  driver.switchTo().alert();
        String Expected_Msg = "Document Uploaded Successfully.... !"; 
        String Actual_Msg = alert.getText();
        Assert.assertEquals(Actual_Msg , Expected_Msg );
        System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
        alert.accept();
        return this;
    }
    
    
    public SL_Academic_SR_StudentInformation Upload_Addressparticulars() throws InterruptedException {
        System.out.println("Upload_Address particulars");
        File uploadFile1 = new File(".\\src\\test\\resources\\documentsForTesting\\ADHAR_CARD.jpg");
        WebElement fileInput = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvBinddata_ctrl3_fuFile"));
        fileInput.sendKeys(uploadFile1.getAbsolutePath());
        threadWait1();
        uploadaddressperticular.click();
        
        Thread.sleep(2000); 
        Alert alert =  driver.switchTo().alert();
        String Expected_Msg = "Document Uploaded Successfully.... !"; 
        String Actual_Msg = alert.getText();
        Assert.assertEquals(Actual_Msg , Expected_Msg );
        System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
        alert.accept();
        return this;
    }
    
    public SL_Academic_SR_StudentInformation Upload_CandidateMedicalRecord() throws InterruptedException {
        System.out.println("Upload_Candidate’s Medical Record");
        File uploadFile1 = new File(".\\src\\test\\resources\\documentsForTesting\\ADHAR_CARD.jpg");
        WebElement fileInput = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvBinddata_ctrl4_fuFile"));
        fileInput.sendKeys(uploadFile1.getAbsolutePath());
        threadWait1();
        medicalrecod.click();
        
        Thread.sleep(2000); 
        Alert alert =  driver.switchTo().alert();
        String Expected_Msg = "Document Uploaded Successfully.... !"; 
        String Actual_Msg = alert.getText();
        Assert.assertEquals(Actual_Msg , Expected_Msg );
        System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
        alert.accept();
        return this;
    }
    
    public SL_Academic_SR_StudentInformation Upload_CommunityCertificate() throws InterruptedException {
        System.out.println("Upload_CommunityCertificate");
        File uploadFile1 = new File(".\\src\\test\\resources\\documentsForTesting\\ADHAR_CARD.jpg");
        WebElement fileInput = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvBinddata_ctrl5_fuFile"));
        fileInput.sendKeys(uploadFile1.getAbsolutePath());
        threadWait1();
        communitycertificate.click();
        
        Thread.sleep(2000); 
        Alert alert =  driver.switchTo().alert();
        String Expected_Msg = "Document Uploaded Successfully.... !"; 
        String Actual_Msg = alert.getText();
        Assert.assertEquals(Actual_Msg , Expected_Msg );
        System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
        alert.accept();
        return this;
    }
    
    public SL_Academic_SR_StudentInformation Upload_ConductCertificate() throws InterruptedException {
        System.out.println("Upload_ConductCertificate");
        File uploadFile1 = new File(".\\src\\test\\resources\\documentsForTesting\\ADHAR_CARD.jpg");
        WebElement fileInput = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvBinddata_ctrl6_fuFile"));
        fileInput.sendKeys(uploadFile1.getAbsolutePath());
        threadWait1();
        conductcertificate.click();
        
        Thread.sleep(2000); 
        Alert alert =  driver.switchTo().alert();
        String Expected_Msg = "Document Uploaded Successfully.... !"; 
        String Actual_Msg = alert.getText();
        Assert.assertEquals(Actual_Msg , Expected_Msg );
        System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
        alert.accept();
        return this;
    }
    
    public SL_Academic_SR_StudentInformation Upload_JointDeclaration() throws InterruptedException {
        System.out.println("Upload_JointDeclaration");
        File uploadFile1 = new File(".\\src\\test\\resources\\documentsForTesting\\ADHAR_CARD.jpg");
        WebElement fileInput = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvBinddata_ctrl9_fuFile"));
        fileInput.sendKeys(uploadFile1.getAbsolutePath());
        threadWait1();
        uploadjointdeclaration.click();
        
        Thread.sleep(2000); 
        Alert alert =  driver.switchTo().alert();
        String Expected_Msg = "Document Uploaded Successfully.... !"; 
        String Actual_Msg = alert.getText();
        Assert.assertEquals(Actual_Msg , Expected_Msg );
        System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
        alert.accept();
        return this;
    }
    
    public SL_Academic_SR_StudentInformation Upload_JointUndertakingHindi() throws InterruptedException {
        System.out.println("Upload_JointUndertakingHindi");
        File uploadFile1 = new File(".\\src\\test\\resources\\documentsForTesting\\ADHAR_CARD.jpg");
        WebElement fileInput = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvBinddata_ctrl10_fuFile"));
        fileInput.sendKeys(uploadFile1.getAbsolutePath());
        threadWait1();
        uploadJointUndertaking.click();
        
        Thread.sleep(2000); 
        Alert alert =  driver.switchTo().alert();
        String Expected_Msg = "Document Uploaded Successfully.... !"; 
        String Actual_Msg = alert.getText();
        Assert.assertEquals(Actual_Msg , Expected_Msg );
        System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
        alert.accept();
        return this;
    }
    
    public SL_Academic_SR_StudentInformation Upload_JointUndertakingTamil() throws InterruptedException {
        System.out.println("Upload_JointUndertakingTamil");
        File uploadFile1 = new File(".\\src\\test\\resources\\documentsForTesting\\ADHAR_CARD.jpg");
        WebElement fileInput = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvBinddata_ctrl11_fuFile"));
        fileInput.sendKeys(uploadFile1.getAbsolutePath());
        threadWait1();
        uploadJointUndertakingTamil.click();
        
        Thread.sleep(2000); 
        Alert alert =  driver.switchTo().alert();
        String Expected_Msg = "Document Uploaded Successfully.... !"; 
        String Actual_Msg = alert.getText();
        Assert.assertEquals(Actual_Msg , Expected_Msg );
        System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
        alert.accept();
        return this;
    }
    
    public SL_Academic_SR_StudentInformation Upload_Otherdocuments() throws InterruptedException {
        System.out.println("Upload_Otherdocuments");
        File uploadFile1 = new File(".\\src\\test\\resources\\documentsForTesting\\ADHAR_CARD.jpg");
        WebElement fileInput = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvBinddata_ctrl13_fuFile"));
        fileInput.sendKeys(uploadFile1.getAbsolutePath());
        threadWait1();
        uploadotherdocuments.click();
        
        Thread.sleep(2000); 
        Alert alert =  driver.switchTo().alert();
        String Expected_Msg = "Document Uploaded Successfully.... !"; 
        String Actual_Msg = alert.getText();
        Assert.assertEquals(Actual_Msg , Expected_Msg );
        System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
        alert.accept();
        return this;
    }
    
    
    public SL_Academic_SR_StudentInformation Upload_Photograph() throws InterruptedException {
        System.out.println("Upload_Photograph");
        File uploadFile1 = new File(".\\src\\test\\resources\\documentsForTesting\\ADHAR_CARD.jpg");
        WebElement fileInput = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvBinddata_ctrl14_fuFile"));
        fileInput.sendKeys(uploadFile1.getAbsolutePath());
        threadWait1();
        uploadphotograph.click();
        
        Thread.sleep(2000); 
        Alert alert =  driver.switchTo().alert();
        String Expected_Msg = "Document Uploaded Successfully.... !"; 
        String Actual_Msg = alert.getText();
        Assert.assertEquals(Actual_Msg , Expected_Msg );
        System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
        alert.accept();
        return this;
    }
    
    public SL_Academic_SR_StudentInformation Upload_Profileofthestudent() throws InterruptedException {
        System.out.println("Upload_Profileofthestudent");
        File uploadFile1 = new File(".\\src\\test\\resources\\documentsForTesting\\ADHAR_CARD.jpg");
        WebElement fileInput = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvBinddata_ctrl15_fuFile"));
        fileInput.sendKeys(uploadFile1.getAbsolutePath());
        threadWait1();
        uploadprofielofstudent.click();
        
        Thread.sleep(2000); 
        Alert alert =  driver.switchTo().alert();
        String Expected_Msg = "Document Uploaded Successfully.... !"; 
        String Actual_Msg = alert.getText();
        Assert.assertEquals(Actual_Msg , Expected_Msg );
        System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
        alert.accept();
        return this;
    }
    
    public SL_Academic_SR_StudentInformation Upload_TransferCertificate() throws InterruptedException {
        System.out.println("Upload_TransferCertificate");
        File uploadFile1 = new File(".\\src\\test\\resources\\documentsForTesting\\ADHAR_CARD.jpg");
        WebElement fileInput = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lvBinddata_ctrl16_fuFile"));
        fileInput.sendKeys(uploadFile1.getAbsolutePath());
        threadWait1();
        uploadtransfercertificate.click();
        
        Thread.sleep(2000); 
        Alert alert =  driver.switchTo().alert();
        String Expected_Msg = "Document Uploaded Successfully.... !"; 
        String Actual_Msg = alert.getText();
        Assert.assertEquals(Actual_Msg , Expected_Msg );
        System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
        alert.accept();
        return this;
    }
    
    public SL_Academic_SR_StudentInformation Click_NextContinueBtn() {
        System.out.println("Click_NextContinueBtn");
        nextContinue.click();
        return this;
    }
    
    
    
}
