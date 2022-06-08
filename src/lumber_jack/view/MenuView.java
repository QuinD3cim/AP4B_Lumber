package lumber_jack.view;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.awt.event.*;

public class MenuView {
    public void TitleScreen() {

        JFrame f = new JFrame();

        System.out.println(System.getProperty("user.dir"));


        JButton start = new JButton("Start");
        String StartButtonIconPath=System.getProperty("user.dir").concat("\\img\\LogMenuStart.png");
        start.setBounds(350, 150, 100, 46);
        start.setOpaque(false);
        start.setContentAreaFilled(false);
        start.setBorderPainted(false);
        start.setIcon(new ImageIcon(StartButtonIconPath));
        start.addActionListener(e -> System.exit(0));
        f.add(start);
        JButton quit = new JButton("Quit");
        String QuitButtonIconPath=System.getProperty("user.dir").concat("\\img\\LogMenuQuit.png");
        quit.setBounds(350,250,100,46);
        quit.setOpaque(false);
        quit.setContentAreaFilled(false);
        quit.setBorderPainted(false);
        quit.setIcon(new ImageIcon(QuitButtonIconPath));
        quit.addActionListener(e -> System.exit(0));
        f.add(quit);
        JLabel label = new JLabel("Welcome to Bois Jacques the game", JLabel.CENTER);
        label.setBounds(250,50,300,50);
        label.setForeground(Color.BLACK);
        f.add(label);

        String path =System.getProperty("user.dir").concat("\\img\\tall-trees-gbbca0afbf_1280.png");
        JLabel background=new JLabel(new ImageIcon(path));
        background.setBounds(0,0,800,500);
        f.add(background);


        f.setSize(800,500);
        f.setLayout(null);
        f.setVisible(true);


    }
}
