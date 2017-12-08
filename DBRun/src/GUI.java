/**
 * @author Aplomb
 */

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI extends JFrame implements ActionListener
{
    private JPanel panel1, panel2, panel3;
    
      private String defalt = "Select * from show_all";
    
JTextField txtInput = new JTextField("");

private String input1, input2, input3, input4, input5;

public GUI()
 {
 JFrame guiFrame = new JFrame();
 
 //make sure the program exits when the frame closes
 guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 guiFrame.setTitle("DBMS GUI");
 guiFrame.setSize(1100,600);
 
 //This will center the JFrame in the middle of the screen
 guiFrame.setLocationRelativeTo(null);
 
 //Options for the JComboBox 
// String[] fruitOptions = {"Apple", "Apricot", "Banana"
// ,"Cherry", "Date", "Kiwi", "Orange", "Pear", "Strawberry"};
 
 //Options for the JList
 String[] tableOption = {"Drug Name", "Drug Class", "Drug Function", "Suggested dosing"
 };
 
 //The first JPanel contains a JLabel and JCombobox
 //final JPanel comboPanel = new JPanel();
 panel1 = new JPanel();
 //JLabel comboLbl = new JLabel("Fruits:");
 //JComboBox fruits = new JComboBox(fruitOptions);
 
 JButton Select = new JButton( "Pull information");
 JButton Insert = new JButton( "Insert info");
 JButton Update = new JButton( "Update info");
 JButton Delete = new JButton( "Delete info");
 JButton Interact = new JButton( "Test Drug Interaction");
 
 panel1.add(Select);
 panel1.add(Insert);
 panel1.add(Update);
 panel1.add(Delete);
 panel1.add(Interact);
 
 
 
 //Create the second JPanel. Add a JLabel and JList and
 //make use the JPanel is not visible.
 //final JPanel listPanel = new JPanel();
 panel2 = new JPanel();
 panel2.setVisible(false);
 JLabel listLbl = new JLabel("Tables:");
 JList vegs = new JList(tableOption);
 vegs.setLayoutOrientation(JList.HORIZONTAL_WRAP);
 
 panel2.add(listLbl);
 panel2.add(vegs);
 
 
 //The ActionListener class is used to handle the
 //event that happens when the user clicks the button.
 //As there is not a lot that needs to happen we can 
 //define an anonymous inner class to make the code simpler.
 Select.addActionListener(new ActionListener()
 {
 @Override
 public void actionPerformed(ActionEvent event)
 {
 //When the fruit of veg button is pressed
 //the setVisible value of the listPanel and
 //comboPanel is switched from true to 
 //value or vice versa.

// panel1.setVisible(!panel1.isVisible());
 
       input1 = JOptionPane.showInputDialog(panel1, "If input box is empty, default will dispaly all", "input for  Select statement",
        JOptionPane.PLAIN_MESSAGE);
        
        String str;
      
        if(input1.equals("")|| input1.equals(null)){str = defalt;}
        else{str = input1;}
        
        RunDB db1 = new RunDB(str);
        
        panel2.setVisible(!panel2.isVisible());     
 }
 });
 
 Insert.addActionListener(new ActionListener()
 {
 @Override
 public void actionPerformed(ActionEvent event)
 {   Selection insert = new Selection();  
 
     input1 = JOptionPane.showInputDialog(panel1, "Enter Drug's Brand Name", "Insert Input Box1",
         JOptionPane.PLAIN_MESSAGE);
         
         insert.setBrand(input1);
 
        input2 = JOptionPane.showInputDialog(panel1, "Enter Drug's Generic Name", "Insert Input Box2",
        JOptionPane.PLAIN_MESSAGE);
        
        insert.setGeneric(input2);
        
        input3 = JOptionPane.showInputDialog(panel1, "Enter Drug Class", "Insert Input Box3",
        JOptionPane.PLAIN_MESSAGE);
        
        insert.setClass(input3);
        
        input4 = JOptionPane.showInputDialog(panel1, "Enter Drug Function", "Insert Input Box4",
        JOptionPane.PLAIN_MESSAGE);
        
        insert.setFunction(input4);
        
        input5 = JOptionPane.showInputDialog(panel1, "Enter Drug's Dosing Info", "Insert Input Box5",
        JOptionPane.PLAIN_MESSAGE);
        
        insert.setDosing(input5);
        
        String str = insert.cmdOut();
        
        RunDB db1 = new RunDB(str);
        
        panel2.setVisible(!panel2.isVisible());
 }
 });
 
  Update.addActionListener(new ActionListener()
 {
 @Override
 public void actionPerformed(ActionEvent event)
 {     Selection update = new Selection();
     
     input1 = JOptionPane.showInputDialog(panel1, "Enter Drug's Name", "Update Input Box",
         JOptionPane.PLAIN_MESSAGE);
     
     String str = update.searchQ(input1);
     
     RunDB db1 = new RunDB(str);
 
          input1 = JOptionPane.showInputDialog(panel1, "Enter Drug's Brand Name", "Update Input Box1",
         JOptionPane.PLAIN_MESSAGE);
 
          update.setBrand(input1);
          
        input2 = JOptionPane.showInputDialog(panel1, "Enter Drug's Generic Name", "Update Input Box2",
        JOptionPane.PLAIN_MESSAGE);
        
        update.setGeneric(input2);
        
        input3 = JOptionPane.showInputDialog(panel1, "Enter Drug Class", "Update Input Box3",
        JOptionPane.PLAIN_MESSAGE);
        
        update.setClass(input3);
        
        input4 = JOptionPane.showInputDialog(panel1, "Enter Drug Function", "Update Input Box4",
        JOptionPane.PLAIN_MESSAGE);
        
        update.setFunction(input4);
        
        input5 = JOptionPane.showInputDialog(panel1, "Enter Drug's Dosing Info", "Update Input Box5",
        JOptionPane.PLAIN_MESSAGE);
        
        update.setDosing(input5);
        
        str = update.cmdOut();
        
        RunDB db2 = new RunDB(str);
        
        panel2.setVisible(!panel2.isVisible());
 }
 });
 
  Delete.addActionListener(new ActionListener()
 {
 @Override
 public void actionPerformed(ActionEvent event)
 {
        Selection delete = new Selection();     
  
        input1 = JOptionPane.showInputDialog(panel1, "Delete", "input for  Deletion",
        JOptionPane.PLAIN_MESSAGE);
        
      String str = delete.searchQ(input1);
      
      RunDB db1 = new RunDB(str);
      
        panel2.setVisible(!panel2.isVisible());     
 }
 });
  
   Interact.addActionListener(new ActionListener()
 {
 @Override
 public void actionPerformed(ActionEvent event)
 { 
     Selection interact = new Selection();
     
        input1 = JOptionPane.showInputDialog(panel1, "Enter Drug1", "input for  Drug interaction",
        JOptionPane.PLAIN_MESSAGE);
        
        interact.searchQ(input1);
        
         input2 = JOptionPane.showInputDialog(panel1, "Enter Drug 2", "input for Drug interaction",
        JOptionPane.PLAIN_MESSAGE);
         
        String str = interact.action(input1, input2);
         
         RunDB db1 = new RunDB(str);
         
        panel2.setVisible(!panel2.isVisible());     
 }
 });
 
 
 //The JFrame uses the BorderLayout layout manager.
 //Put the two JPanels and JButton in different areas.
 guiFrame.add(panel1, BorderLayout.NORTH);
 guiFrame.add(panel2, BorderLayout.CENTER);
 
 
 //make sure the JFrame is visible
 guiFrame.setVisible(true);
 }

  public void actionPerformed(ActionEvent event)
    { 
        
      //  input = txtInput.getText();   //receive input from text field
      //  System.out.println(input);
    }
  
}

    
    
    

