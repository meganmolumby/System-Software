/* Name: Megan Molumby
   N#:N00942101
   Class: COP3404 Systems Software
   Project 1
   Due Date: 9/22/2016
   PROBLEM: Hash a symbol table to be used by the assembler
   FINAL UPDATE 22 SEPT 2016 @ 2:30pm

 */
import java.util.Scanner;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.util.Stack;
import java.lang.*;
import java.util.LinkedList;
import java.util.List;


public class project1{
     

   public static void main(String[] args)throws IOException{
     
      int aKey;
      DataItem aDataItem;
      DataItem tempData;
      int size, n;
      int counter = 0;
      String[] inputs = new String[500];
      
      String temp;
      
      Scanner scan = new Scanner(new File(args[0]));
     
//Pre-scan of file, to get the Prime number for size of hash array.
      while(scan.hasNextLine()){
         temp = scan.nextLine();
         if(temp == "/n"){
            break;
         }
         temp = temp.trim();
         inputs[counter] = temp;
         counter++;
      }
      size = getPrime(counter); 
      HashTable quadratic = new HashTable(size); 
      PrintWriter writer = new PrintWriter("output.txt", "UTF-8");
      
   
//-----------------------------------------------------------   
//Fill quadratic Hash array from temp string files.  
       for(int i = 0; i < counter; i++){
         aDataItem = new DataItem(inputs[i]);
         tempData = quadratic.quadFind(aDataItem);
         
         //if word followed by number already exists, return an error message
         if(tempData == null && aDataItem.getValue() == -1){
            writer.println("ERROR " + aDataItem.getKey() + " not found."); 
              
         }
         //Upon seeing a word followed by a number, if it does not exist, store in hashed location and report
         //if a collision occurs.
         else if(tempData == null && aDataItem.getValue() != -1 ){
            quadratic.insertQuad(aDataItem);
            if(aDataItem.getCollisionValue() == true){
               writer.print("A Collision Occured in Storing " + aDataItem.getKey()+ "! ");
            }
            writer.println("Stored " + aDataItem.getKey() + " " + aDataItem.getValue() + " at location " + aDataItem.getArrayPlace()+".");
          }
          
         //if given a word with a different value than already exists, report the location of word. 
         else if(tempData.getKey().equals(aDataItem.getKey()) && aDataItem.getValue() != -1){
            writer.println("ERROR "+ aDataItem.getKey() + " already exists at location " + aDataItem.getArrayPlace()+ ".");
          
         }
         //if given just a word, say where it is is found if it already exists and with what value. 
         else if(tempData.getKey().equals(aDataItem.getKey()) && aDataItem.getValue() == -1){
         
            writer.println(aDataItem.getKey() +" found at location " + aDataItem.getArrayPlace() + " with value " + tempData.getValue()+ ".");
           
         }  
         
      }
//--------------------------------------------------------------
      
      writer.close();
     
 }  

//-------------------------------------------------------------
    public static int getPrime(int min){
  
      for(int j= min*2; true; j++){
         if(isPrime(j)){
            return j;
         }
      }
  }
//------------------------------------------------------------
     private static boolean isPrime(int n){
      for(int j =2;(j*j <=n); j++){
         if(n % j==0){
            return false;
         }
      }
       return true;
      
    }
}
//================END OF FILE========================================
