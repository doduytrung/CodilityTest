/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem5;

/**
 *
 * @author trung
 */
public class Solution {
    public int solution(int X, int[] A) {
       int N=A.length;            
       
       for(int k=0;k<N;k++){
           int eTotal=0; //total of equal elements
           int dTotal=0; //total of diff elements
           for(int i=0;i<k;i++){
                if(A[i]==X){
                    eTotal++;
                }
           }
          
           for(int i=k;i<N;i++){
                if(A[i]!=X){
                    dTotal++;
                }
           }           
           if(eTotal==dTotal)
                return k;
       }       
       return -1;
    }
}
