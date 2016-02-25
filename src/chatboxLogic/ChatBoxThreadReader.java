package chatboxLogic;

import javax.swing.*;
import java.io.BufferedReader;

/**
 * This class runs the threaded reader class
 * which the chat box uses to get the messages
 * sent to them from the other user
 */
public class ChatBoxThreadReader
{
    public ChatBoxThreadReader(BufferedReader bufferedReader, JTextArea chatBoxTextArea)
    {
        Reader reader = new Reader(bufferedReader, chatBoxTextArea);
        new Thread(reader).start();
    }
}
