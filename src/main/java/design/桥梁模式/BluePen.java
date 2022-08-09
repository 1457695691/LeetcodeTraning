package design.桥梁模式;


/**
 * @author apple
 */
public class BluePen implements DrawApi {
    @Override
    public int draw(int radius, int x, int y) {
        System.out.println("用蓝色画图笔，radius：" + radius + ", x:" +x +", y:"+ y);
        return radius;
    }
}
