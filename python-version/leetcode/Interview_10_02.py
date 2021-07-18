import collections
from typing import List


class Interview_10_02:
    def main(self):
        print(self.groupAnagrams(["eat", "tea", "tan", "ate", "nat", "bat"]))

    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        dict = collections.defaultdict(list)

        for str in strs:
            key = "".join(sorted(str))
            dict[key].append(str)

        return list(dict.values())