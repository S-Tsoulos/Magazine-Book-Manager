//Tsoulos Sotirios 
//ICSD13190
package pkg1haskhsh;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Authors extends JFrame implements ActionListener {
    
    private JTextField[] AuthorsTF;
    private JLabel[] AuthorsLA;
    private JPanel panel;
    private JButton Submit;
    private ArrayList<String> Authors;
    
    
    public Authors(int Number){
        
        super("Î•Î¹ÏƒÎ±Î³Ï‰Î³Î® Î£Ï…Î³Î³Ï�Î±Ï†Î­Ï‰Î½");
        
        
        AuthorsTF = new JTextField[Number];
        AuthorsLA = new JLabel[Number];
        Authors = new <String> ArrayList();
        
        List<String> Authors = new ArrayList<>();        
        
        panel = new JPanel();
        
        setSize(600,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        BoxLayout box = new BoxLayout(panel,BoxLayout.LINE_AXIS);
        
        panel.add(Box.createRigidArea(new Dimension(600,20)));
        
       
        
        for(int i=0;i<Number;i++){
            AuthorsLA[i] = new JLabel("Author" + (i+1)+ ": ");
            AuthorsTF[i] = new JTextField(20);
            panel.add(AuthorsLA[i]);
            panel.add(AuthorsTF[i]);
            panel.add(Box.createRigidArea(new Dimension(600,20)));
        }
        
        Submit = new JButton("Sumbit");
        Submit.addActionListener(this);
        
        panel.add(Submit);
        
        
        
        this.add(panel);
        this.setVisible(true);
        
    }
    
    //Methodos pou vazei tous authors sthn Arraylist
    public void AddAuthorsToArrayList(String Author){     
        Authors.add(Author);
    }
    
    //Methodos pou epistrefei Authors
    public ArrayList<String> getAuthors(){
        return Authors;
    }
;
    @Override
    public void actionPerformed(ActionEvent e) {
        
        //Otan pathsei to koumpi submit
        if(e.getSource()==Submit){
            
            for(int i=0;i<AuthorsTF.length;i++){
                AddAuthorsToArrayList(AuthorsTF[i].getText());
                dispose();
            }
                      
        }
    }
}

