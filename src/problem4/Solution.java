/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem4;

/**
 *
 * @author trung Problem: https://codility.com/tasks/deepest_pit
 *
 *
 */
public class Solution {

    public static void main(String[] args) {
        int[] A = new int[10];
        A[0] = 0;
        A[1] = 1;
        A[2] = 3;
        A[3] = -2;
        A[4] = 0;
        A[5] = 1;
        A[6] = 0;
        A[7] = -3;
        A[8] = 2;
        A[9] = 3;
        int result = solution(A);
        System.out.println("Result:" + result);

    }

    public static int solution(int[] A) {
        int N = A.length;
        int P = 0, Q = -1, R = -1;
        int depth = -1;

        for (int i = 1; i < N; i++) {
            if (Q < 0) {
                if (A[i] < A[i - 1]) {
                    Q = i;
                    continue;
                } else {
                    P = i;
                    continue;
                }
            }

            if (A[i] > A[i - 1]) {
                R = i;
                depth = Math.max(depth, Math.min(A[P] - A[Q], A[R] - A[Q]));
            } else if (R < 0) {
                Q = i;
            } else {
                Q = i;
                R = -1;
                P = i - 1;
            }
        }        
        return depth;
    }
}
