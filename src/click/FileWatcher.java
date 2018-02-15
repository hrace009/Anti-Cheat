package click;

import java.io.File;
import java.util.TimerTask;

public abstract class FileWatcher extends TimerTask
{
    private long timeStamp;
    private File file;
    private boolean firstRead;

    public FileWatcher(File file, boolean firstRead)
    {
        this.file = file;
        timeStamp = file.lastModified();
        this.firstRead = firstRead;
    }

    public final void run() {
        long timeStamp = file.lastModified();

        if ((this.timeStamp != timeStamp) || (firstRead)) {
            this.timeStamp = timeStamp;
            onChange(file);
            firstRead = false;
        }
    }

    protected abstract void onChange(File paramFile);
}
