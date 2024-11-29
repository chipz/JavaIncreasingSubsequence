package org.example;

import java.util.Arrays;


public class Main {
    public static int lengthOfIncreasingSequence(int[] sequence){
        int n = sequence.length;
        if (n == 0) {
            return 0; // Return 0 if the sequence is empty
        }

        int[] tails = new int[n];
        int size = 0;

        for (int i = 0; i < n; i++) {
            int num = sequence[i];

            // Perform binary search on the tails array
            int left = 0;
            int right = size;
            int pos = 0;

            int idx = Arrays.binarySearch(tails, 0, size, num);

            if (idx < 0) {
                // If not found, Arrays.binarySearch returns (-(insertion point) - 1)
                pos = -(idx + 1);
            } else {
                // If found, idx is the position where num exists
                pos = idx;
            }

            // Update tails array
            tails[pos] = num;

            // If num extends largest subsequence, increment size
            if (pos == size) {
                size++;
            }
        }

        return size; // The size represents the length of the longest increasing subsequence
    }

    public static void main(String[] args) {
        int[] sequence = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        int result = lengthOfIncreasingSequence(sequence);
        System.out.println(result); // Output: 6

        int[] sequence2 = {};
        int result2 = lengthOfIncreasingSequence(sequence2);
        //result 2 should be 0
        System.out.println(result2); // Output: 0

        int[] sequence3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int result3 = lengthOfIncreasingSequence(sequence3);
        //result 3 should be 10
        System.out.println(result3); // Output: 10

        int[] sequence4 = {10, 9, 8, 7, 6, 5};
        int result4 = lengthOfIncreasingSequence(sequence4);
        //result 4 should be 1
        System.out.println(result4); // Output: 1
    }
}