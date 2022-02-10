package junit;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest {

    @BeforeAll
    static  void  beforeALL() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successFillTest() {
        open("/text-box");
        $(".main-header").shouldHave(text("Text Box"));

        $("#userName").setValue("Vova");
        $("#userEmail").setValue("Vova@mail.ru");
        $("#currentAddress").setValue("Moscow");
        $("#permanentAddress").setValue("street");
        $("#submit").click();

        $("#output").shouldHave((text("Vova")),text("Vova@mail.ru"),text("Moscow"),text("street"));
        //scrollTo() проскролить до

        $("#name").shouldHave(text("Vova"));
        $("#currentAddress").shouldHave(text("Moscow")); //wrong
        $("#currentAddress",1).shouldHave(text("Moscow"));//wrong
        $("#output").$("#currentAddress").shouldHave(text("Moscow"));

        $("submit").click();


    }
}
