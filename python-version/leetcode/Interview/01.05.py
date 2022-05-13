class Solution:
    def oneEditAway_0(self, first: str, second: str) -> bool:
        n, m = len(first), len(second)
        if abs(n - m) > 1:
            return False
        need_op = False
        f_i, s_i = 0, 0
        while f_i < n and s_i < m:
           if first[f_i] == second[s_i]:
               f_i += 1
               s_i += 1
           elif need_op:
               return False
           else:
               if n > m:
                   f_i += 1
               elif m > n:
                   s_i += 1
               else:
                   f_i += 1
                   s_i += 1
               need_op = True
        return True

    def oneEditAway(self, first: str, second: str) -> bool:
        m, n = len(first), len(second)
        if m < n:
            return self.oneEditAway(second, first)
        if m - n > 1:
            return False
        for i, (x, y) in enumerate(zip(first, second)):
            if x != y:
                return first[i+1:] == second[i+1:] if m == n else first[i+1:] == second[i:]
        return True

solution = Solution()
print(solution.oneEditAway("teacher", "treacher"))