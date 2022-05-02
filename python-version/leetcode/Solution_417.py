from typing import List, Tuple, Set


class Solution:
    def main(self):
        print(self.pacificAtlantic([[2, 1], [1, 2]]))

    def pacificAtlantic_0(self, heights: List[List[int]]) -> List[List[int]]:
        m, n = len(heights), len(heights[0])
        directions = [[-1, 0], [0, 1], [1, 0], [0, -1]]
        pac_able = [[False] * n for _ in range(m)]
        atl_able = [[False] * n for _ in range(m)]

        def dfs(cur_x, cur_y, pac):
            nonlocal pac_able, atl_able
            if pac:
                pac_able[cur_x][cur_y] = True
            else:
                atl_able[cur_x][cur_y] = True

            for direction in directions:
                next_x, next_y = cur_x + direction[0], cur_y + direction[1]
                if next_x < 0 or next_x >= m or next_y < 0 or next_y >= n:
                    continue
                if pac and pac_able[next_x][next_y] or not pac and atl_able[next_x][next_y]:
                    continue
                if heights[next_x][next_y] >= heights[cur_x][cur_y]:
                    dfs(next_x, next_y, pac)

        for index in range(n):
            dfs(0, index, True)
            dfs(m - 1, index, False)
        for index in range(m):
            dfs(index, 0, True)
            dfs(index, n - 1, False)

        ans = []
        for x in range(m):
            for y in range(n):
                if pac_able[x][y] and atl_able[x][y]:
                    ans.append([x, y])

        return ans

    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        m, n = len(heights), len(heights[0])

        def search(starts: List[Tuple[int, int]]) -> Set[Tuple[int, int]]:
            visited = set()

            def dfs(x: int, y: int):
                if (x, y) in visited:
                    return
                visited.add((x, y))
                for nx, ny in ((x, y + 1), (x, y - 1), (x - 1, y), (x + 1, y)):
                    if 0 <= nx < m and 0 <= ny < n and heights[nx][ny] >= heights[x][y]:
                        dfs(nx, ny)

            for x, y in starts:
                dfs(x, y)
            return visited

        pac_able = [(0, i) for i in range(n)] + [(i, 0) for i in range(1, m)]
        atl_able = [(m - 1, i) for i in range(n)] + [(i, n - 1) for i in range(m-1)]

        return list(map(list, search(pac_able) & search(atl_able)))
