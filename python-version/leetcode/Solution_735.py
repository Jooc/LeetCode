from typing import List


class Solution:
    def asteroidCollision_00000(self, asteroids: List[int]) -> List[int]:
        alive = [True for _ in range(len(asteroids))]
        for i in range(1, len(asteroids)):
            if asteroids[i] < 0:
                j = i - 1
                while j >= 0 and alive[j] and asteroids[j] > 0 and abs(asteroids[j]) <= abs(asteroids[i]):
                    if asteroids[j] == asteroids[i]:
                        alive[i] = False
                    alive[j] = False
                if j > 0:
                    alive[i] = False

        return [asteroids[i] for i in range(len(asteroids)) if alive[i]]

    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        stack = []
        for aster in asteroids:
            alive = True
            while alive and aster < 0 and stack and stack[-1] > 0:
                alive = stack[-1] < -aster
                if stack[-1] <= -aster:
                    stack.pop()
            if alive:
                stack.append(aster)
        return stack


print(Solution().asteroidCollision([-2,-1,1,2]))
