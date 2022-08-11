
package conversions;

import java.util.Scanner;

/**
 *
 * @author amadou diallo
 */
public class Conversions {

    static Scanner sc = new Scanner(System.in);
    static boolean usingk;
    
    public static void main(String[] args) {
        int cvtype;
        
        System.out.println("Welcome to the conversation program.");
    
        System.out.print("Do you wish to see Kelvin temps?: ");
     
        String Kchoice = sc.nextLine();
        if(!Kchoice.isEmpty() && Kchoice.substring(0,1).equalsIgnoreCase("Y") ){
           usingk = true;
        } else {
           usingk = false;
        }
      
      
       cvtype = getCVType();
       while (cvtype != 0){
            switch(cvtype) {
              case 1:
                  MitoKm();
                  break;         
              case 2:
                  OztoGr();
                  break;
              case 3:
                  FtoC();
                  break;
              default:
                  System.out.println("Unknown operation passed to main");
                  break;
            }//end of switch
          
            cvtype = getCVType();
     
        }//end of while
        System.out.println("Thanks for using the converter");
       
    }//end of main
    
    public static int getCVType() { 
        int cv = -1;
        do {
            try {
              System.out.print("Conversions? 1=Mi-to-Km, 2=Oz-to-Gr, 3=F-to-C, 0=Quit: " );
              cv = sc.nextInt();
            
              if (cv < 0 || cv > 3) {
               System.out.println("Unknown Conversion: 1-3 or 0 only please.");
              }
                
            } catch (Exception e) {
                System.out.println("Integers between 0-3 Only please.");
                sc.nextLine();
                cv = -1;
            }
                
        } while (cv < 0 || cv > 3 );
        
    return cv;
    }//end of getCVtype
    
    public static double getValue(String prompt) {
        double v = 0;
        boolean badval = true;
        do {
           System.out.print("Enter your " + prompt + ": ");
            try{
               v = sc.nextDouble();
               sc.nextLine(); // clean out the remaining cr-lf in buffer
               badval = false; // success if no exception ocurred
            }catch(Exception e){
               System.out.println("Error: bad value.");
               badval = true;
               sc.nextLine(); // clear out the scanner buffer
            }
        } while(badval);
        return v;
    }
    
    public static void MitoKm() {
       double mi, km;
       mi = getValue("miles");
       km = mi * 1.60934;
   
       System.out.println("A distance of " + mi + " miles = " + km + " kilometers" );
    }
  
    public static void OztoGr() {
         double oz, gr;
         oz = getValue("ounces");
         gr = oz * 28.3495;
         System.out.println(oz + " ounces = " + gr + " grams" );
    }
     
    public static void FtoC() {
        double f, c;
        f = getValue("degrees Fahrenheit");
        //calc c and display result..
        c = (5.0/9.0)*(f-32.0);
        System.out.println(f + " degrees Fahrenheit = " + c + " celsius");
       
        if(usingk) {
           showDegreesK(c);
        }
    }
    
    public static void showDegreesK(double c) {
          double k;
          k = c + 273.15;
          if (k < 0) {
             System.out.println("That temp is actually unreachable: below absolute zero.");
          } else {
             System.out.println("which is a temp of " + k + " Kelvin.");
          }      
    }
              
              
}//end of Coversions        
