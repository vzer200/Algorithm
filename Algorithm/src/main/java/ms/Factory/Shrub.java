package ms.Factory;

// 灌木类实现Plant接口
public class Shrub implements Plant {
    @Override
    public void grow() {
        System.out.println("A shrub is spreading its branches.");
    }
}