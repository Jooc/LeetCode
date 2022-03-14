from typing import List

class Solution:
    def main(self):
        print(self.findRestaurant(["Shogun", "Tapioca Express", "Burger King", "KFC"], ["KFC", "Shogun", "Burger King"]))
    def findRestaurant(self, list1: List[str], list2: List[str]) -> List[str]:
        if len(list1) < len(list2):
            return self.findRestaurant(list2, list1)

        index_of = {rest: index for index, rest in enumerate(list1)}

        min_index = len(list1) + len(list2) - 2
        ans = []
        for index_y, rest in enumerate(list2):
            if rest in index_of:
                index_x = index_of[rest]
                if index_x + index_y < min_index:
                    min_index = index_x + index_y
                    ans = [rest]
                elif index_x + index_y == min_index:
                    ans.append(rest)

        return ans
