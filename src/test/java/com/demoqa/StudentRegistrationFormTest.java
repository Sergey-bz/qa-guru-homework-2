package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9171234567");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("October");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOptionByValue("1993");
        $(".react-datepicker__day--008").click();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("face.png");
        $("#currentAddress").setValue("960 AVENUE OF THE AMERICAS NEW YORK");
        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Panipat")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").find(byText("Student Name")).closest("tr").shouldHave(text("Sergey Sviridov"));
        $(".table-responsive").find(byText("Student Email")).closest("tr").shouldHave(text("super@test.com"));
        $(".table-responsive").find(byText("Gender")).closest("tr").shouldHave(text("Male"));
        $(".table-responsive").find(byText("Mobile")).closest("tr").shouldHave(text("9171234567"));
        $(".table-responsive").find(byText("Date of Birth")).closest("tr").shouldHave(text("08 October,1993"));
        $(".table-responsive").find(byText("Subjects")).closest("tr").shouldHave(text("Computer Science"));
        $(".table-responsive").find(byText("Hobbies")).closest("tr").shouldHave(text("Sports"));
        $(".table-responsive").find(byText("Picture")).closest("tr").shouldHave(text("face.png"));
        $(".table-responsive").find(byText("Address")).closest("tr").shouldHave(text("960 AVENUE OF THE AMERICAS NEW YORK"));
        $(".table-responsive").find(byText("State and City")).closest("tr").shouldHave(text("Haryana Panipat"));
    }
}
