package com.ap.ui.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.ui.base.TestBase;
import com.ap.ui.pages.ContactsPage;
import com.ap.ui.pages.HomePage;

public class ContactTest extends TestBase {
	
	ContactsPage contactspage;
	HomePage homepage;
	
	
	public ContactTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUpDriver()
	{
		initialization();
		contactspage = new ContactsPage();
		homepage = new HomePage();
	}
	
	@Test
	public void testContact()
	{
		homepage.clickOnContactLink();
		contactspage = contactspage.fillContactForm("Customer service", "Random@test.com", 
				"Testing", "This is test purpose");
		
	
		contactspage.submitMessage();
		
		String successMsg = contactspage.getMessage();
		Assert.assertEquals(successMsg, "Your message has been successfully sent to the team");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}




