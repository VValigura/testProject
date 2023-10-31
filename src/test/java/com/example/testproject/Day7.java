package com.example.testproject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class Day7 {



    @Test
    void fillAutomationPracticeForm(){
//        Configuration.browser = "Firefox";
        Configuration.browserSize = "1920x1080";
        open("https://demoqa.com/automation-practice-form");


        executeJavaScript("$('#adplus-anchor').remove()");
        executeJavaScript("$('footer').remove()");



        $("#firstName").setValue("firstName");
        $("#lastName").setValue("lastName");
        $("#userEmail").setValue("name@example.com");
        $("#gender-radio-1").parent().click();
        $("#userNumber").setValue("0123456789");
        $("#dateOfBirthInput").click();
        $("#dateOfBirthInput").sendKeys(Keys.CONTROL + "A");
        $("#dateOfBirthInput").sendKeys( "01/01/1991");
        $("#dateOfBirthInput").sendKeys(Keys.ENTER);
        $("#hobbies-checkbox-1").parent().click();
        $("#uploadPicture").sendKeys("C:\\Users\\Valigura\\2.png");



        $("#currentAddress").setValue("currentAddress");
        $("#submit").click();
        $("table.table").shouldHave(text("firstName"));
    }

}
