/**
 * @author Aplomb Huang && Peter Trand
 * CMSC 508 PROJECT
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBRun {
    
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        InputFilter filter= new InputFilter();
        Scanner scanner=new Scanner(System.in);
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@jasmine.cs.vcu.edu:20037:xe", "huangat2", "V00800816");
            stmt = con.createStatement();
           // String input = scanner.nextLine(); //Reads input for query
           // String filtered=filter.Filter(input); //Filters input for characters used in SQL Injections 
            rs = stmt.executeQuery("SELECT * FROM drug_Names");
            while(rs.next()) {
               // System.out.print(rs.getString(1) + "\t");
                System.out.println(rs.getString("Brand_Name")  + "\t");
               // System.out.println(rs.getString(3));
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
