package pokemongui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Battle extends JFrame{
    JComboBox selectSkill;
    
    JPanel p1,p2,p3;
    JLabel labelR,labelB;
    JButton attackButton,untimateButton;
    Icon red,blue;
    JTextArea redText,blueText;
    public Battle(ArrayList<Pokemon> pokemons,int member){
        super("Battle_Royale");
        
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        
        p1 = new JPanel(); p1.setLayout(new FlowLayout());
        p2 = new JPanel(); p2.setLayout(new FlowLayout());
        p3 = new JPanel(); p3.setLayout(new FlowLayout());
        
        red = new ImageIcon(getClass().getResource("004.png"));
        blue = new ImageIcon(getClass().getResource("007.png"));
        labelR = new JLabel();
        labelR.setIcon(red);
        labelB = new JLabel();
        labelB.setIcon(blue);
        attackButton = new JButton("Attack");
        untimateButton = new JButton("Untimate");
        redText = new JTextArea("",20,30);
        blueText = new JTextArea("",20,30);
        
        p1.add(labelR);
        p1.add(labelB);
        
        p2.add(attackButton);
        p2.add(untimateButton);
        
        p3.add(redText);
        p3.add(blueText);

        c.add(p1, BorderLayout.PAGE_START);
        c.add(p2, BorderLayout.CENTER);
        c.add(p3, BorderLayout.PAGE_END);
        //set others
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        
        
    }
}
