import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Field{
    StartNew startNew = new StartNew();
    int prime;
    public String primeS;
    public int iPrime;
    public int jPrime;
    public static int getRandomIntegerBetweenRange(int min, int max) {
        int x = (int) (Math.random() * ((max - min) + 1)) + min;
        return x;
    }
    public int numClicks = 0;
    public void primeClicked(ActionEvent c) {
        c.getSource();
        numClicks++;
    }

    public void deactivateButton(JButton button) {
        for (ActionListener listener : Arrays.asList(button.getActionListeners())) {
            button.removeActionListener(listener);
        }
    }

    public void setPrime(int prime) {
        this.prime = prime;
    }

    public int getPrime() {
        return prime;
    }

    Field() {
        AtomicInteger clicks = new AtomicInteger();
        int rows = startNew.getRows();
        int columns = startNew.getColumns();
        int differentNumbers = startNew.getDifferentNumbers();
        JButton grid[][] = new JButton[rows][columns];
        int fieldArray[][] = new int[rows][columns];
        JFrame field = new JFrame("New Game");
        field.setLayout(new GridLayout(rows, columns));
        field.setSize(1200, 800);
        field.setLocationRelativeTo(null);
        field.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        for (int i = 0; i < fieldArray.length; i++) {
            for (int j = 0; j < fieldArray[i].length; j++) {
                fieldArray[i][j] = getRandomIntegerBetweenRange(1, differentNumbers);
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                String tmp = Integer.toString(fieldArray[i][j]);
                JButton btn = new JButton(tmp);
                grid[i][j] = btn;
                field.add(btn);
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int finalI = i;
                int finalJ = j;
                if (numClicks != 0) {
                    primeS = grid[finalI][finalJ].getText();
                    setPrime(Integer.parseInt(primeS));
                }
                grid[i][j].addActionListener(e -> {
                    primeS = grid[finalI][finalJ].getText();
                    setPrime(Integer.parseInt(primeS));
                    String message = "You have chosen your prime to be " + primeS;
                    JOptionPane.showMessageDialog(null, message, "Prime", JOptionPane.PLAIN_MESSAGE);
                    grid[finalI][finalJ].setBackground(Color.RED);
                    primeClicked(e);
                    if (numClicks != 0) {
                        for (int n = 0; n < grid.length; n++) {
                            for (int m = 0; m < grid[n].length; m++) {
                                System.out.println("click " + numClicks);
                                deactivateButton(grid[n][m]);
                                clicks.set(numClicks);
                            }
                        }
                    }
                });
            }
        }
        int tmp = getPrime();
        System.out.println("prime is " + tmp);
        String primeString = Integer.toString(tmp);
        for (int i = 0; i <grid.length ; i++) {
            for (int j = 0; j <grid[i].length ; j++) {
                int finalI = i;
                int finalJ = j;
                if(numClicks == 1 ){
                    grid[i][j].addActionListener(h ->{
                        grid[finalI][finalJ].setText(primeString);

                    });
                }

            }
        }
        field.setVisible(true);
        field.setResizable(false);
    }
}
