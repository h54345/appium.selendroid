package cgi.qa.appiumtest.cgi.qa.appiumartitest;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.TestBase.TestBase;
import com.pages.SplashScreenPage;

public class SplashScreenTest extends TestBase {
	
	
	
	public SplashScreenTest()
	{
		super();
	}
	
	@Test(priority=0)
	public void startUp()
	{
	   initialization();
	}

	@Test(priority=1)
	public void appOpens() throws Exception, IOException
	{
		SplashScreenPage ssc=new SplashScreenPage();
		ssc.actionOnTextField();
		ssc.actionOnProgressBar();
		ssc.actionOnPopUpWindow();
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}
