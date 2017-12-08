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

public class RunDB {
    
    public RunDB(String str){
              
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@jasmine.cs.vcu.edu:20037:xe", "huangat2", "V00800816");
            stmt = con.createStatement();
          
            rs = stmt.executeQuery(str);
           
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
