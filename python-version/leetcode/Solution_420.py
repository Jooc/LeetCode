class Solution:
    def main(self):
        print(self.strongPasswordChecker("aaa111"))
        print(self.strongPasswordChecker("aA1"))
        print(self.strongPasswordChecker("bbaaaaaaaaaaaaaaacccccc"))

    def strongPasswordChecker(self, password: str) -> int:
        n = len(password)

        def have_captial(s: str) -> bool:
            for c in s:
                if 65 <= ord(c) <= 90:
                    return True
            return False

        def have_lower(s: str) -> bool:
            for c in s:
                if 97 <= ord(c) <= 122:
                    return True
            return False

        def have_num(s: str) -> bool:
            for c in s:
                if 48 <= ord(c) <= 57:
                    return True
            return False

        def nb_redundant(s: str) -> int:
            ops = 0
            left, right, counter = 0, 0, 0
            while left < len(s):
                while right < len(s) and s[right] == s[left]:
                    right += 1
                    counter += 1
                    if counter >= 3:
                        ops += 1
                        break
                left = right
                counter = 0
            return ops

        ops = 0
        if not have_captial(password):
            ops += 1
        if not have_lower(password):
            ops += 1
        if not have_num(password):
            ops += 1
        r_ops = nb_redundant(password)
        diff = n - 20 if n > 20 else 6 - n

        print(n, diff, r_ops, ops)
        if n > 20:
            ans = max(diff, r_ops) + ops
        elif n < 6:
            ans = max(diff, max(r_ops, ops))
        else:
            ans = max(ops, r_ops)

        return ans
