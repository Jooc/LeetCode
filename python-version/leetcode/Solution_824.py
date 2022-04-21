class Solution:
    def main(self):
        print(self.toGoatLatin("I speak Goat Latin"))
    def toGoatLatin(self, sentence: str) -> str:
        vowel = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}
        words = sentence.split(' ')
        for index in range(len(words)):
            if words[index][0] not in vowel:
                words[index] = words[index][1:] + words[index][0]
            words[index] += 'ma'
            words[index] += 'a' * (index+1)
        print(words)

        ans = ""
        for word in words:
            ans += word
            ans += " "
        return ans.strip()
