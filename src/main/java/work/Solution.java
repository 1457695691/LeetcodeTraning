package leetcode.editor.cn;


import java.util.*;
import java.util.stream.Collectors;

/**
 * leetcode--解题用
 *
 * @author Ayuan
 */
public class Solution {

    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    Deque<Integer> stack = new ArrayDeque<Integer>();

    /**
     * 忘了那道了
     */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        stack.offerLast(0);
        dfs(graph, 0, graph.length - 1);
        return ans;
    }

    public void dfs(int[][] graph, int x, int n) {
        if (x == n) {
            ans.add(new ArrayList<>(stack));
        }
        for (int y : graph[x]) {
            stack.offerLast(y);
            dfs(graph, y, n);
            stack.pollLast();
        }

    }

    /**
     * 14.最长公共前缀
     */
    private static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < ans.length() && j < strs[i].length(); j++) {
                if (ans.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            ans = ans.substring(0, j);
            if ("".equals(ans)) {
                return ans;
            }
        }
        return ans;
    }

    /**
     * 387.字符串中第一个唯一不重复字符
     */
    public static int firstUniqChar(String s) {
        //排除两种特殊情况
        if (0 == s.length()) {
            return -1;
        }
        if (1 == s.length()) {
            return 0;
        }
        //取第一个字符 往后遍历
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 217.存在重复元素
     */
    public static boolean containsDuplicate(int[] nums) {
        return Arrays.stream(nums).distinct().count() > nums.length;
    }

    /**
     * 344.反转字符串(经典双指针问题)
     */
    public static void reverseString(char[] s) {
        if (0 == s.length) {
            return;
        }
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    /**
     * 283.移动0（参考快速排序）
     */
    public static void moveZeroes(int[] nums) {
        if (0 == nums.length) {
            return;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (0 != nums[i]) {
                nums[index++] = nums[i];
            }
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }

    /**
     * 26.删除有序数组的重复项
     */
    public static int removeDuplicates(int[] nums) {
        return 0;
    }

    /**
     * 1002.查找常用字符串(字符表hash法)
     */
    public static List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<>();
        if (A.length == 0) {
            return result;
        }
        int[] hash = new int[26]; // 用来统计所有字符串里字符出现的最小频率
        for (int i = 0; i < A[0].length(); i++) { // 用第一个字符串给hash初始化
            hash[A[0].charAt(i) - 'a']++;
        }
        // 统计除第一个字符串外字符的出现频率
        for (int i = 1; i < A.length; i++) {
            int[] hashOtherStr = new int[26];
            for (int j = 0; j < A[i].length(); j++) {
                hashOtherStr[A[i].charAt(j) - 'a']++;
            }
            // 更新hash，保证hash里统计26个字符在所有字符串里出现的最小次数
            for (int k = 0; k < 26; k++) {
                hash[k] = Math.min(hash[k], hashOtherStr[k]);
            }
        }
        // 将hash统计的字符次数，转成输出形式
        for (int i = 0; i < 26; i++) {
            while (hash[i] != 0) { // 注意这里是while，多个重复的字符
                char c = (char) (i + 'a');
                result.add(String.valueOf(c));
                hash[i]--;
            }
        }
        return result;
    }

    /**
     * 53.最大子序和
     */
    public static int maxSubArray(int[] nums) {
        if (0 == nums.length) {
            return 0;
        }
        if (1 == nums.length) {
            return nums[0];
        }
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }
        int res = dp[0];
        for (int i = 1; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * 152.乘积最大子数组
     */
    public static int maxProduct(int[] nums) {
        if (0 == nums.length) {
            return 0;
        }
        if (1 == nums.length) {
            return nums[0];
        }
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] * nums[i], nums[i]);
        }
        int res = dp[0];
        for (int i = 1; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * 434.字符串中的单词数
     */
    public static int countSegments(String s) {
        return (int) Arrays.stream(s.split(" ")).filter(s1 -> !"".equals(s1)).count();
    }

    /**
     * 561.数组拆分I
     */
    public static int arrayPairSum(int[] nums) {

// 这个解决方案也太牛逼了！无需排序，O(n)
// 首先范围在-10000---10000
// 那么可以用数组统计每个数字出现的次数
// 就自动排序了（只不过没出现的次数为0）
// 然后，从小到大，如果是偶数，就除以2；
// 如果是奇数，就从相邻的后一个借走一个
        int[] count = new int[20001];
        for (int x : nums) {
            count[x + 10000]++;
        }
        // borrow是向上借一个
        int ret = 0, borrow = 0;
        for (int i = -10000; i <= 10000; i++) {
            // count[i]是总共出现了多少个， -borrow是i-1有没有借走一个
            // +1是为了保证，count[i] - borrow是奇数的情况下，多算一个
            ret += (count[i + 10000] - borrow + 1) / 2 * i;

            // 更新borrow，如果count[i] - borrow是奇数，就得从i+1借一个
            // +2是java语言防止-1 % 2 == -1
            borrow = (count[i + 10000] - borrow + 2) % 2;
        }
        return ret;
    }

    /**
     * 167.两数之和2
     */
    public static int[] twoSum(int[] numbers, int target) {
        int[] res = {-1, -1};
        if (1 == numbers.length && target == numbers[0]) {
            res[0] = 0;
            res[1] = 0;
            return res;
        }
        //左指针
        int left = 0;
        //右指针
        int right = numbers.length - 1;
        //遍历字符串
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                res[0] = left + 1;
                res[1] = right + 1;
                return res;
            }
        }
        return res;
    }

    /**
     * 27.移除元素（快慢指针）
     */
    public static int removeElement(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        for (; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    /**
     * 485.最大连续1的个数
     */
    public static int findMaxConsecutiveOnes(int[] nums) {
        int fast = 0, slow = 0;
        int maxlen = 0, tmp = -1;
        for (; fast < nums.length; fast++) {
            if (nums[fast] == 1) {
                tmp = fast;
            } else {
                if (-1 != tmp) {
                    maxlen = Math.max(maxlen, tmp - slow + 1);
                    tmp = -1;
                }
                slow = fast + 1;
            }
        }
        if (tmp != -1) {
            return Math.max(maxlen, tmp - slow + 1);
        }
        return maxlen;
    }

    /**
     * 141.环形连表
     */
    public static boolean hasCycle(ListNode head) {
        Set set = new HashSet<>();
        ListNode node = head;
        while (null != node) {
            if (set.contains(node)) {
                return true;
            }
            set.add(node);
            node = node.next;
        }
        return false;
    }

    /**
     * 160.相交链表
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //两个指针分别从两个链表的开始遍历到结尾，然后再分别从另一个链表开始遍历，当两个指针相等时，便是相交节点
        if (headA == null || headB == null) {
            return null;
        }
        ListNode tempA = headA, tempB = headB;
        while (tempA != tempB) {
            tempA = tempA == null ? headB : tempA.next;
            tempB = tempB == null ? headA : tempB.next;
        }
        return tempA;
    }

    /**
     * 19.删除链表的倒数第N个节点
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev = new ListNode(0);
        prev.next = head;
        ListNode start = prev, end = prev;
        while (0 != n) {
            start = start.next;
            n--;
        }
        while (null != start.next) {
            start = start.next;
            end = end.next;
        }
        end.next = end.next.next;
        return prev.next;
    }

    /**
     * 链表双指针模板
     */
    private boolean demo(ListNode head) {
        // Initialize slow & fast pointers
        ListNode slow = head;
        ListNode fast = head;

        /**
         * Change this condition to fit specific problem.
         * Attention: remember to avoid null-pointer error
         **/
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;           // move slow pointer one step each time
            fast = fast.next.next;      // move fast pointer two steps each time
            if (slow == fast) {         // change this condition to fit specific problem
                return true;
            }
        }
        return false;   // change return value to fit specific problem
    }

    /**
     * 203.移除链表元素
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    /**
     * 328.奇偶链表
     */
    public ListNode oddEvenList(ListNode head) {
        if (null == head) {
            return null;
        }
        //偶数链表头节点是head的下一个
        ListNode evenHead = head.next;
        //fast指针指向奇数，slow指针指向偶数
        ListNode fast = head, slow = evenHead;

        while (null != slow || null != slow.next) {
            //奇数节点下一个节点是偶数节点的下一个
            fast.next = slow.next;
            //奇数节点往后移动一个
            fast = fast.next;
            //偶数节点下一个节点是奇数节点的下一个
            slow.next = fast.next;
            //偶数节点往后移动一位
            slow = slow.next;
        }
        //两个链表链接在一起
        fast.next = slow;
        return head;
    }

    /**
     * 93.复原Ip地址
     */
    public List<String> restoreIpAddresses(String s) {
        return new ArrayList<>();
    }

    /**
     * 611.有效三角形的个数
     */
    public int triangleNumber(int[] nums) {
        return nums.length;
    }

    /**
     * 551.学生出勤记录（api投机取巧）
     */
    public boolean checkRecord(String s) {
        return s.indexOf("A") == s.lastIndexOf("A") && !s.contains("LLL");
    }

    /**
     * 347. 前 K 个高频元素（函数式一行）
     */
    public int[] topKFrequent(int[] nums, int k) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toMap(num -> num, num -> 1, Integer::sum))
                .entrySet()
                .stream()
                .filter(integerIntegerEntry -> integerIntegerEntry.getValue() >= Arrays.stream(nums)
                        .boxed()
                        .collect(Collectors.toMap(num -> num, num -> 1, Integer::sum))
                        .values()
                        .stream()
                        .sorted(Comparator.reverseOrder())
                        .limit(k)
                        .min(Integer::compareTo)
                        .orElse(-1)
                )
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }

    /**
     * 215. 数组中的第K个最大元素（暴力枚举）
     */
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);
        return nums[len - k];
    }

    /**
     * 347.常规解法（优先队列->小顶堆构造）
     */
    public int[] topKFrequent2(int[] nums, int k) {
        int[] result = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>(16);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        //根据map的value值正排序 ，相当于构建一个小顶堆
        PriorityQueue<Map.Entry<Integer, Integer>> queue =
                new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> entry : entries) {
            queue.offer(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        for (int i = k - 1; i >= 0; i--) {
            result[i] = queue.poll().getKey();
        }
        return result;
    }

    /**
     * 162.寻找峰值（二分查找）
     */
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 34.在排序数组中查找元素的第一个和最后一个位置
     */
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int left = 0;
        int right = nums.length - 1;
        for (; left <= right; left++) {
            if (nums[left] == target) {
                result[0] = left;
                break;
            }
        }
        for (; right >= left; right--) {
            if (nums[right] == target) {
                result[1] = right;
                break;
            }
        }
        return result;
    }

    /**
     * 56.合并区间
     */
    public int[][] merge(int[][] intervals) {
        // 先按照区间起始位置排序
        Arrays.sort(intervals, Comparator.comparingInt(v -> v[0]));
        // 遍历区间
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval : intervals) {
            // 如果结果数组是空的，或者当前区间的起始位置 > 结果数组中最后区间的终止位置，
            // 则不合并，直接将当前区间加入结果数组。
            if (idx == -1 || interval[0] > res[idx][1]) {
                res[++idx] = interval;
            } else {
                // 反之将当前区间合并至结果数组的最后区间
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, idx + 1);
    }

    /**
     * 57.插入区间
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // 遍历区间
        int i = 0, index = 0;
        while (i < intervals.length && newInterval[0] > intervals[i][1]) {
            ++i;
        }
        //新区间左边且相离的区间加入结果集
        LinkedList<int[]> Intervals = new LinkedList<>(Arrays.asList(intervals));
        //遍历时，如果当前区间的结束位置 < 新区间的开始位置，说明当前区间在新区间的左边且相离
        while (i < Intervals.size() && Intervals.get(i)[0] <= newInterval[1]) {
            newInterval[0] = Math.min(Intervals.get(i)[0], newInterval[0]);
            newInterval[1] = Math.max(Intervals.get(i)[1], newInterval[1]);
            Intervals.remove(i);
        }
        //当前区间是否与新区间重叠，重叠的话就进行合并
        // 直到遍历到当前区间在新区间的右边且相离，将最终合并后的新区间加入结果集
        //新区间右边且相离的区间加入结果集
        Intervals.add(i, newInterval);
        int[][] ans = new int[Intervals.size()][2];
        for (int[] e : Intervals) {
            ans[index++] = e;
        }
        return ans;
    }

    /**
     * 1656.获取生成数组中的最大值
     */
    public int getMaximumGenerated(int n) {

        if (0 == n) {
            return n;
        }
        //模拟数组
        int[] nums = new int[n + 1];
        //构造特殊值
        nums[0] = 0;
        nums[1] = 1;
        for (int i = 0; i <= n; i++) {
            //偶数
            if (0 == i % 2) {
                nums[i] = nums[i / 2];
            }
            //奇数
            else {
                nums[i] = nums[(i - 1) / 2] + nums[(i + 1) / 2];
            }
        }
        return Arrays.stream(nums).max().getAsInt();
    }

    /**
     * 165.比较版本号
     */
    public int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");

        int i = 0, j = 0;
        while (i < split1.length || j < split2.length) {
            int a = 0, b = 0;
            if (i < split1.length) {
                a = Integer.parseInt(split1[i]);
                i++;
            }
            if (j < split2.length) {
                b = Integer.parseInt(split2[j]);
                j++;
            }
            if (a != b) {
                return a > b ? 1 : -1;
            }
        }
        return 0;
    }

