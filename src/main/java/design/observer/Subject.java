package design.observer;


/**
 * 专题接口,所有的主题必须实现此接口
 * @author apple
 */
public interface Subject {

    /**
     * 注册一个观察着
     *
     * @param observer
     */
    void registerObserver(Observer observer);

    /**
     * 移除一个观察者
     *
     * @param observer
     */
    void removeObserver(Observer observer);

    /**
     * 通知所有的观察着
     */
    void notifyObservers();
}
