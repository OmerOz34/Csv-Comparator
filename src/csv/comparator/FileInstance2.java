/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csv.comparator;

import java.util.Comparator;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author omer.kemal
 */
public class FileInstance2 {
    


    private  SimpleIntegerProperty  No;
    private  SimpleStringProperty  Machine_name;
    private  SimpleStringProperty  Color_Total;
    private  SimpleStringProperty  Black_Total;
   
    public FileInstance2(){}
    public FileInstance2(int No,String Machine_name, String Color_Total, String Black_Total) {
        this.No=new SimpleIntegerProperty(No++);
        this.Machine_name= new SimpleStringProperty(Machine_name);
        this.Color_Total= new SimpleStringProperty(Color_Total); 
        this.Black_Total = new SimpleStringProperty(Black_Total);
    }
       
    public int getNo() {
        return No.get();
    }

    public void setNo(int n) {
        No.set(n);
    }
    
    public String getMachine_name() {
        return Machine_name.get();
    }

    public void setMachine_name(String mname) {
        Machine_name.set(mname);
    }

    public String getColor_Total() {
        return Color_Total.get();
    }

    public void setColor_Total(String ct) {
        Color_Total.set(ct);
    }

    public String getBlack_Total() {
        return Black_Total.get();
    }

    public void setBlack_Total(String bt) {
        Black_Total.set(bt);
    }


    
    public static Comparator<FileInstance2> FiComparator = (FileInstance2 s1, FileInstance2 s2) -> {
        String f1 = s1.getMachine_name().toUpperCase();
        String f2 = s2.getMachine_name().toUpperCase();
        
        //ascending order
        return f1.compareTo(f2);
        
        //descending order
        //return StudentName2.compareTo(StudentName1);
    };
    
   
    
    

    
    


}
