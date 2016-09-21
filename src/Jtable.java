 
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

public class Jtable extends JFrame {

    public Jtable(Object[][] data) {
        String[] col = new String[]{"DAYS", "1", "2", "3",
            "4", "5", "6", "7"};

        JTable table = new JTable(data, col);
        this.add(new JScrollPane(table));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] arg) {
        Object[][] item = new Object[][]{
            {"MONDAY", "ENG", "MATHS", "CHEM", "PHY", "P.EDU", "MATHS", "MUSIC"}
        };
        new Jtable(item);
    }
}
