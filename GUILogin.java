import Session.Session;

import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class GUILogin extends JFrame implements ActionListener {

    private JPanel pannel;
    private JFrame frame;
    private static JLabel userLabel;
    private static JTextField userText;
    private static JLabel passwordLabel;
    private static JPasswordField passwordText;
    private static JButton button;
    private static JLabel succes;

    Connection cnx;

    public GUILogin(Connection databaseConnection) {
        this.cnx = databaseConnection;
    }


    public void window_param()
    {
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pannel = new JPanel();

        pannel.setLayout(null);

        userLabel = new JLabel("User");
        userLabel.setBounds(10,20, 80,25);
        pannel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        pannel.add(userText);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10,50, 80,25);
        pannel.add(passwordLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(100,50,165,25);
        pannel.add(passwordText);

        button = new JButton("Login");
        button.setBounds(10,80,80,25);
        button.addActionListener(new GUILogin(cnx));
        pannel.add(button);

        succes = new JLabel("");
        succes.setBounds(10,110,300,25);
        pannel.add(succes);


        add(pannel);
        setVisible(true);


    }


    public Client checkUser(Connection cnx, String user, String password)
    {
        try {
            PreparedStatement statement = cnx.prepareStatement("select * from user WHERE login = ? AND mdp = ?");
            statement.setString(1, user);
            statement.setString(2, password);
            ResultSet myRes = statement.executeQuery();

            String nom = null;
            String prenom = null;
            int rang = 0;
            int nb_resultats = 0;
            int id = 0;


            while(myRes.next())
            {
                id = myRes.getInt("id");
                nom = myRes.getString("nom");
                prenom = myRes.getString("prenom");
                rang = myRes.getInt("rang");
                nb_resultats++;
            }

            if(nb_resultats > 0)
            {
                Client client1 = new Client(nom, prenom, rang);
                Session session = new Session(id, nom, prenom, "Client");
                return client1;
            }
            else
            {
                return null;
            }


        } catch (Exception ex)
        {
            ex.printStackTrace();
            System.exit(0);
            return null;
        }


    }

    public Employee checkEmploye(Connection cnx, String user, String password)
    {
        try {
            PreparedStatement statement = cnx.prepareStatement("select * from employe WHERE login = ? AND mdp = ?");
            statement.setString(1, user);
            statement.setString(2, password);
            ResultSet myRes = statement.executeQuery();

            String nom = null;
            String prenom = null;
            int rang = 0;
            int id = 0;
            int nb_resultats = 0;


            while(myRes.next())
            {
                nom = myRes.getString("nom");
                prenom = myRes.getString("prenom");
                id = myRes.getInt("id");
                nb_resultats++;
            }
            if(nb_resultats > 0)
            {
                Employee emp1 = new Employee(nom, prenom, id);
                Session session = new Session(id, nom, prenom, "Employe");
                return emp1;
            }
            else
            {
                return null;
            }


        } catch (Exception ex)
        {
            ex.printStackTrace();
            System.exit(0);
            return null;
        }


    }

    public ClientBusiness checkBusiness(Connection cnx, String user, String password)
    {
        try {
            PreparedStatement statement = cnx.prepareStatement("select * from client_business WHERE login = ? AND mdp = ?");
            statement.setString(1, user);
            statement.setString(2, password);
            ResultSet myRes = statement.executeQuery();

            String nom = null;
            String prenom = null;
            String nomEntreprise = null;
            int nb_resultats = 0;
            int id =0;



            while(myRes.next())
            {
                id = myRes.getInt("id");
                nom = myRes.getString("nom");
                prenom = myRes.getString("prenom");
                nomEntreprise = myRes.getString("nomEntreprise");
                nb_resultats++;
            }

            if(nb_resultats > 0)
            {
                ClientBusiness cb1 = new ClientBusiness(nom, prenom, nomEntreprise);
                Session session = new Session(id, nom, prenom, "ClientBusiness");
                return cb1;
            }
            else
            {
                return null;
            }


        } catch (Exception ex)
        {
            ex.printStackTrace();
            System.exit(0);
            return null;
        }


    }



    public void actionPerformed(ActionEvent e) {
        String user = userText.getText();
        String password = passwordText.getText();

        if(checkUser(cnx, user, password) == null)
        {
            if(checkEmploye(cnx, user, password) == null)
            {
                if(checkBusiness(cnx, user, password) == null)
                {
                    System.out.println("Error Page");
                    new ErrorPage("Aucun utilisateur ne correpond").window_param();
                }
                else
                {
                    System.out.println("OK1");
                    ClientBusiness cb1 = checkBusiness(cnx, user, password);
                    new HomePage(cb1).window_param();
                }
            }
            else
            {
                System.out.println("OK2");
                Employee emp = checkEmploye(cnx, user, password);
                new HomePage(emp).window_param();

            }
        }
        else
        {
            System.out.println("OK3");
            Client client = checkUser(cnx, user, password);
            new HomePage(client).window_param();
        }


    }
}
