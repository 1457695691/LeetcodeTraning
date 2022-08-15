package utils;

import com.alibaba.fastjson.JSONArray;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

/**
 * @author ayuan
 */
public class FileUtils {

    /**
     * code生成器
     */
    public static void main(String[] args) {

        String workTime = "[{\"start\":\"09:00\",\"end\":\"12:00\"},{\"start\":\"13:00\",\"end\":\"18:00\"}]";
        List<ReserveTimeVO> list = JSONArray.parseArray(workTime, ReserveTimeVO.class);
        System.out.println(list.size());
        LocalDateTime Yyyymmdd = DateUtil.convertDateToLocalDateTime(new Date());
        String resYyyymmdd = DateUtil.getStringDate(Yyyymmdd);
        System.out.println(resYyyymmdd);
        for (ReserveTimeVO vo : list) {
            //多线程并发问题 尝试解决2
            LocalDateTime startTimeLocal = DateUtil
                    .getDateTimeByString(resYyyymmdd + " " + vo.getStart() + ":00");
            LocalDateTime endTimeLocal = DateUtil
                    .getDateTimeByString(resYyyymmdd + " " + vo.getEnd() + ":00");
            try {
                if (null != startTimeLocal && null != endTimeLocal) {
                    while (startTimeLocal.isBefore(endTimeLocal)) {
                        String dateTimeFormat = DateUtil.getDateTimeFormat(startTimeLocal);
                        Date date = new Date();
                        System.out.println(dateTimeFormat);
                        startTimeLocal = DateUtil.plus(startTimeLocal, 30, ChronoUnit.MINUTES);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
