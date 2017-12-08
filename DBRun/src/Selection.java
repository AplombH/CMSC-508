/**
 *
 * @author Aplomb
 */

public class Selection {
    
    private String b_Name = "";
    private String g_Name = "";
    private String c_Name = "";
    private String function = "";
    private String dosing = "";
    private String cmd = "";
    
    
    public Selection(){}
    
    public String cmdOut()
    {
        return cmd;
    }
    
    public void setBrand(String str){b_Name = str;}
    
    public void setGeneric(String str){g_Name = str;}
    
    public void setClass (String str){c_Name = str;}
    
    public void setFunction(String str){function = str;}
    
    public void setDosing (String str){dosing = str;}
    
    public String searchQ(String str)
    {
        return cmd;
    }
    
    public String delQ(String str)
    {return cmd;}
    
    public String action(String str1, String str2)
    {
        return cmd;
    }
}
