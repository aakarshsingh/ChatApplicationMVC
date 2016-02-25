package chatboxLogic;

import chatboxInteractions.ErrorMessageDisplay;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * This handles the logic behind the WelcomeScreen
 * of the application
 *
 * It retrieves the username and the Local Machine
 * IP Address from the machine
 *
 */
public class WelcomeScreenController
{
    /**
     * Helper function to retrieve the username
     * from the User's Machine
     *
     * @return Username in String format
     */
    public String getName()
    {
        String userName="";
        try
        {
            userName = System.getProperty("user.name");
        }
        catch (Exception e)
        {
            new ErrorMessageDisplay("There was a problem while retrieving the User Name, please try again");
        }
        return userName;
    }
    /**
     * Helper function to retrieve the IP address
     * from the User's Machine
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
