package com.amazon.pages;

import java.util.List;


import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.amazon.helper.Controller;
import com.amazon.helper.Helper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PaymentsPageClass extends Helper implements PaymentsPage {
	
	ProductPageClass product= new ProductPageClass(Controller.instance.driver);
	
	
	@FindBy(xpath = "(//*[@resource-id='spc-orders']//android.view.View[@index='3'])[3]")
	public MobileElement checkout_description;
	
	@FindBy(xpath = "(//*[@resource-id='spc-orders']//android.view.View[@index='6'])[3]")
	public MobileElement checkout_price;
	
	@FindBys(@FindBy(xpath="//*[@resource-id='spc-orders']//android.view.View"))
    public List<MobileElement> AllData;

	
	
	public PaymentsPageClass(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
			 
		}
	
	public void paymentPageTest() throws InterruptedException {
		try {
		logger.info("Verifying payment page");
		Thread.sleep(7000);
		scrollToPlaceOrder();
		Thread.sleep(4000);
		Assert.assertEquals(checkout_description.getText(),product.title);
		Assert.assertEquals(checkout_price.getText(),product.price);
		logger.info("Verified payment page successfully");
		}
		catch(Exception e)
		{
				logger.error("Couldnt verify loginPage due to :"+e.getMessage());
				Assert.fail();
				Controller.instance.stop();
		}
		
	}


}
