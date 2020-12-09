import javax.swing.*;
import HomePage.*;

public class HomePage extends JFrame {
    private JPanel pannel;
    private static JLabel userLabel;
    private JFrame frame;

    private Employee e;
    private Client c;
    private ClientBusiness cb;
    String typeConnexion;



    HomePage(Employee e)
    {
        this.e = e;
        this.typeConnexion = "Emp";
    }
    HomePage(Client c)
    {
        this.c = c;
        this.typeConnexion = "C";

    }
    HomePage(ClientBusiness cb)
    {
        this.cb = cb;
        this.typeConnexion = "CB";

    }




    public void window_param()
    {
        if(this.typeConnexion == "C")
        {


            HomeClient a = new HomeClient();
            a.window_param();
            /*

            setSize(500, 500);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            pannel = new JPanel();

            pannel.setLayout(null);

            userLabel = new JLabel(c.prenom);
            userLabel.setBounds(10,20, 80,25);
            pannel.add(userLabel);


            add(pannel);
            setVisible(true);

             */
        }

    }
}
