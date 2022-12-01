//Tsoulos Sotirios 
//ICSD13190
package pkg1haskhsh;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Window extends JFrame implements ActionListener{
     
    private JButton Create;
    private JButton Search;
    private JPanel ButtonsPanel;
    
    
    private JComboBox StudiesComboBox;
    private String[] StudiesEpiloges = {"-----","Magazine","Book"};
    
    private JTextField Anazhthsh;
    
    
    //Constructor tou grafikou perivalontos
    public Window(){
        
        super("Î•Ï€Î¹Î»Î¿Î³Î® ÎšÎ±Ï„Î±Ï‡ÏŽÏ�Î·ÏƒÎ·Ï‚ Î· Î‘Î½Î±Î¶Î®Ï„Î·ÏƒÎ·Ï‚ Î”Î·Î¼Î¿ÏƒÎ¯ÎµÏ…ÏƒÎ·Ï‚");
        
        setSize(400,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        //Layout
        BoxLayout box = new BoxLayout(ButtonsPanel,BoxLayout.LINE_AXIS);
        
        //Dhmiourgia Buttons
        
        Create = new JButton("Registration");
        Create.addActionListener(this);
        Search = new JButton("Search(Title or Author)");
        Search.addActionListener(this);
        
        //Dhmiourgia ComboBox
        StudiesComboBox = new JComboBox(StudiesEpiloges);
        
        //Dhmiourgia TextField
        Anazhthsh = new JTextField(15);
        
        
        //Panel
        
        ButtonsPanel = new JPanel();       
        ButtonsPanel.add(Box.createRigidArea(new Dimension(400,50)));
        ButtonsPanel.add(StudiesComboBox); 
        ButtonsPanel.add(Box.createRigidArea(new Dimension(50,2)));
        ButtonsPanel.add(Anazhthsh);
        ButtonsPanel.add(Box.createRigidArea(new Dimension(400,25)));
        ButtonsPanel.add(Create);
        ButtonsPanel.add(Box.createRigidArea(new Dimension(50,2)));  
        ButtonsPanel.add(Search);
        
        
 
        this.add(ButtonsPanel);        
        this.setVisible(true);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //Action pou ginetai an epileksei na eisagei stoixeio
        if(e.getSource()== Create){
            
            //An Den exei epileksei to eidos ths ereunas
            if(StudiesComboBox.getSelectedItem().toString().equalsIgnoreCase("-----")){
                JOptionPane.showMessageDialog(this, "Choose Book or Magazine ","Warning",JOptionPane.WARNING_MESSAGE);
            }
            //An epileksei gia Magazine 
            else if(StudiesComboBox.getSelectedItem().toString().equalsIgnoreCase("Magazine")){
                dispose();
                Input w = new Input("Magazine ");
            }
            //An epileksei gia Book
            else if(StudiesComboBox.getSelectedItem().toString().equalsIgnoreCase("Book")){
                dispose();
                Input w = new Input("Book");
            }
        }
        
        if(e.getSource()== Search){
            
            //An to TextField einai keno
            if(Anazhthsh.getText().equalsIgnoreCase("")){
                 JOptionPane.showMessageDialog(this, "Give Title or Author name to Search","Warning",JOptionPane.WARNING_MESSAGE);
            }
            //Alliws an exei kati na psaksei          
            else{
                Search A = new Search(Search.getText());
                dispose();
            }
        }
    }
    
}
