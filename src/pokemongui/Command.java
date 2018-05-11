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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Command extends JFrame{
    
    ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
    JPanel p1,showData;
    JLabel txtSelect,pokemonIcon;
    JTextField jTextField; //
    JButton newButton,eatButton,exerciseButton,battleButton;
    JTextArea printProFile,battleArea;
    Icon dataIcon0,dataIcon1,dataIcon2,dataIconStart;
    JComboBox select;
    int  membershipOfHitokage, 
         membershipOfFushigidane,
         membershipOfZenigame;
    //***************************************************************************************
    public static String printPokemons(ArrayList<Pokemon> pokemons,int member){
        String hp = "======== Pokemon List ======== \n"+"Pokemon "+
                pokemons.get(member).getName()+" health: "+pokemons.get(member).getHealth()
                +"/"+pokemons.get(member).maxHealth;
        String weight = "\n======== Pokemon Weight ======== \n"+" Weight: "+
                pokemons.get(member).getWeight();
        return hp+weight;
    }
    //***************************************************************************************
    public void eatBerry(int mumber){
            Berry berry = new Berry(0);
            pokemons.get(mumber).eat(berry);
            printProFile.setText(printPokemons(pokemons,mumber));
    }
    //***************************************************************************************
    public Command(){
        super("PokemonGame!!!");
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        
        String pokemonName[] = {
            "Hitokage",    // 004 
            "Fushigidane", //008
            "Zenigame"     //007
        };
        //*********************************   
        select = new JComboBox(pokemonName);
        select.setPreferredSize(new Dimension(150,20));
        //********************************* 
        p1 = new JPanel();
        p1.setLayout(new FlowLayout());
        showData = new JPanel();
        showData.setLayout(new FlowLayout());
        //********************************* 
        printProFile  = new JTextArea("",20,30);
        dataIconStart = new ImageIcon(getClass().getResource("while.png"));
        dataIcon0     = new ImageIcon(getClass().getResource("004.png"));
        dataIcon1     = new ImageIcon(getClass().getResource("008.jpg"));
        dataIcon2     = new ImageIcon(getClass().getResource("007.png"));
        pokemonIcon   = new JLabel("");
        pokemonIcon.setIcon(dataIconStart);
         
        txtSelect  = new JLabel("เลือก โปเกม่อนเริ่มต้น : ");
        newButton = new JButton("^^");
        eatButton  = new JButton("EAT!!!");
        battleButton = new JButton("Battle");
        exerciseButton = new JButton("ExerciseGO");
        pokemons.add(new Hitokage());
        pokemons.add(new Fushigidane());
        pokemons.add(new Zenigame());
        //********************************* 
                
        //event ^^!!!
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (select.getSelectedIndex()) {
                    case 0:
                        pokemonIcon.setIcon(dataIcon0);
                        membershipOfHitokage = 0;
                        printProFile.setText(printPokemons(pokemons,membershipOfHitokage));
                        System.out.print("Hitokage"+select.getSelectedIndex());
                        break;
                    case 1:
                        pokemonIcon.setIcon(dataIcon1);
                        membershipOfFushigidane = 1;
                        printProFile.setText(printPokemons(pokemons,membershipOfFushigidane));
                        System.out.print("Fushigidane"+select.getSelectedIndex());
                        break;
                    case 2:
                        pokemonIcon.setIcon(dataIcon2);
                        membershipOfZenigame = 2;
                        printProFile.setText(printPokemons(pokemons,membershipOfZenigame));
                        System.out.print("Zenigame"+select.getSelectedIndex());
                        break;
                    default:
                        break;
                }
            }
        });
        //end 
        
        //Event eatButton
        eatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (select.getSelectedIndex()) {
                    case 0:
                        eatBerry(membershipOfHitokage);
                        pokemonIcon.setIcon(dataIcon0);
                        System.out.print("Hitokage eat"+ select.getSelectedIndex());
                        break;
                    case 1:
                        pokemonIcon.setIcon(dataIcon1);
                        eatBerry(membershipOfFushigidane);
                        System.out.print("Fushigidane eat"+ select.getSelectedIndex());
                        break;
                    case 2:
                        pokemonIcon.setIcon(dataIcon2);
                        eatBerry(membershipOfZenigame);
                        System.out.print("Zenigame eat"+ select.getSelectedIndex());
                        break;
                    default:
                        break;
                }
            }
        });
        //End eat
        
        //Event exerciseButton
        exerciseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 switch (select.getSelectedIndex()) {
                    case 0:
                        pokemonIcon.setIcon(dataIcon0);
                        pokemons.get(membershipOfHitokage).move();
                        printProFile.setText(printPokemons(pokemons,membershipOfHitokage));
                        System.out.print("Hitokage ออกกำลัง"+select.getSelectedIndex());
                        break;
                    case 1:
                        pokemonIcon.setIcon(dataIcon1);
                        pokemons.get( membershipOfFushigidane).move();
                        printProFile.setText(printPokemons(pokemons,membershipOfFushigidane));
                        System.out.print("Fushigidane ออกกำลัง"+select.getSelectedIndex());
                        break;
                    case 2:
                        pokemonIcon.setIcon(dataIcon2);
                        pokemons.get( membershipOfZenigame).move();
                        printProFile.setText(printPokemons(pokemons,membershipOfZenigame));
                        System.out.print("Zenigame ออกกำลัง "+select.getSelectedIndex());
                        break;
                    default:
                        break;
                }
            }
        });

        //event  battleButton 
       battleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                switch (select.getSelectedIndex()) {
                    case 0:
                        JOptionPane.showMessageDialog(new Battle(pokemons,select.getSelectedIndex()),"เริ่มตอนสู้ได้");
                        pokemonIcon.setIcon(dataIcon0);
                        break;
                    case 1:
                        JOptionPane.showMessageDialog(new Battle(pokemons,select.getSelectedIndex()),"เริ่มตอนสู้ได้");
                        pokemonIcon.setIcon(dataIcon1);
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(new Battle(pokemons,select.getSelectedIndex()),"เริ่มตอนสู้ได้");
                        pokemonIcon.setIcon(dataIcon2);
                        break;
                    default:
                        break;
                }
            }
        });
        
         //set layout
        p1.add(txtSelect);
        p1.add(select);
        p1.add(newButton);
        p1.add(eatButton);
        p1.add(battleButton );
        p1.add(exerciseButton);
        showData.add(pokemonIcon);
        showData.add(printProFile);
        c.add(showData, BorderLayout.PAGE_START);
        c.add(p1, BorderLayout.CENTER);

        //set others
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.setSize(700,800);
        pack();
        setVisible(true);
        //**********************
    }
    
}
