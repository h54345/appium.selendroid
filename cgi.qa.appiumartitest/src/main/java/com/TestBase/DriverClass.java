package com.TestBase;

import java.util.Properties;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public abstract class DriverClass {
	private  AndroidDriver<MobileElement> driver;
	public static Properties prop;
	public  AndroidDriver<MobileElement> getDriver()
	{
		
		 return driver;
	}
	
	public void setDriver(AndroidDriver<MobileElement> driver ) {
		this.driver = driver;
	}
	}

