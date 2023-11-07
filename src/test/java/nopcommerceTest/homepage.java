package nopcommerceTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class homepage {
    public static void main(String[] args) {
        // Use WebDriverManager to setup the ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Open a website
        driver.get("https://parabank.parasoft.com/parabank/register.htm");

        // Perform other actions as needed

        // Close the browser
        driver.quit();
    }




}
