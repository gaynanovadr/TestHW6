package Lesson6;

import Lesson6.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class JavaRashTest {
    WebDriver driver;
    MainPage mainPage;
    LoginBlock loginBlock;
    private final static String JAVA_RUSH_BASE_URL = "https://javarush.ru/";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        mainPage = new MainPage(driver);
        loginBlock = new LoginBlock(driver);
        driver.get(JAVA_RUSH_BASE_URL);
        driver.manage().window().maximize();
    }
    @Test
    void writeCommentOnLectures(){
        new MainPage(driver).clickOnHeaderLoginButton();

        //Lesson6.LoginBlock loginBlock = new LoginBlock(driver).clickOnWelcomeLoginButton();

        //new LoginBlock(driver)
         //       .clickOnWelcomeLoginButton()
          //      .fillLoginInput("gaynanovadr@mail.ru")
           //     .fillPasswordInput("******")
            //    .submitLoginButton();

        new PersonalPage(driver)
                .scrollToComments()
                .leaveComment("Its Selenium Test")
                .submitComment()
                .checkCommentIsDisplayed();
    }

    @AfterEach
    void tearDown() {
        driver.quit();

    }
}
