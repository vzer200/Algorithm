package ms.Strategy;


//策略工厂
public class StrategyFactory {

    public enum StrategyType {
        ADD, SUBTRACT, MULTIPLY
    }

    public static Strategy getStrategy(StrategyType type) {
        switch (type) {
            case ADD:
                return new OperationAdd();
            case SUBTRACT:
                return new OperationSubtract();
            case MULTIPLY:
                return new OperationMultiply();
            default:
                throw new IllegalArgumentException("Invalid strategy type");
        }
    }
}

