package com.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

//import com.lm.qa.utility.TestUtil;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TestBase {
	protected static AndroidDriver<MobileElement> driver;
	protected static DesiredCapabilities capa;
	protected static URL url;
	public static Properties prop;

	public TestBase() {
		try {
			prop = new Properties();

			FileInputStream fis = new FileInputStream(
					"C:\\Users\\hamza.naseem\\workspace\\FreeCRMTest\\src\\main\\java\\com\\lm\\qa\\config\\config.properties");

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
public void initialization() {

		

		capa = new DesiredCapabilities();
		try {
			url = new URL("http://127.0.0.1:4723/wd/hub");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		capa.setCapability("automationName", "Appium");
		capa.setCapability("deviceName", "ZY223FT2F4");
		//capa.setCapability("", "ENUL6303030010"); //Give Device ID of your mobile phone
		capa.setCapability("platformName", "Android");
		capa.setCapability("platformVersion", "7.0");
		capa.setCapability("app", "C:/Users/hamza.naseem/Desktop/Apk Files/selendroid-test-app.apk");
		capa.setCapability("appPackage", "io.selendroid.testapp");
		capa.setCapability("appActivity", "io.selendroid.testapp.HomeScreenActivity");
		capa.setCapability("autoDismissAlerts", "true");
		capa.setCapability("noReset", "true");
		capa.setCapability("clearSystemFiles", "true");
		
		driver = new AndroidDriver<MobileElement>(url, capa);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
}
