package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate(String day, String months, String year){
//        year$(".react-datepicker__day--00"+"day"+":not(.react-datepicker__day--outside-month)").click();
        $(".react-datepicker__month-select").selectOption(months);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0"+day+":not(.react-datepicker__day--outside-month)").click();

    }
}
