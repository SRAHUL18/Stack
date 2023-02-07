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

    // next smaller element in right
    int m=arr.length;
    int[] nsr=new int[m];
    Stack<Integer> st =new Stack<>();
    st.push(0);
    for(int i=1;i<m;i++){
       while(st.size()>0 && arr[i]<arr[st.peek()]){
          int idx=st.pop();
          nsr[idx]=i;
       }
       st.push(i);

      }
      while(st.size()>0){
         int idx=st.pop();
         nsr[idx]=m;
      }

    //next smaller element in left
    int[] nsl=new int[m];
    st.push(0);
    nsl[0]=-1;
    for(int i=1;i<m;i++){
       while(st.size()>0 && arr[i]<arr[st.peek()]){
          st.pop();
       }
       if(st.size()==0){
          nsl[i]=-1;
       }
       else{
          nsl[i]=st.peek();
       }
       st.push(i);
    }

    int maxArea=Integer.MIN_VALUE;
    for(int i=0;i<m;i++){
       int width=nsr[i]-nsl[i]-1;
       int area=arr[i]*width;
       maxArea=Math.max(maxArea,area);
    }
    System.out.println(maxArea);
 }
}
