package chatboxLogic;

import chatboxInteractions.ErrorMessageDisplay;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This handles the logic behind the ClientScreen
 * of the application
 *
 * The Client is supposed to enter the Server's IP
 * and the PORT
 *
 * The application then tries to establish the connection
 * and opens up the Chat Box
 */
public class ClientScreenController
{
    private boolean socketFlag = false;
    private String IPAddress;
    private String PORT;
    public ClientScreenController(String port, String ip)
    {
        this.IPAddress = ip;
        this.PORT = port;
        validate(port, ip);
        createSocket();
    }
    public ClientScreenController()
    {

    }
    /**
     * This function is responsible to call
     * the Client_Socket class which sets up
     * the client side connection
     */
    private void createSocket()
    {
        if(socketFlag)
        {
            new Client_Socket(IPAddress, Integer.parseInt(PORT));
        }
        else
        {
            new ErrorMessageDisplay("Invalid Configuration");
        }
    }

    /**
     * This function checks whether the IP and the PORT
     * entered by the client are valid or not
     *
     * If either of then don't fit the valid format
     * an error message is thrown for the user
     *
     * @param port the port the client has given
     * @param ip the ip address the client has given
     */
    private void validate(String port, String ip)
    {
        if (isValidIP(ip))
        {
            if (isValidPort(port))
            {
                socketFlag = true;
            }
            else
            {
                new ErrorMessageDisplay("Invalid PORT Number");
            }
        }
        else
        {
            new ErrorMessageDisplay("Invalid IP Address");
        }
    }

    /**
     * Helper function to valid the provided IP address
     * using Regex
     *
     * @param ip the ip address string to validate
     * @return true or false according to the validity
     */
    public boolean isValidIP(String ip)
    {
        Pattern pattern = Pattern.compile("^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$");
        Matcher matcher = pattern.matcher(ip);
        return matcher.find();
    }
    /**
     * Helper function to valid the provided port number
     * using Regex
     *
     * @param port the port to validate
     * @return true or false according to the validity
     */
    public boolean isValidPort(String port)
    {
        Pattern pattern = Pattern.compile("^(\\d{1,5})$");
        Matcher matcher = pattern.matcher(port);
        return matcher.find();
    }
}
