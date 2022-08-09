package design.策略模式;

/**
 * @author apple
 */
public class BluePen implements Strategy{
    @Override
    public int draw(int radius, int x, int y) {
        System.out.println("用蓝色画图笔，radius：" + radius + ", x:" +x +", y:"+ y);
        return radius;
    }
}
