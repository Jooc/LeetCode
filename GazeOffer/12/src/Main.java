public class Main {
    /**
     * Time = O(3^k MN) —— 最坏情况 M*N 个起点，每个起点需要3^k
     * Space = O(K) —— 开K个系统栈，最坏情况 K = MN
     */
    class Solution {
        public boolean exist(char[][] board, String word) {
            char[] words = word.toCharArray();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (dfs(board, words, i, j, 0)) return true;
                }
            }
            return false;
        }

        boolean dfs(char[][] board, char[] word, int i, int j, int k) {
            if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
            if (k == word.length - 1) return true;
            board[i][j] = '\0';
            boolean res = dfs(board, word, i + 1, j, k + 1) ||
                    dfs(board, word, i - 1, j, k + 1) ||
                    dfs(board, word, i, j + 1, k + 1) ||
                    dfs(board, word, i, j - 1, k + 1);
            board[i][j] = word[k];
            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
