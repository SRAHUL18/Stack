import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    
    System.out.println(prefixeval(exp));
    PrefixConversion(exp);
 }
 public static void PrefixConversion(String exp){
     Stack<String> infix=new Stack<>();
     Stack<String> postfix=new Stack<>();
     for(int i=exp.length()-1;i>=0;i--){
         char ch=exp.charAt(i);
         if(ch>='0' && ch<='9'){
             infix.push(ch+"");
             postfix.push(ch+"");
         }
         else{
             String inv1=infix.pop();
             String inv2=infix.pop();
             String inr="(" + inv1 + ch + inv2 + ")";
             infix.push(inr);

             String postv1=postfix.pop();
             String postv2=postfix.pop();
             String postr=postv1 +  postv2 + ch;
             postfix.push(postr);
         }
     }
      System.out.println(infix.pop());
      System.out.println(postfix.pop());
 }
 public static int prefixeval(String exp){
     Stack<Integer> opnd=new Stack<>();
    for(int i=exp.length()-1;i>=0;i--){
        char ch=exp.charAt(i);
        if(ch>='0' && ch<='9'){
            opnd.push(ch-'0');
        }
        else{
            int v1=opnd.pop();
            int v2=opnd.pop();
            int res=operation(v1,v2,ch);
            opnd.push(res);
        }
    }
    return opnd.pop();

 }
 public static int operation(int v1,int v2,char ch){
     if(ch=='+'){
         return v1+v2;
     }
     else if(ch=='-'){
         return v1-v2;
     }
     else if(ch=='*'){
         return v1*v2;
     }else{
         return v1/v2;
     }
 }
}
