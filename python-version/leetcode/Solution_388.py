class Solution:
    def main(self):
        print(self.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"))

    def lengthLongestPath(self, input: str) -> int:
        stack = []
        ans, index, n = 0, 0, len(input)

        while index < n:
            depth = 1
            while index < n and input[index] == '\t':
                depth += 1
                index += 1

            length, isFile = 0, False
            while index < n and input[index] != '\n':
                if input[index] == '.':
                    isFile = True
                length += 1
                index += 1
            index += 1

            while len(stack) >= depth:
                stack.pop()
            if stack:
                length += stack[-1] + 1
            if isFile:
                ans = max(ans, length)
            else:
                stack.append(length)

        return ans
