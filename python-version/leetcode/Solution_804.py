from typing import List


class Solution:
    def main(self):
        print(self.uniqueMorseRepresentations(["gin", "zen", "gig", "msg"]))

    def uniqueMorseRepresentations_0(self, words: List[str]) -> int:
        moss = [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
        map = {}
        for index in range(26):
            map[chr(index+97)] = moss[index]
        print(map)

        def moss_code(word):
            nonlocal map
            code = ""
            for ch in word:
                code += map[ch]
            return code


        words_count = set()
        for word in words:
            words_count.add(moss_code(word))

        return len(words_count)

    def uniqueMorseRepresentations(self, words: List[str]) -> int:
        morse = [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]

        return len(set("".join(morse[ord(ch)-ord('a')] for ch in word) for word in words))


