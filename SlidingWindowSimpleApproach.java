import java.io.*;
import java.util.*;

public class SlidingWindow{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    for(int i = 0; i < n; i++){
       arr[i] = Integer.parseInt(br.readLine());
    }
    int k = Integer.parseInt(br.readLine());
     int[] ans=new int[n-k+1];
    // code;
    for(int i=0;i<=arr.length-k;i++){
       int max=Integer.MIN_VALUE;
       for(int j=i;j<i+k;j++){
          if(arr[j]>max){
             max=arr[j];
          }
       }
       ans[i]=max;

    }
    for(int i=0;i<ans.length;i++){
       System.out.println(ans[i]);
    }
 }
}
