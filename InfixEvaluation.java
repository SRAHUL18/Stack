import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();
    Stack<Character> optors=new Stack<>();
    Stack<Integer> opnds=new Stack<>();
    for(int i=0;i<exp.length();i++){
        char ch=exp.charAt(i);
        if(ch=='('){
            optors.push(ch);
        }
        else if(Character.isDigit(ch)){
            opnds.push(ch-'0');
        }
        else if(ch==')'){
            while(optors.size()>0 && optors.peek()!='('){
                char operator=optors.pop();
                int v1=opnds.pop();
                int v2=opnds.pop();
                int res=operation(operator,v1,v2);
                opnds.push(res);
            }
            optors.pop();
        }
        else if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){
            while(optors.size()>0 && optors.peek()!='(' && precedence(optors.peek())>=precedence(ch)){
                 char operator=optors.pop();
                int v1=opnds.pop();
                int v2=opnds.pop();
                int res=operation(operator,v1,v2);
                opnds.push(res);
            }
            optors.push(ch);
        }
    }
            while(optors.size()!=0){
                char operator=optors.pop();
               int v1=opnds.pop();
                int v2=opnds.pop();
                int res=operation(operator,v1,v2);
                opnds.push(res);
            }
            System.out.println(opnds.peek());
}    

    // code
 
 public static int precedence(char ch){
     if(ch=='*' || ch=='/'){
         return 2;
     }
     else {
         return 1;
     }
 }

 public static int operation(char ch,int v1,int v2){
     if(ch=='+'){
         return v2+v1;
     }
     else if(ch=='-'){
         return v2-v1;
     }
     else if(ch=='*'){
         return v2*v1;
     }
     else {
         return v2/v1;
     }

 }
           
}

