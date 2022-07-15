package leetcode.editor.cn;


/**
 * @author Ayuan
 * @Description: 558. 四叉树交集
 * @date 2022/7/15 09:59
 */
public class Intersect {

    /**
     * 如果两个节点有任何一个是叶子节点，且该叶子节点值为true,返回这个叶子节点
     * 如果两个节点有一个是叶子节点，且该叶子节点值为false，则返回另外一个节点
     * 如果两个节点都不是叶子节点则继续递归
     * 注意：得到返回值以后，可能会出现4个子节点都是true的情况，这时候要合并四个子节点
     */
    public static void main(String[] args) {
        Intersect.Solution solution = new Intersect().new Solution();


    }

    class Solution {
        /**
         * 1.x = true -> return x;
         * 2.x = false -> return y;
         */
        public Node intersect(Node quadTree1, Node quadTree2) {
            if (quadTree1.isLeaf) {
                if (quadTree1.val) {
                    return quadTree1;
                } else {
                    return quadTree2;
                }
            }
            if (quadTree2.isLeaf) {
                if (quadTree2.val) {
                    return quadTree2;
                } else {
                    return quadTree1;
                }
            }
            Node topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
            Node topRight = intersect(quadTree1.topRight, quadTree2.topRight);
            Node bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
            Node bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
            if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf
                    && topLeft.val && topRight.val && bottomLeft.val && bottomRight.val) {
                return new Node(true, true, null, null, null, null);
            }
            return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
        }
    }


    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
        }

        public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    }

    ;
}


