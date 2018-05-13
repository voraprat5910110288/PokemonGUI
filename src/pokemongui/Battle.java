package pokemongui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
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
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import sun.audio.*;
import java.io.*;

public class Battle extends JFrame{
    JComboBox selectSkill;
    JPanel p1,p2,p3;
    JLabel labelR,labelB;
    JButton attackButton,untimateButton,berryButton;
    Icon red,blue;
    JTextArea redText,blueText;
    JComboBox select;
    int memberR,count;
   
     
    public static String printPokemons(ArrayList<Pokemon> pokemons,int member){
        String hp = "========== Pokemon List ========== \n"+"Name: "+
                pokemons.get(member).getName()+"\nHealth: "+pokemons.get(member).getHealth()
                +"/"+pokemons.get(member).maxHealth;
        String weight = " Weight: "+ pokemons.get(member).getWeight();
        String status = "\nStatus :"+pokemons.get(member).getName()+"is "+pokemons.get(member).getStatus(); 
        
        return hp+weight+status;

    }
        public Battle(ArrayList<Pokemon> pokemons,int member){
        super("Battle_Royale");
        songs();
        
        this.memberR = member;
        
        pokemons.add(new Secrets());
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        count = 0;
        System.out.print("\nssssss"+member);
        Pokemon redPlayer = pokemons.get(member);
        Pokemon bluePlayer = pokemons.get(3);
        
        p1 = new JPanel(); p1.setLayout(new FlowLayout());
        p2 = new JPanel(); p2.setLayout(new FlowLayout());
        p3 = new JPanel(); p3.setLayout(new FlowLayout());
        
        String berryName[] = {
            "Berry",     
            "GoldBerry", 
            "MysteryBerry"     
        };
        select = new JComboBox(berryName);
        select.setPreferredSize(new Dimension(120,20));
        
        switch (member) {
            case 0:
                red = new ImageIcon(getClass().getResource("004.png"));
                break;
            case 1:
                red = new ImageIcon(getClass().getResource("005.png"));
                break;
            case 2:
                red = new ImageIcon(getClass().getResource("006.png"));
                break;
            default:
                break;
        }
        
        blue = new ImageIcon(getClass().getResource("008.png"));
    
        labelR = new JLabel();
        labelR.setIcon(red);
        labelB = new JLabel();
        labelB.setIcon(blue);
        
        attackButton = new JButton("Attack");
        untimateButton = new JButton("Untimate");
        berryButton = new JButton("Berry");
        
        redText = new JTextArea(printPokemons(pokemons,memberR),5,5);
        blueText = new JTextArea(printPokemons(pokemons,3),5,5);
        
       
        berryButton.addActionListener(new ActionListener() {
            private int memberR;
            @Override
            public void actionPerformed(ActionEvent e) {
                
                 switch (select.getSelectedIndex()) {
                    case 0:
                         Berry berry = new Berry(0);
                         pokemons.get(this.memberR).eat(berry);
                         redText.setText(printPokemons(pokemons,this.memberR));
                        break;
                    case 1:
                        Berry berry1 = new Berry(1);
                         pokemons.get(this.memberR).eat(berry1);
                         redText.setText(printPokemons(pokemons,this.memberR));
                        break;
                    case 2:
                         Berry berry2 = new Berry(2);
                         pokemons.get(this.memberR).eat(berry2);
                         redText.setText(printPokemons(pokemons,this.memberR));
                        break;
                    default:
                        break;
                }
            }
            
        });
        //Event attack
        attackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                redPlayer.attack(bluePlayer);
                if(count %2 ==0)
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
                count ++;
            }
        });
       
        p1.add(labelR);
        p1.add(labelB);
        
        p2.add(attackButton);
        p2.add(untimateButton);
        p2.add(select);
        p2.add(berryButton);
        
        p3.add(redText);
        p3.add(blueText);

        c.add(p1, BorderLayout.PAGE_START);
        c.add(p2, BorderLayout.CENTER);
        c.add(p3, BorderLayout.PAGE_END);
        //set others
        
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        c.setSize(700,800);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }
     private void songs() {
       InputStream inputS ;
       try{
            inputS = new FileInputStream(new File("D:\\music.wav"));
            AudioStream audio = new AudioStream(inputS);
            AudioPlayer.player.start(audio);
            
        }
       catch(Exception e){
           
       }
   }
  
      
}
