/**
 * @author: heyong
 */
//给定一个二维网格和一个单词，找出该单词是否存在于网格中。
//
//单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
//
// 
//
//示例:
//
//board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true
//给定 word = "SEE", 返回 true
//给定 word = "ABCB", 返回 false
// 
//
//提示：
//
//board 和 word 中只包含大写和小写英文字母。
//1 <= board.length <= 200
//1 <= board[i].length <= 200
//1 <= word.length <= 10^3
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/word-search
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class WordSearch {
    public boolean flag;

    public boolean exist(char[][] board, String word) {
        // 边际条件
        if (board.length == 0) {
            return false;
        }
        // 遍历起点
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (helper(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, int i, int j, String word, int currIndex) {
        // 单词已经找到了头 可以退出递归了
        if (currIndex == word.length()) {
            // 停止递归的标志
            flag = true;
            return true;
        }
        char c = word.charAt(currIndex);
        // 停止当前递归的条件
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != c) {
            return false;
        }
        // 标志为false代表还没有找到结果
        if (!flag) {
            // 用过的标记
            board[i][j] = '-';
            boolean result1 = helper(board, i + 1, j, word, currIndex + 1);
            boolean result2 = helper(board, i - 1, j, word, currIndex + 1);
            boolean result3 = helper(board, i, j + 1, word, currIndex + 1);
            boolean result4 = helper(board, i, j - 1, word, currIndex + 1);
            // 复原标记
            board[i][j] = c;
            return result1 || result2 || result3 || result4;
        } else {
            // 标志代表找到结果了 直接返回
            return true;
        }
    }

    public static void main(String[] args) {

        char[][] board = {{'a', 'b'}};
        String word = "ba";
        WordSearch solution = new WordSearch();
        boolean exist = solution.exist(board, word);
        System.out.println(exist);
    }


}
