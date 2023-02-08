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
    int k = Integer.parseInt(br.readLine());//window size

    // code

    int[] ngir=new int[n]; // ngir=next greater element index in right 
    Stack<Integer> st=new Stack<>();
    ngir[n-1]=n;
    st.push(n-1);
    for(int i=n-2;i>=0;i--){
       while(st.size()>0 && arr[i]>arr[st.peek()]){
          st.pop();
       }
       if(st.size()==0){
          ngir[i]=n;
       }
       else{
          ngir[i]=st.peek();
       }
       st.push(i);

    }

    int j=0;
    for(int i=0;i<n-k+1;i++){
       if(j<i){
          j=i;
       }
       while(ngir[j]<i+k){
          j=ngir[j];
       }
       System.out.println(arr[j]);
    }
 }
}
