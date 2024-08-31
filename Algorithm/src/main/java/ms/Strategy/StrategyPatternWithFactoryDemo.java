package ms.Strategy;

public class StrategyPatternWithFactoryDemo {
    public static void main(String[] args) {
        // 使用策略工厂获取策略
        Strategy addStrategy = StrategyFactory.getStrategy(StrategyFactory.StrategyType.ADD);
        Context context = new Context(addStrategy);
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

        // 更换策略
        Strategy subtractStrategy = StrategyFactory.getStrategy(StrategyFactory.StrategyType.SUBTRACT);
        context = new Context(subtractStrategy);
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

        // 再次更换策略
        Strategy multiplyStrategy = StrategyFactory.getStrategy(StrategyFactory.StrategyType.MULTIPLY);
        context = new Context(multiplyStrategy);
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
    }
}

