
package pokemongui;

import javax.swing.JFrame;

public class PokemonGUI {

    public static void main(String[] args) {
        Command c = new Command();
        c.setLocationRelativeTo(null);
        c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.setSize(700,800);
        c.pack();
        c.setVisible(true);

    }
    
}
