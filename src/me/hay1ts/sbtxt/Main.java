package me.hay1ts.sbtxt;

import javax.swing.*;

/**
 * Handles all window operations including showing
 * the window and updating the components
 */
public class Main {
    private JFrame jfrMain;
    private JPanel jpnMain;

    private JComboBox jcbP1;
    private JComboBox jcbP2;
    private JComboBox jcbC1;
    private JComboBox jcbC2;
    private JSpinner jspP1s;
    private JSpinner jspP2s;

    private JLabel lblP1;
    private JLabel lblP1s;
    private JLabel lblP2s;
    private JLabel lblP2;
    private JLabel lblC1;
    private JLabel lblC2;

    private JButton btnRefreshC;
    private JButton btnPush;
    private JButton btnRefreshP;

    private String[] players;
    private String[] casters;

    public  Main() {
        btnRefreshC.addActionListener(e -> {
            updateCList();
        });
        btnPush.addActionListener(e -> {
            IO.updateW(IO.c1, (String)jcbC1.getSelectedItem());
            IO.updateW(IO.c2, (String)jcbC2.getSelectedItem());
            IO.updateW(IO.p1, jcbP1.getSelectedItem() + " - " + jspP1s.getValue());
            IO.updateW(IO.p2, jcbP2.getSelectedItem() + " - " + jspP2s.getValue());
        });
        jcbP1.addActionListener(e -> {
            if (jcbP1.getSelectedItem() != null) {
                IO.updateW(IO.p1, jcbP1.getSelectedItem() + " - " + jspP1s.getValue());
            }
        });
        jspP1s.addChangeListener(e -> {
            if (jcbP1.getSelectedItem() != null) {
                IO.updateW(IO.p1, jcbP1.getSelectedItem() + " - " + jspP1s.getValue());
            }
        });
        jcbP2.addActionListener(e -> {
            if (jcbP2.getSelectedItem() != null) {
                IO.updateW(IO.p2, jcbP2.getSelectedItem() + " - " + jspP2s.getValue());
            }
        });
        jspP2s.addChangeListener(e -> {
            if (jcbP2.getSelectedItem() != null) {
                IO.updateW(IO.p2, jcbP2.getSelectedItem() + " - " + jspP2s.getValue());
            }
        });
        jcbC1.addActionListener(e -> {
            if (jcbC1.getSelectedItem() != null) {
                IO.updateW(IO.c1, (String)jcbC1.getSelectedItem());
            }
        });
        jcbC2.addActionListener(e -> {
            if (jcbC2.getSelectedItem() != null) {
                IO.updateW(IO.c2, (String) jcbC2.getSelectedItem());
            }
        });
        btnRefreshP.addActionListener(e -> {
            updatePList();
        });
    }

    /**
     * Sets the properties of the main window and shows it
     */
    public void show() {
        jfrMain = new JFrame("ScoreboardTXT ver. " + Boot.ver);
        jfrMain.setContentPane(jpnMain);
        jfrMain.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jfrMain.setBounds(IO.x,IO.y, IO.width, IO.height);
        jfrMain.setVisible(true);
        updatePList();
        updateCList();
    }

    private void updateCList(){
        casters = IO.updateR(IO.casters);

        jcbC1.removeAllItems();
        jcbC1.addItem("");
        for (String s : casters) {
            jcbC1.addItem(s);
        }

        jcbC2.removeAllItems();
        jcbC2.addItem("");
        for (String s : casters) {
            jcbC2.addItem(s);
        }
    }

    private void updatePList() {
        players = IO.updateR(IO.players);
        jcbP1.removeAllItems();
        jcbP1.addItem("");
        for (String s : players) {
            jcbP1.addItem(s);
        }

        jcbP2.removeAllItems();
        jcbP2.addItem("");
        for (String s : players) {
            jcbP2.addItem(s);
        }
    }
}
