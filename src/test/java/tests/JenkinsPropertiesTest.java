package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.RegistrationFormPage;

import java.util.Locale;
import java.util.Map;

@Disabled
@Tag("JenkinsPropertiesTest")
public class JenkinsPropertiesTest {

    Faker faker;

    @BeforeEach
    void beforeEach(){

 //clean jenkins_properties_test "-Dbrowser_extension=${BROWSER_EXTENSION}" "-Dbrowser_name=${BROWSER_NAME}" "-Dbrowser_version=${BROWSER_VERSION}" "-Dselenoid_url=${SELENOID_URL}"
//java "-DconfigFile=notifications/config.json" -jar notifications/allure-notifications-4.2.1.jar

        SelenideLogger.addListener("allure", new AllureSelenide());

        Configuration.browserSize = System.getProperty("browser_extension","1920x1080");
        Configuration.browser = System.getProperty("browser_name","chrome");
        Configuration.browserVersion = System.getProperty("browser_version","100.0");
        System.setProperty("selenoid_url", "https://user1:1234@selenoid.autotests.cloud/wd/hub");
        Configuration.remote = System.getProperty("selenoid_url");


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
                .verifyResult("Date of Birth", "05 June,1991");
    }
}
