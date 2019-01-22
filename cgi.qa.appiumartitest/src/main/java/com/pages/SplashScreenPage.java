package com.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
//import org.openqa.selenium.By;
//import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestBase.TestBase;
import com.TestUtil.UtilityClass;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SplashScreenPage extends TestBase {
	UtilityClass util=new UtilityClass();
    AndroidDriver<MobileElement> driver;
    
	@FindBy(id="io.selendroid.testapp:id/my_text_field")
	MobileElement textField;
	
	@FindBy(id="io.selendroid.testapp:id/waitingButtonTest")
	MobileElement buttonprogressBar;

	@AndroidFindBy(id="io.selendroid.testapp:id/showPopupWindowButton")
	MobileElement popwindowelement;
	//*[@class='android.widget.Button']and 
	public SplashScreenPage(AndroidDriver<MobileElement> d) {
		// TODO Auto-generated constructor stub
		this.driver=d;
		AppiumFieldDecorator afd= new AppiumFieldDecorator(d);
		PageFactory.initElements(afd, this);
	}
	
	public void actionOnTextField(AndroidDriver<MobileElement> d) throws InterruptedException, IOException
	{
		
		
		textField.sendKeys("Hello World!");
		d.hideKeyboard();
		util.takeScreenShot(d,"splashscreen");
		Thread.sleep(2000);
	    				
	}
	
	public void actionOnProgressBar(AndroidDriver<MobileElement> d) throws IOException, InterruptedException
	{
		buttonprogressBar.click();
		Thread.sleep(5000);
		util.takeScreenShot(driver,"progressBar");
		d.hideKeyboard();
		d.navigate().back();;
		
	}
	/*public void actionOnPopUpWindow() throws IOException, InterruptedException
	{
		popwindowelement.click();
		Thread.sleep(3000);
		util.takeScreenShot("popupwindow");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert=driver.switchTo().alert();
		alert.dismiss();
		util.takeScreenShot("Afteraccepting");
		
	}*/
}
