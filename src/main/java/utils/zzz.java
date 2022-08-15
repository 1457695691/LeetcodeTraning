package utils;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class zzz {
    public static void main(String[] args) {
        String str = "https://chiyanshe-nowatermark.oss-cn-beijing.aliyuncs.com/normandy/1607308582981.jpg,https://chiyanshe-nowatermark.oss-cn-beijing.aliyuncs.com/normandy/1607308593312.jpg,https://chiyanshe-nowatermark.oss-cn-beijing.aliyuncs.com/normandy/1607309244450.jpg";
        String jdPic = getJDPic(str);
        System.out.println(jdPic);
//        String name = "齿研社(测试)";
//        String out = getJDName(name);
//        System.out.println(out);
//        String address = "江西省南昌市阿德区象山北路371号阳明路口（老南昌日报社对面）";
//        String address2 = getAddress(address);
//        System.out.println(address2);

    }

    private static String getJDPic(String url) {
        StringBuilder fileName = new StringBuilder();
        String fileUrl = Arrays.stream(url.split(",")).findFirst().get();
        String substring = fileUrl.substring(fileUrl.lastIndexOf("/") + 1, fileUrl.lastIndexOf("."));
        fileName.append(substring).append(",");
        fileName.delete(fileName.length() - 1, fileName.length());
        return fileName.toString();
    }

    private static String getJDName(String name) {
        return name.replace("(", "（").replace(")", "）");
    }

    private static String getJDAddress(String address) {
        String regEx = "[\n`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）+|{}【】‘；：”“’。， 、？]";
        String aa = " ";
        return address.replaceAll(regEx, aa);
    }

    private static String getAddress(String address){
        String regEx = "[\n`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）+|{}【】‘；：”“’。， 、？]";
        String s = address.replaceAll(regEx, " ");
        if (s.contains("省")){
            s = s.substring(s.indexOf("省")+1,s.length());
        }
        if (s.contains("市")){
            s = s.substring(s.indexOf("市")+1,s.length());
        }
        if (s.contains("区")){
            s = s.substring(s.indexOf("区")+1,s.length());
        }
        return s;
    }



}