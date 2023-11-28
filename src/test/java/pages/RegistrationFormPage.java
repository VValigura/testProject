package pages;

import com.codeborne.selenide.selector.ByText;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {
    private CalendarComponent calendar = new CalendarComponent();
    private RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();

    public RegistrationFormPage openPage(){
        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('#adplus-anchor').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationFormPage setFirstName(String firstName){
        $("#firstName").setValue(firstName);
        return this;
    }

    public RegistrationFormPage setLastName(String lastName){
        $("#lastName").setValue(lastName);
        return this;
    }

    public RegistrationFormPage setEmail(String email){
        $("#userEmail").setValue(email);
        return this;
    }

    public RegistrationFormPage setGender(){
        $("#gender-radio-1").parent().click();
        return this;
    }

    public RegistrationFormPage setMobile(String mobile){
        $("#userNumber").setValue(mobile);
        return this;
    }

    public RegistrationFormPage setDateOfBirth(String day, String months, String year){
        $("#dateOfBirthInput").click();
        calendar.setDate(day, months, year);
        return this;
    }

    public RegistrationFormPage setHobbies(){
        $("#hobbies-checkbox-1").parent().click();
        return this;
    }

    public RegistrationFormPage uploadPicture(String picturePaths){
        $("#uploadPicture").uploadFile(new File(picturePaths));
        return this;
    }

    public RegistrationFormPage setCurrentAddress(String currentAddress){
        $("#currentAddress").setValue(currentAddress);
        return this;
    }

    public RegistrationFormPage selectState(String state){
        $("#state").click();
        $(byText(state)).click();
        return this;
    }

    public RegistrationFormPage selectCity(String city){
        $("#city").click();
        $(byText(city)).click();
        return this;
    }

    public RegistrationFormPage setSubjects(String subjects){
        $("#subjectsInput").setValue(subjects).pressEnter();;
        return this;
    }

    public RegistrationFormPage pressSubmit(){
        $("#submit").click();
        return this;
    }

    public RegistrationFormPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();

        return this;
    }

    public RegistrationFormPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);

        return this;
    }










}
