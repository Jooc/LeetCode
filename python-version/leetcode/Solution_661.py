from typing import List


class Solution:
    def main(self):
        print(self.imageSmoother([[100,200,100],[200,50,200],[100,200,100]]))

    def imageSmoother(self, img: List[List[int]]) -> List[List[int]]:
        directions = [[-1, -1], [-1, 0], [-1, 1], [0, -1], [0, 0], [0, 1], [1, -1], [1, 0], [1, 1]]

        rows, cols = len(img), len(img[0])
        res = [[0] * cols for _ in range(rows)]

        def cal(x, y):

            counter, sum = 0, 0
            for direction in directions:
                pos_x, pos_y = x + direction[0], y + direction[1]
                if 0 <= pos_x <= rows - 1 and 0 <= pos_y <= cols - 1:
                    sum += img[pos_x][pos_y]
                    counter += 1
            print(x, y, sum, counter)
            res[x][y] = sum // counter

        for row in range(rows):
            for col in range(cols):
                cal(row, col)

        return res
