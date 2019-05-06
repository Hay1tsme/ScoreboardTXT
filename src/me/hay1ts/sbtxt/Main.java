package me.hay1ts.sbtxt;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;

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

    private JButton btnRefresh;
    private JButton btnPush;

    private String[] players;
    private String[] casters;

    private String er;

    public Main() {
        btnRefresh.addActionListener(e -> {
            updateCList();
            updatePList();
        });
        btnPush.addActionListener(e -> {
            Boot.io.updateW(Boot.io.c1, (String)jcbC1.getSelectedItem());
            Boot.io.updateW(Boot.io.c2, (String)jcbC2.getSelectedItem());
            Boot.io.updateW(Boot.io.p1, jcbP1.getSelectedItem() + " - " + jspP1s.getValue());
            Boot.io.updateW(Boot.io.p2, jcbP2.getSelectedItem() + " - " + jspP2s.getValue());
        });
        jcbP1.addActionListener(e -> {
            if (jcbP1.getSelectedItem() != null) {
                Boot.io.updateW(Boot.io.p1, jcbP1.getSelectedItem() + " - " + jspP1s.getValue());
            }
        });
        jspP1s.addChangeListener(e -> {
            if (jcbP1.getSelectedItem() != null) {
                Boot.io.updateW(Boot.io.p1, jcbP1.getSelectedItem() + " - " + jspP1s.getValue());
            }
        });
        jcbP2.addActionListener(e -> {
            if (jcbP2.getSelectedItem() != null) {
                Boot.io.updateW(Boot.io.p2, jcbP2.getSelectedItem() + " - " + jspP2s.getValue());
            }
        });
        jspP2s.addChangeListener(e -> {
            if (jcbP2.getSelectedItem() != null) {
                Boot.io.updateW(Boot.io.p2, jcbP2.getSelectedItem() + " - " + jspP2s.getValue());
            }
        });
        jcbC1.addActionListener(e -> {
            if (jcbC1.getSelectedItem() != null) {
                Boot.io.updateW(Boot.io.c1, (String)jcbC1.getSelectedItem());
            }
        });
        jcbC2.addActionListener(e -> {
            if (jcbC2.getSelectedItem() != null) {
                Boot.io.updateW(Boot.io.c2, (String) jcbC2.getSelectedItem());
            }
        });
    }

    /**
     * Sets the properties of the main window and shows it
     */
    public void show() {
        jfrMain = new JFrame("ScoreboardTXT ver. " + Boot.ver);
        jfrMain.setContentPane(jpnMain);
        jfrMain.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jfrMain.setBounds(Boot.io.x,Boot.io.y, Boot.io.width, Boot.io.height);
        jfrMain.setVisible(true);
        updatePList();
        updateCList();
    }

    private void updateCList(){
        casters = Boot.io.updateR(Boot.io.casters);

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
        players = Boot.io.updateR(Boot.io.players);
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
