//Tsoulos Sotirios 
//ICSD13190
package pkg1haskhsh;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Input extends JFrame implements ActionListener {
    private JTextField IsbnTF,TitlePeriodikoTF,NumberSelidesTF,EtosTF,MagazineVolumeTF,SelidaDhmosieushsTF;
    private JComboBox AuthorsNumber;
    private JTextField OnomaVivliouTF;
    private JTextField[] Authors;  
    private JFormattedTextField HmeromhniaEkdoshsTF;
    
    private JLabel IsbnLA,TitlePeriodikoLA,NumberSelidesLA,EtosLA,MagazineVolumeLA,SelidaDhmosieushsLA;
    private JLabel OnomaVivliouLA,HmeromhniaEkdoshsLA,AuthorNumberLA;
    private String[] ComboBoxNumbers= {"1","2","3","4","5","6","7","8"};
    private JPanel MagazinePanel,BookPanel;
    
    private JButton Submit,AuthorsButton;
    
    private String Eidos;
    
    DateFormat df;
    private Authors w;
    
    private  ObjectOutputStream out;
    
    
    //Constructor tou Window  
    public Input (String EidosResearch){
        
        super("Î•Î¹ÏƒÎ±Î³Ï‰Î³Î® Î£Ï„Î¿Î¹Ï‡ÎµÎ¯Ï‰Î½");
        
        setSize(600,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
        //Ftiaxnw ta Textfields kai ta JLabels kai ta JButtons
        IsbnLA = new JLabel("Give Article Title:");
        AuthorNumberLA = new JLabel("Give Number of authors:");
        
        IsbnTF = new JTextField(15);
        AuthorsNumber = new JComboBox(ComboBoxNumbers);   
        
        AuthorsButton = new JButton("Which Authors");
        AuthorsButton.addActionListener(this);
        Submit = new JButton("Sumbit");
        Submit.addActionListener(this);
        
        BoxLayout box = new BoxLayout(MagazinePanel,BoxLayout.LINE_AXIS);
        BoxLayout box2 = new BoxLayout(BookPanel,BoxLayout.LINE_AXIS);
        
        
        if(EidosResearch.equalsIgnoreCase("Magazine")){
            
            
            MagazinePanel = new JPanel();
            Eidos = "Magazine";
            
            
            //Ftiaxnw Ta JLabels
            TitlePeriodikoLA = new JLabel("Give Magazine Title:");
            NumberSelidesLA = new JLabel("Give Number of page:"); 
            EtosLA = new JLabel("Give YEAR:  (Number)");
            MagazineVolumeLA = new JLabel("Give The Volume of the Magazine:");
            SelidaDhmosieushsLA = new JLabel("Give Publishing page:");
            
            //Ftiaxnw ta Textfields              
            TitlePeriodikoTF = new JTextField(15);
            NumberSelidesTF = new JTextField(15);
            EtosTF = new JTextField(5);
            MagazineVolumeTF = new JTextField(5);
            SelidaDhmosieushsTF = new JTextField(15);
            
            
            MagazinePanel.add(Box.createRigidArea(new Dimension(600,10)));
            MagazinePanel.add(IsbnLA);
            MagazinePanel.add(IsbnTF);
            MagazinePanel.add(Box.createRigidArea(new Dimension(600,20)));
            MagazinePanel.add(AuthorNumberLA);
            MagazinePanel.add(AuthorsNumber);
            MagazinePanel.add(AuthorsButton);
            MagazinePanel.add(Box.createRigidArea(new Dimension(600,20)));
            MagazinePanel.add(TitlePeriodikoLA);
            MagazinePanel.add(TitlePeriodikoTF);
            MagazinePanel.add(Box.createRigidArea(new Dimension(600,20)));
            MagazinePanel.add(NumberSelidesLA);
            MagazinePanel.add(NumberSelidesTF);
            MagazinePanel.add(Box.createRigidArea(new Dimension(600,20)));
            MagazinePanel.add(EtosLA);
            MagazinePanel.add(EtosTF);
            MagazinePanel.add(Box.createRigidArea(new Dimension(600,20)));
            MagazinePanel.add(MagazineVolumeLA);
            MagazinePanel.add(MagazineVolumeTF);
            MagazinePanel.add(Box.createRigidArea(new Dimension(600,20)));
            MagazinePanel.add(SelidaDhmosieushsLA);
            MagazinePanel.add(SelidaDhmosieushsTF);
            MagazinePanel.add(Box.createRigidArea(new Dimension(600,20)));
            MagazinePanel.add(Submit);
               
            this.add(MagazinePanel);
            
        }
        else if(EidosResearch.equalsIgnoreCase("Science ")){
            
            BookPanel = new JPanel();
            Eidos = "Science ";
            
            OnomaVivliouLA = new JLabel("Give book name:");
            OnomaVivliouTF = new JTextField(15);
            HmeromhniaEkdoshsLA = new JLabel("Give Date of publication  (MM/yyyy)");
            df = new SimpleDateFormat("MM/yyyy");
            HmeromhniaEkdoshsTF = new JFormattedTextField(df); 
            HmeromhniaEkdoshsTF.setColumns(15);
            
            
            BookPanel.add(Box.createRigidArea(new Dimension(600,10)));
            BookPanel.add(IsbnLA);
            BookPanel.add(IsbnTF);
            BookPanel.add(Box.createRigidArea(new Dimension(600,10)));
            BookPanel.add(AuthorNumberLA);
            BookPanel.add(AuthorsNumber);
            BookPanel.add(AuthorsButton);
            BookPanel.add(Box.createRigidArea(new Dimension(600,10)));
            BookPanel.add(OnomaVivliouLA);
            BookPanel.add(OnomaVivliouTF);
            BookPanel.add(Box.createRigidArea(new Dimension(600,10)));
            BookPanel.add(HmeromhniaEkdoshsLA);
            BookPanel.add(HmeromhniaEkdoshsTF);
            BookPanel.add(Box.createRigidArea(new Dimension(600,10)));
            BookPanel.add(Submit);
            
            this.add(BookPanel);
            
        }
        
        
        
        this.setVisible(true);
        
    }
    
  

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        //Ama paththei to koumpi gia tous sugrafeis
        if(e.getSource()==AuthorsButton){
             w = new Authors(Integer.parseInt(AuthorsNumber.getSelectedItem().toString()));
        }
        
        //An patithei to button submit
        if(e.getSource()== Submit){
            
            //Ama einai forma gia magazine 
            if(Eidos.equalsIgnoreCase("Magazine ")){
                
                //Ftiaxnw to antikeimeno analoga me ta stpoixeia pou mou edwse o xrhsths 
                var RM = new ResearchMagazine(w.getAuthors(),TitlePeriodikoTF.getText(),(Integer.parseInt(NumberSelidesTF.getText())),(Integer.parseInt(EtosTF.getText())),(Integer.parseInt(MagazineVolumeTF.getText())),SelidaDhmosieushsTF.getText());                                            
                
                
                //Dhmiourgw to antikeimeno out to opoio tha grafei ta antikeimena sto arxeio Object.txt
                try {
                    out = new ObjectOutputStream(new FileOutputStream("Object.txt"));
                    out.writeObject(RM);
                    out.flush();
                    out.close();
                    JOptionPane.showMessageDialog(this, "Your Magazine  has Succesfully Submited","Success",JOptionPane.PLAIN_MESSAGE);
                    dispose();
                    Window AW = new Window();
                    
                } catch (FileNotFoundException ex) {
                    System.out.println("File Not Found");
                    Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    System.out.println("");
                    System.out.println("I/O Exception");
                    Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            //Ama einai forma gia Book
            else if(Eidos.equalsIgnoreCase("Book")){
                
                //Ftiaxnw to antikeimeno analoga me ta stpoixeia pou mou edwse o xrhsths 
                ResearchBook RS = new ResearchBook(IsbnTF.getText(),w.getAuthors(),OnomaVivliouTF.getText(),HmeromhniaEkdoshsTF.getText());
                
                
                //Dhmiourgw to antikeimeno out to opoio tha grafei ta antikeimena sto arxeio Object.txt
                try {
                    //To true einai oti grafei apo to telos tou arxeiou kai den kanei overwrite
                    FileOutputStream fos = new FileOutputStream("Object.txt", true);
                    out = new ObjectOutputStream(fos);
                    out.writeObject(RS);
                    out.flush();
                    out.close();
                    JOptionPane.showMessageDialog(this, "Your Science Study has Succesfully Submited","Success",JOptionPane.PLAIN_MESSAGE);
                    dispose();
                    Window AW = new Window();
                    
                } catch (FileNotFoundException ex) {
                    System.out.println("File Not Found");
                    Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    System.out.println("");
                    System.out.println("I/O Exception");
                    Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
    }
    
}
