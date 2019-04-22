package me.hay1ts.sbtxt;

import java.io.File;
import java.io.IOException;

/**
 * Handles all file IO, including loading the config
 * file and updating the text files
 */
public class IO {
    public int width = 500;
    public int height = 500;
    public int x = 300;
    public int y = 100;
    public File cfg = new File("./cfg/sb.cfg");
    public File p1 = new File("./txt/p1.txt");
    public File p1s = new File("./txt/p1s.txt");
    public File p2 = new File("./txt/p2.txt");
    public File p2s = new File("./txt/p2s.txt");
    public File players = new File("./txt/players.txt");
    public File casters = new File("./txt/casters.txt");

    /**
     * Initial file reading, checks for the presence of the config file as well as the other text files
     * @return true if init passed without issues, false if unrecoverable error
     */
    public boolean init() {
        //test for config file
        if (!cfg.exists()) {
            System.out.println("Config file not found and no other specified. Creating one with default values" +
                    " in the cfg folder.");
            try {
                cfg.createNewFile();
            }
            catch(IOException e) {
                System.out.println("Error creating cfg file. Do you have permissions?");
                return false;
            }
        }
        //test if config file is writable. This will also tell us if it's readable so no need to check.
        if (!cfg.canWrite()) {
            System.out.println("Can't read/write to config file. Do you have permissions?");
            return false;
        }
        //TODO: Test for the rest of the text files and create them if they don't exist
        return true;
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
