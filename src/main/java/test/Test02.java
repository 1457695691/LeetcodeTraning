package test;

import java.util.Scanner;

/**
 * @author Ayuan
 * @Description: 第二题
 * @date 2022/12/13 15:39
 */
public class Test02 {

    public static void main(String[] args) {
        int x = 1;
        int sum = 1;
        System.out.println("请输入数字n：");
        Scanner input = new Scanner(System.in);
        int i = input.nextInt();
        do {
            sum = sum * x;
            x++;
        } while (x <= i);
        System.out.println(i + "的阶乘为" + sum);
    }


}
