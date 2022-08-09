package design.策略模式;

/**
 * @author apple
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public int executeDraw(int radius,int x, int y){
        return strategy.draw(radius,x,y);
    }
}
