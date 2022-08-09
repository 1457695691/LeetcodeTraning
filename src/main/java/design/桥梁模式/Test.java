package design.桥梁模式;

public class Test {
    public static void main(String[] args) {
        Shape greenCircleShape = new Circle(new Greenpen(), 10);
        Shape redRectangleShape = new Rectangle(new Redpen(), 4, 8);

        greenCircleShape.draw();
        redRectangleShape.draw();
    }
}
