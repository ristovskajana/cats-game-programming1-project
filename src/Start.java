import javax.swing.*;
import java.awt.*;

public class Start{
    Start() {
        JFrame start = new JFrame("Game");
        JPanel panel = new JPanel();
        panel.setSize(1100, 700);
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(2,1));
        panel2.setSize(200,200);
        JLabel label1 = new JLabel("Welcome to Cat Wars.");
        label1.setFont(new Font("Cooper Black", Font.ITALIC, 23));
        JLabel label2 = new JLabel("Please select if you want to start a new game or reload a saved one ");
        label2.setFont(new Font("Cooper Black", Font.ITALIC, 23));
        panel2.setBackground(new java.awt.Color(255, 221, 154));
        panel2.add(label1);
        panel2.add(label2);
        ImageIcon picture =  new ImageIcon("src/Untitled.png");
        JLabel label3 = new JLabel(" ");
        JButton newGame = new JButton("New Game");
;       JLabel l = new JLabel(picture);
        newGame.addActionListener(e -> {
            start.dispose();
            Paint paint = new Paint();
        });
        JButton reloadGame = new JButton("Reload saved game");
        newGame.setFont(new Font("Cooper Black", Font.ITALIC, 20));
        reloadGame.setFont(new Font("Cooper Black", Font.ITALIC, 20));
        reloadGame.addActionListener(e -> {
            start.dispose();
          StartReload startReloadedGame = new StartReload();
        });
        ImageIcon picture1 =  new ImageIcon("src/Untitled4.png");
        JLabel l1 = new JLabel(picture1);
        ImageIcon picture2 =  new ImageIcon("src/Untitled2.png");
        JLabel l2 = new JLabel(picture2);
        panel.add(panel2);
        panel.add(l);
        panel.add(label3);
        panel.add(newGame);
        panel.add(reloadGame);
        panel.add(l1);
        panel.add(l2);
        panel.setBackground(new java.awt.Color(255, 221, 154));
        start.add(panel);
        start.setSize(1200, 800);
        start.setLocationRelativeTo(null);
        start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        start.setVisible(true);
        start.setResizable(false);
    }
}
