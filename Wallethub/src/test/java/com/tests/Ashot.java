package com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ashot {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		System.setProperty("webdriver.chrome.driver", "/Users/asahoo/Downloads/chromedriver");
		
		driver.get("https://wallethub.com/join/light");

	}

}
