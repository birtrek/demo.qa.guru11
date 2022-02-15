package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setBirthDate (String day, String month, String year){
    $(".react-datepicker__month-select").selectOption("month");
    $(".react-datepicker__year-select").selectOption("year");
    $("[aria-labels$=' " + month + "" + day + "th," + year + "'']").click();
    }
}
