package chatboxInteractions;

import javax.swing.*;

/**
 * General class to throw a Message
 * Dialog Box whenever the user lands
 * into an error
 */
public class ErrorMessageDisplay
{
    private final String errorMessage;

    public ErrorMessageDisplay(String message)
    {
        this.errorMessage = message;
        throwDialog();
    }

    private void throwDialog()
    {
        String errorHeader = "There was an Error";
        JOptionPane.showMessageDialog(null, errorMessage, errorHeader, JOptionPane.ERROR_MESSAGE);
    }


}