//Day1： 二分查找

    /**
     * 704.二分查找
     */
    public int search(int[] nums, int target) {
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = left + ((right - left) >> 1);
            if (target == nums[middle]) {
                return middle;
            } else if (target > nums[middle]) {
                left = middle + 1;
            } else if (target < nums[middle]) {
                right = middle - 1;
            }
        }
        return -1;
    }

    /**
     * 278.第一个错误的版本
     */
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int middle = left + ((right - left) >> 1);
            if (isBadVersion(middle)) {
                right = middle;
            } else {
                left = middle + 1;
            }

        }
        return left;
    }

    private boolean isBadVersion(int middle) {
        return false;
    }

    /**
     * 35.搜索插入位置
     */
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        // 特殊判断
        if (nums[len - 1] < target) {
            return len;
        }

        // 程序走到这里一定有 nums[len - 1] >= target
        int left = 0;
        int right = len - 1;
        // 在区间 nums[left..right] 里查找第 1 个大于等于 target 的元素的下标
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                // 下一轮搜索的区间是 [mid + 1..right]
                left = mid + 1;
            } else {
                // 下一轮搜索的区间是 [left..mid]
                right = mid;
            }
        }
        return left;
    }

//Day2：双指针

    /**
     * 977. 有序数组的平方
     */
    public int[] sortedSquares(int[] nums) {
        int right = nums.length - 1;
        int left = 0;
        int[] result = new int[nums.length];
        int index = result.length - 1;
        //循环开始
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                result[index--] = nums[left] * nums[left];
                ++left;
            } else {
                result[index--] = nums[right] * nums[right];
                --right;
            }
        }
        return result;
    }

    /**
     * 189. 旋转数组
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        //1.整体反转
        reverse(nums, 0, n - 1);
        //2.分割前后
        reverse(nums, 0, k - 1);
        //3.反转后面的数组
        reverse(nums, k, n - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


//Day3：双指针 283 & 167


//Day4：双指针 344 & 557

    /**
     * 881.救生艇
     */
    public int numRescueBoats(int[] people, int limit) {
        int ans = 0;
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        while (left <= right) {
            if (left + right > limit) {
                right--;
                ans++;
            }
            right--;
            left++;
        }
        return ans;
    }

    /**
     * 557.反转字符串中的单词2
     */
    public String reverseWords(String s) {
        String[] string = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String value : string) {
            sb.append(new StringBuilder(value).reverse().toString());
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    /**
     * 69.x的平方根
     */
    public int mySqrt(int x) {
        //去掉特殊情况
        switch (x) {
            case 0:
                return 0;
            case 1:
            case 2:
            case 3:
                return 1;
            default:
                break;
        }
        //双指针查找
        int left = 0;
        int right = x / 2;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (x / mid < mid) {
                right = mid - 1;
            } else if (x / mid > mid && x / (mid + 1) >= (mid + 1)) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


//Day5. 双指针

    /**
     * 876. 链表的中间结点
     * 快指针走两步，满指针走一步，刚好到中间
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 4.寻找两个正序数组中的中位数
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //数据合并
        List<Integer> collect = Arrays.stream(nums1)
                .boxed()
                .collect(Collectors.toList());
        collect.addAll(Arrays.stream(nums2).boxed().collect(Collectors.toList()));

        //梯形的小顶堆
        PriorityQueue<Integer> large = new PriorityQueue<>();
        //倒三角形的大顶堆
        PriorityQueue<Integer> small = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
        //构造大小顶堆
        collect.forEach(it -> {
            if (small.size() >= large.size()) {
                small.offer(it);
                large.offer(small.poll());
            } else {
                large.offer(it);
                small.offer(large.poll());
            }
        });

        if (large.size() > small.size()) {
            return large.peek();
        } else if (small.size() > large.size()) {
            return small.peek();
        }
        return ((large.peek() + small.peek()) / 2.0);

    }

//Day6.滑动窗口

    /**
     * 567.字符串的排列
     */
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        if (len1 > len2) {
            return false;
        }

        HashMap<Character, Integer> mapS1 = new HashMap<>();
        HashMap<Character, Integer> mapS2 = new HashMap<>();

        for (char ch : s1.toCharArray()) {
            mapS1.put(ch, mapS1.getOrDefault(ch, 0) + 1);
        }

        int index = 0;

        for (int i = 0; i < len1; i++, index++) {
            char ch = s2.charAt(i);
            mapS2.put(ch, mapS2.getOrDefault(ch, 0) + 1);
        }

        while (index < s2.length()) {
            if (mapS2.equals(mapS1)) {
                return true;
            }

            char before = s2.charAt(index - len1);
            char after = s2.charAt(index);

            mapS2.put(before, mapS2.get(before) - 1);
            if (mapS2.get(before) == 0) {
                mapS2.remove(before);
            }

            mapS2.put(after, mapS2.getOrDefault(after, 0) + 1);

            index++;
        }

        return mapS2.equals(mapS1);
    }

//Day7.广度优先搜索 / 深度优先搜索

    //733. 图像渲染
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originalColor = image[sr][sc];
        //颜色相同不处理
        if (originalColor != newColor) {
            dfs733(image, sr, sc, newColor, originalColor);
        }
        return image;
    }

    private void dfs733(int[][] image, int x, int y, int newColor, int originalColor) {
        //判断是否超出边界
        if (x < 0 || x >= image.length || y < 0 || y >= image[0].length) {
            return;
        }
        if (image[x][y] == originalColor) {
            //颜色替换
            image[x][y] = newColor;

            //深度有限搜索四周的像素点
            dfs733(image, x - 1, y, newColor, originalColor);
            dfs733(image, x + 1, y, newColor, originalColor);
            dfs733(image, x, y - 1, newColor, originalColor);
            dfs733(image, x, y + 1, newColor, originalColor);

        }
    }

    //695. 岛屿的最大面积
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        //遍历所有网格
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (1 == grid[x][y]) {
                    // 每次调用的时候默认num为1，进入后判断如果不是岛屿，则直接返回0，就可以避免预防错误的情况。
                    // 每次找到岛屿，则直接把找到的岛屿改成0，这是传说中的沉岛思想，就是遇到岛屿就把他和周围的全部沉默。
                    res = Math.max(res, dfs695(x, y, grid));
                }
            }
        }
        return res;
    }

    private int dfs695(int i, int j, int[][] grid) {
        //越界返回0
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int num = 1;
        num += dfs695(i + 1, j, grid);
        num += dfs695(i - 1, j, grid);
        num += dfs695(i, j + 1, grid);
        num += dfs695(i, j - 1, grid);
        return num;
    }

