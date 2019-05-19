package com.ap.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.ui.base.TestBase;

public class OrderSummeryPage extends TestBase {
	
	@FindBy(css="[class='button btn btn-default standard-checkout button-medium']")
	WebElement proceedToCheckOutButton;
	
	@FindBy(xpath="//*[@id='order_step']/li[3]/span")
	WebElement proceedToAdressButton;
	
	@FindBy(xpath="//*[@id='order_step']/li[4]/span")
	WebElement processToCarrierButton;
	
	@FindBy(id="cgv")
	WebElement termsAndCondition;
	
	@FindBy(css="[class='bankwire'] [title='Pay by bank wire']")
	WebElement payByBankWire;
	
	@FindBy(xpath="//*[@id='cart_navigation']/button/span")
	WebElement confirmOrder;
	
	@FindBy(css="[class='navigation_page']")
	WebElement OrderConfirm;
	
	public OrderSummeryPage(){
		PageFactory.initElements(driver, this);
	}
	public OrderSummeryPage proceedCheckOut(){
		proceedToCheckOutButton.click();
		return this;
	}
	public OrderSummeryPage proceedAdessCheckOut(){
		proceedToAdressButton.click();
		return this;
	}
	public OrderSummeryPage proceedShipping(){
		termsAndCondition.click();
		processToCarrierButton.click();
		return this;
	}
	public OrderSummeryPage confirmOrder(){
		payByBankWire.click();
		confirmOrder.click();
		return this;
	}
	public String getConfirmationMessage(){
		return OrderConfirm.getText();
	}
	
	
	

}
