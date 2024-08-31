package ms.ObserverPattern;

public class ObserverPatternDemo {
    public static void main(String[] args) {
        // 创建具体的被观察者
        ConcreteSubject subject = new ConcreteSubject();

        // 创建观察者
        Observer observer1 = new ConcreteObserver("Observer 1");
        Observer observer2 = new ConcreteObserver("Observer 2");

        // 将观察者添加到被观察者中
        subject.attach(observer1);
        subject.attach(observer2);

        // 改变被观察者的状态，并通知观察者
        subject.setMessage("First Message");
        // 输出:
        // Observer 1 received message: First Message
        // Observer 2 received message: First Message

        // 移除一个观察者
        subject.detach(observer1);

        // 再次改变被观察者的状态
        subject.setMessage("Second Message");
        // 输出:
        // Observer 2 received message: Second Message
    }
}

