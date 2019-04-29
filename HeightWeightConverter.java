import java.util.Scanner;
class HeightWeightConverter{

public static void main(String[]args){

Scanner scan=new Scanner(System.in); /* The reason why I assigned scan variable to 
        "new Scanner(System.in)" is using this class very easiy.*/

System.out.println("Are you willing to convert weight or height?");
String z=scan.nextLine(); // I assigned this z variable to value which is entered by user like weight or height, to use in conditions easily.//

System.out.println("Will it be for imperial unit or metric unit?");
String g=scan.nextLine(); // I assigned this g variable to value which is entered by user like imperial or metric, to use in conditions easily.//



/* I wrote if conditions because i wanted to seperate probabilities which are occured by
java program. */ 

if((z.equals("height")) && (g.equals("metric"))) {  

System.out.println("Please provide the height information in meter");
double t=scan.nextDouble();   // I assigned this t variable to value which shows user's height in meter, to use easily.// 

System.out.printf("Your height in mtr "+t+" is equal to %.2f in inches",h(t,g)); // I used h method due to convert meter to inches.//
}


else if((z.equals("height")) && (g.equals("imperial"))) {

    System.out.println("Please provide the height information in inch");
    double t1=scan.nextDouble();   // I assigned this t1 variable to value which shows user's height in inches, to use easily.//
    
    System.out.printf("Your height in inch "+t1+" is equal to %.2f in meters",h(t1,g)); // I used h method due to convert inch to meter.//
}


else if((z.equals("weight")) && (g.equals("metric"))) {

    System.out.println("Please provide the weight information in kg");
    double f=scan.nextDouble(); // I assigned this f variable to value which shows user's weight in kg, to use easily.//
    
    System.out.printf("Your weight in kgs " + f+" is equal to %.2f in pounds",w(f,g)); // I used h method due to convert kg to pound.//

}
else if((z.equals("weight")) && (g.equals("imperial"))) { 

    System.out.println("Please provide the weight information in pound"); 
    double f1=scan.nextDouble(); // I assigned this f variable to value which shows user's weight in pound, to use easily.//
 
    System.out.printf("Your weight in pounds "+ f1+" is equal to %.2f in kgs ",w(f1,g));// I used h method due to convert pound to kg.//
}
else {
    System.out.println("YOU ENTERED WRONG INPUT!");
}

} //End of main method.


// I created w method to convert user's weight imperial unit or metric unit //

public static double  w(double x,String y){

double result; // I determined result value to write in return. //

if(y.equals("metric"))

      result=(x*2.20462);

else 
        result=(x*0.453592);

 return result;



} // End of w method. //

// I created h method to convert user's height imperial unit or metric unit. //

public static double h(double a,String b){

double result2; // I determined result2 value to write in return. //

if(b.equals("metric"))

    result2=(a*39.3701);


else 
    result2=(a*0.0254); 

  return result2;
} // End Of h method.

} // End Of Part1 Class.