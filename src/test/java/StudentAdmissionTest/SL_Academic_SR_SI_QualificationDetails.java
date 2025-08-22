package StudentAdmissionTest;

import java.io.File;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utility.BaseClass;

public class SL_Academic_SR_SI_QualificationDetails extends BaseClass
{
    public SL_Academic_SR_SI_QualificationDetails(WebDriver rdriver) {
        driver = rdriver;
        PageFactory.initElements(rdriver, this);
    }
    
    @FindBy(linkText = "Student Information")
    private WebElement studentInformation;
    
    @FindBy(linkText = "Student Related")
    private WebElement studentRelated;
    
    @FindBy(linkText = "Qualification Details") 
    private WebElement qualificationdetailstab;
    
	   @FindBy(id = "ctl00_ContentPlaceHolder1_txtSchoolCollegeNameSsc") 
	    private WebElement schoolname;

	    @FindBy(id = "ctl00_ContentPlaceHolder1_txtBoardSsc") 
	    private WebElement board;
	    
	    @FindBy(id = "ctl00_ContentPlaceHolder1_txtYearOfExamSsc") 
	    private WebElement yearofexam;
	    
	    @FindBy(id = "ctl00_ContentPlaceHolder1_txtOutOfMarksSsc") 
	    private WebElement outofmarks10th;
	    
	    @FindBy(id = "ctl00_ContentPlaceHolder1_txtMarksObtainedSsc") 
	    private WebElement marksobtaine10th;
	  
	    
		   @FindBy(id = "ctl00_ContentPlaceHolder1_txtSchoolCollegeNameHssc") 
		    private WebElement schoolname12th;

		    @FindBy(id = "ctl00_ContentPlaceHolder1_txtBoardHssc") 
		    private WebElement board12th;
		    
		    @FindBy(id = "ctl00_ContentPlaceHolder1_txtYearOfExamHssc") 
		    private WebElement yearofexam12th;
		    
		    @FindBy(id = "ctl00_ContentPlaceHolder1_txtOutOfMarksHssc") 
		    private WebElement totalmarks12th;
		    
		    @FindBy(id = "ctl00_ContentPlaceHolder1_txtMarksObtainedHssc") 
		    private WebElement obtainedmarks12th;
		    
		    @FindBy(id = "ctl00_ContentPlaceHolder1_ddlExamNo") 
		    private WebElement entranceExamname;
		    
		    @FindBy(id = "ctl00_ContentPlaceHolder1_txtQExamRollNo") 
		    private WebElement EntranceSeatNo;
		 
		    @FindBy(id = "ctl00_ContentPlaceHolder1_txtYearOfExam") 
		    private WebElement EntranceYearOfExam;
		    
		    @FindBy(id = "ctl00_ContentPlaceHolder1_txtPer") 
		    private WebElement EntrancePercentage;
		    
		    @FindBy(id = "ctl00_ContentPlaceHolder1_txtEntMaxMarks") 
		    private WebElement entrancetotalmarks;
		    
		    @FindBy(id = "ctl00_ContentPlaceHolder1_txtEntObtMarks") 
		    private WebElement entranceobtainedmarks;
		    
		    @FindBy(id = "ctl00_ContentPlaceHolder1_txtAllIndiaRank") 
		    private WebElement entrancerank;
		    
		    @FindBy(id = "ctl00_ContentPlaceHolder1_txtCategoryRank") 
		    private WebElement categoryrank;
		    
		    @FindBy(id = "ctl00_ContentPlaceHolder1_btnAddEntranceExam") 
		    private WebElement addbtn;
		    
		    @FindBy(id = "ctl00_ContentPlaceHolder1_txtSchoolCollegeNameQualifying") 
		    private WebElement schoolnamePG;
		    
		    @FindBy(id = "ctl00_ContentPlaceHolder1_txtBoardQualifying") 
		    private WebElement boardPG;
		    
