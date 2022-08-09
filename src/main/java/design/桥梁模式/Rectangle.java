package design.桥梁模式;

/**
 * @author apple
 */
public class Rectangle extends Shape{
    private  int x;
    private  int y;

    public Rectangle(DrawApi drawApi, int x, int y) {
        super(drawApi);
        this.x = x;
        this.y = y;
    }
    @Override
    public void draw() {
        drawApi.draw(0,x,y);
    }
}
