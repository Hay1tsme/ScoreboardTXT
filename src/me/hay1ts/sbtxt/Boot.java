package me.hay1ts.sbtxt;

/**
 * Main class, handles creating the initial GUI as well as initialization
 */
public class Boot {
    public static IO io = new IO();
    public static Main m = new Main();
    public static String ver = "α0.0.1";
    public static void main(String args[]) {
        if (io.init()) {
            m.show();
        }
    }
}
