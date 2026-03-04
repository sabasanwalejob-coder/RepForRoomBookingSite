package com.test.application.launchTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LounchChrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.google.com/?zx=1771842148134&no_sw_cr=1");
	driver.manage().window().fullscreen();
	driver.quit();
	
	}

}
