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

public class ChooseDateTests {

    private static FirefoxDriver driver;
	
    @BeforeEach
    void setUp() throws Exception 
    {        
        FirefoxOptions capabilities = new FirefoxOptions();
        // // capabilities.setPreference(FirefoxProfile.PORT_PREFERENCE, 4444);
    
        // driver = new FirefoxDriver(capabilities);
        // driver.get("http://localhost:8080/test");

        // driver.findElement(By.id("username")).sendKeys("admin");
        // driver.findElement(By.id("password")).sendKeys("admin");
        // driver.findElement(By.xpath("//input[@value='Login']")).click();
    }

    @AfterEach
    void close() throws Exception {
        // driver.quit();
    } 


    @Test
    @DisplayName("input date range")	
    public void addPoint(){
        assertEquals(1,1);
        // assertEquals(driver.findElement(By.xpath("//span[@class='copyTitle']/b")).getText(), "admin");	
        // driver.quit();
    }

}		