package click;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BanController
{
    public BanController() {}

    public static void ban(String id, String tag)
    {
        String ipPort = Main.ipPort;
        String banUrl = "http://" + ipPort + "/pwAdmin/ban.jsp?id=";
        banUrl = banUrl + id;
        String command = "wget -c " + banUrl + " -q > /dev/null";
        Calendar c = Calendar.getInstance();
        SimpleDateFormat DF = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
        String nowTime = DF.format(c.getTime()) + " GMT";
        try
        {
            Process processo = Runtime.getRuntime().exec(command);
            FileWriter fw = new FileWriter("BanLog.txt", true);
            fw.write("UserID:" + id + " has been banned for using " + tag + ". Date: "+ nowTime + "\n");
            fw.close();
        } catch (IOException e) {
            System.out.println("FAILED TO INVOKE BAN: " + banUrl);
            e.printStackTrace();
        }
    }
}