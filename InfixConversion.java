import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    
    Stack<String>pre=new Stack<>();
    Stack<String>post=new Stack<>();
    Stack<Character>op=new Stack<>();
    for(int i=0;i<exp.length();i++){
        char ch=exp.charAt(i);
        if(ch=='('){
            op.push(ch);
        }
        else if(ch>='0' && ch<='9' || ch>='a' && ch<= 'z' || ch<='A' && ch=='Z'){
            pre.push(ch+"");
            post.push(ch+"");
        }
        else if(ch==')'){
            while(op.size()>0 && op.peek()!='('){
               evaluate(pre,post,op);
            }
            op.pop();

        }
        else if(ch=='+' || ch=='-' || ch=='/' ||ch=='*'){
             while(op.size()>0 && op.peek()!='(' && precedence(op.peek())>=precedence(ch)){
                evaluate(pre,post,op);
            }
            op.push(ch);
        
        }
        
    }
            while(op.size()>0){
               evaluate(pre,post,op);

            }
        System.out.println(post.pop());
        System.out.println(pre.pop());

 }
 public static int precedence(char ch){
     if(ch=='+' || ch=='-'){
         return 1;
     }
     else{
         return 2;
     }
 }
 public static void evaluate(Stack<String> pre,Stack<String> post,Stack<Character> op){
                char operator=op.pop();
                String prev2=pre.pop();
                String prev1=pre.pop();
                String prer=operator + prev1 + prev2;
                pre.push(prer);

                String postv2=post.pop();
                String postv1=post.pop();
                String postr=postv1+postv2+operator;
                post.push(postr);
            }
}
