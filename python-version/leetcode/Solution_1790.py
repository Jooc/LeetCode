class Solution:
    def areAlmostEqual0(self, s1: str, s2: str) -> bool:
        if len(s1) != len(s2): return False

        diff_indices = [i if s1[i] != s2[i] else -1 for i in range(len(s1))]
        diff_indices = list(filter(lambda x: x != -1, diff_indices))

        if len(diff_indices) == 0:
            return True

        if len(diff_indices) != 2:
            return False

        return s1[diff_indices[0]] == s2[diff_indices[1]] and s1[diff_indices[1]] == s2[diff_indices[0]]

    def areAlmostEqual(self, s1: str, s2: str) -> bool:
        i = j = -1
        for idx, (c1, c2) in enumerate(zip(s1, s2)):
            if c1 != c2:
                if i < 0:
                    i = idx
                elif j < 0:
                    j = idx
                else:
                    return False
        return i < 0 or j >= 0 and s1[i] == s2[j] and s1[j] == s2[i]


print(Solution().areAlmostEqual('kelb', 'kelb'))
