/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem1;

/**
 *
 * @author trung
 * @problem:
 *
 * intervals
 *
 * I(A,B) - I(C,D) overlap: Exist L: A<=L<=B && C<=L<=D disjoint : not overlap
 * union: I(min(A,C),max(C,D)) - overlap union: I(A,B) && I (C,D) - disjoint
 */
public class Solution {

    public static void main(String[] args) {
        int A[] = new int[8];
        int B[] = new int[8];
        A[0] = 1;
        A[1] = 12;
        A[2] = 42;
        A[3] = 70;
        A[4] = 36;
        A[5] = -4;
        A[6] = 43;
        A[7] = 15;

        B[0] = 5;
        B[1] = 15;
        B[2] = 44;
        B[3] = 72;
        B[4] = 36;
        B[5] = 2;
        B[6] = 69;
        B[7] = 24;
        int result = solution1(A, B);
        System.out.println("Result: " + result);
    }

    public static int solution1(int A[], int B[]) {
        //sort intervals
        int N = A.length;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (A[i] > A[j]) {
                    int temp;

                    temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;

                    temp = B[i];
                    B[i] = B[j];
                    B[j] = temp;
                }
            }
        }
        //find k
        int k;
        boolean flag = true;
        do {
            int[] X = new int[N];
            int[] Y = new int[N];
            k = 0;
            for (int i = 0; i < N - 1; i++) {
                int a = A[i];
                int b = B[i];
                int c = A[i + 1];
                int d = B[i + 1];

                if (b < c) {//disjointnt    
                    X[k] = a;
                    Y[k] = b;
                    k++;
                    X[k] = c;
                    Y[k] = d;
                } else {//overlap
                    X[k] = Math.min(a, c);
                    Y[k] = Math.max(b, d);
                }

            }
            k++;
            //re-initialize
            if (k < N) {
                N = k;
                A = new int[N];
                B = new int[N];
                for (int j = 0; j < N; j++) {
                    A[j] = X[j];
                    B[j] = Y[j];
                    //System.out.println("(" + X[j] + "," + Y[j] + ")");
                }
                flag = true;
            } else {
                flag = false;
            }
        } while (flag);
        return N;
    }
}