//Day8.广度优先搜索 / 深度优先搜索

    /**
     * 617.合并二叉树
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (null == root1) {
            return root2;
        }
        if (null == root2) {
            return root1;
        }

        TreeNode merged = new TreeNode(root1.val + root2.val);
        merged.left = mergeTrees(root1.left, root2.left);
        merged.right = mergeTrees(root1.right, root2.right);
        return merged;
    }

    /**
     * 102.二叉树的层序遍历(模板)
     */
    private List<List<Integer>> resList = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        //checkFun01(root,0);
        checkFun02(root);
        return resList;
    }

    //DFS--递归方式
    private void checkFun01(TreeNode node, Integer deep) {
        if (null == node) {
            return;
        }
        deep++;
        if (resList.size() < deep) {
            //当层级增加时，list的Item也增加，利用list的索引值进行层级界定
            List<Integer> item = new ArrayList<Integer>();
            resList.add(item);
        }
        resList.get(deep - 1).add(node.val);

        checkFun01(node.left, deep);
        checkFun01(node.right, deep);
    }

    //BFS--迭代方式
    private void checkFun02(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> level = new ArrayList<>();
            while (n > 0) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                n--;
            }
            resList.add(level);
        }
    }


//Day9.广度优先搜索 / 深度优先搜索

    /**
     * 542. 01 矩阵
     */
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> que = new LinkedList<>();
        //??
        int[] directions = {-1, 0, 1, 0, -1};
        //遍历整个矩阵
        for (int x = 0; x < mat.length; x++) {
            for (int y = 0; y < mat[0].length; y++) {
                if (mat[x][y] == 0) {
                    que.offer(new int[]{x, y});
                } else {
                    //标记非0元素为负数，和遍历后设定的正数距离加以区分
                    mat[x][y] = -1;
                }
            }
        }

        int step = 1;
        //套模板
        while (!que.isEmpty()) {
            //对当前队列中所有非0元素遍历，所有元素向四周走一步
            int size = que.size();
            for (int i = 0; i < size; i++) {
                //获取队列中元素位置
                int[] cur = que.poll();
                for (int j = 0; j < directions.length - 1; j++) {
                    int x = cur[0] + directions[j];
                    int y = cur[1] + directions[j + 1];
                    //边界判断：如果超出矩阵范围，或者遇见零元素及设置过距离step的元素则跳过，只对未遍历到的-1操作
                    if (x < 0 || x >= mat.length || y < 0 || y >= mat[0].length || mat[x][y] >= 0) {
                        continue;
                    }
                    mat[x][y] = step;
                    que.offer(new int[]{x, y});
                }
            }
            //下次遍历到-1的元素比前一次的step加一
            step++;
        }
        return mat;
    }

    /**
     * 994. 腐烂的橘子
     */
    public static int orangesRotting(int[][] grid) {
        int count = 0;
        //dr,dc 配合使用得到 grid[r][c] 上grid[r-1][c]左grid[r][c-1]下grid[r+1][c]右grid[r][c+1]的元素
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        // queue : all starting cells with rotten oranges
        Queue<int[]> que = new LinkedList<>();
        //好果子数量
        int good = 0;
        //遍历整个矩阵
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == 2) {
                    //记录下坏果的坐标
                    que.add(new int[]{x, y});
                }
                if (grid[x][y] == 1) {
                    //记录好果子数量+1
                    good++;
                }
            }
        }
        //如果桌子上没有坏果，则进行对应的判断
        if (que.size() == 0) {
            return good == 0 ? 0 : -1;
        }
        // 每运行一分钟，将上一次坏果的坐标抛出，并且记录新的坐标，直到不能再感染为止
        while (!que.isEmpty()) {
            int size = que.size();
            //取出所有坏果子
            for (int i = 0; i < size; i++) {
                int[] poll = que.poll();
                int x = poll[0];
                int y = poll[1];
                for (int j = 0; j < 4; j++) {
                    int newx = x + dx[j];
                    int newy = y + dy[j];
                    ///边界判断: 以及只能感染好果也就是 grid[newx][newy] == 1 的
                    if (newx >= 0 && newy >= 0 && newx < grid.length && newy < grid[0].length && grid[newx][newy] == 1) {
                        //将水果感染
                        grid[newx][newy] = 2;
                        //好果子数量-1
                        good--;
                        //新的坐标入队列进行下一次感染
                        que.add(new int[]{newx, newy});
                    }
                }
            }
            count++;
        }
        //最后结果进行对比，如果还存在好的水果，则返回-1 否者返回 count-1
        return good == 0 ? count - 1 : -1;
    }

