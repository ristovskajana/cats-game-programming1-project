import javax.swing.*;
import java.awt.*;

import java.awt.event.ItemListener;
import java.io.*;
import java.util.Scanner;
import java.util.Vector;
public class StartReload extends Component {
    int rows;
    int columns;
    StartReload(){
        Vector<String> vector = new Vector();
        File f = new File("C:\\Users\\ASUS\\IdeaProjects\\Project2");
        FilenameFilter textFilter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".txt");
            }
        };
        File[] files = f.listFiles(textFilter);
        for (File file : files) {
            if (file.isDirectory()) {
                System.out.print("directory:");
            } else {
                System.out.print("     file:");
                vector.add(file.getName());
            }
            try {
                System.out.println(file.getCanonicalPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String load[] = vector.toArray(new String[vector.size()]);
        JComboBox<String> savedFiles = new JComboBox<String>();
        for (int i = 0; i <load.length ; i++) {
            savedFiles.addItem(load[i]);
        }
        Vector<Integer> items = new Vector<>();
        String selected = (String) savedFiles.getSelectedItem();
        File myObj = new File(selected);
        try{
            Scanner reader = new Scanner(myObj);
            rows = reader.nextInt();
            columns = reader.nextInt();
            while(reader.hasNextLine()){
                String data = reader.nextLine();
                System.out.println(data);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        JFrame reload = new JFrame("Reload");
        reload.setLayout(new FlowLayout());
        reload.setSize(300, 300);
        reload.setLocationRelativeTo(null);
        reload.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        reload.add(savedFiles);
        reload.setVisible(true);
        reload.setResizable(false);
    }

}

