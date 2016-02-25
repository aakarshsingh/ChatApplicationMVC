package chatboxLogic;

import chatboxInteractions.ErrorMessageDisplay;
import chatboxUI.ChatBoxView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * This class sets up the Server Socket
 *
 * It uses the Port which the SecurePort class
 * has retrieved, then waits for the connection from
 * the client side
 *
 * This sets up the BufferedReader and the PrintWriters
 * which will be attached to the server
 *
 * It finally calls for an instance of the ChatBox
 */
public class Server_Socket
{
    private final int PORT;
    public Server_Socket(int PORT)
    {
        this.PORT = PORT;
        initComponents();
    }
    private void initComponents()
    {
        try
        {
            ServerSocket serverSocket = new ServerSocket(PORT);
            Socket socket = serverSocket.accept();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            new ChatBoxView(bufferedReader, printWriter).setVisible(true);
        }
        catch (IOException e)
        {
            new ErrorMessageDisplay("Error Connecting with Client");
        }
    }
}
