package ms.Factory;

public class FactoryDemo {
        public static void main(String[] args) {
            // 使用工厂模式创建不同的植物
            Plant flower = PlantFactory.createPlant("flower");
            flower.grow();

            Plant tree = PlantFactory.createPlant("tree");
            tree.grow();

            Plant shrub = PlantFactory.createPlant("shrub");
            shrub.grow();

            // 尝试创建未知的植物类型
            try {
                Plant unknown = PlantFactory.createPlant("cactus");
                unknown.grow();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
}
