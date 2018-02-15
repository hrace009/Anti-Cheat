package click;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class CheatEngineHandler
{
    private String CHEATENGINEWORDS = "./Configs/CheatEngineWords.txt";
    private String USERCONTEXT = "./Configs/UserContext.txt";
    private Vector<String> cheatEngineWords;
    private String currentUser;
    private String userContext;

    public CheatEngineHandler(String logFileName)
    {
        cheatEngineWords = new Vector();
        userContext = "";
        currentUser = "";
        loadCheatWords();
        loadUserContext();
        System.gc();

        String logPath = logFileName;
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(logPath));
            String line = "";
            while ((line = br.readLine()) != null) {
                if (declaresNewUser(line)) {
                    currentUser = getUserID(line);
                }
                else
                {
                    String tag = hasCheatEngine(line);
                    if (!tag.equals("")) {
                        BanController.ban(currentUser, tag);
                        System.out.println("User " + currentUser + "has been banned");
                    }
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileWriter fwx = new FileWriter(logFileName);
            fwx.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean declaresNewUser(String text) {
        if ((text != null) && (text.contains("acReport received from user")))
            return true;
        return false;
    }

    private String hasCheatEngine(String text) {
        for (String cw : cheatEngineWords) {
            if (text.contains(cw)) {
                return cw;
            }
        }
        return "";
    }

    private String getUserID(String text) {
        String userID = "";
        if (text != null) {
            userID = text.replace(userContext, "");
        }
        return userID;
    }

    private void loadUserContext()
    {
        try {
            BufferedReader br = new BufferedReader(new FileReader(USERCONTEXT));
            String line = br.readLine();
            userContext = line;
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadCheatWords()
    {
        try {
            BufferedReader br = new BufferedReader(new FileReader(CHEATENGINEWORDS));
            String line = "";
            while ((line = br.readLine()) != null) {
                cheatEngineWords.add(line);
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
