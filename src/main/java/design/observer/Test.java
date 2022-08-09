package design.observer;

/**
 * @author apple
 */
public class Test {

    public static void main(String[] args) {
        //模拟一个服务号
        ObjectFor3D objectFor3D = new ObjectFor3D();

        //客户1
        ObserverUser1 user1 = new ObserverUser1(objectFor3D);

        //客户2
        ObserverUser2 user2 = new ObserverUser2(objectFor3D);

        //两个观察者,发送两条信息
        objectFor3D.setMsg("20140420的3D号码是：127" );
        objectFor3D.setMsg("20140421的3D号码是：333" );
    }
}