////Day10.递归/回溯

    /**
     * 21.合并两个有序链表(递归)
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;
        } else if (null == l2) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /**
     * 206.反转链表
     */
    public static ListNode reverseList(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

//Tree.

    /**
     * 94.二叉树的中序遍历
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);
        return res;
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if (null == root) {
            return;
        }
        preorder(root.left, res);
        res.add(root.val);
        preorder(root.right, res);
    }

    /**
     * 144.二叉树的前序遍历
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        preorder(root, res);
        return res;
    }

    private void preorder(TreeNode root, List<Integer> res) {
        if (null == root) {
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }

    /**
     * 145.二叉树的后序遍历
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        postorder(root, res);
        return res;
    }

    private void postorder(TreeNode root, List<Integer> res) {
        if (null == root) {
            return;
        }
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }

    /**
     * 104.二叉树的最大深度
     */
    public int maxDepth(TreeNode root) {
        return null != root ? Math.max(maxDepth(root.left), maxDepth(root.right)) + 1 : 0;
    }

    /**
     * 101.对称二叉树
     */
    public boolean isSymmetric(TreeNode root) {
        return null == root || isSame(root, root);
    }

    private boolean isSame(TreeNode left, TreeNode right) {
        ////如果左右子节点都为空，说明当前节点是叶子节点，返回true
        if (null == left && null == right) {
            return true;
        }
        ////如果当前节点只有一个子节点或者有两个子节点，但两个子节点的值不相同，直接返回false
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        //然后左子节点的左子节点和右子节点的右子节点比较，左子节点的右子节点和右子节点的左子节点比较
        return isSame(left.left, right.right) && isSame(left.right, right.left);
    }

    /**
     * 266. 翻转二叉树
     */
    public TreeNode invertTree(TreeNode root) {
        if (null == root) {
            return null;
        }
        //在前序遍历的位置交换左右子节点
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        //递归对左右子树进行反转
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    /**
     * 112.路径总和
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //如果根节点为空，或者叶子节点也遍历完了也没找到这样的结果，就返回false
        if (null == root) {
            return false;
        }
        //如果到叶子节点了，并且剩余值等于叶子节点的值，说明找到了这样的结果，直接返回true
        if (null == root.left && null == root.right && (0 == targetSum - root.val)) {
            return true;
        }
        //分别沿着左右子节点走下去，然后顺便把当前节点的值减掉，左右子节点只要有一个返回true，说明存在这样的结果
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    /**
     * 106.从中序与后序遍历序列构造二叉树
     */
    public TreeNode buildTree106(int[] inorder, int[] postorder) {
        return build106(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    private TreeNode build106(int[] inorder, int inLeft, int inRight, int[] postorder, int postLeft, int postRight) {
        // 没有元素了
        if (inRight - inLeft < 1) {
            return null;
        }
        // 只有一个元素了
        if (inRight - inLeft == 1) {
            return new TreeNode(inorder[inLeft]);
        }
        // 后序数组postorder里最后一个即为根结点
        int rootVal = postorder[postRight - 1];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = 0;
        // 根据根结点的值找到该值在中序数组inorder里的位置
        for (int i = inLeft; i < inRight; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        // 根据rootIndex划分左右子树
        root.left = build106(inorder, inLeft, rootIndex,
                postorder, postLeft, postLeft + (rootIndex - inLeft));
        root.right = build106(inorder, rootIndex + 1, inRight,
                postorder, postLeft + (rootIndex - inLeft), postRight - 1);
        return root;
    }

    /**
     * 105.从前序与中序遍历序列构造二叉树
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int preLeft, int preRight,
                           int[] inorder, int inLeft, int inRight) {
        // 递归终止条件
        if (inLeft > inRight || preLeft > preRight) return null;

        // val 为前序遍历第一个的值，也即是根节点的值
        // idx 为根据根节点的值来找中序遍历的下标
        int idx = inLeft, val = preorder[preLeft];
        TreeNode root = new TreeNode(val);
        for (int i = inLeft; i <= inRight; i++) {
            if (inorder[i] == val) {
                idx = i;
                break;
            }
        }

        // 根据 idx 来递归找左右子树
        root.left = helper(preorder, preLeft + 1, preLeft + (idx - inLeft),
                inorder, inLeft, idx - 1);
        root.right = helper(preorder, preLeft + (idx - inLeft) + 1, preRight,
                inorder, idx + 1, inRight);
        return root;
    }

    /**
     * 116. 填充每个节点的下一个右侧节点指针
     */
    private Node[] nodes = new Node[13];

    public Node connect(Node root) {
        if (null != root) {
            dfs116(root, 0);
        }
        return root;
    }

    private void dfs116(Node root, int depth) {
        if (null != root) {
            if (null != nodes[depth]) {
                nodes[depth].next = root;
            }
        }
        nodes[depth] = root;
        dfs116(root.left, depth + 1);
        dfs116(root.right, depth + 1);
    }

    /**
     * 117.填充每个节点的下一个右侧节点指针 II
     */
    public Node connect2(Node root) {
        if (null == root) {
            return null;
        }
        Node cur = root;
        Node dummy = new Node(0);
        while (null != cur) {
            //遍历当前层的时候，为了方便操作在下一层前面添加一个哑结点（注意这里是访问当前层的节点，然后把下一层的节点串起来)
            dummy.next = null;
            //访问下一个层节点的前一个节点
            Node pre = dummy;
            while (cur != null) {
                if (cur.left != null) {
                    pre.next = cur.left;
                    pre = pre.next;
                }
                if (cur.right != null) {
                    pre.next = cur.right;
                    pre = pre.next;
                }
                //继续访问当前层的下一个节点
                cur = cur.next;
            }
            //把下一层串联成一个链表之后，让他赋值给cur，后续继续循环，直到cur为空为止
            cur = dummy.next;
        }
        return root;
    }

    /**
     * 235,236.二叉树的最近公共祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //空的找个屁！ 肯定有的话,只能是根！
        if (null == root || root == p || root == q) {
            return root;
        }
        //上面都没有，只可能在左右两边
        //根节点往下一层挪，知道根两个中一个相等为止
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //如果同在右边，那肯定right不空，左边空
        if (null == left) {
            return right;
        }
        //如果同在左边，那肯定left不空，右边空
        if (null == right) {
            return left;
        }
        //两边都不空，肯定是根
        return root;
    }

    /**
     * 111.二叉树的最小深度
     */
    public int minDepth(TreeNode root) {
        //根为空，则最小深度为0
        if (root == null) return 0;
        //左右子树为空，最大深度为1
        if (root.left == null && root.right == null) return 1;
        //左子树不为空 递归+1
        if (root.left != null && root.right == null) return minDepth(root.left) + 1;
        if (root.right != null && root.left == null) return minDepth(root.right) + 1;
        //求最小深度
        return Math.min(minDepth(root.right), minDepth(root.left)) + 1;
    }

    /**
     * 68.文本左右对其
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        // 每次取出来满足maxWidth的数量最多的单词
        int count = 0, start = 0;
        for (int i = 0; i < words.length; i++) {
            count += words[i].length();
            if (count > maxWidth) {
                res.add(helper(words, start, i - 1, maxWidth));
                start = i;
                count = words[i].length();
            }
            count++;
        }
        // 处理最后一节骨单词
        res.add(helper(words, start, words.length - 1, maxWidth));
        return res;
    }

    private String helper(String[] words, int start, int end, int maxWidth) {
        StringBuilder stringBuilder = new StringBuilder();
        // 一行一词
        if (start == end) {
            oneWordOneRow(words, start, maxWidth, stringBuilder);
        }
        // 最后一行
        else if (end == words.length - 1) {
            lastRow(words, start, end, maxWidth, stringBuilder);
        }
        // 一行多词
        else {
            normal(words, start, end, maxWidth, stringBuilder);
        }
        return stringBuilder.toString();
    }

    private void oneWordOneRow(String[] words, int start, int maxWidth, StringBuilder sb) {
        // 一行只有一个单词的情况：右边添加多余的空格
        sb.append(words[start]);
        int num = maxWidth - words[start].length();
        for (int i = 0; i < num; i++) {
            sb.append(" ");
        }
    }

    private void lastRow(String[] words, int start, int end, int maxWidth, StringBuilder sb) {
        // 最后一行：单词之间不用添加额外的空格，多余的空格全部在右边
        for (int i = start; i <= end; i++) {
            sb.append(words[i]);
            if (i != end) {
                // 单词之间只有一个空格
                sb.append(" ");
            } else {
                // 判断要加几个空格
                int num = maxWidth - sb.length();
                for (int j = 0; j < num; j++) {
                    sb.append(" ");
                }
            }
        }
    }

    private void normal(String[] words, int start, int end, int maxWidth, StringBuilder sb) {
        // 正常情况：单词间的空格尽量均匀分配，可能左边的空格会多一
        // 先计算出单词总长度
        int wordsLength = 0;
        for (int i = start; i <= end; i++) {
            wordsLength += words[i].length();
        }
        // 再看均匀分配能分配几个
        int seperate = (maxWidth - wordsLength) / (end - start);
        // 多余出来的空格，即不能平均的部分，这部分要按照从左到右依次分配
        // 比如，有4个单词，即3个间隔，一共有5个空格的话
        // 平均的话是每个间隔一个空格，还多了2个空格，从左到右分配
        // 最后的间隔就是前两个各占2个空格，最后一个占1个空格
        int remain = (maxWidth - wordsLength) % (end - start);

        for (int i = start; i <= end; i++) {
            sb.append(words[i]);
            if (i != end) {
                // 先加上平均分配的空格
                for (int j = 0; j < seperate; j++) {
                    sb.append(" ");
                }
                // 再看还有没有多余的空格
                if (remain-- > 0) {
                    sb.append(" ");
                }
            }
        }
    }

    /**
     * 70.爬楼梯
     */
    public int climbStairs(int n) {
        if (n < 2) return n;
        int a = 1;
        int b = 2;
        int sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    /**
     * 746. 使用最小花费爬楼梯
     */
    public int minCostClimbingStairs(int[] cost) {
        if (null == cost || 0 == cost.length) {
            return 0;
        }
        if (1 == cost.length) {
            return cost[0];
        }
        //dp[i]定义：上到第i个台阶时，花费最小体力为dp[i]--> 到达第i个台阶所花费的最少体力为do[i]
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        ////最后一步，如果是由倒数第二步爬，则最后一步的体力花费可以不用算
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }

    /**
     * 62. 不同路径
     * 1. 确定dp数组下表含义 dp[i][j] 到每一个坐标可能的路径种类
     * 2. 递推公式 dp[i][j] = dp[i-1][j] dp[i][j-1]
     * 3. 初始化 dp[i][0]=1 dp[0][i]=1 初始化横竖就可
     * 4. 遍历顺序 一行一行遍历
     * 5. 推导结果 。。。。。。。。
     */
    public int unwiquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 63. 不同路径 II
     */
//    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//
//    }

    /**
     * 212.单词搜索2
     */
//    public List<String> findWords(char[][] board, String[] words) {
//
//    }

    /**
     * 725.分割链表
     */
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        int index = 0;

        ListNode tmp = head;

        //链表长度
        int n = 0;
        while (null != tmp) {
            n++;
            tmp = tmp.next;
        }

        //平均长度
        int size = n / k;
        //余数
        int remain = n % k;

        tmp = head;
        while (null != tmp) {
            ans[index++] = tmp;
            ListNode prev = tmp;

            for (int i = 0; i < size; i++) {
                prev = tmp;
                tmp = tmp.next;
            }

            if (remain > 0) {
                prev = tmp;
                tmp = tmp.next;
                remain--;
            }
            prev.next = null;
        }
        return ans;
    }

    /**
     * 187.重复的DNA序列
     */
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        int n = s.length();

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i + 10 <= n; i++) {
            String cur = s.substring(i, i + 10);
            int cnt = map.getOrDefault(cur, 0);
            if (1 == cnt) {
                ans.add(cur);
            }
            map.put(cur, cnt + 1);
        }
        return ans;
    }

    /**
     * 23.合并k个升序链表
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (null == lists || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val) return -1;
                else if (o1.val == o2.val) return 0;
                else return -1;
            }
        });
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        for (ListNode node : lists) {
            if (null != node) {
                queue.add(node);
            }
        }

        while (!queue.isEmpty()) {
            p.next = queue.poll();
            p = p.next;
            if (null != p.next) {
                queue.add(p.next);
            }
        }
        return dummy.next;
    }

    /**
     * 240.搜索二维矩阵2 （Z字查找）
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = n - 1;

        while (x < m && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            }
            if (matrix[x][y] > target) {
                --y;
            } else {
                ++x;
            }
        }
        return false;
    }

    /**
     * 1816.截断句子
     * @param s
     * @param k
     * @return
     */
    public String truncateSentence(String s, int k) {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(s.split(" ")).limit(k).forEach(it -> sb.append(it).append(" "));
        return sb.substring(0, sb.length() - 1);
    }


    public static void main(String[] args) {
        //-------------14.
//        String[] strs ={"flow","flige","florsd"};
//        String s = longestCommonPrefix(strs);
//        System.out.println(s);
        //-------------387.
//        String s = "leetcode";
//        int i = firstUniqChar(s);
//        System.out.println(i);
        //-------------217
//        int[] nums = {1,2,3,4};
//        boolean b = containsDuplicate(nums);
//        System.out.println(b);
        //-------------344
//        char[] str = {'a', 'b', 'c', 'd'};
//        reverseString(str);
//        System.out.println(str);
        //-------------283
//        int[] nums = {0, 1, 0, 3, 12};
//        moveZeroes(nums);
//        System.out.println(Arrays.toString(nums));
        //--------------26
//        int[] nums = {1, 1, 2};
//        int i = removeDuplicates(nums);
//        System.out.println(i);
        //--------------1002
//        String[] words = {"bella", "label", "roller"};
//        List<String> list = commonChars(words);
//        System.out.println(list.toString());

        //--------------152
//        int[] nums = {-1,2,-3, 4, 5};
//        List<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toList());
//        int i = maxProduct(nums);
//        System.out.println(i);
        //-------------434
//        String s = ", , , ,        a, eaefa";
//        int i = countSegments(s);
//        System.out.println(i);
        //-------------561
//        int[] nums = {1, 4, 3, 2};
//        int i = arrayPairSum(nums);
//        System.out.println(i);
//
//        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
//        int x = orangesRotting(grid);
//        System.out.println(x);

    }
}


/**
 * 二叉树
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * 完美二叉树
 */
//class Node {
//    public int val;
//    public Node left;
//    public Node right;
//    public Node next;
//
//    public Node() {
//    }
//
//    public Node(int _val) {
//        val = _val;
//    }
//
//    public Node(int _val, Node _left, Node _right, Node _next) {
//        val = _val;
//        left = _left;
//        right = _right;
//        next = _next;
//    }
//}

/**
 * 链表
 */
class ListNode {
    private static ListNode listNodeInstance;
    int val;
    ListNode next;

    private ListNode() {
    }

    public ListNode(int i) {
    }

    public static ListNode getInstance() {
        if (listNodeInstance == null) {
            listNodeInstance = new ListNode();
        }
        return listNodeInstance;
    }

    private boolean isBadVersion(int middle) {
        if (middle > 0) {
            return false;
        }
        return true;
    }

}
