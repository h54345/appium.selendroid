package cgi.qa.appiumtest.cgi.qa.appiumartitest;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.TestBase.TestBase;
import com.pages.SplashScreenPage;

public class SplashScreenTest extends TestBase{
	
	
	
	public SplashScreenTest()
	{
		super();
	}
	
	//@Parameters({"automationName","deviceName","platformVersion"})
	@BeforeTest(alwaysRun = true)
	
	public void startUp() throws Exception
	{
	   initialization("Appium", "DRGID18092105974", "9");
		
	}

	@Test()
	public void appOpens() throws Exception, IOException
	{
		SplashScreenPage ssc=new SplashScreenPage(getDriver());
		ssc.actionOnTextField(getDriver());
		ssc.actionOnProgressBar(getDriver());
		//ssc.actionOnPopUpWindow();
	}
	
	@AfterTest
	public void tearDown()
	{
		getDriver().quit();
	}
	
	
	
}
