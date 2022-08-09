package design.observer;

public class ObserverUser2 implements Observer{

    private Subject subject;

    public ObserverUser2(Subject subject){
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(String msg) {
        System.out.println("User2 得到 3D 号码  -->" + msg + ", 我要告诉舍友们。。");
    }
}
