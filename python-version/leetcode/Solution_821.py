from typing import List


class Solution:
    def main(self):
        print(self.shortestToChar("loveleetcode", "e"))

    def shortestToChar_0(self, s: str, c: str) -> List[int]:
        n = len(s)
        distance = [n] * n
        index = 0

        while index < n:
            if s[index] == c:
                distance[index] = 0
                index += 1
                while index < n and s[index] != c:
                    distance[index] = distance[index-1] + 1
                    index += 1
            else:
                index += 1
        print(distance)

        index = n - 1
        while index >= 0:
            if s[index] == c:
                index -= 1
                while index >= 0 and s[index] != c:
                    distance[index] = min(distance[index+1] + 1, distance[index])
                    index -= 1
            else:
                index -= 1

        return distance

    def shortestToChar(self, s: str, c: str) -> List[int]:
        n = len(s)
        distance = [0] * n

        idx = -n
        for index, ch in enumerate(s):
            if ch == c:
                idx = index
            distance[index] = index - idx
        idx = 2 * n
        for index in range(n - 1, -1, -1):
            if s[index] == c:
                idx = index
            distance[index] = min(distance[index], idx - index)
        return distance
