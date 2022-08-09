package design.策略模式;

public class Greenpen implements Strategy{
    @Override
    public int draw(int radius, int x, int y) {
        System.out.println("用绿色画图笔，radius：" + radius + ", x:" +x +", y:"+ y);
        return radius;
    }
}
