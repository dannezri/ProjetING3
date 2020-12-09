package HomePage;

import Catalogue.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeClient extends JFrame implements ActionListener {
    private JButton b1,b2, b3;

    public void window_param()
    {
        JFrame f=new JFrame("Button Example");


        b1=new JButton("Réservez");
        b1.setBounds(50,100,100,100);
        b1.addActionListener(this);
        f.add(b1);

        b2=new JButton("Mes réservations");
        b2.setBounds(300,100,100,100);
        b2.addActionListener(this);
        f.add(b2);

        b3=new JButton("Click Here");
        b3.setBounds(550,100,100,100);
        f.add(b3);

        f.setSize(800,800);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {

        Object source=e.getSource();

        if(source == b1)
        {
            Catalogue c = new Catalogue(new Voiture(0, "null", "null", 0));
            c.load_data();
        }
        else if(source == b2)
        {
            System.out.println("Mes resas");
        }
    }


    public static void main(String[] args) {
        HomePage.HomeClient a = new HomePage.HomeClient();
        a.window_param();
    }


}
