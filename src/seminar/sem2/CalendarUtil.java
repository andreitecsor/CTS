package seminar.sem2;

import java.text.DateFormatSymbols;
import java.util.Locale;

public class CalendarUtil {
    public String weekDay(int day) throws IncorrectDayException {
        if (day == 1)
            return "Sunday";
        else if (day == 2)
            return "Monday";
        else if (day == 3)
            return "Tuesday";
        else if (day == 4)
            return "Wednesday";
        else if (day == 5)
            return "Thursday";
        else if (day == 6)
            return "Friday";
        else if (day == 7)
            return "Saturday";

        throw new IncorrectDayException("Only 7 days in a week");
    }

    public String weekDay2(int day) throws IncorrectDayException {
        switch (day) {
            case 1:
                return "Sunday";
            case 2:
                return "Monday";
            case 3:
                return "Tuesday";
            case 4:
                return "Wednesday";
            case 5:
                return "Thursday";
            case 6:
                return "Friday";
            case 7:
                return "Saturday";
            default:
                throw new IncorrectDayException("Only 7 days in a week");
        }
    }

    public String weekDay3(int day) throws IncorrectDayException {
        if (day <= 0 || day > 7) {
            throw new IncorrectDayException("Only 7 days in a week");
        }
        String[] weekdays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        return weekdays[day - 1];
    }

    public String weekDay4(int day) throws IncorrectDayException {
        if (day <= 0 || day > 7) {
            throw new IncorrectDayException("Only 7 days in a week");
        }
        String[] weekdays = DateFormatSymbols.getInstance(Locale.CHINESE).getWeekdays();
        return weekdays[day - 1];
    }
}
