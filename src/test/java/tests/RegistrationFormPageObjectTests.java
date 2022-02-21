package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

//Объявляем класс RegistrationFormTestspageObject
//и присваем ему уровень доступа (модификатор) указывая public.
//Public говорит что класс доступен из других пакетов
//Поля и методы, объявленные с модификатором public,
//видны другим классам из текущего пакета и из внешних пакетов.
//Class
public class RegistrationFormPageObjectTests {
    //создали объект класса RegistrationPage с помощью оператора new
    RegistrationPage registrationPage = new RegistrationPage();
    //создали приватный класс стринг со значениями
    private String
            firstName = "Vova",
            lastName = "Olegovich",
            userEmail = "Vova@mail.ru",
            userGender = "Male",
            userNumber = "7123456789",
    //birth day
            day = "06",
            month = "July",
            year = "2010",

            pathFile = "src/test/resources/123.jpg",
            currentAddress = "Moscow",
            state = "Haryana",
            city = "Panipat";
    private String[] subjects = new String[] {"Biology","Arts", "Maths", "History"};
    private  String[] hobbies = new String[] {"Sports", "Reading", "Music"};


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
        registrationPage.setFirstName(firstName);
        registrationPage.setLastName(lastName);
        registrationPage.setUserEmail(userEmail);
        registrationPage.typeGender(userGender);
        registrationPage.setUserNumber(userNumber);
        registrationPage.setBirthDate(day,month,year);
        registrationPage.setSubjectsInput(subjects);
        registrationPage.setHobbiesWrapper(hobbies);
        registrationPage.setUploadPicture(pathFile);
        registrationPage.setCurrentAddress(currentAddress);
        registrationPage.setState(state);
        registrationPage.setCity(city);
        registrationPage.submitForm();


        //Проверяем ожидаемый результат
        registrationPage.checkTable("Thanks for submitting the form");
        registrationPage.checkForm("Student Name", firstName + " " + lastName  );
        registrationPage.checkForm("Student Email", userEmail);
        registrationPage.checkForm("Gender", userGender);
        registrationPage.checkForm("Mobile", userNumber);
        registrationPage.checkForm("Date of Birth", day+ " "+ month+ ","+ year);
        registrationPage.checkForm("Subjects", subjects[0]+',' + ' '+subjects[1]+',' + ' '+subjects[2]+',' + ' '+subjects[3]);
        registrationPage.checkForm("Hobbies", hobbies[0]+',' + ' '+hobbies[1]+',' + ' '+hobbies[2]);
        registrationPage.checkForm("Picture", "123.jpg");
        registrationPage.checkForm("Address", currentAddress);
        registrationPage.checkForm("State and City", state+ " "+ city);


    }
}