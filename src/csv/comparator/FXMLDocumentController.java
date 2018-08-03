
package csv.comparator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.image.ImageView;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;


public class FXMLDocumentController implements Initializable {
 
    DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd-HH.mm.ss");
    String file1name,file2name;
    String[] tableNames ={"table1","table2","table3","table4","table5"};
    String path1="", path2="";
    List<FileInstance2> temp=new ArrayList<>();
    List<FileInstance> list1=new ArrayList<>(); 
    List<FileInstance> list3=new ArrayList<>(); 
    List<FileInstance> list2=new ArrayList<>(); 
    List<FileInstance> only1=new ArrayList<>(); 
    List<FileInstance> only2=new ArrayList<>(); 
    Moduls moduls=new Moduls();
    
    
    
    @FXML
    private Button button_Clean_table;
    @FXML
    private Button printFile;
    @FXML
    private AnchorPane anchorid;
    @FXML
    private Button printFileD;
    @FXML
    private Label file1;
    @FXML
    private Label file2;
    @FXML
    private Label file3;
    @FXML
    private Label onlyf1;
    @FXML
    private Label onlyf2;
    @FXML
    private Label nameoutput;
    @FXML
    private Button sort;
    @FXML
    private TableView<FileInstance2> table1;
    @FXML
    private ImageView ImgView2_darg_drop;
    @FXML
    private ImageView ImgView1_drag_drop;
    @FXML
    private TableColumn table1c1;
    @FXML
    private TableColumn table1c2;
    @FXML
    private TableColumn table1c3;
    @FXML
    private TableColumn table1No;
    @FXML
    private TableView<FileInstance2> table2;
    @FXML
    private TableColumn table2No;
    @FXML
    private TableColumn table2c1;
    @FXML
    private TableColumn table2c2;
    @FXML
    private TableColumn table2c3;
    @FXML
    private TableView<FileInstance2> table3;
    @FXML
    private TableColumn table3No;
    @FXML
    private TableColumn table3c1;
    @FXML
    private TableColumn table3c2;
    @FXML
    private TableColumn table3c3;
    @FXML
    private TableView<FileInstance2> table4;
    @FXML
    private TableColumn table4No;
    @FXML
    private TableColumn table4c1;
    @FXML
    private TableColumn table4c2;
    @FXML
    private TableColumn table4c3;
    @FXML
    private TableView<FileInstance2> table5;
    @FXML
    private TableColumn table5No;
    @FXML
    private TableColumn table5c1;
    @FXML
    private TableColumn table5c2;
    @FXML
    private TableColumn table5c3;
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    file1.setVisible(false);
    file2.setVisible(false);
    file3.setVisible(false);
    onlyf1.setVisible(false);
    onlyf2.setVisible(false);
    nameoutput.setVisible(false);
    
    table2No.setCellValueFactory(
            new PropertyValueFactory<>("No")); table2No.getStyleClass().add("foo");;
    table2c1.setCellValueFactory(
            new PropertyValueFactory<>("Machine_name"));
    table2c2.setCellValueFactory(
            new PropertyValueFactory<>("Color_Total"));
    table2c3.setCellValueFactory(
            new PropertyValueFactory<>("Black_Total"));
    table2.getColumns().addAll(table2No,table2c1,table2c2,table2c3);
    
    
     table3No.setCellValueFactory(
            new PropertyValueFactory<>("No"));
    table3c1.setCellValueFactory(
            new PropertyValueFactory<>("Machine_name"));
    table3c2.setCellValueFactory(
            new PropertyValueFactory<>("Color_Total"));
    table3c3.setCellValueFactory(
            new PropertyValueFactory<>("Black_Total"));
    table3.getColumns().addAll(table3No,table3c1,table3c2,table3c3);
    
    
    
       table4No.setCellValueFactory(
            new PropertyValueFactory<>("No"));
    table4c1.setCellValueFactory(
            new PropertyValueFactory<>("Machine_name"));
    table4c2.setCellValueFactory(
            new PropertyValueFactory<>("Color_Total"));
    table4c3.setCellValueFactory(
            new PropertyValueFactory<>("Black_Total"));
    table4.getColumns().addAll(table4No,table4c1,table4c2,table4c3);
    
    
    
