package test;

/**
 * @author Ayuan
 * @Description: 计算圆形面积
 * @date 2022/12/13 15:32
 */
public class Circle implements Shape {

    private double PI = 3.14;

    @Override
    public double area(double x) {
        //s = πr²
        return PI * Math.sqrt(x);
    }
}
