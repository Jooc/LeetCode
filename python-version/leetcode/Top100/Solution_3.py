class Solution:
    def main(self):
        print(self.lengthOfLongestSubstring('avc '))


    def lengthOfLongestSubstring(self, s: str) -> int:
        n = len(s)
        left, right = 0, 0

        mark = set()
        ans, counter = 0, 0
        while right < n:
            if s[right] in mark:
                while left <= right and s[right] in mark:
                    mark.remove(s[left])
                    left += 1
                    counter -= 1
                mark.add([s[right]])
                counter += 1
            else:
                mark.add(s[right])
                counter += 1
                ans = max(ans, counter)
                print(ans, s[left: right+1])
            right += 1

        return ans