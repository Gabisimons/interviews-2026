package pattern01_arrays_hashing;

import java.util.*;

/*
    📝 Problem Statement:
    Given an integer array nums and an integer k, 
    return the k most frequent elements. You may return the answer in any order.

    Example 1:
    Input: nums = [1,1,1,2,2,3], k = 2
    Output: [1,2]

    Example 2:
    Input: nums = [1], k = 1
    Output: [1]

    ---
    💡 Approach Hints:
    - Use a frequency map to count occurrences of each number.
    - Use a PriorityQueue (heap) to extract the k elements with the highest frequency.
    - Be careful of the return type and order if required.

    Implement the function below.
*/

public class TopKFrequent {

    public static void main(String[] args) {
        // Test 1
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;
        System.out.println("Test 1 Input: " + Arrays.toString(nums1) + ", k=" + k1);
        System.out.println("Test 1 Result: " + Arrays.toString(topKFrequent(nums1, k1)));
        // Expected: [1, 2]

        System.out.println("-------------------");

        // Test 2
        int[] nums2 = {1};
        int k2 = 1;
        System.out.println("Test 2 Input: " + Arrays.toString(nums2) + ", k=" + k2);
        System.out.println("Test 2 Result: " + Arrays.toString(topKFrequent(nums2, k2)));
        // Expected: [1]
        
        System.out.println("-------------------");

        // Test 3 (Negative numbers)
        int[] nums3 = {4, 4, 4, -1, -1, 5};
        int k3 = 2;
        System.out.println("Test 3 Input: " + Arrays.toString(nums3) + ", k=" + k3);
        System.out.println("Test 3 Result: " + Arrays.toString(topKFrequent(nums3, k3)));
        // Expected: [4, -1]
    }

    /**
     * Returns the k most frequent elements in the array.
     * @param nums the input array of integers
     * @param k number of top frequent elements to return
     * @return int array of k most frequent elements
     */
    public static int[] topKFrequent(int[] nums, int k) {
        // 1. Build a frequency map of the numbers.
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }   
        // 2. Use a priority queue (min or max heap) to get the k most frequent elements.
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            heap.offer(entry.getKey());
            if (heap.size() > k) {
                heap.poll();
            }   
        }
        // 3. Prepare and return the output as an int array of size k.
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll();
        }
        return result;
    }
}