package chatboxLogic;

import chatboxInteractions.ErrorMessageDisplay;

import java.net.InetAddress;
import java.net.UnknownHostException;
/**
 * This handles the logic behind the ServerScreen
 * of the application
 *
 * It retrieves the Server IP from the backend and
 * then shares it on the screen
 *
 */
public class ServerScreenController
{
    /**
     * Helper function to retrieve the IP address
     * from the Server's Machine
     *
     * @return IP Address in String format
     */
    public String getIPAddress()
    {
        String hostAddress="";
        try
        {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        }
        catch (UnknownHostException e)
        {
            new ErrorMessageDisplay("There was a problem while retrieving the local IP, please try again");
        }
        return hostAddress;
    }
}
