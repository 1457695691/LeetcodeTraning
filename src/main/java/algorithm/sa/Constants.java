package algorithm.sa;

/**
 * @author Ayuan
 */
public class Constants {
    // 初始温度
    public static final Double INIT_TEMPERATURE = 100.0;
    // 最大迭代次数
    public static final Integer ITERATION_TIMES = 2000;
    // 每个温度下的迭代次数
    public static final Integer CURRENT_TEMP_ITERATION_TIMES = 50;
    // 温度衰减系数
    public static final Double TEMP_DECREASE_RATE = 0.95;
    // x的上、下界
    public static final Double MIN_X = -3.0;
    public static final Double MAX_X = 3.0;
}
