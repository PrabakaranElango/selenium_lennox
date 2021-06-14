package com.seleniumassessment.SeleniumAssessment;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseMethods {
	
	
	public static String driverpath = "C:\\Users\\sabariecs\\Downloads\\Prabakaran\\driver\\chromedriver_win32\\chromedriver.exe";
	public static WebDriver driver;
	ExcelDataConfig excel = new ExcelDataConfig("C:\\Users\\sabariecs\\eclipse-workspace\\SeleniumAssessment\\Lennox.xlsx");
    ReadExcel readexcel = new ReadExcel();
    WebElement compressor;
    String temp="";
    List<String>catalog_arr = new ArrayList<>();
    List<String>catalog_id = new ArrayList<>();
    boolean foundflag = false;
	
	public  void startChrome() {
		System.setProperty("webdriver.chrome.driver", driverpath);
		driver = new ChromeDriver();
		System.out.println("Chrome launched");
	}
	
    public void geturl() {
    	driver.get("https://www.liidaveqa.com/");
    	driver.manage().window().maximize();
		System.out.println("URL Entered");
    }
    
    public void login() {
    	driver.findElement(By.xpath("//a[@href='/signin']")).click();
        driver.findElement(By.xpath("//input[@id='j_username']")).sendKeys(readexcel.getemailID());
        driver.findElement(By.xpath("//input[@id='j_password']")).sendKeys(readexcel.getPassword());
        driver.findElement(By.xpath("//button[@id='loginSubmit']")).click();
		System.out.println("Login sucessfully");
    }
    
    public void navigation() {
        driver.findElement(By.xpath("//a[@href='#navigation']")).click();
        driver.findElement(By.xpath("//a[@href='#navigation']")).click();
        driver.findElement(By.xpath("//a[@href='#navigation']")).click();
        driver.findElement(By.xpath("//a[text()='Parts and Supplies']")).click();
        driver.findElement(By.xpath("//a[@title='Compressors']")).click();
        compressor = driver.findElement(By.xpath("(//a[@href='/compressors/compressors/c/p261'])[2]"));
        Actions action = new Actions(driver);
        action.doubleClick(compressor).perform();
		System.out.println("Page navigated");
    }
    
    public void checksubcatagory(String catalogid) {
        
        do {
            List<WebElement> catalog_list = driver.findElements(By.xpath("//div[@class='sku']"));
          for(WebElement catlog:catalog_list) {
              catalog_arr.add(catlog.getText());
            }
     
          for(int i=0;i<catalog_arr.size();i++) {
          temp = catalog_arr.get(i);
          catalog_id.add(temp.substring(7, 13));
          }
          
//          for(String catalog_str1:catalog_id) {
//        	  System.out.println("Catalog ID---"+catalog_str1);
//          }
          
          for(String catalog_str:catalog_id) {
//        	  System.out.println("catalog_str---"+catalog_str);
//        	  System.out.println("catalogid---"+catalogid);
              if(catalog_str.contains(catalogid)) {
              	foundflag=true;
              	System.out.println("ID Matched");
              	driver.findElement(By.xpath("//li[@data-product-id='10T46']")).click();
              	break;
              }else {
              	System.out.println("ID not matched");
              	foundflag=false;
              }
          }
          if(foundflag==false) {
              JavascriptExecutor js = (JavascriptExecutor) driver;
           	  js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
           	  driver.findElement(By.xpath("//a[@rel='next']")).click();
              System.out.println("Next page clicked");
        }
      }
        
        while(foundflag!=true);
    }
    
    public boolean checkproductname(String expectedname) {
      WebElement pro_name = driver.findElement(By.xpath("//h1[@itemprop='name']"));
      WebDriverWait wait = new WebDriverWait(driver,5);
      wait.until(ExpectedConditions.elementToBeClickable(pro_name));
      String product_name = pro_name.getText();
      boolean productexpected = product_name.contains(expectedname);
      if(productexpected) {
    	  System.out.println("Expected and output are same");
      }else {
    	  System.out.println("Expected and output are not same");
      }
		return productexpected;
    }
    
    public boolean checkproductprice(String expectedprice) {
   	  String product_price = driver.findElement(By.xpath("//p[@class='price']")).getText();
      boolean priceexpected = product_price.contains(expectedprice);
      if(priceexpected) {
    	  System.out.println("Expected and output are same");
      }else {
    	  System.out.println("Expected and output are not same");
      }
		return priceexpected;
  }   
    
    public void driverclose() {
    	driver.close();
    	System.out.println("Browser closed");
    }
}
