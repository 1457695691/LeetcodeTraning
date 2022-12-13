package test;

/**
 * @author Ayuan
 * @Description: 计算正方形面积
 * @date 2022/12/13 15:32
 */
public class Square implements Shape {

    @Override
    public double area(double x) {
        //x的平方
        return Math.sqrt(x);
    }
}
