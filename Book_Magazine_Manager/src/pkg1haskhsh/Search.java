//Tsoulos Sotirios 
//ICSD13190
package pkg1haskhsh;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Search extends JFrame {
    private ObjectInputStream inF;
    private ArrayList <Research> ObjectList;
    private boolean Exist=false;
    
    public Search (String Search){
        
        
        
        ObjectList = new ArrayList();
        
        //Vazw sto Arraylist ObjectList ola ta objects pou periexei to arxeio
        try {
            
            FileInputStream fis = new FileInputStream("Object.txt");
            
            //Code gia error StreamCorruptedException: invalid type code: AC
            //if(FirstTime==false){
                inF = new ObjectInputStream(fis);
           //     FirstTime=true;
           // }
            
            Research RS = new Research(){};
            //Oso yparxoun objects na diavastoun 
            while(fis.available()>0){
                try {
                    //Ta vazv sthn arraylist apo objects
                    RS= (Research) inF.readObject();
                    inF.close();

                    //Oso mporei na diavasei
                    if(RS!=null){
                        ObjectList.add(RS);
                    }
                    
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                
                
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        ///psaxnw sthn arraylist
        for(int i=0;i<ObjectList.size();i++){
            //Psaxnw tous titlous
            if(ObjectList.get(i).OnomaVivliou.equalsIgnoreCase(Search)){
                Results WA = new Results ("Title",ObjectList.get(i));
                Exist=true;
            }
            
            //Psaxnw tous sugrafeis
            for(int j=0;j<ObjectList.get(i).Authors.size();j++){
                if(Search.equalsIgnoreCase(ObjectList.get(i).Authors.get(j))){
                    Results WA = new Results ("Author",ObjectList.get(i));
                    Exist=true;
                }
            }
        }
        
        if(Exist==false){
            JOptionPane.showMessageDialog(this, "Does not Exist Try Again ","Warning",JOptionPane.WARNING_MESSAGE);
            Window AW= new Window();
            
        }
        
    }
    
}
    

