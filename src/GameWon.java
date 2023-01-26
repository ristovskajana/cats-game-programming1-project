import javax.swing.*;
import java.awt.*;

public class GameWon {
    GameWon(){
        JFrame frame = new JFrame("GAME WON");
        frame.setSize(800,800);
        JButton end = new JButton("Exit");
        end.addActionListener(e-> frame.dispose());
        end.setSize(200,200);
        ImageIcon win = new ImageIcon("src/win.gif");
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,1));
        JLabel label1 = new JLabel(win);
        JLabel label2 = new JLabel("You won the game, \n Congratulations !!!");
        label2.setFont(new Font("Engravers MT", Font.ITALIC, 26));
        JPanel miniPanel = new JPanel();
        miniPanel.setLayout(new GridLayout(2,1));
        miniPanel.add(label2);
        miniPanel.add(end);
        panel.add(label1);
        panel.add(miniPanel);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}

