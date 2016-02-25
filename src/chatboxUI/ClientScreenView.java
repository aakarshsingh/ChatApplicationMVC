package chatboxUI;

import chatboxLogic.ClientScreenController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Java Swing JFrame Class for ClientScreen
 *
 * This is the client screen which lets
 * the client setup the connection
 */
public class ClientScreenView extends JFrame
{
    public static String getConnectServerButtonText()
    {
        return connectServerButtonText;
    }

    private static final String IPText = "Server IP : ";
    private static final String portText = "Server Port : ";
    private static final String connectServerButtonText = "Connect with Server";

    public ClientScreenView()
    {
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        JLabel IPLabel = new JLabel();
        setIPLabel(IPLabel);

        JTextField IPField = new JTextField(10);
        IPField.setFont(WelcomeScreenView.getMyFont());

        JLabel portLabel = new JLabel();
        setPortLabel(portLabel);

        JTextField portField = new JTextField(5);
        portField.setFont(WelcomeScreenView.getMyFont());

        JButton connectServerButton = new JButton(connectServerButtonText);
        connectServerButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                connectServerButtonActionPerformed(evt);
            }

            private void connectServerButtonActionPerformed(ActionEvent evt)
            {
                String port = portField.getText();
                String IP = IPField.getText();
                new ClientScreenController(port, IP);
                setVisible(false);
            }
        });
        connectServerButton.setFont(WelcomeScreenView.getMyFont());

        JPanel header = new JPanel();
        header.setLayout(new FlowLayout(FlowLayout.LEFT));
        header.add(IPLabel);
        header.add(IPField);

        JPanel body = new JPanel();
        body.setLayout(new FlowLayout(FlowLayout.LEFT));
        body.add(portLabel);
        body.add(portField);

        JPanel footer = new JPanel();
        footer.add(connectServerButton);

        setTitle("Client Setup");
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

    private void setPortLabel(JLabel portLabel)
    {
        portLabel.setText(portText);
        portLabel.setFont(WelcomeScreenView.getMyFont());
    }

    private void setIPLabel(JLabel ipLabel)
    {
        ipLabel.setText(IPText);
        ipLabel.setFont(WelcomeScreenView.getMyFont());
    }
}
