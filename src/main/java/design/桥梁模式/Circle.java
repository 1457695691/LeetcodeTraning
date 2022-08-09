package design.桥梁模式;

/**
 * @author apple
 */
public class Circle extends Shape{

    private int radius;

    public Circle(DrawApi drawApi, int radius) {
        super(drawApi);
        this.radius = radius;
    }

    @Override
    public void draw() {
        drawApi.draw(radius,0,0);
    }
}
