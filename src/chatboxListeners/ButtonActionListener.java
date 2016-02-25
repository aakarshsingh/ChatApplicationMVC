package chatboxListeners;

import chatboxLogic.SecurePort;
import chatboxLogic.Server_Socket;
import chatboxUI.ClientScreenView;
import chatboxUI.ServerScreenView;
import chatboxUI.ServerWaitView;
import chatboxUI.WelcomeScreenView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listener class which handles all the Action Events
 * for the buttons across the screens
 */
public class ButtonActionListener implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        if(actionEvent.getActionCommand().equals(WelcomeScreenView.getServerButtonText()))
        {
            hidePreviousFrame(actionEvent);
            ServerScreenView screenView = new ServerScreenView();
            screenView.setVisible(true);
        }
        else if(actionEvent.getActionCommand().equals(WelcomeScreenView.getClientButtonText()))
        {
            hidePreviousFrame(actionEvent);
            ClientScreenView screenView = new ClientScreenView();
            screenView.setVisible(true);
        }
        else if(actionEvent.getActionCommand().equals(ServerScreenView.getStartServerButtonText()))
        {
            hidePreviousFrame(actionEvent);
            int currentFreePort = retrieveAFreePort();
            ServerWaitView waitView = new ServerWaitView(currentFreePort);
            waitView.setVisible(true);
        }
        else if(actionEvent.getActionCommand().equals(ServerWaitView.getStartServerButtonText()))
        {
            new Server_Socket(ServerWaitView.getPORT());
            hidePreviousFrame(actionEvent);
        }
    }

    private int retrieveAFreePort()
    {
        SecurePort port = new SecurePort();
        return port.getPort();
    }

    private void hidePreviousFrame(ActionEvent actionEvent)
    {
        Window frame = SwingUtilities.windowForComponent((Component)actionEvent.getSource());
        frame.setVisible(false);
    }
}
