//Tsoulos Sotirios 
//ICSD13190
package pkg1haskhsh;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Results extends JFrame implements ActionListener {
    
    private JPanel panel;
    
    private JLabel TitlePeriodikoLA,NumberSelidesLA,EtosLA,MagazineVolumeLA,SelidaDhmosieushsLA;
    private JLabel OnomaVivliouLA,HmeromniaEkdoshs;
    private JLabel AuthorLA[];
    
    private JButton BackButton;
            
    public Results(String Found,Research object){
        
        super("Search results for the " + Found + " you gave");
        
        AuthorLA = new JLabel[object.Authors.size()];
        
        
        setSize(500,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        panel = new JPanel();
        BoxLayout box = new BoxLayout(panel,BoxLayout.LINE_AXIS);
        
        BackButton = new JButton("BACK");
        BackButton.addActionListener(this);
        
        OnomaVivliouLA = new JLabel("Article Title: " + object.OnomaVivliou);
        
        panel.add(Box.createRigidArea(new Dimension(500,10)));
        panel.add(OnomaVivliouLA);
        panel.add(Box.createRigidArea(new Dimension(500,10)));
        
        for(int i=0;i<object.Authors.size();i++){
            AuthorLA[i] = new JLabel(" Author "+ (i+1) + ": " + object.Authors.get(i));
            panel.add(AuthorLA[i]);
            panel.add(Box.createRigidArea(new Dimension(500,10)));
        }
        

        //Ama objecttype == true pou shmainei oti milame gia magazine study
        if(object.type){
            
            TitlePeriodikoLA = new JLabel("Magazine Title: " + object.TitlePeriodiko);
            NumberSelidesLA= new JLabel("Number of Pages: " + object.NumberSelides);
            EtosLA = new JLabel("Year of publication: " + object.Etos);
            MagazineVolumeLA = new JLabel("Magazine Volume: " + object.MagazineVolume);
            SelidaDhmosieushsLA = new JLabel("Publication Page:" + object.SelidaDhmosieushs);
            
            panel.add(TitlePeriodikoLA);
            panel.add(Box.createRigidArea(new Dimension(500,10)));
            panel.add(NumberSelidesLA);
            panel.add(Box.createRigidArea(new Dimension(500,10)));
            panel.add(EtosLA);
            panel.add(Box.createRigidArea(new Dimension(500,10)));
            panel.add(MagazineVolumeLA);
            panel.add(Box.createRigidArea(new Dimension(500,10)));
            panel.add(SelidaDhmosieushsLA);
                 
                       
        }
        else{
            OnomaVivliouLA = new JLabel("Conference name: " + object.OnomaVivliou);
            HmeromniaEkdoshs = new JLabel("Conference Date: " + object.HmeromniaEkdoshs);
            
            
            panel.add(OnomaVivliouLA);
            panel.add(Box.createRigidArea(new Dimension(500,10)));
            panel.add(HmeromniaEkdoshs);
            panel.add(Box.createRigidArea(new Dimension(500,10)));
            
            
        }
        
        panel.add(Box.createRigidArea(new Dimension(500,10)));
        panel.add(BackButton);
        
        
        this.add(panel);
        this.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()== BackButton){
            dispose();
            Window AW = new Window();
        }
    }
    
}
