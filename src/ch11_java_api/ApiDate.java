package ch11_java_api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class ApiDate {
	public static void main(String[] args) {
		//1. Date 클래스 (1970년 1월 1일 자정 이후 시간을 밀리초 단위로 표현)
		Date dateToday = new Date();
		System.out.println(dateToday); //korean standard time
		//원하는 문자열 format 형태
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
		System.out.println(sdf.format(dateToday));
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf2.format(dateToday));
		//뉴욕시간
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.US);
		TimeZone timeZone = TimeZone.getTimeZone("America/New_York");
		sdf3.setTimeZone(timeZone);
		System.out.println(sdf3.format(dateToday));
		
		//String to date
		String str = "2025/01/21 09-10-00";
		sdf = new SimpleDateFormat("yyyy/MM/dd HH-mm-ss");
		try {
			Date startDt = sdf.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Calendar 클래스 (year, month, day 같은 필드를 제공) 날짜 계산에 유용함.
		Calendar calToday = Calendar.getInstance();
		System.out.println(calToday.getTime());
		System.out.println(calToday.get(Calendar.DATE));
		System.out.println(calToday.get(Calendar.MONTH) + 1);
		System.out.println(calToday.get(Calendar.YEAR));
		System.out.println(calToday.get(Calendar.HOUR_OF_DAY));
		
		//1일 뒤
		calToday.add(Calendar.DATE, 1);
		System.out.println(sdf.format(calToday.getTime()));
		//3일뒤
		calToday.add(Calendar.DATE, 3);
		System.out.println(sdf.format(calToday.getTime()));
		//5개월뒤
		calToday.add(Calendar.MONTH, 5);
		System.out.println(sdf.format(calToday.getTime()));
		
		Calendar calendars = Calendar.getInstance();
		int year = 2025;
		int month = 2;
		calendars.set(year, month-1, 1); //해당 월의 1일 날짜
		System.out.println(sdf.format(calendars.getTime()));
		int startDay = calendars.get(calendars.DAY_OF_MONTH);
		System.out.println(startDay);
		//해당 월의 마지막 일자 얻기
		int lastDay = calendars.getActualMaximum(calendars.DAY_OF_MONTH);
		System.out.println(lastDay);
		//요일 1: 일요일, 2: 월요일 ~~~ 7: 토요일
		System.out.println(calendars.get(Calendar.DAY_OF_WEEK));
		System.out.println(year + "년 " + month + "월 달력");
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		int current = 1;
		for (int i = 1; i <= 42; i++) {
			if (i < startDay) {
				System.out.println("\t");
			} else {
				System.out.printf("%d\t", current);
				current++;
				if (current > lastDay) {
					break;
				}
			}
			if (i % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println();
		//input : int year, int month
		//output : void
		//내용 : 해당 년월(달력 출력) workingCalendar(2025, 10)
		//주말을 빼고 월 -금요일만 출력 (토욜, 일욜 없도록)
		workingCalendar(2025,10);
		System.out.println();
	}
    public static void workingCalendar(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1); // Set the calendar to the 1st day of the month
        int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH); // Get last day of the month
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK); // Get the day of the week for the 1st day of the month

        System.out.println(year + "년 " + month + "월 달력");
        System.out.println("월\t화\t수\t목\t금");

        int current = 1;

        // Skip the initial empty spaces before the 1st of the month
        for (int i = 1; i <= 42; i++) { 
            if (i < dayOfWeek) {
                // Skip empty cells before the 1st day of the month
                System.out.print("\t");
            } else {
                // Only print weekdays (Monday to Friday)
                if (current <= lastDay) {
                    if (i % 7 != 1 && i % 7 != 0) { // Avoid Saturdays (i % 7 == 1) and Sundays (i % 7 == 0)
                        System.out.printf("%2d\t", current);
                        current++;
                    }
                }
            }

            // New line after printing 5 weekdays (Monday to Friday)
            if (i % 7 == 0) {
                System.out.println();
            }

            // Stop when we reach the last day of the month
            if (current > lastDay) {
                break;
            }
        }
    }
}
