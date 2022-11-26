class Solution:
    def generateTheString(self, n: int) -> str:
        s1 = "a" * n if n % 2 == 1 else "a" * (n - 1)
        return s1 + "b" * (n - len(s1))
