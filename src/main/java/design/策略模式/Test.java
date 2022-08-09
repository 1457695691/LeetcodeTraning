package design.策略模式;

public class Test {
    public static void main(String[] args) {
        Context context = new Context(new BluePen());
        context.executeDraw(10,0,0);
    }
}
