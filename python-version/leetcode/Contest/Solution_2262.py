class Solution:
    def main(self):
        print(self.appealSum('abbca'))

    def appealSum(self, s: str) -> int:
        n = len(s)
        ch_map = {}
        for ch in 'abcdefghijklmnopqrstuvwxyz':
            ch_map[ch] = -1

        dp = [0 for _ in range(n)]
        for index, ch in enumerate(s):
            if index == 0:
                dp[index] = 1
                ch_map[ch] = index
                continue
            if ch_map[ch] == -1:
                dp[index] = dp[index-1] + index + 1
            else:
                last_index = ch_map[ch]
                dp[index] = 1 + dp[index-1] + index - (last_index + 1)
            ch_map[ch] = index

        return sum(dp)

