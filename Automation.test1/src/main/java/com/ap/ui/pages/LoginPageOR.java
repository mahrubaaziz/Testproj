package com.ap.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.ui.base.TestBase;

public class LoginPageOR extends TestBase {
	
	//page factory
	
	@FindBy(id="email")
	WebElement username;
	
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(xpath=".//[@id='SubmitLogin']")
	WebElement submitbutton;
	
	@FindBy(xpath =".//*[@id='header_logo']/a/img")
	WebElement apLogo;
	
	public LoginPageOR(){
		PageFactory.initElements(driver, this);
	}
	
	public String verifyPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateAPImage(){
		return apLogo.isDisplayed();
		
	}
	
	public HomePage login(String uname, String passw){
		username.sendKeys(uname);
		password.sendKeys(passw);
		submitbutton.click();
		
		return new HomePage();
	}
}