		    @FindBy(id = "ctl00_ContentPlaceHolder1_ddldegree") 
		    private WebElement qualifyingexamPG;
		    
		    @FindBy(id = "ctl00_ContentPlaceHolder1_txtQualExamRollNo") 
		    private WebElement seatnoPG;
		    
		    @FindBy(id = "ctl00_ContentPlaceHolder1_txtYearOfExamQualifying") 
		    private WebElement yearofexamPG;
		    
		    @FindBy(id = "ctl00_ContentPlaceHolder1_ddlPGResultStatus") 
		    private WebElement StatusPG;
		    
		    @FindBy(id = "ctl00_ContentPlaceHolder1_txtOutOfMarksQualifying") 
		    private WebElement outofmarksPG;
		    
		    @FindBy(id = "ctl00_ContentPlaceHolder1_txtMarksObtainedQualifying") 
		    private WebElement markobtainPG;
		    
		    @FindBy(id = "ctl00_ContentPlaceHolder1_txtGradeQualifying") 
		    private WebElement gradePG;
		    
		    @FindBy(id = "ctl00_ContentPlaceHolder1_txtPercentileQualifying") 
		    private WebElement dgpacgpaPG;
		    
		    @FindBy(id = "ctl00_ContentPlaceHolder1_txtQualExmAddress") 
		    private WebElement collegeAddressPG;
		    
		    @FindBy(id = "ctl00_ContentPlaceHolder1_btnAdd") 
		    private WebElement addbtnPG;
		    
		    @FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit") 
		    private WebElement SaveContinueQualificationDetails;
		    
		    @FindBy(id = "ctl00_ContentPlaceHolder1_rdVaccinated") 
		    private WebElement vaccination_yes;

             @FindBy(id = "ctl00_ContentPlaceHolder1_rdNotVaccinated")
            private WebElement vaccination_No;
		    
		    @FindBy(id = "ctl00_ContentPlaceHolder1_txtFirstDoseVaccName") 
		    private WebElement vaccinname1st;
		    
		    @FindBy(id = "ctl00_ContentPlaceHolder1_txtFirstDoseVaccCenter") 
		    private WebElement vaccincentre1st;
		    
		    @FindBy(id = "ctl00_ContentPlaceHolder1_txtFirstDoseVaccDate") 
		    private WebElement vaccinaDate1st;
		    
		    @FindBy(id = "ctl00_ContentPlaceHolder1_btnFirstDose") 
		    private WebElement vaccinaSubmit1st;
		    
		    @FindBy(id = "ctl00_ContentPlaceHolder1_txtSecondDoseVaccName") 
		    private WebElement vaccinname2nd;
		    
		    @FindBy(id = "ctl00_ContentPlaceHolder1_txtSecondDoseVaccCenter") 
		    private WebElement vaccincentre2nd;
		    
		    @FindBy(id = "ctl00_ContentPlaceHolder1_txtSecondDoseVaccDate") 
		    private WebElement vaccinaDate2nd;
		    
		    @FindBy(id = "ctl00_ContentPlaceHolder1_btnSecondDose") 
		    private WebElement vaccinaSubmit2nd;
		    
		    @FindBy(id = "ctl00_ContentPlaceHolder1_Button1") 
		    private WebElement saveContinueCovidInformation;
		    
		    @FindBy(id = "ctl00_ContentPlaceHolder1_ddlBank") 
		    private WebElement bankname;
		    
		    @FindBy(id = "ctl00_ContentPlaceHolder1_txtAccNo") 
		    private WebElement bankaccno;
		    
		    @FindBy(id = "ctl00_ContentPlaceHolder1_txtBranchName") 
		    private WebElement branchname;
		    
		    @FindBy(id = "ctl00_ContentPlaceHolder1_txtIFSC") 
		    private WebElement IFScode;
		    
		    @FindBy(id = "ctl00_ContentPlaceHolder1_txtBankAddress") 
		    private WebElement bankaddress;
		    
