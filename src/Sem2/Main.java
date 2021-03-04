package Sem2;

public class Main {
    public static void main(String[] args) {
        CalendarUtil cu = new CalendarUtil();
        try {
            System.out.println(cu.weekDay(2));
            System.out.println(cu.weekDay2(3));
            System.out.println(cu.weekDay3(2));
            System.out.println(cu.weekDay4(3));
        } catch (IncorrectDayException e) {
            System.out.println(e.getMessage());
        }

    }
}
