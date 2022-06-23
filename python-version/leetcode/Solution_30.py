from typing import List


class Solution:
    def main(self):
        print(self.findSubstring("wordgoodgoodgoodbestword", ["word", "good", "best", "good"]))

    # Time-Limited
    def findSubstring_0(self, s: str, words: List[str]) -> List[int]:
        length = sum([len(word) for word in words])
        all_alternative = set()

        nums = list(range(len(words)))
        def recur(first=0):
            if first == len(words):
                w = ""
                for index in nums:
                    w += words[index]
                all_alternative.add(w)

            for i in range(first, len(words)):
                nums[first], nums[i] = nums[i], nums[first]
                recur(first+1)
                nums[first], nums[i] = nums[i], nums[first]

        recur()
        print(all_alternative)

        ans = []
        for start in range(len(s) - length + 1):
            print(start, s[start:start+length])
            if s[start: start+length] in all_alternative:
                ans.append(start)

        return ans

    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        res = []
        m, n, ls = len(words), len(words[0]), len(s)
