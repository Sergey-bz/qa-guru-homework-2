package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationFormTest {

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Sergey");
        $("#lastName").setValue("Sviridov");
        $("#userEmail").setValue("super@test.com");
        $("[for = gender-radio-1]").click();
        $("#userNumber").setValue("9171234567");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("October");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOptionByValue("1993");
        $(".react-datepicker__day--008").click();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("[for = hobbies-checkbox-1]").click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/face.png"));
        $("#currentAddress").setValue("960 AVENUE OF THE AMERICAS NEW YORK");
        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Panipat")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Sergey Sviridov"));
        $(".table-responsive").shouldHave(text("super@test.com"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("9171234567"));
        $(".table-responsive").shouldHave(text("08 October,1993"));
        $(".table-responsive").shouldHave(text("Computer Science"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("face.png"));
        $(".table-responsive").shouldHave(text("960 AVENUE OF THE AMERICAS NEW YORK"));
        $(".table-responsive").shouldHave(text("Haryana Panipat"));
    }
}
