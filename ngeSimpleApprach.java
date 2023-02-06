import java.io.*;
import java.util.*;

public class ngeSimpleApproach{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + "\n");
    }
    System.out.println(sb);
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int[] nge = solve(a);
    display(nge);
 }

 public static int[] solve(int[] arr){
   int[] nge=new int[arr.length];
   for(int i=0;i<arr.length;i++){
     for(int j=i+1;j<arr.length;j++){
       if(arr[j]>arr[i]){
         nge[i]=arr[j];
         break;

       }
     }
     if(nge[i]!=0){

     }else{
       nge[i]=-1;
     }
   }
   return nge;
 }

}
