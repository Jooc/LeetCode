class Solution:
    def main(self):
        print(self.winnerOfGame('AAABABB'))

    def winnerOfGame(self, colors: str) -> bool:
        n, i, j = len(colors), 0, 0
        scores = {'A': 0, 'B':0}

        while j < n:
            counter = 0
            while j < n:
                if colors[j] != colors[i]:
                    i = j
                    break
                else:
                    counter += 1
                    if counter >= 3:
                        scores[colors[i]] += 1
                    j += 1


        return scores['A'] > scores['B']
