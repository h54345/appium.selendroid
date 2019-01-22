package com.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;

//import com.lm.qa.utility.TestUtil;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TestBase extends DriverClass {
	
	
	protected static DesiredCapabilities capa;
	//public static AndroidDriver<MobileElement> driver;
	public static Properties prop;

	public TestBase() {
		try {
			prop = new Properties();

			FileInputStream fis = new FileInputStream(
					"C:\\Users\\Hamza\\git\\appium.selendroid\\cgi.qa.appiumartitest\\src\\main\\java\\configpage\\config.properties");

			try {
				prop.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	//@Parameters({"automationName","deviceName","platformVersion"})
	public void initialization(String automationName, String deviceName, String platformVersion/*,String appiumServer*/) throws MalformedURLException
	{
		
		capa = new DesiredCapabilities();
	
		capa.setCapability("automationName", automationName);
		capa.setCapability("deviceName", deviceName);
		//capa.setCapability("", "ENUL6303030010"); //Give Device ID of your mobile phone
		capa.setCapability("platformName", "Android");
		capa.setCapability("platformVersion",platformVersion );
		capa.setCapability("appPackage", "io.selendroid.testapp");
		capa.setCapability("appActivity", "io.selendroid.testapp.HomeScreenActivity");
		capa.setCapability("autoDismissAlerts", "true");
		capa.setCapability("noReset", "true");
		capa.setCapability("clearSystemFiles", "true");
		//capa.setCapability("autoWebView", "true");
		
		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		
		
        setDriver(new AndroidDriver<MobileElement>(url, capa));
		
		getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		
		
		
	
	}
	
}
