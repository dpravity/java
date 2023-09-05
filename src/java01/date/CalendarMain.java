package java01.date;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class CalendarMain {
    static Calendar cal = Calendar.getInstance();
    static LocalDate ld = LocalDate.now();
    static LocalDateTime ldt = LocalDateTime.now();

    public static void main(String[] args) {

        CalendarMain c = new CalendarMain();
//        c.calendar();
//        c.calendarToDate();
//        c.localDate();
//        c.localDateTime();
        c.viewCalendar();
//        c.instant();
//        c.localDateAndTime();
//        c.zoneDate();
//        c.period();
//        c.duration();

    }

    public void calendar(){
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + "=============================");
        System.out.println(cal);
        System.out.println(cal.get(Calendar.YEAR));
        System.out.println(cal.get(Calendar.MONTH) + 1);
        System.out.println(cal.get(Calendar.DATE));
        System.out.println(cal.get(Calendar.HOUR));
        System.out.println(cal.get(Calendar.MINUTE));
        System.out.println("=============================");
    }

    public void calendarToDate(){
        System.out.println("=============================");
        Date d = new Date(cal.getTimeInMillis());
        System.out.println(d);
        System.out.println("=============================");
    }

    public void localDate(){
        System.out.println("=============================");
        System.out.println(ld);
        System.out.println("=============================");
    }

    public void localDateTime(){
        System.out.println("=============================");
        System.out.println(ldt);
        System.out.println("=============================");
    }
    public void viewCalendar(){
        System.out.println("=============================");
        Scanner scanner = new Scanner(System.in);
        String yearStr = scanner.nextLine();
        String monthStr = scanner.nextLine();

        int year = Integer.parseInt(yearStr);
        int month = Integer.parseInt(monthStr);
        int startDayOfWeek = 0;
        int endDay = 0;

        Calendar sDay = Calendar.getInstance(); // 시작일
        Calendar eDay = Calendar.getInstance(); // 종료일

        sDay.set(year, month - 1, 1);
        eDay.set(year, month, 1);

        eDay.add(Calendar.DATE, -1);
        startDayOfWeek = sDay.get(Calendar.DAY_OF_WEEK);
        endDay = eDay.get(Calendar.DATE);

        System.out.println("  " + yearStr + "년 " + monthStr + "월");
        System.out.println("  SU  MO  TU  WE  TH  FR  SA");

        for(int i = 1; i < startDayOfWeek; i++){
            System.out.print("   ");
        }

        for(int i = 1, n = startDayOfWeek; i <= endDay; i++, n++){
            System.out.print((i < 10) ? "  0" + i : "  " + i);
            if(n % 7 == 0){
                System.out.println();
            }
        }


        System.out.println();
        System.out.println("=============================");
    }


    public void instant(){
        System.out.println("=============================");
        Instant now = Instant.now();
        System.out.println(now);
        System.out.println("=============================");
    }

    public void localDateAndTime(){
        System.out.println("=============================");
        LocalDate ld = LocalDate.now();
        LocalTime lt = LocalTime.of(10, 30);
        System.out.println(ld + "   " + lt);
        System.out.println("=============================");
    }

    public void zoneDate(){
        System.out.println("=============================");
        ZoneId zid = ZoneId.of("Asia/Seoul");
        ZonedDateTime zdt = ZonedDateTime.now(zid);
        System.out.println(zdt);
        System.out.println("=============================");
    }

    public void period(){
        System.out.println("=============================");
        LocalDate st = LocalDate.of(2023, 1, 25);
        LocalDate et = LocalDate.of(2023, 1, 30);
        Period p = Period.between(st, et);
        System.out.println(p.getDays());
        System.out.println("=============================");
    }

    public void duration(){
        System.out.println("=============================");
        LocalTime st = LocalTime.of(00, 00, 00);
        LocalTime et = LocalTime.of(1, 0, 0);
        Duration d = Duration.between(st, et);
        System.out.println(d.get(ChronoUnit.SECONDS) / 3600);
        System.out.println("=============================");
    }

}
