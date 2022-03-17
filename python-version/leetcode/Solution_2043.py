from typing import List


class Bank:

    def __init__(self, balance: List[int]):
        self.n = len(balance)
        self.balance = balance

    def transfer(self, account1: int, account2: int, money: int) -> bool:
        if account1 > self.n or account2 > self.n or money > self.balance[account1 - 1]:
            return False
        self.balance[account1 - 1] -= money
        self.balance[account2 - 1] += money
        return True

    def deposit(self, account: int, money: int) -> bool:
        if account > self.n:
            return False
        self.balance[account - 1] += money
        return True

    def withdraw(self, account: int, money: int) -> bool:
        if account > self.n or money > self.balance[account - 1]:
            return False
        self.balance[account - 1] -= money
        return True


# Your Bank object will be instantiated and called as such:
obj = Bank([10, 100, 20, 50, 30])
print(obj.withdraw(3, 10))
print(obj.transfer(5, 1, 20))
print(obj.deposit(5, 20))
print(obj.transfer(3, 4, 15))
print(obj.withdraw(10, 50))
