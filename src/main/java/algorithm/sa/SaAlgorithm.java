package algorithm.sa;

import static algorithm.sa.Constants.*;

/**
 * 模拟退火算法
 * eg:求解函数y = 11*sin(x) + 7*cos(5*x)在[-3,3]内的最大值
 *
 * @author Ayuan
 */
public class SaAlgorithm {
    public static void main(String[] args) {
        // 迭代中温度会发生改变，第一次迭代时温度就是T0
        Double currentTemp = INIT_TEMPERATURE;
        // 随机生成一个初始解 并计算当前解的函数值
        Double initX = Util.random(-3.0, 3.0);
        Double initY = targetFun(initX);
        System.out.println("初始解：" + initX + "  初始函数值：" + initY);
        // 全局最优解
        Double bestX = initX;
        Double bestY = initY;
        // 模拟退火过程
        // 外循环, 我这里采用的是指定最大迭代次数
        for (int iter = 1; iter <= ITERATION_TIMES; iter++) {
            System.out.println("-----------------" + iter + "------------------------");
            // 本次迭代（当前温度）最优解
            Double currTempBestX = bestX;
            Double currTempBestY = bestY;
            // 循环，在每个温度下开始迭代
            for (int i = 1; i < CURRENT_TEMP_ITERATION_TIMES; i++) {
                //找一个当前解附近的x， 计算新解的函数值
                Double tmpX = getNewX(initX, currentTemp, MIN_X, MAX_X);
                Double tmpY = targetFun(tmpX);
                // 如果新解函数值大于当前解的函数值 更新当前解为新解
                if (tmpY > currTempBestY) {
                    currTempBestX = tmpX;
                    currTempBestY = tmpY;
                } else {
                    //根据Metropolis准则计算一个概率
                    Double p = Math.exp(-(currTempBestY - tmpY) / currentTemp);
                    // 生成一个随机数和这个概率比较，如果该随机数小于这个概率
                    Double random = Util.random(0.0, 1.0);
                    if (random < p) {
                        // 更新当前解为新解
                        currTempBestX = tmpX;
                        currTempBestY = tmpY;
                    }
                }
            }
            // 判断是否要更新找到的最佳的解 如果当前解更好，则对其进行更新
            if (currTempBestY > bestY) {
                // 更新最大的y
                bestY = currTempBestY;
                // 更新找到的最好的x
                bestX = currTempBestX;
            }
            System.out.println("iter:" + iter + "  新解：" + bestX + "  新函数值：" + bestY + "  当前温度" + currentTemp);
            // 温度下降
            currentTemp = TEMP_DECREASE_RATE * currentTemp;
        }
        System.out.println("最终：" + bestX + "------------" + bestY);
    }

    public static Double targetFun(Double x) {
        return 11 * Math.sin(x) + 7 * Math.cos(5 * x);
    }

    public static Double getNewX(Double x0, Double T, Double xLb, Double xUb) {
        // 为变量生成N(0,1)随机数
        Double y = Util.random();
        // 根据新解的产生规则计算x_new的值
        Double xNew = x0 + y * T;

        // 如果这个新解的位置超出了定义域，就对其进行调整
        if (xNew < xLb) {
            Double r = Util.random(0.0, 1.0);
            xNew = r * xLb + (1 - r) * x0;
        } else if (xNew > xUb) {
            Double r = Util.random(0.0, 1.0);
            xNew = r * xUb + (1 - r) * x0;
        }
        System.out.println("x0:" + x0 + "---------------x_new:" + xNew);
        return xNew;
    }

}
