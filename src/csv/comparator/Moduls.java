
package csv.comparator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;


public class Moduls {
    
    List<FileInstance> only1=new ArrayList<>();    
    List<FileInstance> only2=new ArrayList<>(); 
    List<FileInstance> list3=new ArrayList<>(); 
    BufferedReader br = null;
        String line = "";
        String empty = "";
        String cvsSplitBy = ";";
        int indisMN,indisTC,indisTB,header;
        String NoData="NoData";
       int counter=1;
    
    
    
    List<FileInstance> getList(String path1,List<FileInstance> list1){
    
    try{
        header=0;
    br = new BufferedReader(new FileReader(path1));
            while ((line = br.readLine()) != null) 
         
              if(line.replaceAll(";","").equals(empty)){}
                
                else{    
                String[] values = line.split(cvsSplitBy);
                if(header==0){
                for(int i=0;i<values.length;i++){             
                if(values[i].equals("Machine Name")) {indisMN=i;}
                if(values[i].equals("Full Color:Total")) {indisTC=i;}
                if(values[i].equals("Black:Total")) {indisTB=i;}
                header=1;         
               
                } //continue;
                }
                
                FileInstance fi=new FileInstance();
                   fi.setCv1(false);
                   fi.setCv2(false);
                if(  values[indisMN].equals("Machine Name") || values[indisTC].equals("Full Color:Total") || values[indisTB].equals("Black:Total")  )
                    continue;
                if(values[indisMN].equals("NoData") || values[indisMN].equals("")  ) { values[indisMN]="NoData"; }
                if(values[indisTC].equals("NoData") || values[indisTC].equals("") ) { values[indisTC]="NoData" ;fi.setCv1(true); }
                if(values[indisTB].equals("NoData") || values[indisTB].equals("")  ) { values[indisTB]="NoData" ;fi.setCv2(true); }
                 
                   fi.setMachine_name(values[indisMN]);
                   fi.setColor_Total(values[indisTC]);
                   fi.setBlack_Total(values[indisTB]);
                   
                  list1.add(fi);                 
                 
                
                          
            }
            }
       
       
    
    catch(IOException e){
    
       Alert alert = new Alert(Alert.AlertType.INFORMATION);
              alert.setTitle("Information");  
              alert.setHeaderText(null);
              alert.setContentText("ERROR :"+e);
              alert.showAndWait();
    
    }
     
     return list1;
}   

    
    List<FileInstance>  Compare(List<FileInstance> list1,List<FileInstance> list2){
    
    try{
   for(int i=0;i<list1.size();i++){
      for(int j=0;j<list2.size();j++){
      
        if(list1.get(i).getMachine_name().equals(list2.get(j).getMachine_name()))
      {
      FileInstance fi=new FileInstance();
      fi.setMachine_name(list1.get(i).getMachine_name());
      
      
           if(list1.get(i).getCv1()==true || list2.get(j).getCv1()==true ){    
          fi.setColor_Total(NoData);       
      }
            else{
               fi.setCv1(false); fi.setCv2(false);
           fi.setColor_Total(Integer.toString(Math.abs((Integer.parseInt(list1.get(i).getColor_Total())-Integer.parseInt(list2.get(j).getColor_Total())))));          
      }
     
           if(list1.get(i).getCv2()==true || list2.get(j).getCv2()==true ){    
           fi.setBlack_Total(NoData);       
      }
           else{
         fi.setCv1(false); fi.setCv2(false);
      fi.setBlack_Total(Integer.toString(Math.abs((Integer.parseInt(list1.get(i).getBlack_Total())-Integer.parseInt(list2.get(j).getBlack_Total())))));          
      }
      
      list3.add(fi);  
      }
      
      
      
      }
    }
    
   
   list3=onlyList(list2,list3);
   list3=onlyList(list1,list3);

   
    
    }
    catch(Exception e){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information"); 
        alert.setHeaderText(null);
              alert.setContentText("ERROR :"+e);
        alert.showAndWait();

    }
    return list3; 
}
    
    
    
    List<FileInstance> onlyList(List<FileInstance> list2,List<FileInstance> list3){
        try{
        counter=0;
    for(int i=0;i<list2.size();i++)
    {
    for(int j=0;j<list3.size();j++)
    { 
    if(list2.get(i).getMachine_name().equals(list3.get(j).getMachine_name()))
    {  
       counter=1;
    }  
 
    }
    if(counter==0){
    FileInstance fi=new FileInstance();
       fi.setMachine_name(list2.get(i).getMachine_name());
      fi.setColor_Total(list2.get(i).getColor_Total()); 
      fi.setBlack_Total(list2.get(i).getBlack_Total());
      list3.add(fi);
     
    }
    counter=0;
    }
        
        }
        catch(Exception e){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information"); 
            alert.setHeaderText(null);
              alert.setContentText("ERROR :"+e);
              alert.showAndWait();
        }
        return list3;
}
    
    List<FileInstance> only(List<FileInstance> list2,List<FileInstance> list3){
        List<FileInstance> returnlist=new ArrayList<>(); 
        try{         
        counter=0;
    for(int i=0;i<list2.size();i++)
    {
    for(int j=0;j<list3.size();j++)
    { 
    if(list2.get(i).getMachine_name().equals(list3.get(j).getMachine_name()))
    {  
       counter=1;
    }  
    }
    if(counter==0){
    FileInstance fi=new FileInstance();
       fi.setMachine_name(list2.get(i).getMachine_name());
      fi.setColor_Total(list2.get(i).getColor_Total()); 
      fi.setBlack_Total(list2.get(i).getBlack_Total());
      returnlist.add(fi);
     
    }
    counter=0;
    }
        

}
         catch(Exception e){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Information");
             alert.setHeaderText(null);
              alert.setContentText("ERROR :"+e);
              alert.showAndWait();
        }
      return returnlist;  
    }
    
    } 
