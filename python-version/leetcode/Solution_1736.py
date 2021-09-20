class Solution:
    def main(self):
        print(self.maximumTime("?4:03"))

    def maximumTime(self, time: str) -> str:
        time = list(time)
        if time[0] == '?':
            if '4' <= time[1] <= '9':
                time[0] = '1'
            else:
                time[0] = '2'

        if time[1] == '?':
            if time[0] == '2':
                time[1] = '3'
            else:
                time[1] = '9'

        if time[3] == '?':
            time[3] = '5'

        if time[4] == '?':
            time[4] = '9'

        return ''.join(time)

