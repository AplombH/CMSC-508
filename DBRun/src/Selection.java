/**
 * @author APLOMB 
 */

import java.util.Scanner;

public class Selection {
    
    private String C_select = "Select";
    private String C_all = "*";
    private String choice1 = "";
    private String choice2 = "";
    
   
    
    public Selection(){}
    
    public Selection (String str)
    {
         Scanner scanner=new Scanner(str);
         if (scanner.next().equals("Select"))
         {
             
         }
    }
    
    public int getColumn(String str)
    { int cNum = 0; String temp = "";
    
       Scanner scanner=new Scanner(str);
       
       while (scanner.hasNext())
       {
           temp = scanner.next();
           if(temp.equalsIgnoreCase("*")){}
       }
     
        
    
    return cNum;
    }
    
}
