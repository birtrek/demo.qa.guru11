package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

//Объявляем класс RegistrationFormTestspageObject
//и присваем ему уровень доступа (модификатор) указывая public.
//Public говорит что класс доступен из других пакетов
//Поля и методы, объявленные с модификатором public,
//видны другим классам из текущего пакета и из внешних пакетов.
//Class
public class RegistrationFormTestspageObject {
    //создали объект класса RegistrationPage с помощью оператора new
    RegistrationPage registrationPage = new RegistrationPage();
    //создали приватный класс стринг со значением Vova
//    private String
//            firstName = "Vova",
//            lastName = "Olegovich",
////            userEmail = "Vova@mail.ru",
////            userGender = "Male",
////            lastName = "",
//            lastName = "",
//            lastName = "",
//            lastName = "",
//            lastName = "",

    //Аннотация @BeforeAll  используется для указания что эти методы
    // должны быть выполнены перед всеми @Test.
    // Методы должны быть public void
    @BeforeAll
    static void beforeALL() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }
    //Аннотация @Test обозначает набор тестовых методов
    //Здесь размещаются сами проверки
    @Test
    //void метод
    void successFillTest() {

        registrationPage.openPage();
        registrationPage.setFirstName("Vova");
        registrationPage.setLastName("Olegovich");
        registrationPage.setUserEmail("Vova@mail.ru");
        registrationPage.typeGender("Male");
        registrationPage.setUserNumber("7123456789");
        registrationPage.setBirthDate("06","July","2010");
        registrationPage.setSubjectsInput("Biology");
        registrationPage.setHobbiesWrapper("Sports");
        registrationPage.setUploadPicture("uploadFile");
        registrationPage.setCurrentAddress("Moscow");
        registrationPage.setState("Haryana");
        registrationPage.setCity("Panipat");
        registrationPage.submitForm();


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
                text("State and City " + "Haryana" + " " + "Panipat"));
    }
}