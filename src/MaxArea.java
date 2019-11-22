/**
 * @Auther: heyong
 * @Date: 2019-11-22 13:10
 * @Description:
 */

//给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//
//说明：你不能倾斜容器，且 n 的值至少为 2。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/container-with-most-water
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class MaxArea {

    // 暴力法；双重for循环 直接算出所有的组合面积 取最大值
    public static int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            int leftHeight = height[i];
            for (int j = i + 1; j < height.length; j++) {
                int rightHeight = height[j];
                int currHeight = Math.min(leftHeight, rightHeight);
                int area = currHeight * (j - i);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    // 双指针法 从两端往中间扫描 扫描的过程中长度不断减小
    // 因为空间的上限在短柱子那边 所以在位移的时候放弃掉短的那个柱子 即放弃值相对小的那一端
    public static int maxArea1(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < height.length && right > 0 && right > left) {
            int leftHeight = height[left];
            int rightHeight = height[right];
            maxArea = Math.max(maxArea, (right - left) * Math.min(leftHeight, rightHeight));
            if (leftHeight < rightHeight) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }


    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int area = maxArea(height);
        System.out.println(area);
        int area1 = maxArea1(height);
        System.out.println(area1);
    }

}
