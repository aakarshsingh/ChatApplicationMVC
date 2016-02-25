import chatboxUI.WelcomeScreenView;

/**
 *
 * The solution is a one-to-one chat application
 * which lets two people talk by setting up a connection
 * on a secure port using TCP Sockets
 *
 * One person gets to be the server and invites the
 * client to connect on its server
 *
 * Once the server is running, the client connects and they
 * get the Chat Box which they can use to chat
 *
 * @author AS046134
 * @version 0.2
 * @since 2016-02-23
 */
public class Main
{
    /**
     * The main function initializes the first screen and starts the
     * whole application
     *
     * @param args These are the command line arguments
     */
    public static void main(String[] args)
    {
        WelcomeScreenView welcomeScreenView = new WelcomeScreenView();
        welcomeScreenView.setVisible(true);
    }
}
