package me.hay1ts.sbtxt;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;

//TODO: Allow the config file to be written to on resizing and moving the window
//TODO: Make new fields for tournament name and current round

/**
 * Handles all file IO, including loading the config
 * file and updating the text files
 */
public class IO {
    public static int width = 550;
    public static int height = 300;
    public static int x = 300;
    public static int y = 100;

    private static String cfgS;

    private static File cfgF = new File("./cfg/sb.json");
    public static File p1 = new File("./txt/p1.txt");
    public static File p2 = new File("./txt/p2.txt");
    public static File c1 = new File("./txt/c1.txt");
    public static File c2 = new File("./txt/c2.txt");
    public static File players = new File("./txt/players.txt");
    public static File casters = new File("./txt/casters.txt");

    public IO() {
    }

    /**
     * Initial file reading, checks for the presence of the config file as well as the other text files
     * @return true if init passed without issues, false if unrecoverable error
     */
    public static boolean init() {
        System.out.println("Loading configuration file...");
        try {
            cfgS = new String(Files.readAllBytes(cfgF.toPath()));
            JsonObject cfgJ = new JsonParser().parse(cfgS).getAsJsonObject();
            System.out.println("Successfully loaded configuration file, loading values...");

            x = cfgJ.get("x").getAsInt();
            y = cfgJ.get("y").getAsInt();
            width = cfgJ.get("width").getAsInt();
            height = cfgJ.get("height").getAsInt();
        } catch (ClassCastException f) {
            System.out.println("Class Cast Error");
            f.printStackTrace();
        }
        catch (IOException e) {
            System.out.println("Failed to find config file, creating one with default values");
            try {
                 if (!cfgF.createNewFile()) {
                     System.out.println("Unable to create file, do you have proper permissions?");
                     JOptionPane.showMessageDialog(null, "Unable to create file, do you have " +
                             "proper permissions?");
                 }
                 else {
                     System.out.println("Writing to new config file");
                     BufferedWriter w = new BufferedWriter(new FileWriter(cfgF, true));
                     w.append("{\n" +
                             "  \"width\": 550,\n" +
                             "  \"height\": 300,\n" +

                             "  \"x\": 500,\n" +
                             "  \"y\": 500\n" +
                             "}\n");
                     w.close();
                     System.out.println("Successfully written to new config file.");
                 }
            } catch (IOException ex) {
                System.out.println("Unable to create file, do you have proper permissions?");
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Unable to create file, do you have " +
                        "proper permissions?");
                System.exit(-1);
            }
            e.printStackTrace();
            System.exit(-1);
        }
        findFiles(p1);
        findFiles(p2);
        findFiles(c1);
        findFiles(c2);
        findFiles(players);
        findFiles(casters);
        return true;
    }

    private static void findFiles (File f) {
        System.out.println("Looking for file " + f.getName());
        if(!f.exists()) {
            System.out.println("No " + f.getName() + " file found, creating...");
            try {
                if (!f.createNewFile()) {
                    System.out.println("Failed to create " + f.getName() + " file, do you have permissions?");
                    JOptionPane.showMessageDialog(null, "Failed to create " + f.getName() +
                            " file, do you have permissions?");
                    System.exit(-1);
                }
                else {
                    System.out.println("Created " + f.getName() + " txt file.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("" + f.getName() + " file found!");
        }
    }

    /**
     * Updates the requested text file by reading from it
     * @param f Text file to read from
     * @return Array of names on success, null on fail
     */
    public static String[] updateR(File f) {
        System.out.println("Reading from file " + f.getName());
        String[] fa;
        try {
            String fs = new String(Files.readAllBytes(f.toPath()));
            fa = fs.split("\\r?\\n");
            return fa;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading from " + f.getName());
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Updates the requested text file by writing to it
     * @param f Text file to write to
     * @param s Text to write to file
     * @return String on error, null on success
     */
    public static  void updateW(File f, String s) {
        System.out.println("Writing " + s + " to " + f.getName());
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(f.toPath().toString()));
            bw.write(s);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error writing to " + f.getName());
        }
    }

    /**
     * Writes changes to the config file
     * @param f Config file
     * @param key key to be changed
     * @param val value to change the key to
     */
    public static void writeCfg(File f, String key, String val) {
        //TODO: Load config file, find the key, write the new value

    }
}
