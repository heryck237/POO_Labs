import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;


public class POOActionListener
{

    private static JTextField text;


    public static void main(String[] args)

    {
        JFrame frame = new JFrame("");

        text = new JTextField();

        text.setBounds(15,50,200,20);

        JButton btn = new JButton("Cliquez ici");

        btn.setBounds(70,100,100,30);


        frame.add(btn);

        frame.add(text);

        frame.setSize(270,250);

        frame.setLayout(null);

        frame.setVisible(true);



//

// TODO: enregistrer l'action listener au boutton 'bnt'

// pour que lorsqu'on clique, le text suivant soit

// affiché: "Welcome to the POO class of 2021"

//

    }

}
