package chatboxUI;

import chatboxLogic.ChatBoxController;
import chatboxLogic.ChatBoxThreadReader;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.PrintWriter;

/**
 * Java Swing JFrame Class for ChatBox
 *
 * This is the final screen which lets
 * the users talk to each other
 */
public class ChatBoxView extends JFrame
{
    private static BufferedReader bufferedReader;
    private static PrintWriter printWriter;
    private final JTextArea chatBoxTextArea = new JTextArea();
    private JTextField chatBoxTextField = new JTextField();

    public ChatBoxView(BufferedReader bufferedReader, PrintWriter printWriter)
    {
        ChatBoxView.bufferedReader = bufferedReader;
        ChatBoxView.printWriter = printWriter;
        initComponents();
        new ChatBoxThreadReader(bufferedReader, chatBoxTextArea);
    }

    private void initComponents()
    {
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        chatBoxTextField = new JTextField(42);
        new GhostText(chatBoxTextField, "press enter to exchange messages");

        chatBoxTextField.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                chatBoxTextFieldActionPerformed(evt);
            }

            private void chatBoxTextFieldActionPerformed(ActionEvent evt)
            {
                String message = chatBoxTextField.getText();
                ChatBoxController chatBoxController = new ChatBoxController();
                if(chatBoxController.isValidMessage(message))
                {
                    sendMessage(chatBoxController.prepareFinalMessage(message));
                    chatBoxTextField.setText("");
                }
                else
                {
                    chatBoxTextField.setFocusCycleRoot(true);
                }
            }
        });

        JScrollPane chatScrollPane = new JScrollPane (chatBoxTextArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        DefaultCaret caret = (DefaultCaret)chatBoxTextArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        setTitle("Talk");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800,800);
        setCenterLocation();
        setResizable(false);

        setUpTextArea(chatBoxTextArea);
        setUpTextField(chatBoxTextField);

        JPanel header = new JPanel();
        header.add(chatScrollPane);

        JPanel footer = new JPanel();
        footer.add(chatBoxTextField);

        contentPane.add(header, BorderLayout.NORTH);
        contentPane.add(footer, BorderLayout.SOUTH);
    }

    private void sendMessage(String finalMessage)
    {
        chatBoxTextArea.append(finalMessage);
        printWriter.print(finalMessage);
        printWriter.flush();
    }

    private void setUpTextField(JTextField textField)
    {
        textField.setFont(WelcomeScreenView.getMyFont());
    }

    private void setUpTextArea(JTextArea textArea)
    {
        textArea.setFont(WelcomeScreenView.getMyFont());
        textArea.setColumns(42);
        textArea.setFont(WelcomeScreenView.getMyFont());
        textArea.setRows(26);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setAutoscrolls(true);
        textArea.setEditable(false);
        DefaultCaret caret = (DefaultCaret)textArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
    }

    private void setCenterLocation()
    {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }
}
