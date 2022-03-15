from typing import List


class Solution:
    def main(self):
        print(self.isValidSudoku([["5", "3", ".", ".", "7", ".", ".", ".", "."]
                               , ["6", ".", ".", "1", "9", "5", ".", ".", "."]
                               , [".", "9", "8", ".", ".", ".", ".", "6", "."]
                               , ["8", ".", ".", ".", "6", ".", ".", ".", "3"]
                               , ["4", ".", ".", "8", ".", "3", ".", ".", "1"]
                               , ["7", ".", ".", ".", "2", ".", ".", ".", "6"]
                               , [".", "6", ".", ".", ".", ".", "2", "8", "."]
                               , [".", ".", ".", "4", "1", "9", ".", ".", "5"]
                               , [".", ".", ".", ".", "8", ".", ".", "7", "9"]]
                           ))

    # index = i / 3 * 3 + j / 3
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        row = [set() for _ in range(9)]
        col = [set() for _ in range(9)]
        area = [set() for _ in range(9)]

        for i in range(len(board)):
            for j in range(len(board[i])):
                if board[i][j] == '.':
                    continue

                num = int(board[i][j])
                area_index = int(i / 3) * 3 + int(j / 3)
                if row[i].__contains__(num) or col[j].__contains__(num) or area[area_index].__contains__(num):
                    return False

                row[i].add(num)
                col[j].add(num)
                area[area_index].add(num)

        return True
