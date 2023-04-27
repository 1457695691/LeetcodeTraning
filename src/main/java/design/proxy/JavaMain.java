package design.proxy;

/**
 * @author Ayuan
 * @Description: 主要执行方法
 * @date 2023/4/26 18:00
 */
public class JavaMain {
    public static void main(String[] args) {
        Landlord landlord = new HangZhouLandlord();
        System.out.println(landlord.getClass());
//        LandlordProxy proxy = new LandlordProxy(landlord);
        Landlord proxy = (Landlord) new ProxyFactory(landlord).getProxyInstance();
        // 从中介进行租房
        proxy.apartmentToRent();

        System.out.println(proxy.getClass());

        while (true) {
        }
    }
}