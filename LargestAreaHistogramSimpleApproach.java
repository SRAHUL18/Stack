import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    for(int i = 0; i < n; i++){
       arr[i] = Integer.parseInt(br.readLine());
    }

    // code

    //next smaller element in right
    int n1=arr.length;
    int[] nsr=new int[n1];
    nsr[n1-1]=n1;
    for(int i=0;i<n1;i++){
       for(int j=i+1;j<n1;j++){
          if(arr[j]<arr[i]){
             nsr[i]=j;
             break;
          }
       }
       if(nsr[i]==0){
          nsr[i]=n1;
       }
    }
 //next smaller element in left
    int[] nsl=new int[n1];
    nsl[0]=-1;
    for(int i=0;i<n1;i++){
       for(int j=i-1;j>=0;j--){
          if(arr[j]<arr[i]){
             nsl[i]=j;
             break;
          }
       }
       if(nsl[i]==0){
          nsl[i]=-1;
       }

    }

    int maxArea=Integer.MIN_VALUE;
    for(int i=0;i<n1;i++){
       int width=nsr[i]-nsl[i]-1;
       int area=arr[i]*width;
       maxArea=Math.max(maxArea,area);
    }

    System.out.println(maxArea);
 }
}
