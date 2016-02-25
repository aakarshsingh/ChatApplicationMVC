package chatboxUI;

import chatboxListeners.ButtonActionListener;
import chatboxLogic.ServerScreenController;

import javax.swing.*;
import java.awt.*;

/**
 * Java Swing JFrame Class for ServerScreen
 *
 * This is the first screen the Server side
 * user sees
 */
public class ServerScreenView extends JFrame
{
    public static String getStartServerButtonText()
    {
        return startServerButtonText;
    }

    private static final String IPText = "Server IP is ";
    private static final String startServerButtonText = "Setup Server";

    public ServerScreenView()
    {
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        JLabel IPLabel = new JLabel();
        setIPLabel(IPLabel);

        JButton startServerButton = new JButton(startServerButtonText);
        setButton(startServerButton);

        JPanel header = new JPanel();
        header.add(IPLabel);

        JPanel footer = new JPanel();
        footer.add(startServerButton);

        setTitle("Setup Server");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setCenterLocation();
        setSize(350,200);
        setResizable(false);

        contentPane.add(header, BorderLayout.NORTH);
        contentPane.add(footer, BorderLayout.SOUTH);
    }

    private void setCenterLocation()
    {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }

    private void setButton(JButton button)
    {
        ButtonActionListener actionListener = new ButtonActionListener();
        button.addActionListener(actionListener);
        button.setFont(WelcomeScreenView.getMyFont());
    }

    private void setIPLabel(JLabel ipLabel)
    {
        ServerScreenController screenController = new ServerScreenController();
        ipLabel.setText(IPText + screenController.getIPAddress());
        ipLabel.setFont(WelcomeScreenView.getMyFont());
    }
}
