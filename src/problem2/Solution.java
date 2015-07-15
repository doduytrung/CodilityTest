/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem2;

/**
 *
 * @author trung
 */
public class Solution {
     public static void main(String[] args) {
         //A
         IntList list=new IntList();
         list.value=0;
         list.next=new IntList();
         //B
         list.next.value=1;
         list.next.next=new IntList();
         //C
         list.next.next.value=2;
         list.next.next.next=new IntList();
         //D
         list.next.next.next.value=3;
         list.next.next.next.next=null;
         
         int result=solution(list);
         System.out.println("Result:"+result);
     }
     
     public static int solution(IntList L){
         int total=0;
         IntList node=null;
         IntList next=null;
         do{
             node=L;
             next=node.next;
             L=next;
             total++;
         }while(next!=null);
         return total;
     }
}
