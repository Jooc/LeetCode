#include<stdio.h>
#include<vector>
using namespace std;

// class Solution {
// public:
//     vector<int> twoSum(vector<int>& nums, int target) {
//         for(int i = 0; i < nums.size(); i++){
//             for(int j = i+1; j < nums.size(); j++){
//                 if(i != j && nums[i] + nums[j] == target){
//                     return {i, j};
//                 }
//             }
//         }
//     }
// };

int main(){

    printf("char �洢��С : %lu \n", sizeof(char));
    printf("short �洢��С : %lu \n", sizeof(short));
    printf("int �洢��С : %lu \n", sizeof(int));
    printf("long �洢��С : %lu \n", sizeof(long));
    printf("float �洢��С : %lu \n", sizeof(float));
    printf("double �洢��С : %lu \n", sizeof(double));

    return 0;
}