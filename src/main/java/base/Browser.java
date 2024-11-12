package base;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Browser {
    public static void launchBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        DriverContext.driver  = new ChromeDriver(chromeOptions);
        DriverContext.driver.get("https://www.webuyanycar.com/");
        System.out.println("ChromeDriver launched successfully...");
        DriverContext.driver.manage().window().maximize();
        DriverContext.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        DriverContext.driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        DriverContext.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

}
