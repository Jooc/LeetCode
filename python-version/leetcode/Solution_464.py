from functools import cache


class Solution:
    def canIWin(self, maxChoosableInteger: int, desiredTotal: int) -> bool:
        @cache
        def dfs(used_num, current_total):
            for num in range(maxChoosableInteger):
                if (used_num >> num) & 1 == 0:
                    if num + current_total + 1 >= desiredTotal or not dfs(used_num | (1 << num), current_total+num+1):
                        return True
            return False

        # sum = (n+1)*n/2
        return (1+maxChoosableInteger) * maxChoosableInteger // 2 >= desiredTotal and dfs(0, 0)

