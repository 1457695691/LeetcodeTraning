package design.桥梁模式;

public class Greenpen implements DrawApi {
    @Override
    public int draw(int radius, int x, int y) {
        System.out.println("用绿色画图笔，radius：" + radius + ", x:" +x +", y:"+ y);
        return radius;
    }
}
