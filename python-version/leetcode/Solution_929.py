from typing import List

class Solution:
    def main(self):
        print(self.numUniqueEmails(["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]))

    def numUniqueEmails_0(self, emails: List[str]) -> int:
        record = dict()

        for email in emails:
            local_name, net_name = email.split('@')[0], email.split('@')[1]
            local_name = local_name.split('+')[0]
            local_name = local_name.replace('.', '')
            if local_name in record.keys():
                record[local_name].add(net_name)
            else:
                record[local_name] = set([net_name])

        return sum([len(result_set) for result_set in record.values()])

    def numUniqueEmails(self, emails: List[str]) -> int:
        record = set()
        for email in emails:
            i = email.index('@')
            local = email[:i].split('+')[0].replace('.', '')
            record.add(local + email[i:])
        return len(record)