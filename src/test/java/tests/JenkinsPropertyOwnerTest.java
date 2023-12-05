package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import config.ConfigWebDriver;
import config.WebDriverConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;

import java.util.Locale;

@Tag("JenkinsPropertyOwnerTest")
public class JenkinsPropertyOwnerTest {
    Faker faker;

    @BeforeEach
    void beforeEach() {
        //clean jenkins_properties_test "-Dbrowser_extension=${BROWSER_EXTENSION}" "-Dbrowser_name=${BROWSER_NAME}" "-Dbrowser_version=${BROWSER_VERSION}" "-Dselenoid_url=${SELENOID_URL}"

        faker = new Faker(new Locale("en"));
        SelenideLogger.addListener("allure", new AllureSelenide());


       new ConfigWebDriver().setBrowserConfig();
        new ConfigWebDriver().addRemoteSelenide();


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

