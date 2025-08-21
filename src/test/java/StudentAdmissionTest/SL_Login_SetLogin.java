package StudentAdmissionTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utility.BaseClass;

public class SL_Login_SetLogin extends BaseClass {


    public SL_Login_SetLogin(WebDriver rdriver) {
        driver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    By userName = By.id("txt_username");
    By passWord = By.id("txt_password");
    By captcha = By.id("txtcaptcha");
    By signInBtn = By.id("btnLogin");
    public void newCreatedStudentLogin(String username,String Password) throws InterruptedException {
        System.out.println("Login Student with the RRNO ");
        waitUntilElementIsClickableBy(userName);
        sendKeysBy(userName,username);
        Thread.sleep(2000);
        sendKeysBy(passWord,Password);
        Thread.sleep(2000);
        sendKeysBy(captcha,"5321");
        clickBy(signInBtn);
        Thread.sleep(10000);
    }

    By oldPassword = By.id("ctl00_ContentPlaceHolder1_txtOldPassword");
    By newPassword = By.id("ctl00_ContentPlaceHolder1_txtNewPassword");
    By confirmPassword = By.id("ctl00_ContentPlaceHolder1_txtConfirmPassword");
    By submitbtnChangepass = By.id("ctl00_ContentPlaceHolder1_btnSubmit");

    public void changeStudentPassword(String StudentRRNO) throws InterruptedException {
        System.out.println("Enter the old password");
        sendKeysBy(oldPassword, StudentRRNO);
        System.out.println("Enter the new Password");
        Thread.sleep(2000);
        sendKeysBy(newPassword, "Student@12345");
        Thread.sleep(2000);
        System.out.println("Enter the confirm password");
        sendKeysBy(confirmPassword, "Student@12345");
        clickBy(submitbtnChangepass);
        Thread.sleep(2000);
        acceptAlert();
    }
    public void StudentLoginWithChangepassword(String StudentRRNO) throws InterruptedException {
            System.out.println("Login Student with the changed password ");
            waitUntilElementIsClickableBy(userName);
            sendKeysBy(userName,StudentRRNO);
            Thread.sleep(2000);
            sendKeysBy(passWord,"Student@12345");
            Thread.sleep(2000);
            sendKeysBy(captcha,"5321");
            clickBy(signInBtn);
            Thread.sleep(10000);
        }
}

