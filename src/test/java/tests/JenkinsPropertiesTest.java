package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.RegistrationFormPage;

import java.util.Locale;
import java.util.Map;


@Tag("JenkinsPropertiesTest")
public class JenkinsPropertiesTest {

    Faker faker;

    @BeforeEach
    void beforeEach(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        Configuration.browserSize = System.getProperty("browser_extension","1920x1080");
        Configuration.browser = System.getProperty("browser_name","chrome");
        Configuration.browserVersion = System.getProperty("browser_version","100.0");
        Configuration.remote = System.getProperty("selenoid_url","https://user1:1234@selenoid.autotests.cloud/wd/hub");


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;


        faker = new Faker(new Locale("en"));

    }

    @Test
    void fillAutomationPracticeForm(){

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String mobile = faker.phoneNumber().subscriberNumber(10);
        String picturePaths = "src/test/resources/1.jpg";
        String setCurrentAddress = faker.address().fullAddress();
        String state = "Haryana";
        String city = "Karnal";
        String subjects = "English";

        System.out.println("----------------------PARAMETERS START---------------------");
        System.out.println("browser_extension : " + System.getProperty("browser_extension"));
        System.out.println("browser_name : "+System.getProperty("browser_name"));
        System.out.println("browser_version : "+System.getProperty("browser_version"));
        System.out.println("selenoid_url : "+System.getProperty("selenoid_url"));
        System.out.println("----------------------PARAMETERS END---------------------");

        new RegistrationFormPage().openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender()
                .setMobile(mobile)
                .setDateOfBirth("05", "June", "1991")
                .setSubjects(subjects)
                .setHobbies()
                .uploadPicture(picturePaths)
                .setCurrentAddress(setCurrentAddress)
                .selectState(state)
                .selectCity(city)
                .pressSubmit()
                .verifyResultsModalAppears()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile",mobile )
                .verifyResult("Date of Birth", "05 June,1991");

    }
}
