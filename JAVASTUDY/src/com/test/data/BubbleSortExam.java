package com.test.data;

import java.util.Arrays;

public class BubbleSortExam {
    public static void main(String[] args) {
        int[] nums = { 1, 7, 2, 4, 3, 5, 0, 9, 8, 6 };

        System.out.println("--- 정렬 전 ---");
        System.out.println(Arrays.toString(nums));

        // 오름 차순 정렬 --> 정렬 알고리즘은 Bubble Sort 알고리즘을 사용
        // outer for문이 한번 반복 할 때마다 배열의 왼쪽으로 가장 작은 수가 옮겨짐

        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                // 만약 앞의 수가 뒤의 수보다 더 크다면 swap 연산을 진행
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j]; // swap을 위해 값을 임시 저장
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        System.out.println("--- 정렬 후 ---");
        System.out.println(Arrays.toString(nums));

    }
}
