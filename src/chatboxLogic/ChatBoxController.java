package chatboxLogic;

/**
 * This handles the logic needed for the Chat Box
 * which is the final screen of this application
 */
public class ChatBoxController
{
    /**
     * This function validates the message which the
     * user is trying to send to the other side
     *
     * @param message the message that the user is trying
     *                to send
     *
     * @return flag true/false according to the validity
     *              of the message
     */
    public boolean isValidMessage(String message)
    {
        if(null == message)
            return false;
        message = message.replaceAll(" ","");
        return !message.isEmpty();
    }

    /**
     * This function prepares the final message for the
     * Chat Box, it appends the retrieved user name
     * from the machine and forms the final message
     * [UserName] : [Message]
     *
     * @param message the message that the user is trying
     *                to send
     * @return the final message for the Chat Box
     */
    public String prepareFinalMessage(String message)
    {
        if(null == message)
            return "";
        WelcomeScreenController welcomeScreenController = new WelcomeScreenController();
        String userName = welcomeScreenController.getName();
        return userName+" : "+message+"\n";
    }
}
