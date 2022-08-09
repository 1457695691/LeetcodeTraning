package design.chain_of_responsibility;

/**
 * @author apple
 */
public class FileLogger extends AbstractLogger {
    @Override
    protected void write(String message) {
        System.out.println("File Console::Logger " + message);
    }

    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    public void setNextLogger(AbstractLogger nextLogger) {
        super.nextLogger = nextLogger;
    }
}
