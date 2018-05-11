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
import static pokemongui.Command.printPokemons;

public class Battle extends JFrame{
    JComboBox selectSkill;
    JPanel p1,p2,p3;
    JLabel labelR,labelB;
    JButton attackButton,untimateButton,berryButton;
    Icon red,blue;
    JTextArea redText,blueText;
    int memberR,count;
    
    public static String printPokemons(ArrayList<Pokemon> pokemons,int member){
        String hp = "======== Pokemon List ======== \n"+"Pokemon "+
                pokemons.get(member).getName()+" health: "+pokemons.get(member).getHealth()
                +"/"+pokemons.get(member).maxHealth;
        String weight = "\n======== Pokemon Weight ======== \n"+" Weight: "+
                pokemons.get(member).getWeight();
        return hp+weight;
    }
    
    
    public Battle(ArrayList<Pokemon> pokemons,int member){
        super("Battle_Royale");
        this.memberR = member;
        pokemons.add(new Zenigame());
        
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        count = 0;
        System.out.print("\nssssss"+member);
        Pokemon redPlayer = pokemons.get(member);
        Pokemon bluePlayer = pokemons.get(3);
        
        p1 = new JPanel(); p1.setLayout(new FlowLayout());
        p2 = new JPanel(); p2.setLayout(new FlowLayout());
        p3 = new JPanel(); p3.setLayout(new FlowLayout());
        switch (member) {
            case 0:
                red = new ImageIcon(getClass().getResource("004.png"));
                break;
            case 1:
                red = new ImageIcon(getClass().getResource("008.jpg"));
                break;
            case 2:
                red = new ImageIcon(getClass().getResource("007.png"));
                break;
            default:
                break;
        }
        blue = new ImageIcon(getClass().getResource("007.png"));
        labelR = new JLabel();
        labelR.setIcon(red);
        labelB = new JLabel();
        labelB.setIcon(blue);
        attackButton = new JButton("Attack");
        untimateButton = new JButton("Untimate");
        redText = new JTextArea(printPokemons(pokemons,memberR),5,5);
        blueText = new JTextArea(printPokemons(pokemons,3),5,5);
        
        //Event attack
        attackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                redPlayer.attack(bluePlayer);
                if(count %2  ==0)
                    bluePlayer.attack(redPlayer);
                blueText.setText(printPokemons(pokemons,3));
                redText.setText(printPokemons(pokemons,member));
                count ++;
                
                    
            }
        });
        untimateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                redPlayer.untimate(bluePlayer);
                if(count %2  ==0)
                    bluePlayer.untimate(redPlayer);
                blueText.setText(printPokemons(pokemons,3));
                redText.setText(printPokemons(pokemons,member));
            }
        });
       
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
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        c.setSize(700,800);
        pack();
        setVisible(true);

        
        
    }
    
}
