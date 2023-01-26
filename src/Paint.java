import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Paint extends Component  {
    JFrame field = new JFrame();
    public ImageIcon primeCat;
    int prime;
    public String catArray[] = new String[25];

    public String cat(int i) {
        String tmp = "Cats/cat" + i + ".jpg";
        return tmp;
    }

    public String rulesMessage = "This is how to play the game.\n" +
            "-After your Warrior has been selected randomly for you, start selecting different fields that are not with the same cat as your Warrior.\n" +
            "-When you select a field with a cat, you will change all the surrounding fields with that same cat with your Warrior.\n" +
            "-The purpose of the game is to repaint every field with your Warrior in less moves.\n" +
            "-Points are counted as number of clicks it takes to change all fields.\n" +
            "-The less points you have the better.\n" +
            "\n" +
            "Enjoy.\n";
    StartNew startNew = new StartNew();

    public static int getRandomIntegerBetweenRange(int min, int max) {
        int x = (int) (Math.random() * ((max - min) + 1)) + min;
        return x;
    }

    int rows = startNew.getRows();
    int columns = startNew.getColumns();
    int differentNumbers = startNew.getDifferentNumbers();
    JButton grid[][] = new JButton[rows][columns];
    int fieldArray[][] = new int[rows][columns];
    int clicks = 0;
    int save[][] = new int[rows][columns];

    public boolean borderLeft(int n, int m) {
        if (n == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean borderTop(int n, int m) {
        if (m == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean borderRight(int n, int m) {
        if (n == rows) {
            return true;
        } else {
            return false;
        }
    }

    public boolean borderBottom(int n, int m) {
        if (m == columns) {
            return true;
        } else {
            return false;
        }
    }

    int numOfButtons = rows * columns;

    public void color(int n, int m) {
        int left = n - 1;
        int right = n + 1;
        int bottom = m + 1;
        int top = m - 1;
        int c = fieldArray[n][m];
        fieldArray[n][m] = prime;
        grid[n][m].setIcon(primeCat);
        int counter = 0;
        for (int i = 0; i < fieldArray.length; i++) {
            for (int j = 0; j < fieldArray[i].length; j++) {
                if (fieldArray[i][j] == prime) {
                    counter++;
                }
            }
        }
        if (counter != numOfButtons) {
            if (borderLeft(n, m) == false && borderTop(n, m) == false && borderRight(n, m) == false && borderBottom(n, m) == false) {
                if (fieldArray[left][m] == c) {
                    color(left, m);
                }
                if (fieldArray[right][m] == c) {
                    color(right, m);
                }
                if (fieldArray[n][bottom] == c) {
                    color(n, bottom);
                }
                if (fieldArray[n][top] == c) {
                    color(n, top);
                }
            }
            if (borderLeft(n, m) == true && borderTop(n, m) == false && borderRight(n, m) == false && borderBottom(n, m) == false) {
                if (fieldArray[right][m] == c) {
                    color(right, m);
                }
                if (fieldArray[n][bottom] == c) {
                    color(n, bottom);
                }
                if (fieldArray[n][top] == c) {
                    color(n, top);
                } else
                    color(n, m);
            }
            if (borderLeft(n, m) == true && borderTop(n, m) == true && borderRight(n, m) == false && borderBottom(n, m) == false) {
                if (fieldArray[right][m] == c) {
                    color(right, m);
                }
                if (fieldArray[n][bottom] == c) {
                    color(n, bottom);
                } else
                    color(n, m);
            }
            if (borderTop(n, m) == true && borderRight(n, m) == false && borderBottom(n, m) == false && borderLeft(n, m) == false) {
                if (fieldArray[left][m] == c) {
                    color(left, m);
                }
                if (fieldArray[right][m] == c) {
                    color(right, m);
                }
                if (fieldArray[n][bottom] == c) {
                    color(n, bottom);
                } else
                    color(n, m);
            }
            if (borderTop(n, m) == true && borderRight(n, m) == true && borderBottom(n, m) == false && borderLeft(n, m) == false) {
                if (fieldArray[left][m] == c) {
                    color(left, m);
                }
                if (fieldArray[n][bottom] == c) {
                    color(n, bottom);
                } else
                    color(n, m);
            }
            if (borderRight(n, m) == true && borderTop(n, m) == false && borderBottom(n, m) == false && borderLeft(n, m) == false) {
                if (fieldArray[left][m] == c) {
                    color(left, m);
                }
                if (fieldArray[n][bottom] == c) {
                    color(n, bottom);
                }
                if (fieldArray[n][top] == c) {
                    color(n, top);
                } else
                    color(n, m);
            }
            if (borderRight(n, m) == true && borderBottom(n, m) == true && borderTop(n, m) == false && borderLeft(n, m) == false) {
                if (fieldArray[left][m] == c) {
                    color(left, m);
                }
                if (fieldArray[n][top] == c) {
                    color(n, top);
                } else
                    color(n, m);
            }
            if (borderBottom(n, m) == true && borderTop(n, m) == false && borderRight(n, m) == false && borderLeft(n, m) == false) {
                if (fieldArray[left][m] == c) {
                    color(left, m);
                }
                if (fieldArray[right][m] == c) {
                    color(right, m);
                }
                if (fieldArray[n][top] == c) {
                    color(n, top);
                } else
                    color(n, m);
            }
            if (borderBottom(n, m) == true && borderLeft(n, m) == true && borderRight(n, m) == false && borderTop(n, m) == false) {
                if (fieldArray[top][m] == c) {
                    color(top, m);
                }
                if (fieldArray[right][m] == c) {
                    color(right, m);
                } else
                    color(n, m);
            }
        }else
        {
            field.dispose();
            GameWon gameWon = new GameWon();
        }
    }

    Paint() {
        field.setLayout(new GridLayout(rows, columns));
        field.setSize(1200, 800);
        field.setLocationRelativeTo(null);
        field.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar menuBar = new JMenuBar();
        JMenu gameOptions = new JMenu("Game Options");
        JMenu numberOfClicks = new JMenu("Number of clicks: ");
        ImageIcon iconNew = new ImageIcon("src/restart.png");
        ImageIcon iconSave = new ImageIcon("src/save.png");
        ImageIcon iconExit = new ImageIcon("src/exit.png");

        JMenuItem newMenuItem = new JMenuItem("Restart", iconNew);
        newMenuItem.addActionListener(e -> {
            field.dispose();
            Start start = new Start();
        });
        JMenuItem saveMenuItem = new JMenuItem("Save", iconSave);
        JMenuItem exitMenuItem = new JMenuItem("Exit", iconExit);
        exitMenuItem.setToolTipText("Exit application");
        exitMenuItem.addActionListener((event) -> System.exit(0));
        JMenu rules = new JMenu("Rules");
        JMenuItem rulesItem = new JMenuItem("Read Rules");
        rulesItem.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, rulesMessage, "Rules", JOptionPane.PLAIN_MESSAGE);
        });
        rules.add(rulesItem);
        gameOptions.add(newMenuItem);
        gameOptions.add(saveMenuItem);
        gameOptions.add(exitMenuItem);
        menuBar.add(gameOptions);
        menuBar.add(rules);
        menuBar.add(numberOfClicks);
        field.setJMenuBar(menuBar);
        for (int i = 0; i < 25; i++) {
            catArray[i] = cat(i);
        }
        for (int i = 0; i < fieldArray.length; i++) {
            for (int j = 0; j < fieldArray[i].length; j++) {
                fieldArray[i][j] = getRandomIntegerBetweenRange(1, differentNumbers);
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int number = fieldArray[i][j];
                String tmp = Integer.toString(fieldArray[i][j]);
                String tmpCat = catArray[number];
                JButton btn = new JButton();
                btn.setIcon(new ImageIcon(tmpCat));
                grid[i][j] = btn;
                field.add(btn);
            }
        }
        prime = getRandomIntegerBetweenRange(1, differentNumbers);
        String l = "Cats/cat" + prime + ".jpg";
        primeCat = new ImageIcon(l);
        String message = "Your warrior is  ";
        JOptionPane.showMessageDialog(null, message, "Warrior Cat", JOptionPane.PLAIN_MESSAGE, primeCat);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int finalI = i;
                int finalJ = j;
                grid[i][j].addActionListener(e -> {
                    if(fieldArray[finalI][finalJ] != prime){
                        color(finalI, finalJ);
                    }
                    if (grid[finalI][finalJ] == e.getSource()) {
                        clicks++;
                        numberOfClicks.setText("Number of clicks: " + clicks);
                    }
                });
            }
        }
        field.setVisible(true);
        field.setResizable(false);
        saveMenuItem.addActionListener(q-> {
            if(saveMenuItem == q.getSource()) {
                String name = JOptionPane.showInputDialog("Enter name");
                String fileName = name + ".txt";
                try {
                    File myObj = new File(fileName);
                    if (myObj.createNewFile()) {
                        System.out.println("File created: " + myObj.getName());
                    } else {
                        System.out.println("File already exists.");
                    }
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
                try {
                    FileWriter fileWriter = new FileWriter(fileName);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    bufferedWriter.write(rows);
                    bufferedWriter.newLine();
                    bufferedWriter.write(columns);
                    bufferedWriter.newLine();
                    for (int i = 0; i < fieldArray.length; i++) {
                        for (int j = 0; j < fieldArray[i].length; j++) {
                            String tmp = Integer.toString(fieldArray[i][j]);
                            bufferedWriter.write(tmp);
                            bufferedWriter.newLine();
                        }
                        bufferedWriter.newLine();
                    }
                    bufferedWriter.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
