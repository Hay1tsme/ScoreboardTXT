package me.hay1ts.sbtxt;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import java.io.*;

/**
 * Handles all file IO, including loading the config
 * file and updating the text files
 */
public class IO {
    public int width = 500;
    public int height = 500;
    public int x = 300;
    public int y = 100;

    private Gson g = new Gson();
    private JsonReader cfgR;

    private File cfgF = new File("./cfg/sb.json");
    private File p1 = new File("./txt/p1.txt");
    private File p1s = new File("./txt/p1s.txt");
    private File p2 = new File("./txt/p2.txt");
    private File p2s = new File("./txt/p2s.txt");
    private File c1 = new File("./txt/c1.txt");
    private File c2 = new File("./txt/c2.txt");
    private File players = new File("./txt/players.txt");
    private File casters = new File("./txt/casters.txt");

    public IO() {
    }

    /**
     * Initial file reading, checks for the presence of the config file as well as the other text files
     * @return true if init passed without issues, false if unrecoverable error
     */
    public boolean init() {
        //TODO: Fix config file loading, it doesn't work right now but at least the rest of the files work
        System.out.println("Loading configuration file...");
        try {
            cfgR = new JsonReader(new FileReader(cfgF));
            JsonObject cfgJ = g.fromJson(cfgR, Object.class);
            System.out.println("Successfully loaded configuration file, loading values...");

            x = cfgJ.get("x").getAsInt();
            y = cfgJ.get("y").getAsInt();
            width = cfgJ.get("width").getAsInt();
            height = cfgJ.get("height").getAsInt();
        } catch (ClassCastException f) {
            System.out.println("Class Cast Error");
            f.printStackTrace();
        }
        catch (FileNotFoundException e) {
            System.out.println("Failed to find config file, creating one with default values");
            try {
                 if (!cfgF.createNewFile()) {
                     System.out.println("Unable to create file, do you have proper permissions?");
                 }
                 else {
                     System.out.println("Writing to new config file");
                     BufferedWriter w = new BufferedWriter(new FileWriter(cfgF, true));
                     w.append("{\n" +
                             "  \"width\": 500,\n" +
                             "  \"height\": 500,\n" +
                             "  \"x\": 500,\n" +
                             "  \"y\": 500\n" +
                             "}\n");
                     w.close();
                     System.out.println("Successfully written to new config file.");
                 }
            } catch (IOException ex) {
                System.out.println("Unable to create file, do you have proper permissions?");
                ex.printStackTrace();
                System.exit(-1);
            }
            e.printStackTrace();
            System.exit(-1);
        }
        findFiles(p1);
        findFiles(p1s);
        findFiles(p2);
        findFiles(p2s);
        findFiles(c1);
        findFiles(c2);
        findFiles(players);
        findFiles(casters);
        return true;
    }

    private void findFiles (File f) {
        System.out.println("Looking for file " + f.getName());
        if(!f.exists()) {
            System.out.println("No " + f.getName() + " file found, creating...");
            try {
                if (!f.createNewFile()) {
                    System.out.println("Failed to create " + f.getName() + " file, do you have permissions?");
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
     * Updates all text files
     */
    public void update() {
        //TODO: Collect values from all fields, write to appropriate files
    }

    /**
     * Updates the requested text file
     * @param f Text file to update
     */
    public void update(File f) {
        //TODO: File file, drop new value
    }

    /**
     * Loads the configuration file and sets the properties accordingly
     * @param f configuration file to load
     */
    public void loadCfg(File f) {
        //TODO: Load config file, set values
    }

    /**
     * Writes changes to the config file
     * @param f Config file
     * @param key key to be changed
     * @param val value to change the key to
     */
    public void writeCfg(File f, String key, String val) {
        //TODO: Load config file, find the key, write the new value
    }

    /**
     *
     * @param f File to get text from
     * @return The file contents in an array, separated by newline
     */
    public String[] reload(File f) {
        //TODO: Read file, seperate by newline, add to array, return array
        String[] cts = {};
        return cts;
    }

}
