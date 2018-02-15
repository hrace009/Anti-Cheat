package click;

import java.io.File;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
public class Main {
    public static boolean firstRead = true;
    public static String ipPort = "";

    public Main() {}

    public static void main(String[] args) throws Exception {
        if (args.length < 2) {
            throw new Exception("This program should take two values as input parameteres: a log file name and the ip:port of the server");
        }

        String logFileName = args[0];
        ipPort = args[1];

        TimerTask task = new FileWatcher(new File(logFileName), firstRead) {
            protected void onChange(File file) {
                CheatEngineHandler readLog = new CheatEngineHandler(file.getAbsolutePath());
                Main.firstRead = false;
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, new Date(), 4000L);
    }
}
