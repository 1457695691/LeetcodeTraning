package design.chain_of_responsibility;

/**
 * @author apple
 */
public class ErrorLogger extends AbstractLogger{
    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger " + message);
    }

    public ErrorLogger(int level) {
        this.level = level;
    }

}
