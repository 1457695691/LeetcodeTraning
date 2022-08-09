package design.chain_of_responsibility;


/**
 * @author apple
 */
public class ConsoleLogger extends AbstractLogger{

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger " + message);
    }

    public ConsoleLogger(int level){
        this.level = level;
    }

    @Override
    public void setNextLogger(AbstractLogger nextLogger) {
        super.nextLogger = nextLogger;
    }
}
