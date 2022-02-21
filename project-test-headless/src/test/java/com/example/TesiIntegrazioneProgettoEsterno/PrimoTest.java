package com.example.ProvaProcesso;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import java.io.File;

public class PrimoTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testPrimo() throws Exception {
    driver.get("http://127.0.0.1:8080/#!/main");
    driver.findElement(By.xpath("//*[@x-test-tpl-1]//*[@x-test-hook-9]//*[@x-test-tpl-40]//*[@x-test-hook-46]")).click();
    driver.findElement(By.xpath("//*[@x-test-tpl-1]//*[@x-test-hook-9]//*[@x-test-tpl-40]//*[@x-test-hook-48]")).click();
    driver.findElement(By.xpath("//*[@x-test-tpl-1]//*[@x-test-hook-9]//*[@x-test-tpl-40]//*[@x-test-hook-49]//*[@x-test-tpl-62]//*[@x-test-hook-81]")).click();
    driver.findElement(By.xpath("//*[@x-test-tpl-1]//*[@x-test-hook-9]//*[@x-test-tpl-40]//*[@x-test-hook-49]//*[@x-test-tpl-62]//*[@x-test-hook-82]")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
