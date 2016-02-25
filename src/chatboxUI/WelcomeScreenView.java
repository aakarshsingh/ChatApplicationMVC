package chatboxUI;

import chatboxListeners.ButtonActionListener;
import chatboxLogic.WelcomeScreenController;

import javax.swing.*;
import java.awt.*;
/**
 * Java Swing JFrame Class for WelcomeScreen
 *
 * This is the first screen of the application
 *
 * This asks the user whether they wants to
 * be the client or the server
 */
public class WelcomeScreenView extends JFrame
{
    public static String getServerButtonText()
    {
        return ServerButtonText;
    }

    public static String getClientButtonText()
    {
        return ClientButtonText;
    }
    public static Font getMyFont()
    {
        return myFont;
    }
    private static final String welcomeText = "Hello ";
    private static final String IPText = "Current IP is ";
    private static final String ServerButtonText = "Be Server";
    private static final String ClientButtonText = "Be Client";
    private static final Font myFont = new Font("Calibri", 0, 22);

    public WelcomeScreenView()
    {
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel();
        setWelcomeLabel(welcomeLabel);

        JLabel IPLabel = new JLabel();
        setIPLabel(IPLabel);

        JButton serverButton = new JButton(ServerButtonText);
        JButton clientButton = new JButton(ClientButtonText);
        setButton(serverButton);
        setButton(clientButton);

        JPanel header = new JPanel();
        header.add(welcomeLabel);

        JPanel body = new JPanel();
        body.add(IPLabel);

        JPanel footer = new JPanel();
        footer.setLayout(new FlowLayout(FlowLayout.CENTER));
        footer.add(serverButton);
        footer.add(clientButton);

        setTitle("Welcome");
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
        button.setFont(myFont);
    }

    private void setIPLabel(JLabel ipLabel)
    {
        WelcomeScreenController screenController = new WelcomeScreenController();
        ipLabel.setText(IPText +screenController.getIPAddress());
        ipLabel.setFont(myFont);
    }

    private void setWelcomeLabel(JLabel welcomeLabel)
    {
        WelcomeScreenController screenController = new WelcomeScreenController();
        welcomeLabel.setText(welcomeText +screenController.getName());
        welcomeLabel.setFont(myFont);
    }
}
