package chatboxLogic;

import javax.swing.*;
import java.io.BufferedReader;

/**
 * This is a threaded class which receives all
 * the messages from the other user
 *
 * It also uses appends all the text transferred
 * to the Text Area for the users to keep track
 * of the chat
 */
public class Reader implements Runnable
{
    private final BufferedReader bufferedReader ;
    private final JTextArea chatBox;

    Reader(BufferedReader bufferedReader, JTextArea chatTextArea)
    {
        this.bufferedReader = bufferedReader;
        this.chatBox = chatTextArea;
    }
    @Override
    public void run()
    {
        String receivedMessage;
        try
        {
            while((receivedMessage=bufferedReader.readLine())!=null)
            {
                chatBox.append(receivedMessage+"\n");
            }
        }
        catch(Exception e)
        {
            System.exit(0);
        }
    }
}