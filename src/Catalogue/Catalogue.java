package Catalogue;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Catalogue extends JFrame implements ActionListener {

    Connection cnx = getDatabaseConnection();
    private static JLabel title;
    private JFrame f;
    private JButton b1;


    int id_select = 0;
    Voiture a;


    public Catalogue(Voiture a)
    {
        this.a = a;
    }




    private static Connection getDatabaseConnection()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");

            String url="jdbc:mysql://localhost:8889/javaClass";
            String user="projetJAVA";
            String password="danannaing3";
            // Create a connection to the database.
            Connection cnx = DriverManager.getConnection(url, user, password);



            return cnx;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            System.exit(0);
            return null;
        }
    }

    public void load_data()
    {
        try {
            Statement stmt=cnx.createStatement();
            ResultSet rs = stmt.executeQuery("select * from catalogue");
            int id;
            String marque;
            String modele;
            int prix;

            window_create();

            int y_init = 20;
            int index = 0;

            while(rs.next())
            {
                id = rs.getInt("id");
                marque = rs.getString("marque");
                modele = rs.getString("modele");
                prix = rs.getInt("prix");

                y_init = y_init+50;

                data_aficher(id, marque, modele, prix, y_init, index);
                index++;


            }


        } catch (Exception ex)
        {
            ex.printStackTrace();
            System.exit(0);

        }
    }

    public void window_create()
    {
        f = new JFrame("Catalogue");

        f.setSize(800,800);
        f.setLayout(null);
        f.setVisible(true);
    }


    public void data_aficher(int id, String marque, String modele, int prix, int y, int index)
    {
        String data = id+" "+" "+marque+" "+modele+" "+prix;
        title = new JLabel(data);
        title.setBounds(10,y, 600,80);
        f.add(title);
        b1=new JButton("Réservez");
        b1.addActionListener(new Catalogue(new Voiture(id, marque, modele, prix)));
        b1.setBounds(100,y+25,80,30);
        f.add(b1);


    }

    public void actionPerformed(ActionEvent e)
    {

        System.out.print(this.id_select);
        new Reservation(this.a, this.cnx);

    }


}
