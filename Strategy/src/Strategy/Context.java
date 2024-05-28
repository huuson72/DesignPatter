package Strategy;

public class Context {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(int[] data) {
        strategy.execute(data);
    }
}