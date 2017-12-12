package pl.blaszak.kata.digitalroot;

public class PrinterError {

    public static String getStatistic(String commands) {
        return commands.replace("[a-m]", "").length() + "/" + commands.length();
    }
}
