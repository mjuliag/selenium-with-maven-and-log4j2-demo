package com.juliamavenpractice.test;

import com.juliamavenpractice.pageclasses.SearchPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/*
To run the different profiles from the terminal we run the command mvn -P{profilename}, for example: mvn -Pregression
This profiles need to be properly configured in the pom.xml file. If we run the 'mvn test' command, all the tests are
going to be executed.
This profiles need to be properly configured in the pom.xml file.
We can find the TestNG reports inside target > surefire-reports folder and we can also delete de target folder with
'mvn clean' command.
 */
public class TestNG_Test {
    private WebDriver driver;
    private String baseUrl;
    private SearchPage sp;
    private static final Logger log = LogManager.getLogger("loggingfile");

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\JuliaGirona\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.expedia.com/";
        sp = new SearchPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void fillBasicInfo() {
        log.info("Clicking Flights Tab");
        sp.clickFlightsTab();
        log.info("Setting Origin City");
        sp.setOriginCity("New York");
        log.info("Setting Destination City");
        sp.setDestinationCity("Chicago");
        log.info("Setting Departure Date");
        sp.setDepartureDate("12/25/2015");
        log.info("Setting Return Date");
        sp.setReturnDate("12/31/2015");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}