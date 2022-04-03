from typing import List


class Solution:
    def main(self):
        print(self.nextGreatestLetter(["e","e","e","e","e","e","n","n","n","n"], "e"))

    def nextGreatestLetter_0(self, letters: List[str], target: str) -> str:
        for letter in letters:
            if letter > target:
                return letter
        return letters[0]

    def nextGreatestLetter(self, letters: List[str], target: str) -> str:
        left, right = 0, len(letters)-1

        while left < right:
            mid = (left + right) >> 1
            if letters[mid] > target:
                right = mid
            else:
                left = mid + 1

        return letters[right] if letters[right] > target else letters[0]