       table5No.setCellValueFactory(
            new PropertyValueFactory<>("No"));
    table5c1.setCellValueFactory(
            new PropertyValueFactory<>("Machine_name"));
    table5c2.setCellValueFactory(
            new PropertyValueFactory<>("Color_Total"));
    table5c3.setCellValueFactory(
            new PropertyValueFactory<>("Black_Total"));
    table5.getColumns().addAll(table5No,table5c1,table5c2,table5c3);
    
    
    
    
    
       table1No.setCellValueFactory(
            new PropertyValueFactory<>("No"));
    table1c1.setCellValueFactory(
            new PropertyValueFactory<>("Machine_name"));
    table1c2.setCellValueFactory(
            new PropertyValueFactory<>("Color_Total"));
    table1c3.setCellValueFactory(
            new PropertyValueFactory<>("Black_Total"));
    table1.getColumns().addAll(table1No,table1c1,table1c2,table1c3);
    
        table1.getItems().clear(); list1.clear();  table1.setPlaceholder(new Label("NO CONTENT"));
        table2.getItems().clear(); list2.clear();  table2.setPlaceholder(new Label("NO CONTENT"));
        table3.getItems().clear(); list3.clear();  table3.setPlaceholder(new Label("NO CONTENT"));
        table4.getItems().clear(); only1.clear();  table4.setPlaceholder(new Label("NO CONTENT"));
        table5.getItems().clear(); only2.clear();  table5.setPlaceholder(new Label("NO CONTENT"));
        
    }   
    
    

    
     @FXML
     void HandleDragDrop1(DragEvent event) {
        try{
            
        List<File> files=event.getDragboard().getFiles();
        path1=files.get(0).getAbsolutePath();
        file1name=files.get(0).getName();
        //  DOSYA TÜRÜ KONTROLÜ
        if(!path1.endsWith(".csv"))
        {
            path1="";
             Alert alert = new Alert(AlertType.INFORMATION);
              alert.setHeaderText(null);
              alert.setTitle("Information");        
              alert.setContentText("ERROR : Wrong File Extension");
              alert.showAndWait();
        }
        else{
            
        // RED FILE 1 AND SAVE IN LIST1
        list1= moduls.getList(path1,list1);
        
        // DISPLAY LIST1 IN TABLE1
        
        PutONTable(list1,tableNames[0]); 
        file1.setVisible(true);
        file1.setText(file1name);

        // COMPARE FILE1 AND FILE2 IF TWO OF THEM ARE READ
       if(!path1.equals("") && !path2.equals("")){
       
       list3=moduls.Compare(list1,list2);
       
       
       only1=moduls.only(list1,list2) ;   // RETURN DATA THAT FILE 1 HAS AND FILE 2 DOESNT HAVE
       only2=moduls.only(list2,list1) ;   //RETURN DATA THAT FILE 1 HAS AND FILE 2 DOESNT HAVE
       list3=moduls.onlyList(list1,list3);  // PUT ONLY1 FILE INTO FILE3
       list3=moduls.onlyList(list2,list3);   //PUT ONLY2 FILE INTO FILE3
       //DISPLAY LIST3 IN TABLE3
       PutONTable(list3,tableNames[2]);
       file3.setVisible(true);
       file3.setText("Compared File");
       
        //DISPLAY ONLY1 IN TABLE4
       PutONTable(only1,tableNames[3]);
       onlyf1.setVisible(true);
       onlyf1.setText("Data In Only File 1");
       
        //DISPLAY ONLY2 IN TABLE5
       PutONTable(only2,tableNames[4]);
       onlyf2.setVisible(true);
       onlyf2.setText("Data In Only File 2");

        }
 
    } }
        catch(Exception e){
              Alert alert = new Alert(AlertType.INFORMATION);
              alert.setTitle("Information");        
              alert.setContentText("ERROR : "+e);
              alert.showAndWait();
    }
       }
 

    
    @FXML
     void HandleDragDrop2(DragEvent event) {
      try{
        List<File> files=event.getDragboard().getFiles();
        path2=files.get(0).getAbsolutePath();
        file2name=files.get(0).getName();
        //  DOSYA TÜRÜ KONTROLÜ
        if(!path2.endsWith(".csv"))
        {
            path2="";
            Alert alert = new Alert(AlertType.INFORMATION);
              alert.setHeaderText(null);
              alert.setTitle("Information");        
              alert.setContentText("ERROR : Wrong File Extension");
              alert.showAndWait();
        
       }
        else {
            
            
        list2= moduls.getList(path2,list2);

        
        PutONTable(list2,tableNames[1]);  
       file2.setVisible(true);
       file2.setText(file2name);
        
       if(!path1.equals("") && !path2.equals("")){
       
       list3=moduls.Compare(list1,list2);
     
       
       only1=moduls.only(list1,list2) ;
       only2=moduls.only(list2,list1) ;
       list3=moduls.onlyList(list1,list3);
       list3=moduls.onlyList(list2,list3);
       PutONTable(list3,tableNames[2]);
       file3.setVisible(true);
       file3.setText("Compared File");
       
       PutONTable(only1,tableNames[3]);
       onlyf1.setVisible(true);
       onlyf1.setText("Data In Only File 1");
       
       PutONTable(only2,tableNames[4]);
       onlyf2.setVisible(true);
       onlyf2.setText("Data In Only File 2");
          
  
        }     
    }} catch(Exception e){
    Alert alert = new Alert(AlertType.INFORMATION);
              alert.setHeaderText(null);
              alert.setTitle("Information");        
              alert.setContentText("ERROR : Wrong File Extension");
              alert.showAndWait();
    }

       }

         
     
        void PutONTable(List<FileInstance> list,String value){
            
         ObservableList<FileInstance2> data = FXCollections.observableArrayList ();
           for(int i=0;i<list.size();i++)
           {
          data.add(new FileInstance2((i+1),list.get(i).getMachine_name(),list.get(i).getColor_Total(),list.get(i).getBlack_Total() ));
           }
        
           //GET LISTS AND TABLE NAMES AND DISPLAY DATA IN THE TABLES
           if(value.equals("table1"))
            table1.setItems(data); 
           else if(value.equals("table2"))
            table2.setItems(data);
           else if(value.equals("table3"))
            table3.setItems(data);
           else if(value.equals("table4"))
            table4.setItems(data); 
           else
           table5.setItems(data);
    }
     
     
     
     
     
     @FXML
     void HandleDragOver1(DragEvent event) {
        if(event.getDragboard().hasFiles()){
        event.acceptTransferModes(TransferMode.ANY);}
    }
        
    
  @FXML
     void HandleDragOver2(DragEvent event) {
        
        if(event.getDragboard().hasFiles()){
        event.acceptTransferModes(TransferMode.ANY);             
        }               
    }
     
     
     
   // CLEAN THE TABLES' CONTENTS FOR NEW COMPARISON
    @FXML
    private void clean(ActionEvent event) {
        
    path1="";
    path2="";
    file1.setVisible(false);
    file2.setVisible(false);
    file3.setVisible(false);
    onlyf1.setVisible(false);
    onlyf2.setVisible(false);
    nameoutput.setVisible(false);
    
        table1.getItems().clear(); list1.clear();  table1.setPlaceholder(new Label("NO CONTENT"));
        table2.getItems().clear(); list2.clear();  table2.setPlaceholder(new Label("NO CONTENT"));
        table3.getItems().clear(); list3.clear();  table3.setPlaceholder(new Label("NO CONTENT"));
        table4.getItems().clear(); only1.clear();  table4.setPlaceholder(new Label("NO CONTENT"));
        table5.getItems().clear(); only2.clear();  table5.setPlaceholder(new Label("NO CONTENT"));
     
    }

    // WRITE FCOMPARED FILE ON A SPECIFIED DIRECTORY
    @FXML
    private void PrintFile(ActionEvent event) {
         Date date=new Date();
         try{  if(list3.size()>0){
             
             
             
             DirectoryChooser dc = new DirectoryChooser();
          dc.setTitle("Select Directory");
          Stage stage=(Stage)anchorid.getScene().getWindow();
          File f=dc.showDialog(stage);
          String directoryPath =f.getAbsolutePath()+"/"+"/CSV-"+dateFormat.format(date)+".csv";
          File fout = new File(directoryPath);
	  FileOutputStream fos = new FileOutputStream(fout);
	  BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
          
             bw.write("Machine Name"+";"+"Full Color:Total"+";"+"Black:Total");
             bw.newLine();
           for(int i=0;i<list3.size();i++){
             bw.write(list3.get(i).getMachine_name()+";"+list3.get(i).getColor_Total()+";"+list3.get(i).getBlack_Total()); 
             bw.newLine();
             }
            bw.close();
            
              nameoutput.setText("File Name : "+fout.getName());
              nameoutput.setVisible(true);
            Alert alert = new Alert(AlertType.INFORMATION);
              alert.setHeaderText(null);
              alert.setTitle("Information");        
              alert.setContentText("File Successfully Created..");
              alert.showAndWait();
              
         
          }
         else {
              Alert alert = new Alert(AlertType.INFORMATION);
              alert.setHeaderText(null);
              alert.setTitle("Information");        
              alert.setContentText("Could Not Find The Compared Data");
              alert.showAndWait();
         }
         }
         catch(Exception e){
          Alert alert = new Alert(AlertType.INFORMATION);
              alert.setTitle("Information"); 
              alert.setHeaderText(null);
              alert.setContentText("ERROR :"+e);
              alert.showAndWait();
         }    
           
         }

    
    
    
    
    
    //WRITE FCOMPARED FILE ON DESKTOP
    @FXML
    private void PrintFileDesktop(ActionEvent event) {
        Date date=new Date();
        String desktopPath = System.getProperty("user.home") + "/Desktop"+"/CSV-"+dateFormat.format(date)+".csv";
        try{if(list3.size()>0){
    File fout = new File(desktopPath);
	FileOutputStream fos = new FileOutputStream(fout);
 
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
           
         bw.write("Machine Name"+";"+"Full Color:Total"+";"+"Black:Total");
         bw.newLine();
         
           for(int i=0;i<list3.size();i++){
             bw.write(list3.get(i).getMachine_name()+";"+list3.get(i).getColor_Total()+";"+list3.get(i).getBlack_Total()); 
             bw.newLine();
             }
           bw.close();  
           nameoutput.setText("Dosya Adı : "+fout.getName());
           nameoutput.setVisible(true);
              Alert alert = new Alert(AlertType.INFORMATION);
              alert.setHeaderText(null);
              alert.setTitle("Information");        
              alert.setContentText("File Successfully Created..");
              alert.showAndWait();                    
             
          }  else {
              Alert alert = new Alert(AlertType.INFORMATION);
              alert.setHeaderText(null);
            alert.setTitle("Information");        
              alert.setContentText("Could Not Find The Compared Data");
              alert.showAndWait();
         }
    }catch(Exception e){
              Alert alert = new Alert(AlertType.INFORMATION);
              alert.setHeaderText(null);
               alert.setTitle("Information");        
              alert.setContentText("Could Not Find The Compared Data");
              alert.showAndWait();
          }    
        
     }    

    
    //SORT TABLES' CONTENT ACCORDING TO MACHINE NAME
    @FXML
    private void Sort(ActionEvent event) {
    
        
    Collections.sort(list1, FileInstance.FiComparator);
    Collections.sort(list2, FileInstance.FiComparator);
    Collections.sort(list3, FileInstance.FiComparator);
    Collections.sort(only1, FileInstance.FiComparator);
    Collections.sort(only2, FileInstance.FiComparator);
    
    table1.getItems().clear();
    table2.getItems().clear();
    table3.getItems().clear();
    table4.getItems().clear();
    table5.getItems().clear();
    
    
    PutONTable(list1,tableNames[0]);
    PutONTable(list2,tableNames[1]);
    PutONTable(list3,tableNames[2]);
    PutONTable(only1,tableNames[3]);
    PutONTable(only2,tableNames[4]);
    
    
    
    
    
    
    
}  
    
     }
