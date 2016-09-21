
package student;
/*
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.Calendar;
import javax.swing.*;
import javax.swing.JFormattedTextField.AbstractFormatter;
import org.jdatepicker.impl.*;

public class datechooser extends JFrame {

    JDatePanelImpl datePanel;
    JDatePickerImpl datePicker;

    datechooser() {
        JFrame frame=new JFrame();
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "TODAY");
        p.put("text.month", "MONTH");
        p.put("text.year", "YEAR");
        datePanel = new JDatePanelImpl(model, p);

        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePicker.setBounds(10,10,50,50);
        frame.add(datePicker);
    }

    public class DateLabelFormatter extends AbstractFormatter {

        private final String datePattern = "yyyy-MM-dd";
        private final SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

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

    public static void main(String[] arg) {
        datechooser dc = new datechooser();
        dc.setLayout(null);
        dc.setBounds(30,30,500,500);
        dc.setVisible(true);
    }

}
*/