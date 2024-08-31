package ms.ObserverPattern;

////被观察者类
public interface Subject {
    void attach(Observer observer);  // 添加观察者
    void detach(Observer observer);  // 移除观察者
    void notifyObservers();          // 通知所有观察者
}
