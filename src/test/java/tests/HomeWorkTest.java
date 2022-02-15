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
        $("#userNumber").setValue("7123456789");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2010");
        $(byText("6")).click();
        $("#subjectsInput").setValue("Biology").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/123.jpg"));
        $("#currentAddress").setValue("Moscow");
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Panipat")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text("Student Name " + "Vova" + " " + "Olegovich"),
                text("Student Email " + "Vova@mail.ru"),
                text("Gender " + "Male"),
                text("Mobile " + "7123456789"),
                text("Date of Birth " + "06 July,2010"),
                text("Subjects " + "Biology"),
                text("Hobbies " + "Sports"),
                text("Picture " + "123.jpg"),
                text("Address " + "Moscow"),
                text("State and City " + "Haryana" + " " + "Panipat")
                );


    }
}