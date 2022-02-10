package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomeWorkTest {

    @BeforeAll
    static void beforeALL() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successFillTest() {
        open("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));

        $("#firstName").setValue("Vova");
        $("#lastName").setValue("Olegovich");
        $("#userEmail").setValue("Vova@mail.ru");
        $(byText("Male")).click();
        $("#userNumber").setValue("71234567896");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July"); // я хотел очистить поле календаря и подставить заготовленную маску 10 Feb 2022
        $(".react-datepicker__year-select").selectOption("2010");
        $(byText("6")).click();
        $("#subjectsInput").setValue("Biology").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFile(new File("src/test/java/data/123.jpg"));
        $("#currentAddress").setValue("Moscow");
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Panipat")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));


    }
}