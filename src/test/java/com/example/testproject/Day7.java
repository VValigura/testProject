package com.example.testproject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class Day7 {

    @Test
    void fillAutomationPracticeForm(){
        System.setProperty("selenide.browser", "firefox");
        Configuration.browserSize = "3220x1500";
        open("https://demoqa.com/automation-practice-form");
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
        sleep(5000);
        $("table.table").shouldHave(Condition.text("firstName"));
    }

}
