package ms.Factory;

// 树类实现Plant接口
public class Tree implements Plant {
    @Override
    public void grow() {
        System.out.println("A tree is growing tall.");
    }
}
