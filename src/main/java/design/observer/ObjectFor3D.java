package design.observer;

import java.util.ArrayList;
import java.util.List;

public class ObjectFor3D implements Subject{

    private String msg;

    private List<Observer> observerList = new ArrayList<Observer>();
    /**
     * 注册一个观察着 课程
     *
     * @param observer
     */
    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    /**
     * 移除一个观察者
     *
     * @param observer
     */
    @Override
    public void removeObserver(Observer observer) {
        int index = observerList.indexOf(observer);
        if (index >= 0){
            observer.update(String.valueOf(index));
        }
    }

    /**
     * 通知所有的观察着
     *
     */
    @Override
    public void notifyObservers() {
        for (Observer observer: observerList){
            observer.update(msg);
        }
    }


    public void setMsg(String msg){
        this.msg = msg;

        notifyObservers();
    }
}
