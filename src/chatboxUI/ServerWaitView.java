package chatboxUI;

import chatboxListeners.ButtonActionListener;
import chatboxLogic.ServerScreenController;

import javax.swing.*;
import java.awt.*;
/**
 * Java Swing JFrame Class for ServerScreen
 *
 * This is the second screen the Server side
 * user sees, this prompts the user to setup
 * the server
 */
public class ServerWaitView extends JFrame
{
    public static String getStartServerButtonText()
    {
        return startServerButtonText;
    }
    public static int getPORT()
    {
        return PORT;
    }

    private static final String IPText = "Server IP is ";
    private static final String portText = "Port # is ";
    private static final String startServerButtonText = "Start Server";
    private static int PORT;

    public ServerWaitView(int currentPort)
    {
        PORT = currentPort;

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        JLabel IPLabel = new JLabel();
        setIPLabel(IPLabel);

        JLabel portLabel = new JLabel();
        setPortLabel(portLabel);

        JButton startServerButton = new JButton(startServerButtonText);
        setButton(startServerButton);

        JPanel header = new JPanel();
        header.add(IPLabel);

        JPanel body = new JPanel();
        body.add(portLabel);

        JPanel footer = new JPanel();
        footer.add(startServerButton);

        setTitle("Server Waiting");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setCenterLocation();
        setSize(350,200);
        setResizable(false);

        contentPane.add(header, BorderLayout.NORTH);
        contentPane.add(body, BorderLayout.CENTER);
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

    private void setPortLabel(JLabel portLabel)
    {
        portLabel.setText(portText + String.valueOf(PORT));
        portLabel.setFont(WelcomeScreenView.getMyFont());
    }

    private void setIPLabel(JLabel ipLabel)
    {
        ServerScreenController screenController = new ServerScreenController();
        ipLabel.setText(IPText + screenController.getIPAddress());
        ipLabel.setFont(WelcomeScreenView.getMyFont());
    }
}
