import javax.swing.*;
import java.awt.*;

public class StartNew{

    private int rows;
    private int columns;
    private int differentNumbers;

    public int getRows() {
        return this.rows;
    }
    public int getColumns() {
        return this.columns;
    }
    public int getDifferentNumbers() {
        return this.differentNumbers;
    }

    public static void error(int a){
        if(a>50){
            JOptionPane.showMessageDialog(null, "Please enter a number smaller or equal to 50","Invalid number", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void error1(int a){
        if(a>25){
            JOptionPane.showMessageDialog(null, "Please enter a number smaller or equal to 50","Invalid number", JOptionPane.ERROR_MESSAGE);
        }
    }
    StartNew() {
        JFrame startNew = new JFrame("New Game");
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        String numberOfRows = JOptionPane.showInputDialog("Enter number of rows");
        rows = Integer.parseInt(numberOfRows);
        error(rows);
        String numberOfColumns = JOptionPane.showInputDialog("Enter number of columns");
        this.columns = Integer.parseInt(numberOfColumns);
        error(columns);
        String numberOfDifferentNumbers = JOptionPane.showInputDialog("Enter number of different numbers");
        this.differentNumbers = Integer.parseInt(numberOfDifferentNumbers);
        error1(differentNumbers);
        startNew.add(panel);
        startNew.setSize(1200, 800);
        startNew.setLocationRelativeTo(null);
        startNew.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startNew.setVisible(true);
        startNew.setResizable(false);
        startNew.dispose();
    }

}