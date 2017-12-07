/**
 * @author Aplomb Huang && Peter Trand
 * CMSC 508 PROJECT
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBRun {
    
    public static void main(String[] args) {
        
        GUI ui = new GUI();
        
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        
       
    //    InputFilter filter= new InputFilter();
    //    Scanner scanner=new Scanner(System.in);
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@jasmine.cs.vcu.edu:20037:xe", "huangat2", "V00800816");
            stmt = con.createStatement();
            
           // String input = scanner.nextLine(); //Reads input for query
           // String filtered=filter.Filter(input); //Filters input for characters used in SQL Injections 
            rs = stmt.executeQuery("SELECT * FROM drug_Names");
   
          ResultSetMetaData metadata = rs.getMetaData();
          int columnCount = metadata.getColumnCount();
          for (int i=2; i<=columnCount; i++) 
            {
           String columnName = metadata.getColumnName(i);
          System.out.print(columnName + "\t");
          
            }
           System.out.println();  
            while(rs.next()) {
              
                for (int i = 2; i <= columnCount; i++) {
                        System.out.print(rs.getString(i) + "\t");    
                    }
                System.out.println();
      
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    
}
