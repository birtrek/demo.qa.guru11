package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    //компоненты
    CalendarComponent calendarComponent = new CalendarComponent();

    // перечисляем переменные селектора (локаторы)
    private SelenideElement
            lastNameInput =$("#lastName"),
            userEmailInput =$("#userEmail"),
            userGenderInput=$("#male"),
            userNumberInput=$("#userNumber"),
            userBirthInput=$("#dateOfBirthInput"),
            userSubjectsInput=$("#subjectsInput"),
            hobbiesWrapperInput=$(".practice-form-wrapper #hobbiesWrapper"),
            setUploadPicture=$("#uploadPicture"),
            setCurrentAddressInput=$("#currentAddress"),
            setStateInput=$("#state"),
            setCityInput=$("#city"),
            setClickInput=$("#submit");





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
        $(byText(gender)).click();
    }

    public void setUserNumber(String userNumber) {
        userNumberInput.setValue(userNumber);
    }

    //добавили переменую на выбор календаря
    public void setBirthDate(String day, String month, String year){
        $("#dateOfBirthInput").click();
        calendarComponent.setBirthDate(day,month,year);
    }

    public void setSubjectsInput(String[] subjects){
        for (String subject : subjects) //циклы,перебор значения массива
            userSubjectsInput.setValue(subject).pressEnter();
    }
    public void setHobbiesWrapper(String[] hobbiesWrapper){
        for (String hobbies : hobbiesWrapper)
            hobbiesWrapperInput.setValue(hobbies).pressEnter();
            hobbiesWrapperInput.$(byText("hobbies")).click();
    }

    public void setUploadPicture(String pathFile){
        setUploadPicture.uploadFile(new File(pathFile));

    }
    public void setCurrentAddress (String currentAddress){
        setCurrentAddressInput.setValue(currentAddress);
    }

    public void setState(String state){
        $("#state").scrollTo();
        setStateInput.click();
        $(byText(state)).click();
    }

    public void setCity(String city) {
        setCityInput.click();
        $(byText(city)).click();
    }

    public void submitForm() {
        setClickInput.click();
    }

    public void checkTable(String checkTable){
        $("#example-modal-sizes-title-lg").shouldHave(text(checkTable));
    }

    public void checkForm(String label, String value) {
        $(".table-responsive")// говорим где мы будем искать
                .$(byText(label)) //находим строку с label
                .parent() //говорим что бы мы перешли на уровень выше и искали необходимый елемент
                .shouldHave(text(value)); //  в этой строке мы проверяем конкретное значение
    }



}
