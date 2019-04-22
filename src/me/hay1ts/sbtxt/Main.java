package me.hay1ts.sbtxt;

import javax.swing.*;

//TODO: Add refresh buttons to pull players and casters from the text files without needing a restart
/**
 * Handles all window operations including showing
 * the window and updating the components
 */
public class Main {
    private JFrame jfrMain;
    private JPanel jpnMain;
    private JComboBox jcbP1;
    private JComboBox jcbP2;
    private JSpinner jspP1s;
    private JSpinner jspP2s;
    private JLabel lblP1;
    private JLabel lblP1s;
    private JLabel lblP2s;
    private JLabel lblP2;
    public String[] players;
    public String[] casters;

    /**
     * Sets the properties of the main window and shows it
     */
    public void show() {
        jfrMain = new JFrame();
        jfrMain.setContentPane(jpnMain);
        jfrMain.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jfrMain.setBounds(Boot.io.x,Boot.io.y, Boot.io.width, Boot.io.height);
        jfrMain.setVisible(true);
    }
}
