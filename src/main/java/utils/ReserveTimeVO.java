package utils;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wangqinghe
 * 门店预约时间段
 */
@Data
public class ReserveTimeVO implements Serializable {

    private String start;

    private String end;

    public int findStartInt(){
        try {
            return Integer.valueOf(start.substring(0, 2));
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public int findEndInt(){
        try {
            return Integer.valueOf(end.substring(0, 2));
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
