
//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
//示例 1：
//
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
//示例 2：
//
//输入：height = [4,2,0,3,2,5]
//输出：9
//
//提示：
//
//n == height.length
//1 <= n <= 2 * 104
//0 <= height[i] <= 105
//
//来源：力扣（LeetCode）
//链接：https://leetcode.cn/problems/trapping-rain-water
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


public class Trap {

    // 按行取
    public int trap(int[] height) {
        // 获取最高层
        int max = getMax(height);

        int sum = 0;
        for (int i = 1; i <= max; i++) {
            // hasLeft表示左边已经有了围墙
            boolean hasLeft = false;
            // 表示从左边的围墙算起 出现了多少个连续的空格
            int partSum = 0;
            // 遍历每一行
            for (int k : height) {
                // 当前index的数组小于i 代表出现了空格
                if (hasLeft && k < i) {
                    partSum++;
                }
                // 出现了新的围墙，是前一段的右围墙 同时也是后一段的左围墙
                if (k >= i) {
                    sum += partSum;
                    partSum = 0;
                    hasLeft = true;
                }
            }
        }
        return sum;
    }

    private int getMax(int[] height) {
        int max = 0;
        for (int j : height) {
            if (j > max) {
                max = j;
            }
        }
        return max;
    }

    // 按列取
    private int solution2(int[] height) {

        int sum = 0;
        // 按列取 第一列和最后一列不需要遍历 只能是围墙
        for (int i = 1; i < height.length - 1; i++) {
            // 左边最高的墙
            int leftMax = 0;
            // 右边最高的墙
            int rightMax = 0;

            // 遍历寻找左边最高的墙
            for (int j = 0; j < i; j++) {
                if (height[j] > leftMax) {
                    leftMax = height[j];
                }
            }
            // 遍历寻找右边最高的墙
            for (int j = height.length - 1; j > i; j--) {
                if (height[j] > rightMax) {
                    rightMax = height[j];
                }
            }

            // 木桶效应 能装多少水取决于矮的那块木板
            int min = Math.min(leftMax, rightMax);

            // 当前列小于左右两侧矮的那块木板 则当前列可装水
            if (height[i] < min) {
                // 矮木板-当前的值=能装的水
                sum += min - height[i];
            }
        }
        return sum;
    }

    public int solution3(int[] height) {
        int sum = 0;
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        for (int i = 1; i < height.length - 1; i++) {
            left[i] = Math.max(left[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i > 0; i--) {
            right[i] = Math.max(right[i + 1], height[i + 1]);
        }
        // 按列取 第一列和最后一列不需要遍历 只能是围墙
        for (int i = 1; i < height.length - 1; i++) {
            // 木桶效应 能装多少水取决于矮的那块木板
            int min = Math.min(left[i], right[i]);

            // 当前列小于左右两侧矮的那块木板 则当前列可装水
            if (height[i] < min) {
                // 矮木板-当前的值=能装的水
                sum += min - height[i];
            }
        }

        return sum;
    }

    public int solution4(int[] height) {

        int sum = 0;
        int leftMax = 0;
        int rightMax = 0;

        // 左指针
        int left = 1;
        // 右指针
        int right = height.length - 2;

        while (left <= right) {
            // 左边的木板矮 说明left右边肯定有比left高的模板
            if (height[left - 1] < height[right + 1]) {
                // 更新left左边的最高木板
                leftMax = Math.max(leftMax, height[left - 1]);

                // 如果left比左边的木板小 则left能装水
                if (leftMax > height[left]) {
                    sum += +(leftMax - height[left]);
                }
                //left 往后移动
                left++;
                continue;
            }
            // 右边的木板矮 说明right左边肯定有比right高的模板
            // 更新右边最高木板
            rightMax = Math.max(rightMax, height[right + 1]);
            // 如果right比右边的木板小 则right能装水
            if (rightMax > height[right]) {
                sum += (rightMax - height[right]);
            }
            // right 往前移
            right--;
        }
        return sum;
    }


    public static void main(String[] args) {
        Trap instance = new Trap();

        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] height1 = new int[]{4, 2, 0, 3, 2, 5};

        int result = instance.trap(height);
        System.out.println(result);
        int result1 = instance.trap(height1);
        System.out.println(result1);

        System.out.println(instance.solution2(height));
        System.out.println(instance.solution2(height1));

        System.out.println(instance.solution3(height));
        System.out.println(instance.solution3(height1));

        System.out.println(instance.solution4(height));
        System.out.println(instance.solution4(height1));

    }

}
