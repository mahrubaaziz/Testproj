package com.ap.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.ui.base.TestBase;

public class ContactsPage extends TestBase{
	
		
		
		@FindBy (id = "id_contact")
		WebElement headingDropdown;
		
		@FindBy (id = "email")
		WebElement emailInput;
		
		@FindBy (id = "id_order")
		WebElement orderReference;
		
		@FindBy (id = "message")
		WebElement messageTextBox;
		
		@FindBy (id = "submitMessage")
		WebElement submitMessageButton;
		
		@FindBy (css = "[class='alert alert-success']")
		WebElement successMsg;
		

		public ContactsPage()
		{
			PageFactory.initElements(driver, this);
		}
		
		public ContactsPage fillContactForm (String heading, String email, String reference, String message)
		{

			Select select = new Select(headingDropdown);
			select.selectByVisibleText(heading);
			emailInput.sendKeys(email);
			orderReference.sendKeys(reference);
			messageTextBox.sendKeys(message);
			
			return this;
		}
		
		public void submitMessage()
		{
			submitMessageButton.click();
		}
		
		public String getMessage()
		{
			return successMsg.getText();
		}
	}



