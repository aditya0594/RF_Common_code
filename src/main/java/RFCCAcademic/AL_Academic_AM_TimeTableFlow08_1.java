package RFCCAcademic;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Academic_AM_TimeTableFlow08_1 extends BaseClass{

	public AL_Academic_AM_TimeTableFlow08_1(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "ctl00_repLinks_ctl02_lbLink") private WebElement timeTable_link;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlClgname") private WebElement college_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSession") private WebElement session_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlDepartment") private WebElement department_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSem") private WebElement semester_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSection") private WebElement section_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_ddlSlotType") private WebElement slotType_dropdown;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtStartDate") private WebElement startDate_inputfield;
	@FindBy(id = "ctl00_ContentPlaceHolder1_txtEndDate") private WebElement endDate_inputfield;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvSlots_ctrl1_drp1") private WebElement scrollToSlot;
	@FindBy(id = "ctl00_ContentPlaceHolder1_dListFaculty_ctrl0_lblFac") private WebElement draggable;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvSlots_ctrl0_drp1") private WebElement droppable;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvSlots_ctrl0_drp2") private WebElement droppable1;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvSlots_ctrl0_drp3") private WebElement droppable2;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvSlots_ctrl0_drp4") private WebElement droppable3;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvSlots_ctrl0_drp5") private WebElement droppable4;
	@FindBy(id = "ctl00_ContentPlaceHolder1_lvSlots_ctrl0_drp6") private WebElement droppable5;
	@FindBy(id = "btnSave") private WebElement save_btn;
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public AL_Academic_AM_TimeTableFlow08_1 click_timeTable_link() throws InterruptedException 
	{
		System.out.println("Click Time Table Link");
		//timeTable_link.click();
		js.executeScript("arguments[0].scrollIntoView();",timeTable_link);

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", timeTable_link);
		return this;
	}
	public AL_Academic_AM_TimeTableFlow08_1 select_college() 
	{
		System.out.println("Select College > SIS - BTech-Department of Civil Engineering-Civil Engineering-2017-18 (Old Scheme)");
		Select options = new Select(college_dropdown);
		options.selectByVisibleText("SIS - BTech-Department of Civil Engineering-Civil Engineering-2017-18 (Old Scheme)");
		return this;
	}
	public AL_Academic_AM_TimeTableFlow08_1 select_session() 
	{
		System.out.println("Select Session > May 2022");
		Select options = new Select(session_dropdown);
		options.selectByVisibleText("May 2022");
		return this;
	}
	public AL_Academic_AM_TimeTableFlow08_1 select_department() 
	{
		System.out.println("Select Department > Department of Civil Engineering");
		Select options = new Select(department_dropdown);
		options.selectByVisibleText("Department of Civil Engineering");
		return this;
	}
	public AL_Academic_AM_TimeTableFlow08_1 select_semester() 
	{
		System.out.println("Select Semester > IV");
		Select options = new Select(semester_dropdown);
		options.selectByVisibleText("IV");
		return this;
	}
	public AL_Academic_AM_TimeTableFlow08_1 select_section() 
	{
		System.out.println("Select Section > A");
		Select options = new Select(section_dropdown);
		options.selectByVisibleText("A");
		return this;
	}
	public AL_Academic_AM_TimeTableFlow08_1 select_slotType() 
	{
		System.out.println("Select Slot Type > Regular ");
		Select options = new Select(slotType_dropdown);
		options.selectByVisibleText("Regular");
		return this;
	}
	public AL_Academic_AM_TimeTableFlow08_1 enter_startDate() 
	{
		System.out.println("Enter Start Date > 31/01/2024");
		//startDate_inputfield.sendKeys("31/01/2024");
		js.executeScript("arguments[0].value = arguments[1]",startDate_inputfield, "31/01/2024");
		return this;
	}
	public AL_Academic_AM_TimeTableFlow08_1 enter_endDate() 
	{
		System.out.println("Enter End Date > 01/01/2025");
		//endDate_inputfield.sendKeys("01/01/2025");
		js.executeScript("arguments[0].value = arguments[1]",endDate_inputfield, "01/01/2025");
		return this;
	}
	public AL_Academic_AM_TimeTableFlow08_1 dragAndDropFaculty() 
	{
		System.out.println("Drag Faculty to the slots");
		js.executeScript("arguments[0].scrollIntoView();",scrollToSlot);
		Actions actions = new Actions(driver);
		actions.dragAndDrop(draggable, droppable).build().perform();
		actions.dragAndDrop(draggable, droppable1).build().perform();
		actions.dragAndDrop(draggable, droppable2).build().perform();
		actions.dragAndDrop(draggable, droppable3).build().perform();
		actions.dragAndDrop(draggable, droppable4).build().perform();
		actions.dragAndDrop(draggable, droppable5).build().perform();
		return this;
	}
	public AL_Academic_AM_TimeTableFlow08_1 click_save_btn() throws InterruptedException 
	{
		System.out.println("Select Schedule and Room Occupancy");
		//js.executeScript("arguments[0].scrollIntoView();",save_btn);
		js.executeScript("window.scrollTo(0, 0);");

		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", save_btn);
		return this;
	}
	
	
	
}