		    @FindBy(id = "ctl00_ContentPlaceHolder1_btnSave") 
		    private WebElement saveBtn;

		    
		    
		    
		    
		   
			public SL_Academic_SR_SI_QualificationDetails loginPage() throws InterruptedException {

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
			
		    public SL_Academic_SR_SI_QualificationDetails clickStudentInformation() {
		        System.out.println("Click on Student Information");
		        studentInformation.click();
		        return this;
		    }
		    
		    public SL_Academic_SR_SI_QualificationDetails clickStudentRelated() {
		        System.out.println("Click on Student Related");
		        studentRelated.click();
		        return this;
		    }
		    
		    public SL_Academic_SR_SI_QualificationDetails Click_QualificationDetailsTab() {
		        System.out.println("Click on Qualification DetailsTab");
		        qualificationdetailstab.click();
		        return this;
		    }
		    
		    
    public SL_Academic_SR_SI_QualificationDetails Enter_Schoolname10th() {
        System.out.println("Enter_Schoolname > City High School");
        schoolname.clear();
        schoolname.sendKeys("City High School");
        return this;
    }
    
    public SL_Academic_SR_SI_QualificationDetails Enter_Board10th() {
        System.out.println("Enter_Board > Maharashtra Board");
        board.clear();
        board.sendKeys("Maharashtra Board");
        return this;
    }
    
    public SL_Academic_SR_SI_QualificationDetails Enter_YearOfExam10th() {
        System.out.println("Enter_YearOfExam > 2009");
        yearofexam.clear();
        yearofexam.sendKeys("2009");
        return this;
    }

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_txtOutOfMarksSsc']")
    private WebElement OutOfMArk;

    public SL_Academic_SR_SI_QualificationDetails OutOfMArks() {
        System.out.println("Enter_Out of Marks > 500");
        OutOfMArk.clear();
        OutOfMArk.sendKeys("500");
        return this;
    }

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_txtMarksObtainedSsc']")
    private WebElement MarksObtained;

    public SL_Academic_SR_SI_QualificationDetails MarksObtain() {
        System.out.println("Enter mark obtained  > 300");
        MarksObtained.clear();
        MarksObtained.sendKeys("300");
        return this;
    }
    
    public SL_Academic_SR_SI_QualificationDetails Enter_OutOfMarks10th() throws InterruptedException {
        System.out.println("Enter_OutOfMarks > 600");
        outofmarks10th.clear();
        threadWait1();
        js.executeScript("arguments[0].value = arguments[1]",outofmarks10th, "600");

//        outofmarks10th.sendKeys("700");
        return this;
    }
    
    public SL_Academic_SR_SI_QualificationDetails Enter_MarkObtain10th() {
        System.out.println("Enter_MarkObtain10th > 450");
        marksobtaine10th.clear();
        js.executeScript("arguments[0].value = arguments[1]",marksobtaine10th, "410");

//        marksobtaine10th.sendKeys("450");
        return this;
    }
    
    public SL_Academic_SR_SI_QualificationDetails Enter_SchoolName12th() {
        System.out.println("Enter_SchoolName12th > Shahu Garden");
        schoolname12th.clear();
        schoolname12th.sendKeys("Shahu Garden");
        return this;
    }
    
    public SL_Academic_SR_SI_QualificationDetails Enter_Board12th() {
        System.out.println("Enter_Board12th > ");
        board12th.clear();
        board12th.sendKeys("Maharashtra");
        return this;
    }
    
    
    public SL_Academic_SR_SI_QualificationDetails Enter_YearOfExam12th() {
        System.out.println("Enter_YearOfExam12th > 2011");
        yearofexam12th.clear();
        yearofexam12th.sendKeys("2011");
        return this;
    }
    
    public SL_Academic_SR_SI_QualificationDetails Enter_TotalMarks12th() {
        System.out.println("Enter_TotalMarks12th > 600");
        clearText(totalmarks12th);
        js.executeScript("arguments[0].value = arguments[1]",totalmarks12th, "700");
//        totalmarks12th.sendKeys("700");
        return this;
    }
    
    public SL_Academic_SR_SI_QualificationDetails Enter_MarkObtained12th() {
        System.out.println("Enter_MarkObtained12th > 500");
        clearText(obtainedmarks12th);
        js.executeScript("arguments[0].value = arguments[1]",obtainedmarks12th, "500");

//        obtainedmarks12th.sendKeys("500");
        return this;
    }
    

	JavascriptExecutor js = (JavascriptExecutor) driver;

    public SL_Academic_SR_SI_QualificationDetails Enter_EntranceExamName() {
		js.executeScript("arguments[0].scrollIntoView();",yearofexam12th);
        String examname = "State Common Entrance Test";
        Select select = new Select(entranceExamname);
        select.selectByVisibleText(examname);
        System.out.println("Enter_EntranceExamName > "+examname);
        return this;
    }
    
    public SL_Academic_SR_SI_QualificationDetails Enter_SeatNo() {
        String num="MS 7845213";
        EntranceSeatNo.clear();
        EntranceSeatNo.sendKeys(num);
        System.out.println("Enter_SeatNo > "+num);
        return this;
    }
    
    public SL_Academic_SR_SI_QualificationDetails Enter_YearOfExam() {
        String num="2011";
        EntranceYearOfExam.clear();
        EntranceYearOfExam.sendKeys(num);
        System.out.println("Enter_YearOfExam > "+num);
        return this;
    }
    
    public SL_Academic_SR_SI_QualificationDetails Enter_Percentage() {
        String num="69";
        EntrancePercentage.clear();
        EntrancePercentage.sendKeys(num);
        System.out.println("Enter_Percentage > "+num);
        return this;
    }
    
    public SL_Academic_SR_SI_QualificationDetails Enter_TotalMarks() {
        String num="200";
        entrancetotalmarks.clear();
        entrancetotalmarks.sendKeys(num);
        System.out.println("Enter_TotalMarks > "+num);
        return this;
    }
    
    public SL_Academic_SR_SI_QualificationDetails Enter_EntranceObtainedMarks() {
        String num="130";
        entranceobtainedmarks.clear();
        entranceobtainedmarks.sendKeys(num);
        System.out.println("Enter_ObtainedMarks > "+num);
        return this;
    }
    
    public SL_Academic_SR_SI_QualificationDetails Enter_Rank() {
        String num="111";
        entrancerank.clear();
        entrancerank.sendKeys(num);
        System.out.println("Enter_Rank > "+num);
        return this;
    }
    
    public SL_Academic_SR_SI_QualificationDetails Enter_CategoryRank() {
        String num="74";
        categoryrank.clear();
        categoryrank.sendKeys(num);
        System.out.println("Enter_CategoryRank > "+num);
        return this;
    }
    
    public SL_Academic_SR_SI_QualificationDetails Click_EntranceAddBtn() {   
        addbtn.click();
        System.out.println("Click_EntranceAddBtn");
        return this;
    }
    
    public SL_Academic_SR_SI_QualificationDetails Enter_SchoolCollegePG() {
		js.executeScript("arguments[0].scrollIntoView();",schoolnamePG);
        String num="Datta Meghe";
        schoolnamePG.clear();
        schoolnamePG.sendKeys(num);
        System.out.println("Enter_SchoolCollegePG > "+num);
        return this;
    }
    
    public SL_Academic_SR_SI_QualificationDetails Enter_BoardPG() {
        String num="Nagpur";
        boardPG.clear();
        boardPG.sendKeys(num);
        System.out.println("Enter_BoardPG > "+num);
        return this;
    }
    
    public SL_Academic_SR_SI_QualificationDetails Enter_QualifyingExamPG() {
        String examname = "HG";
        Select select = new Select(qualifyingexamPG);
        select.selectByVisibleText(examname);
        System.out.println("Enter_QualifyingExamPG > "+examname);
        return this;
    }
    
    public SL_Academic_SR_SI_QualificationDetails Enter_SeatNoPG() {
        String num="RF 12345";
        seatnoPG.clear();
        seatnoPG.sendKeys(num);
        System.out.println("Enter_SeatNoPG > "+num);
        return this;
    }
    
    public SL_Academic_SR_SI_QualificationDetails Enter_YearofExamPG() {
        String num="2015";
        yearofexamPG.clear();
        yearofexamPG.sendKeys(num);
        System.out.println("Enter_YearofExamPG > "+num);
        return this;
    }
    
    public SL_Academic_SR_SI_QualificationDetails Enter_StatusPG() {
        String examname = "Completed";
        Select select = new Select(StatusPG);
        select.selectByVisibleText(examname);
        System.out.println("Enter_StatusPG > "+examname);
        return this;
    }
    
    public SL_Academic_SR_SI_QualificationDetails Enter_OutOfMarksPG() {
        String num="600";
        outofmarksPG.clear();
        outofmarksPG.sendKeys(num);
        System.out.println("Enter_OutOfMarksPG > "+num);
        return this;
    }
    
    public SL_Academic_SR_SI_QualificationDetails Enter_MarksObtainedPG() {
        String num="430";
        markobtainPG.clear();
        markobtainPG.sendKeys(num);
        System.out.println("Enter_MarksObtainedPG > "+num);
        return this;
    }
    
    public SL_Academic_SR_SI_QualificationDetails Enter_GradePG() {
        String num="A";
        gradePG.clear();
        gradePG.sendKeys(num);
        System.out.println("Enter_GradePG > "+num);  
        return this;
    }
    
    public SL_Academic_SR_SI_QualificationDetails Enter_DGPACGPA_PG() {
        String num="7.5";
        dgpacgpaPG.clear();
        dgpacgpaPG.sendKeys(num);
        System.out.println("Enter_DGPACGPA_PG > "+num); 
        return this;
    }
    
    public SL_Academic_SR_SI_QualificationDetails Enter_SchoolCollegeAddressPG() {
        String num="At post nagpur";
        collegeAddressPG.clear();
        collegeAddressPG.sendKeys(num);
        System.out.println("Enter_SchoolCollegeAddressPG > "+num); 
        return this;
    }
    
    public SL_Academic_SR_SI_QualificationDetails Click_AddBtn_PG() {
    	addbtnPG.click();
        System.out.println("Click_AddBtn_PG"); 
        return this;
    }
    
    public SL_Academic_SR_SI_QualificationDetails Click_SaveContinueQualificationDetails() throws InterruptedException {
    	js.executeScript("arguments[0].scrollIntoView();",SaveContinueQualificationDetails);
		js.executeScript("arguments[0].click();", SaveContinueQualificationDetails);
        
        Thread.sleep(2000); 
//		Alert alert =  driver.switchTo().alert();
//		String Expected_Msg = "Data saved successfully!";
//		String Actual_Msg = alert.getText();
//		Assert.assertEquals(Actual_Msg , Expected_Msg );
//		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
//		alert.accept();
        System.out.println("Click_SaveContinuePG");

        return this;
    }
    
    // Covid Information
    
    public SL_Academic_SR_SI_QualificationDetails Click_Vaccinated_No() {
    	vaccination_No.click();
        System.out.println("Click_Vaccinated_No");
        return this;
    }

    public SL_Academic_SR_SI_QualificationDetails Click_Vaccinated_Yes() {
        vaccination_yes.click();
        System.out.println("Click_Vaccinated_Yes");
        return this;
    }


    public SL_Academic_SR_SI_QualificationDetails Click_SaveContinueCovidInformation() {
    	js.executeScript("arguments[0].click();", saveContinueCovidInformation);
        System.out.println("Click_SaveContinueCovidInformation"); 
        return this;
    }
    
    // Other Information
    
    public SL_Academic_SR_SI_QualificationDetails Enter_BankName() {
        String examname = "AXIS Bank";
        Select select = new Select(bankname);
        select.selectByVisibleText(examname);
        System.out.println("Enter_BankName > "+examname);
        return this;
    }
 
    public SL_Academic_SR_SI_QualificationDetails Enter_BankAccountNo() {
    	String num="123456789321";
        bankaccno.clear();
        bankaccno.sendKeys(num);
        System.out.println("Enter_BankAccountNo > "+num);  
        return this;
    }
    
    public SL_Academic_SR_SI_QualificationDetails Enter_BranchName() {
    	String num="Dhantoli";
        branchname.clear();
        branchname.sendKeys(num);
        System.out.println("Enter_BranchName > "+num);  
        return this;
    }
    
    public SL_Academic_SR_SI_QualificationDetails Enter_IFSCode() {
    	String num="AXISIN00213";
        IFScode.clear();
        IFScode.sendKeys(num);
        System.out.println("Enter_IFSCode > "+num);  
        return this;
    }
    
    public SL_Academic_SR_SI_QualificationDetails Enter_BankAddress() {
    	String num="At post Dhantoli, Nagpur";
        bankaddress.clear();
        bankaddress.sendKeys(num);
        System.out.println("Enter_BankAddress > "+num);  
        return this;
    }

    @FindBy(id = "ctl00_ContentPlaceHolder1_txtBankAddress")
    private WebElement IAgreeCheckBox;
    public SL_Academic_SR_SI_QualificationDetails I_AgreeCheckBox() {
        System.out.println("Click_AgreeCheckBox");
        IAgreeCheckBox.click();
        return this;
    }

    @FindBy(id = "ctl00_ContentPlaceHolder1_txtSportName")
    private WebElement sportNametextbox;
    public SL_Academic_SR_SI_QualificationDetails sportName() throws InterruptedException {
        Thread.sleep(1000);
        scrollIntoElement(sportNametextbox);
        System.out.println("Click_SportName");
        sportNametextbox.clear();
        sportNametextbox.sendKeys("Cricket");
        return this;
    }
    @FindBy(id = "select2-ctl00_ContentPlaceHolder1_ddlSportLevel-container")
    private WebElement sportNameLevel;
    public SL_Academic_SR_SI_QualificationDetails sportLevel() throws InterruptedException {

        String level = "State";
        Thread.sleep(1000);
        driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlSportLevel-container")).click();
        driver.findElement(By.xpath("//span/span/input")).sendKeys(level);
        driver.findElement(By.xpath("//span/span/input")).sendKeys(Keys.ENTER);
        System.out.println("Enter_StatusPG > "+level);
        return this;
    }

    @FindBy(id = "ctl00_ContentPlaceHolder1_txtSportName")
    private WebElement sportaddbtn;
    public SL_Academic_SR_SI_QualificationDetails sportAddButton() {
        System.out.println("Click sportAddButton");
        sportaddbtn.click();
        return this;
    }


    @FindBy(id = "ctl00_ContentPlaceHolder1_txtSportAchieve")
    private WebElement sportAchivementtextbox1;
    public SL_Academic_SR_SI_QualificationDetails sportAchivement() {
        System.out.println("Click_Sport Achivement");
        sportAchivementtextbox1.clear();
        sportAchivementtextbox1.sendKeys("Got Rank 1 in state level");

        return this;
    }




    public SL_Academic_SR_SI_QualificationDetails Click_SaveBtn() throws InterruptedException {
    	Thread.sleep(2000);
        scrollIntoElement(saveBtn);
        saveBtn.click();
        System.out.println("Click_SaveBtn");    
        
        Thread.sleep(2000); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Other Information Saved Successfully!"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
        return this;
    }
    
    
}
