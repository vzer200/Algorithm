package ms.Factory;

public class Flower implements Plant {
    @Override
    public void grow() {
        System.out.println("A flower is blooming.");
    }
}
