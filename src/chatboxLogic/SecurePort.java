package chatboxLogic;

import chatboxInteractions.ErrorMessageDisplay;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * This class randomly procures a PORT number
 * which is not being used on the Server
 *
 * This is done by first creating a socket,
 * getting the port and then closing the socket
 *
 * The server side then shares this with
 * the client and they can connect using
 * the IP and Port
 */
public class SecurePort
{
    private static int PORT;

    public SecurePort()
    {
        setPort();
    }

    private void setPort()
    {
        try
        {
            ServerSocket socket = new ServerSocket(0);
            socket.setReuseAddress(true);
            PORT = socket.getLocalPort();
            socket.close();
        }
        catch (IOException e)
        {
            new ErrorMessageDisplay("There was a problem while retrieving a free port, please try again");
        }
    }

    public int getPort()
    {
        return PORT;
    }
}
