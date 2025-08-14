package ELearning;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class FL_ELearning_Trans_CreateElibrary_DeleteFlow01_3 extends BaseClass {

	public FL_ELearning_Trans_CreateElibrary_DeleteFlow01_3(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession")
	private WebElement session_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_RpCourse_ctl00_btnlncardkSelect")
	private WebElement course_dropdown;
	@FindBy(xpath = "//button[normalize-space()='OK']")
	private WebElement Ok_Button;
	@FindBy(linkText = "Create E-Library")
	private WebElement CreateELibrary_Link;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public FL_ELearning_Trans_CreateElibrary_DeleteFlow01_3 select_Session() {
		Select colg_typ = new Select(session_dropdown);
		colg_typ.selectByVisibleText("May 2022 - School of Social Sciences and Humanities");
		System.out.println("Course-> May 2022 - School of Social Sciences and Humanities");
		return this;
	}

	public FL_ELearning_Trans_CreateElibrary_DeleteFlow01_3 select_Course() {
		course_dropdown.click();
		System.out.println("Select Course");
		return this;
	}

	public FL_ELearning_Trans_CreateElibrary_DeleteFlow01_3 Click_OkButton() {
		Ok_Button.click();
		return this;
	}

	public FL_ELearning_Trans_CreateElibrary_DeleteFlow01_3 click_CreateELibrary() {
		System.out.println("Create E-Library submenu selected");
		Actions action = new Actions(driver);
		action.moveToElement(CreateELibrary_Link);
		action.click().build().perform();
		return this;
	}

	public FL_ELearning_Trans_CreateElibrary_DeleteFlow01_3 search_Txt() {

		WebElement searchbox = driver.findElement(By.xpath("(//input[@class='form-control form-control-sm'])[1]"));
		System.out.println("Search text => ");
		js.executeScript("arguments[0].scrollIntoView();", searchbox);
		sendKeys(searchbox, "Income Tax amd Law Practicee");
		return this;
	}

	public FL_ELearning_Trans_CreateElibrary_DeleteFlow01_3 click_Delete() {
		WebElement deleteIcon = driver
				.findElement(By.xpath("(//input[@id='ctl00_ContentPlaceHolder1_lvLibrary_ctrl0_btnDelete'])[1]"));
		deleteIcon.click();

		// Click yes
		WebElement yesBtn = driver.findElement(By.xpath("(//input[@id='ctl00_ContentPlaceHolder1_btnOkDel'])[1]"));
		yesBtn.click();
		return this;
	}
}
