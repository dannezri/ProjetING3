package Catalogue;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;


import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

public class Reservation {

    public Voiture v;
    Connection cnx;
    private JFrame f;
    private static JLabel title;





    public Reservation(Voiture v, Connection cnx)
    {
        this.v = v;
        this.cnx = cnx;
        window_create();


    }

    public void window_create()
    {
        f = new JFrame("Catalogue.Catalogue.Reservation");

        f.setSize(800,800);
        f.setLayout(null);
        f.setVisible(true);
        data_aficher();
    }

    public void data_aficher()
    {
        String data = v.id+" "+" "+v.marque+" "+v.modele+" "+v.prix;
        title = new JLabel(data);
        title.setBounds(10,80, 600,80);
        f.add(title);

        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");

        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new Reservation.DateLabelFormatter());
        f.setLayout(new GridBagLayout());
        f.add(datePicker);



    }

    public class DateLabelFormatter extends JFormattedTextField.AbstractFormatter {

        private String datePattern = "yyyy-MM-dd";
        private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

        @Override
        public Object stringToValue(String text) throws ParseException {
            return dateFormatter.parseObject(text);
        }

        @Override
        public String valueToString(Object value) throws ParseException {
            if (value != null) {
                Calendar cal = (Calendar) value;
                return dateFormatter.format(cal.getTime());
            }

            return "";
        }

    }


}
