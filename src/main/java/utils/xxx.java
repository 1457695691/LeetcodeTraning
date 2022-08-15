package utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class xxx {
    public final static String DEFAULT_PATTERN_DATE = "yyyy-MM-dd";

    public static Date getYearMonthDayDate(Date date) {
        if (date == null) {
            return null;
        }
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DEFAULT_PATTERN_DATE);
            String format = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().format(formatter);
            LocalDate localDate = LocalDate.parse(format, formatter);
            return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Date getDateTimeByString(String dateStr) {
        try {
            //"yyyy-MM-dd HH:mm:ss"格式必须如此
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DEFAULT_PATTERN_DATE);
            LocalDateTime localDateTime = LocalDateTime.parse(dateStr, formatter);
            Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
            return date;
        } catch (Exception e) {
            return null;
        }
    }
    public static void main(String[] args) {
//        Date date = new Date();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        String format = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().format(formatter);
//        System.out.println(format);
//
//        System.out.println("===========================");
//
//        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String dateString = simpleDateFormat.format(date);
//        System.out.println(dateString);
//
//
//        //提前多少天生成库存🤣🤣🤣🤣🤣
//        Integer earlyDay = 30;
//        Date now = new Date();//
//        Calendar calendar = new GregorianCalendar();
//        calendar.setTime(now);
//        for (int i = 0; i < earlyDay; i++) {
//            //当前日期加一天
//            calendar.add(Calendar.DATE, 1);
//            Date reserveDate = calendar.getTime();
//            System.out.println(reserveDate);
//            String week = "day" + (calendar.get(Calendar.DAY_OF_WEEK) - 1 == 0 ? 7
//                    : calendar.get(Calendar.DAY_OF_WEEK) - 1);
//            System.out.println(week);
//        }
//

    }
}
