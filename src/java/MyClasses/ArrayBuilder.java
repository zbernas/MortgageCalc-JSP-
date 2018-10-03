/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyClasses;
import java.util.Arrays;
import java.text.DecimalFormat;
/**
 *
 * @author zacharybernas
 */
public class ArrayBuilder {

   private int arr_Length;
   private double interest;
   private double principal;
   private double monthly;
   private int numMonths;
   public static double[] PrincipalArr;
   public static double[] InterestArr;
   private static DecimalFormat df = new DecimalFormat("#.##");
   
       public ArrayBuilder(double interest, double principal, double monthly, int numMonths){
        this.interest = interest;
        this.principal = principal;
        this.monthly = monthly;
        this.numMonths = numMonths;     
   }
       
       public int getArrayLength(){
           
           return this.arr_Length;
       }
       
       public void setArray(){
           
           this.PrincipalArr = new double[0];
           this.InterestArr = new double[0];
       }
       
       public void CalcLength(){
        
        double interest_paid = ((this.principal * this.interest)/(12*100));
        double newPrincipal = this.principal;
        this.arr_Length =0;
        
        while(newPrincipal > 0.0){
            this.arr_Length++;
            newPrincipal = newPrincipal + interest_paid - this.monthly;
            interest_paid = ((newPrincipal * this.interest)/(12 *100));
        }
        
        if(this.numMonths < this.arr_Length){
            
            this.arr_Length = this.numMonths;
        }
        
    }
       
       public void makeArray(){
           double[] principal_Array = new double[this.arr_Length];
           double [] interest_Array = new double[this.arr_Length];
           double interest_paid = ((this.principal * this.interest)/(12*100));
           double newPrincipal = this.principal;
           
           double ArrayValue_double = (this.principal + interest_paid - this.monthly);
           String arrayValue_String;
           
           for(int i= 0; i < this.arr_Length; i++){
               
               if(i == 0)
            {
                arrayValue_String = df.format(ArrayValue_double);
                ArrayValue_double = Double.parseDouble(arrayValue_String);
                principal_Array[i] = (ArrayValue_double);
                newPrincipal = newPrincipal + interest_paid - this.monthly;
                
                arrayValue_String = df.format(interest_paid);
                interest_paid = Double.parseDouble(arrayValue_String);
                interest_Array[i] = interest_paid;
            }
               else{
                   interest_paid = ((newPrincipal * this.interest)/(12 *100));
                   newPrincipal = newPrincipal + interest_paid - this.monthly;
                   if (newPrincipal > 0){
                        arrayValue_String = df.format(newPrincipal);
                        ArrayValue_double = Double.parseDouble(arrayValue_String);
                        principal_Array[i] = (ArrayValue_double);

                        arrayValue_String = df.format(interest_paid);
                        ArrayValue_double = Double.parseDouble(arrayValue_String);
                        interest_Array[i] = ArrayValue_double;
                   }
                   else{
                       newPrincipal = principal_Array[i-1] + interest_paid;
                       arrayValue_String = df.format(newPrincipal);
                       ArrayValue_double = Double.parseDouble(arrayValue_String);
                       principal_Array[i] = (ArrayValue_double);
                       
                       arrayValue_String = df.format(interest_paid);
                       ArrayValue_double = Double.parseDouble(arrayValue_String);
                       interest_Array[i] = ArrayValue_double;
                   }
               }
           }
           
           this.PrincipalArr = principal_Array;
           this.InterestArr = interest_Array;
       }
    
}
