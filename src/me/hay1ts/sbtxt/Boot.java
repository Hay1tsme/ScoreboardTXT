package me.hay1ts.sbtxt;

/**
 * Main class, handles creating the initial GUI as well as initialization
 */
public class Boot {
    public static Main m = new Main();
    public static String ver = "1.1.0";
    public static void main(String[] args) {
        if (IO.init()) {
            m.show();
        }
    }
}
