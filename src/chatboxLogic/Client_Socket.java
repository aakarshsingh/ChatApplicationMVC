package chatboxLogic;

import chatboxInteractions.ErrorMessageDisplay;
import chatboxUI.ChatBoxView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * This class sets up the Client Socket
 *
 * It uses the IP and Port which the server
 * has shared with the client
 *
 * This sets up the BufferedReader and the PrintWriters
 * which will be attached to the client
 *
 * It finally calls for an instance of the ChatBox
 */
public class Client_Socket
{
    private final int PORT;
    private final String IP;
    Client_Socket(String IP, int PORT)
    {
        this.IP = IP;
        this.PORT = PORT;
        initComponents();
    }
    private void initComponents()
    {
        try
        {
            Socket socket = new Socket(IP, PORT);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            new ChatBoxView(bufferedReader, printWriter).setVisible(true);
        }
        catch (IOException e)
        {
            new ErrorMessageDisplay("Error Connecting with Server");
        }
    }
}