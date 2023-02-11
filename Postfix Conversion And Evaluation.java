import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();
    System.out.println(PostfixEva(exp));
    PostfixConversion(exp);
     
 
 }
 public static void PostfixConversion(String exp){
     Stack<String> infix=new Stack<>();
     Stack<String> prefix=new Stack<>();
     Stack<Character> op=new Stack<>();

     for(int i=0;i<exp.length();i++){
         char ch=exp.charAt(i);
         if(ch>='0' && ch<='9'){
             infix.push(ch+"");
             prefix.push(ch+"");

         }
         else if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){                 
                 String inv2=infix.pop();
                 String inv1=infix.pop();
                 String inres="(" + inv1 + ch + inv2 + ")";
                 infix.push(inres);
                 String prev2=prefix.pop();
                 String prev1=prefix.pop();
                 String preres=ch + prev1 + prev2;
                 prefix.push(preres);
                             
         }
     }
     
     System.out.println(infix.pop());
     System.out.println(prefix.pop());
 }
 public static int precedence(char ch){
     if(ch=='+' || ch=='-'){
         return 1;
     }
     else{
         return 2;
     }
 }
 public static int PostfixEva(String exp){
     Stack<Integer> opnd =new Stack<>();
    
    for(int i=0;i<exp.length();i++){
        char ch=exp.charAt(i);
        if(ch>='0' && ch<='9'){
            opnd.push(ch-'0');
        }
        else if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){
            int v2=opnd.pop();
            int v1=opnd.pop();
            int res=operation(v1,v2,ch);
            opnd.push(res);
        }

    }
    return opnd.pop();

 }
 public static int operation(int v1,int v2,char op){
     if(op=='+'){
         return v1+v2;
     }
     else if(op=='-'){
         return v1-v2;
     }
     else if(op=='*'){
         return v1*v2;
     }
     else{
         return v1/v2;
     }
 }
}
