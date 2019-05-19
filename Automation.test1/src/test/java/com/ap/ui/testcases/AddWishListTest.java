package com.ap.ui.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.ui.base.TestBase;
import com.ap.ui.pages.HomePage;
import com.ap.ui.pages.LoginPageOR;
import com.ap.ui.pages.ProductDetailsPage;
import com.ap.ui.pages.SearchPage;

public class AddWishListTest extends TestBase{
	
//we create property in as globaly
	LoginPageOR loginPage;
	HomePage homePage;
	SearchPage searchPage;
	ProductDetailsPage productDetailsPage;
	
	public AddWishListTest(){
		super();
	}

	@BeforeMethod
	public void setUpdriver(){
		initialization();
		loginPage= new LoginPageOR();
		homePage= new HomePage();
	}
	
	@Test
	public void testAddProductToWishList(){
		
		String product = "Printed Chiffon Dress";
	    homePage.clickOnSignIn();
		homePage= loginPage.login(propt.getProperty("username"),propt.getProperty("password")); 
		//search product
		searchPage = homePage.searchProduct(product);
		String header = searchPage.getHeader();
		Assert.assertTrue(header.toLowerCase().contains(product.toLowerCase()));
		//add product to wish list
		productDetailsPage.clickAddWishListButton();
		productDetailsPage.verifyAddwishListMsg();
		homePage.logOut();
   }
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
