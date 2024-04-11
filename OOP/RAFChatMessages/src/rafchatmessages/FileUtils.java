package rafchatmessages;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FileUtils {
    public static void writeEmojis(List<Emoji> emojis) {
        FileWriter fileWriter = null;
        PrintWriter printWriter = null;
        try {
            fileWriter = new FileWriter("emojis.txt");
            printWriter = new PrintWriter(fileWriter);
            emojis.sort(null);
            for (Emoji e : emojis)
                printWriter.println(e.getNaziv() + ";" + e.getSkracenica());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (printWriter != null)
                printWriter.close();
            try {
                if (fileWriter != null)
                    fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
