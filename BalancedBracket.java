import java.io.*;
import java.util.*;
class BalancedBracket{
   public static void main(String[] args){
      Scanner scn=new Scanner(System.in);
      String str=scn.nextLine();
      Stack<Character> st=new Stack<>();
      for(int i=0;i<str.length();i++){
         char ch=str.charAt(i);
         if(ch == '(' || ch == '{' || ch == '['){
            st.push(ch);
         }
         else if(ch==')' || ch=='}' || ch==']'){
            if(st.size()==0){
               System.out.println(false);
               return;
            }
            if(isValidCharacter(st,ch)){
               st.pop();
            }
            else{
               System.out.println(false);
               return;
            }
         }
      }
      if(st.size()==0){
         System.out.println(true);
      }
      else if(st.size()!=0){
         System.out.println(false);
      }
      
   }
   public static boolean isValidCharacter(Stack<Character> st,char ch){
      if(ch==')'){
         if(st.peek()=='('){
            return true;
         }
      }
      else if(ch=='}'){
         if(st.peek()=='{'){
            return true;
         }
      }
      else if(ch==']'){
         if(st.peek()=='['){
            return true;
         }
      }
      return false;
   }
}
