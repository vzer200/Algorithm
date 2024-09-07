package ms.Factory;

import java.util.HashMap;
import java.util.Map;

// 工厂类，用于生成不同类型的植物
public class PlantFactory {
    // 使用Map来存储植物类型和对应的类
    private static final Map<String, Class<? extends Plant>> plantRegistry = new HashMap<>();

    // 静态代码块，注册所有已知的植物类型
    static {
        registerPlant("flower", Flower.class);
        registerPlant("tree", Tree.class);
        registerPlant("shrub", Shrub.class);
    }

    // 注册植物类型的方法
    public static void registerPlant(String plantType, Class<? extends Plant> plantClass) {
        plantRegistry.put(plantType, plantClass);
    }

    // 工厂方法，根据植物类型创建相应的植物对象
    public static Plant createPlant(String plantType) {
        Class<? extends Plant> plantClass = plantRegistry.get(plantType);
        if (plantClass == null) {
            throw new IllegalArgumentException("Unknown plant type: " + plantType);
        }
        try {
            return plantClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create plant of type: " + plantType, e);
        }
    }
}

