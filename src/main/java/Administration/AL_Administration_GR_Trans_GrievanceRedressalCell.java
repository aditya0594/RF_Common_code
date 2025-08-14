package Administration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class AL_Administration_GR_Trans_GrievanceRedressalCell extends BaseClass {

	public AL_Administration_GR_Trans_GrievanceRedressalCell(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(id = "ctl00_repLinks_ctl00_lbLink")
	private WebElement GrievanceRedressalCell;

	@FindBy(id = "ctl00_ContentPlaceHolder1_rdbGriv_0")
	private WebElement CommitteeTypeMember;

	@FindBy(id = "ctl00_ContentPlaceHolder1_lvCommittee_ctrl1_btnEditRecord")
	private WebElement EditClick;

	@FindBy(id = "ctl00_ContentPlaceHolder1_lvshowRedressalCell_ctrl0_btnEditRecord")
	private WebElement EditClick2;
	
	@FindBy(id = "ctl00_ContentPlaceHolder1_btnAdd")
	private WebElement AddBtn;


	@FindBy(id = "ctl00_ContentPlaceHolder1_btnSubmit")
	private WebElement SubmitBtn;

	@FindBy(id = "ctl00_ContentPlaceHolder1_btnReport")
	private WebElement ReportBtn;

	public AL_Administration_GR_Trans_GrievanceRedressalCell ClickOn_GrievanceRedressalCell() {
		System.out.println("Click on GrievanceRedressalCell ");
		GrievanceRedressalCell.click();
		return this;
	}

	public AL_Administration_GR_Trans_GrievanceRedressalCell ClickOn_CommitteeTypeMember() {
		System.out.println("Click on CommitteeTypeMember ");
		CommitteeTypeMember.click();
		return this;
	}

	public AL_Administration_GR_Trans_GrievanceRedressalCell ClickOn_Edit() {
		System.out.println("Click on Edit ");
		EditClick.click();
		return this;
	}

	public AL_Administration_GR_Trans_GrievanceRedressalCell ClickOn_Edit2() {
		System.out.println("Click on Edit 2nd ");
		EditClick2.click();
		return this;
	}
	
	public AL_Administration_GR_Trans_GrievanceRedressalCell ClickOn_AddBtn() {
		System.out.println("Click on AddBtn ");
		AddBtn.click();
		return this;
	}

	public AL_Administration_GR_Trans_GrievanceRedressalCell ClickOn_SubmitBtn() {
		System.out.println("Click on SubmitBtn ");
		SubmitBtn.click();
		return this;
	}

	public AL_Administration_GR_Trans_GrievanceRedressalCell ClickOn_ReportBtn() {
		System.out.println("Click on ReportBtn ");
		ReportBtn.click();
		return this;
	}

}
