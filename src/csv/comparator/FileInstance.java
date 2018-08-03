/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csv.comparator;

import java.util.Comparator;

/**
 *
 * @author omer.kemal
 */
public class FileInstance {
    
    private  String Machine_name;
    private  String Color_Total;
    private  String Black_Total;
    private  Boolean cv1,cv2; 

    public FileInstance(){}
    public FileInstance(String Machine_name, String Color_Total, String Black_Total, Boolean cv1, Boolean cv2) {
       
        this.Machine_name = Machine_name;
        this.Color_Total  = Color_Total;
        this.Black_Total  =Black_Total;
        this.cv1 =cv1;
        this.cv2 =cv2;}
        
    public String getMachine_name() {
        return Machine_name;
    }

    public void setMachine_name(String Machine_name) {
        this.Machine_name = Machine_name;
    }

    public String getColor_Total() {
        return Color_Total;
    }

    public void setColor_Total(String Color_Total) {
        this.Color_Total = Color_Total;
    }

    public String getBlack_Total() {
        return Black_Total;
    }

    public void setBlack_Total(String Black_Total) {
        this.Black_Total = Black_Total;
    }

    public Boolean getCv1() {
        return cv1;
    }

    public void setCv1(Boolean cv1) {
        this.cv1 = cv1;
    }

    public Boolean getCv2() {
        return cv2;
    }

    public void setCv2(Boolean cv2) {
        this.cv2 = cv2;
    }
   
     
    public static Comparator<FileInstance> FiComparator = (FileInstance s1, FileInstance s2) -> {
        String f1 = s1.getMachine_name().toUpperCase();
        String f2 = s2.getMachine_name().toUpperCase();
        
        //ascending order
        return f1.compareTo(f2);
        
        //descending order
        //return StudentName2.compareTo(StudentName1);
    };
    
    
    
    
       
    }
    
    
    

    
    

