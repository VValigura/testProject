package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class Day7 {

    @BeforeEach
    void beforeEach(){
        Configuration.browserSize = "1920x1080";

    }

    @Test
    void fillAutomationPracticeForm(){

        String firstName = "firstName1";
        String lastName = "lastName1";
        String email = "name1@ex.com";
        String mobile = "0123456789";
        String picturePaths = "src/test/java/resources/1.jpg";
        String setCurrentAddress = "setCurrentAddress";
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
                .verifyResult("Mobile",mobile )
                .verifyResult("Date of Birth", "05 June,1991");
    }

}
