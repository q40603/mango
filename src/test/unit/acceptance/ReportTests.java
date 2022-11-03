package test.acceptance;



import static org.junit.Assert.assertEquals;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class ReportTests {

    private static FirefoxDriver driver;
	
    @BeforeEach
    void setUp() throws Exception 
    {        
        FirefoxOptions capabilities = new FirefoxOptions();
    
        driver = new FirefoxDriver(capabilities);
        driver.get("http://localhost:8080/test");

        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@href='reports.shtm']")).click();
    }

    @AfterEach
    void close() throws Exception {
        driver.quit();
    } 


    @Test
    @DisplayName("Generate report")	
    public void generate_report(){
        driver.findElement(By.xpath("//*[@id='r31']")).click();
        driver.findElement(By.xpath("/*[@id='runImg']")).click();
        assertEquals(driver.findElement(By.xpath("//*[@id='userMessage']")).getText(), "Report has been queued");	
        // driver.quit();
    }

}		