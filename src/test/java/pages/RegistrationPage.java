package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    CalendarComponent calendarComponent = new CalendarComponent();

    // перечисляем переменные селектора
    private SelenideElement
            lastNameInput =$("#lastName"),
            userEmailInput =$("#userEmail"),
            userGenderInput=$("#male"),
            userNumberInput=$("#userNumber"),
            userBirthInput=$("#dateOfBirthInput"),
            userSubjectsInput=$("#subjectsInput"),
            hobbiesWrapperInput=$("#hobbiesWrapper"),
            setUploadPicture=$("#uploadPicture"),
            setCurrentAddressInput=$("#currentAddress"),
            setstateCityWrapperInput=$("#state"),
            setstateCityWrapperInput1=$("#city");



    public void openPage () {
        open("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));
    }

    public void setFirstName(String firstName) {
         $("#firstName").setValue(firstName);
    }

    public void setLastName(String lastName) {
        lastNameInput.setValue(lastName);
    }

    public void setUserEmail (String userEmail){
        userEmailInput.setValue(userEmail);
    }

    public void typeGender(String gender){
        //userGenderInput.setValue(userGender);
        $(byText(gender)).click();
    }

    public void setUserNumber (String userNumber) {
        userNumberInput.setValue(userNumber);
    }

    //добавили переменую на выбор календаря
    public void setBirthDate (String day, String month, String year){
        $("#dateOfBirthInput").click();
        calendarComponent.setBirthDate(day,month,year);
    }

    public void setSubjectsInput (String subjectsInput){
        userSubjectsInput.setValue(subjectsInput);
    }
    public void setHobbiesWrapper (String setHobbiesWrapper){
        $(byText(setHobbiesWrapper)).click();
    }

    public void setUploadPicture(String uploadFile){
        setUploadPicture.uploadFile(new File("src/test/resources/123.jpg"));

    }
    public void setCurrentAddress (String currentAddressInput){
        setCurrentAddressInput.setValue(currentAddressInput);
    }

    public void setState (String stateCityWrapperInput){
        setstateCityWrapperInput.setValue(stateCityWrapperInput);
    }
    public void setCity (String stateCityWrapperInput1){
        setstateCityWrapperInput1.setValue(stateCityWrapperInput1);

    }






//    }public void checkForm(String fieldName) {
//        $(".table-responsive").shouldHave(
//                text("Student Name " + "Vova" + " " + "Olegovich"),
//                text("Student Email " + "Vova@mail.ru"),
//                text("Gender " + "Male"),
//                text("Mobile " + "7123456789"),
//                text("Date of Birth " + "06 July,2010"),
//                text("Subjects " + "Biology"),
//                text("Hobbies " + "Sports"),
//                text("Picture " + "123.jpg"),
//                text("Address " + "Moscow"),
//                text("State and City " + "Haryana" + " " + "Panipat"));
//    }



}
