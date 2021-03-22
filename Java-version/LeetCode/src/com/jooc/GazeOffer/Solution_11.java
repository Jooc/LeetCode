package com.jooc.GazeOffer;

public class Solution_11 {
    public int minArray(int[] numbers) {
        int low = 0, high = numbers.length - 1;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(numbers[mid] < numbers[high]){
                high = mid;
            }
            else if(numbers[mid] > numbers[high]){
                low = mid + 1;
            }
            else {
                high--;
            }
        }
        return numbers[low];
    }
}
