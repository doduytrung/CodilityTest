/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem3;

/**
 *
 * @author trung
 * Problem: https://codility.com/tasks/min_abs_slice_sum/
 * 
 * 
 */
public class Solution {

    public static void main(String[] args) {
        int[] A = new int[5];
        A[0] = 2;
        A[1] = -4;
        A[2] = 6;
        A[3] = -3;
        A[4] = 9;
        int result = solution(A);
        System.out.println("Result:" + result);

        A = new int[5];
        A[0] = 2;
        A[1] = -4;
        A[2] = 6;
        A[3] = -3;
        A[4] = 9;
        result = solution(A);
        System.out.println("Result:" + result);
    }

    public static int solution(int[] A) {
        int n = A.length;
        int min = Math.abs(A[0] + A[1]);
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i + 1; j < n - 1; j++) {
                sum += A[j];
            }
            sum += A[i];
            sum=Math.abs(sum);
            if (min > sum) {
                min = sum;
            }

        }
        return min;
    }
}
