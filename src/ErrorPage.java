import javax.swing.*;

public class ErrorPage extends JFrame {
    private JPanel pannel;
    private static JLabel ErrorLabel;
    private JFrame frame;


    String errorMessage;



    ErrorPage(String message)
    {
        this.errorMessage = message;
    }




    public void window_param()
    {

            JOptionPane.showMessageDialog(null, this.errorMessage);


    }
}
