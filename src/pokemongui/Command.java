package pokemongui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
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
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;



public class Command extends JFrame{
    
    ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
    JPanel p1,showData;
    JLabel txtSelect,pokemonIcon;
    JButton newButton,eatButton,exerciseButton,battleButton;
    JTextArea printProFile;
    Icon dataIcon0,dataIcon1,dataIcon2,dataIconStart;
    JComboBox select;
    
    
    public static String printPokemons(ArrayList<Pokemon> pokemons,int member){
        String hp = "========== Pokemon List ========== \n"+"Name: "+
                pokemons.get(member).getName()+"\nHealth: "+pokemons.get(member).getHealth()
                +"/"+pokemons.get(member).maxHealth;
        String weight = " Weight: "+ pokemons.get(member).getWeight();
        String mood ="\nMood: "+ pokemons.get(member).getMood()+"/"+pokemons.get(member).maxMood;
        String status = "\nStatus :"+pokemons.get(member).getName()+" is "+pokemons.get(member).getStatus();        
        return hp+weight+mood+status;
    }
    
    
    public void eatBerry(int mumber){
            Berry berry = new Berry(0);
            pokemons.get(mumber).eat(berry);
            printProFile.setText(printPokemons(pokemons,mumber));
    }
    
    public Command(){
        super("PokemonGame!!!");
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        String pokemonName[] = {
            "Hitokage",    // 004 
            "Fushigidane", // 005
            "Zenigame"     // 006
        };
        songs();
        select = new JComboBox(pokemonName);
        select.setPreferredSize(new Dimension(100,20));
        
        p1 = new JPanel();
        p1.setLayout(new FlowLayout());
        showData = new JPanel();
        showData.setLayout(new FlowLayout());
        
        
        printProFile  = new JTextArea("Pokemon.....",6,20);
        dataIconStart = new ImageIcon(getClass().getResource("000.png"));
        dataIcon0     = new ImageIcon(getClass().getResource("004.png"));
        dataIcon1     = new ImageIcon(getClass().getResource("005.png"));
        dataIcon2     = new ImageIcon(getClass().getResource("006.png"));
        pokemonIcon   = new JLabel("");
        pokemonIcon.setIcon(dataIconStart);
         
        txtSelect  = new JLabel("Select PokemonStarter: ");
        newButton = new JButton(" GO ");
        eatButton  = new JButton("EAT!!!");
        exerciseButton = new JButton("Exercise");
        battleButton = new JButton("Battle");
        
        pokemons.add(new Hitokage());
        pokemons.add(new Fushigidane());
        pokemons.add(new Zenigame());
        
        exerciseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 switch (select.getSelectedIndex()) {
                    case 0:
                        pokemonIcon.setIcon(dataIcon0);
                        pokemons.get(select.getSelectedIndex()).move();
                        printProFile.setText(printPokemons(pokemons,select.getSelectedIndex()));
                        System.out.print("ออกกำลัง"+select.getSelectedIndex());
                        break;
                    case 1:
                        pokemonIcon.setIcon(dataIcon1);
                        pokemons.get(select.getSelectedIndex()).move();
                        printProFile.setText(printPokemons(pokemons,select.getSelectedIndex()));
                        System.out.print("ออกกำลัง"+select.getSelectedIndex());
                        break;
                    case 2:
                        pokemonIcon.setIcon(dataIcon2);
                        pokemons.get(select.getSelectedIndex()).move();
                        printProFile.setText(printPokemons(pokemons,select.getSelectedIndex()));
                        System.out.print("ออกกำลัง "+select.getSelectedIndex());
                        break;
                    default:
                        break;
                }
            }
        });
        
        
        battleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (select.getSelectedIndex()) {
                    case 0:
                        JOptionPane.showMessageDialog(new Battle(pokemons,select.getSelectedIndex()),"Start Battle");
                        pokemonIcon.setIcon(dataIcon0);
                        break;
                    case 1:
                        JOptionPane.showMessageDialog(new Battle(pokemons,select.getSelectedIndex()),"Start Battle");
                        pokemonIcon.setIcon(dataIcon1);
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(new Battle(pokemons,select.getSelectedIndex()),"Start Battle");
                        pokemonIcon.setIcon(dataIcon2);
                        break;
                    default:
                        break;

                }
            }
        });

        
        //event GO!!!
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (select.getSelectedIndex()) {
                    case 0:
                        pokemonIcon.setIcon(dataIcon0);
                        printProFile.setText(printPokemons(pokemons,select.getSelectedIndex()));
                        System.out.print("Hitokage"+select.getSelectedIndex());
                        break;
                    case 1:
                        pokemonIcon.setIcon(dataIcon1);
                        printProFile.setText(printPokemons(pokemons,select.getSelectedIndex()));
                        System.out.print("Fushigidane"+select.getSelectedIndex());
                        break;
                    case 2:
                        pokemonIcon.setIcon(dataIcon2);
                        printProFile.setText(printPokemons(pokemons,select.getSelectedIndex()));
                        System.out.print("Zenigame"+select.getSelectedIndex());
                        break;
                    default:
                        break;
                }
            }
        });
        
        //Event eatButton
        eatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (select.getSelectedIndex()) {
                    case 0:
                        eatBerry(select.getSelectedIndex());
                        pokemonIcon.setIcon(dataIcon0);
                        Pokemon pokemon1 = pokemons.get(0);
		        Pokemon pokemon2 = pokemons.get(1);
		        pokemon1.attack(pokemon2);
                        System.out.print("Hitokage eat"+ select.getSelectedIndex());
                        break;
                    case 1:
                        pokemonIcon.setIcon(dataIcon1);
                        eatBerry(select.getSelectedIndex());
                        System.out.print("Fushigidane eat"+ select.getSelectedIndex());
                        break;
                    case 2:
                        pokemonIcon.setIcon(dataIcon2);
                        eatBerry(select.getSelectedIndex());
                        System.out.print("Zenigame eat"+ select.getSelectedIndex());
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
        p1.add(exerciseButton);
        p1.add(battleButton);
        
        showData.add(pokemonIcon);
        showData.add(printProFile);
        c.add(showData, BorderLayout.PAGE_START);
        c.add(p1, BorderLayout.CENTER);

        //**********************
    }
    
    private void songs() {
       InputStream inputS ;
       try{
            inputS = new FileInputStream(new File("D:\\starwars.wav"));
            AudioStream audio = new AudioStream(inputS);
            AudioPlayer.player.start(audio);
                   
        }
       catch(Exception e){
           
       }
   }
   
}