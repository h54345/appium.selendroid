package com.pages;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
//import org.openqa.selenium.By;
//import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.TestBase.TestBase;
import com.TestUtil.UtilityClass;

import io.appium.java_client.MobileElement;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SplashScreenPage extends TestBase {
	UtilityClass util=new UtilityClass();
	
	@FindBy(id="io.selendroid.testapp:id/my_text_field")
	MobileElement textField;
	
	@FindBy(id="io.selendroid.testapp:id/waitingButtonTest")
	MobileElement buttonprogressBar;

	@AndroidFindBy(id="io.selendroid.testapp:id/showPopupWindowButton")
	MobileElement popwindowelement;
	//*[@class='android.widget.Button']and 
	public SplashScreenPage() {
		// TODO Auto-generated constructor stub
	    AppiumFieldDecorator afd= new AppiumFieldDecorator(driver);
		PageFactory.initElements(afd, this );
	}
	
	public void actionOnTextField() throws InterruptedException, IOException
	{
		
		
		textField.sendKeys("Hello World!");
		driver.hideKeyboard();
		util.takeScreenShot("splashscreen");
		Thread.sleep(2000);
	    				
	}
	
	public void actionOnProgressBar() throws IOException, InterruptedException
	{
		buttonprogressBar.click();
		Thread.sleep(5000);
		util.takeScreenShot("progressBar");
		driver.hideKeyboard();
		driver.navigate().back();;
		
	}
	public void actionOnPopUpWindow() throws IOException, InterruptedException
	{
		popwindowelement.click();
		Thread.sleep(3000);
		util.takeScreenShot("popupwindow");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert=driver.switchTo().alert();
		alert.dismiss();
		util.takeScreenShot("Afteraccepting");
		
	}
}
