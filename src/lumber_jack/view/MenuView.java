package lumber_jack.view;
import javax.swing.*;

import lumber_jack.controller.FactoryController;
import lumber_jack.controller.ForestController;
import lumber_jack.controller.MenuController;
import lumber_jack.model.IndustryModel;

import java.awt.*;
import java.io.IOException;
import java.awt.event.*;

public class MenuView {
    public void TitleScreen() {

        JFrame f = new JFrame();

        System.out.println(System.getProperty("user.dir"));


        JButton start = new JButton("Start");
        String StartButtonIconPath=System.getProperty("user.dir").concat("/img/LogMenuStart.png");
        start.setBounds(350, 150, 100, 46);
        start.setOpaque(false);
        start.setContentAreaFilled(false);
        start.setBorderPainted(false);
        start.setIcon(new ImageIcon(StartButtonIconPath));
        f.add(start);
        JButton quit = new JButton("Quit");
        String QuitButtonIconPath=System.getProperty("user.dir").concat("/img/LogMenuQuit.png");
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

        String path =System.getProperty("user.dir").concat("/img/tall-trees-gbbca0afbf_1280.png");
        JLabel background=new JLabel(new ImageIcon(path));
        background.setBounds(0,0,800,500);
        f.add(background);


        f.setSize(800,500);
        f.setLayout(null);
        f.setVisible(true);


        start.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Dimension size = Toolkit.getDefaultToolkit().getScreenSize();

                JFrame game = new JFrame("LumberJack");
                JFrame forestGame = new JFrame("Lumberjack forest");
                game.setLayout(new GridBagLayout());
                forestGame.setLayout(new GridBagLayout());
                
                game.setSize(size);
                forestGame.setSize(size);

                RessourcePanel ressources = new RessourcePanel(size);
            
                ForestController forestController = new ForestController(size);
                FactoryController factoryController= new FactoryController(size,ressources);

                game.add(ressources, createSideMenuConstraints(size));
                forestGame.add(forestController.getPanel(),createMainPanelConstraints(size));
                game.add(factoryController.getPanel(),createMainPanelConstraints(size));

                game.setVisible(true);
                forestGame.setVisible(true);

                new IndustryModel();
                new MenuController();
            }

            
        });
    }

    private GridBagConstraints createSideMenuConstraints(Dimension size) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weightx = 0.5;
        constraints.fill = GridBagConstraints.VERTICAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        constraints.ipadx = size.width/5;
        constraints.ipady = size.height;
        return constraints;
    }

    private GridBagConstraints createMainPanelConstraints(Dimension size) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weightx = 0.8;
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        constraints.ipadx = size.width*4/5;
        constraints.ipady = size.height*4/5;
        return constraints;
    }
}
