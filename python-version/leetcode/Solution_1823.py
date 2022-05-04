class Solution:
    def main(self):
        print(self.findTheWinner(5, 2))

    def findTheWinner_0(self, n: int, k: int) -> int:
        a = list(range(n + 1))[1:]
        print(a)
        index = 0
        while len(a) != 1:
            index = (index + k - 1) % len(a)
            print(a[index])
            a.pop(index)

        return a[0]

    def findTheWinner_1(self, n: int, k: int) -> int:
        return 1 if n == 1 else (k + self.findTheWinner(n - 1, k) - 1) % n + 1

    def findTheWinner(self, n: int, k: int) -> int:
        winner = 1
        for i in range(2, n + 1):
            winner = (k + winner - 1) % i + 1
        return winner
