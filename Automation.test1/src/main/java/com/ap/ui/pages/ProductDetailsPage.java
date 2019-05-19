package com.ap.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.ap.ui.base.TestBase;

public class ProductDetailsPage extends TestBase {
	
	@FindBy(id="quantity_wanted")
	WebElement quantityInput;
	
	@FindBy(id="group_1")
	WebElement sizeDropdown;
	
	@FindBy(xpath="//*[@id='add_to_cart']/button/span")
	WebElement addToCartButton;
	
	@FindBy(id="wishlist_button")
	WebElement addWishListButton;
	
	@FindBy(xpath="//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span")
	WebElement proceedToCheckOut;
	
	@FindBy(css="[class='fancybox-error']")
	WebElement addWishlistMsg;
	
	@FindBy(css="[title='Add to my wishlist']")
	WebElement addToWishlistButton;
	
	@FindBy(css="[class='fancybox-item fancybox-close']")
	WebElement addWishlistMsgCloseButton;
	
	
	public ProductDetailsPage(){
		PageFactory.initElements(driver, this);
		
	}
	public void verifyAddwishListMsg(){
		Assert.assertEquals(addWishlistMsg.getText(), "Added to your wishlist.");
		addWishlistMsgCloseButton.click();
	}
	//ceat a variable with locator value ,use concatination ,the color come from the excel file
	//from config prop , we create for locator
	public ProductDetailsPage selecProductColor(String color){
		String locator ="[name='+color+']";//this is not comming from app, we are sending this to app
		driver.findElement(By.cssSelector(locator)).click();
		return this;//we return this when we use method over and over again
	}
	public ProductDetailsPage inputQuantity(String quantity){//creating constructor with parameter,its constructor overloading
		quantityInput.click();
		quantityInput.sendKeys(quantity);
		return this;
	}
	public ProductDetailsPage selectsize(String size){
		Select select = new Select(sizeDropdown);
		select.selectByVisibleText(size);
		return this;
	}
	
	public ProductDetailsPage clickAddtoCart(){
		addToCartButton.click();
		return this;
	}
	public ProductDetailsPage clickAddWishListButton(){
		addToWishlistButton.click();
		return this;
	}
	public OrderSummeryPage proceedToCheckOut(){
		proceedToCheckOut.click();
		return new OrderSummeryPage();
	}
	
	
		
	
	
	
	
	
	

}
