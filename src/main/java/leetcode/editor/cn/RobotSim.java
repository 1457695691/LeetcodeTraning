package leetcode.editor.cn;

import java.util.HashSet;

/**
 * @author Ayuan
 * @Description: 874. 模拟行走机器人
 * @date 2023/7/19 11:02
 */
public class RobotSim {

    class Solution {
        public int robotSim(int[] commands, int[][] obstacles) {
            //设置移动的方向(北、东、南、西)顺时方向循环
            int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            //初始位置
            int x = 0, y = 0, direction = 0;
            //最大欧式距离
            int maxDistance = 0;
            //存储障碍物
            HashSet<String> obstacleSet = new HashSet<>();
            for (int[] obs : obstacles) {
                obstacleSet.add(obs[0] + "," + obs[1]);
            }
            //执行命令
            for (int command : commands) {
                if (command == -2) {//左转命令
                    direction = (direction + 3) % 4;
                } else if (command == -1) {//右转命令
                    direction = (direction + 1) % 4;
                } else {//移动命令
                    //当前方向
                    int[] currDir = directions[direction];
                    for (int i = 0; i < command; i++) {
                        int nextX = x + currDir[0];
                        int nextY = y + currDir[1];
                        //碰到障碍物
                        if (obstacleSet.contains(nextX + "," + nextY)) {
                            break;
                        }
                        //移动
                        x = nextX;
                        y = nextY;
                        maxDistance = Math.max(maxDistance, x * x + y * y);
                    }
                }
            }
            return maxDistance;
        }
    }
}
