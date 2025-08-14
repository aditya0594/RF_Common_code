package Establishment;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Establishment_Rpt_EmployeePunchStatus extends BaseClass {
	
    public AL_Establishment_Rpt_EmployeePunchStatus(WebDriver rdriver) {
        driver = rdriver;
        PageFactory.initElements(rdriver, this);
    }
    JavascriptExecutor js = (JavascriptExecutor) driver;

    @FindBy(linkText = "Reports") private WebElement Report;

    @FindBy(linkText = "Employee Punch Status")
    private WebElement employeePunchStatusLink;

    @FindBy(id = "ctl00_ContentPlaceHolder1_ddlCollege")
    private WebElement collegeDropdown;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_ddlstafftype")
    private WebElement staffTypeDropdown;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_txtFromdt")
    private WebElement fromDateField;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_txtTodt")
    private WebElement toDateField;
    
    @FindBy(id = "ctl00_ContentPlaceHolder1_btnReport")
    private WebElement reportButton;

	public AL_Establishment_Rpt_EmployeePunchStatus click_Report() {
		System.out.println("Click on Report");
		Report.click();
		return this;
	}
	
    public AL_Establishment_Rpt_EmployeePunchStatus Click_EmployeePunchStatus() throws Exception {
        System.out.println("Click on Employee Punch Status");
        js.executeScript("arguments[0].scrollIntoView();", employeePunchStatusLink);
        threadWait1();
        js.executeScript("arguments[0].click();", employeePunchStatusLink);
        return this;
    }
    
    public AL_Establishment_Rpt_EmployeePunchStatus Select_College() throws Exception {
        System.out.println("Select College -> Crescent School of Law");
        js.executeScript("arguments[0].scrollIntoView();", collegeDropdown);
        threadWait1();
        Select select = new Select(collegeDropdown);
        select.selectByVisibleText("Crescent School of Law");
        return this;
    }
    
    public AL_Establishment_Rpt_EmployeePunchStatus Select_StaffType() throws Exception {
        System.out.println("Select Staff Type -> Teaching Staff");
        js.executeScript("arguments[0].scrollIntoView();", staffTypeDropdown);
        threadWait1();
        Select select = new Select(staffTypeDropdown);
        select.selectByVisibleText("Teaching Staff");
        return this;
    }
    
    public AL_Establishment_Rpt_EmployeePunchStatus Enter_FromDate() throws Exception {
        System.out.println("Enter From Date (Current Date)");
        
        // Get current date
        Date currentDate = new Date();
        
        // Format the date
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = dateFormat.format(currentDate);
        
        System.out.println("Setting From Date to current date: " + formattedDate);
        js.executeScript("arguments[0].value = arguments[1]", fromDateField, formattedDate);
        return this;
    }
    
    public AL_Establishment_Rpt_EmployeePunchStatus Enter_ToDate() throws Exception {
        System.out.println("Enter To Date (Current Date)");
        
        // Get current date
        Date currentDate = new Date();
        
        // Format the date
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = dateFormat.format(currentDate);
        
        System.out.println("Setting To Date to current date: " + formattedDate);
        js.executeScript("arguments[0].value = arguments[1]", toDateField, formattedDate);
        return this;
    }
    
    public AL_Establishment_Rpt_EmployeePunchStatus Click_ReportButton() throws Exception {
        System.out.println("Click on Report button");
        js.executeScript("arguments[0].scrollIntoView();", reportButton);
        threadWait1();
        js.executeScript("arguments[0].click();", reportButton);
        return this;
    }
}
