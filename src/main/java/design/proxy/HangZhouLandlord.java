package design.proxy;

/**
 * @author Ayuan
 * @Description: 杭州房东
 * @date 2023/4/26 17:58
 */
public class HangZhouLandlord implements Landlord {
    @Override
    public void apartmentToRent() {
        System.out.println("杭州房东出租房子");
    }
}
