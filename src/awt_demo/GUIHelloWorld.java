package awt_demo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUIHelloWorld {
    TextField username = null;
    TextField password = null;
    class ButtonClickHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand() == "SEND"){
                System.out.println("sending...." + username.getText());
                System.out.println("sending...." + password.getText());
            }else if(e.getActionCommand() == "CLEAR"){
                username.setText(" ");
                password.setText(" ");
            }
        }

    }
    private Frame mainFrame;
    private Panel headerPanel;
    private Panel controlPanel;
    private Panel footerPanel;
    public GUIHelloWorld() {
        prepareGUI();
    }

    public static void main(String[] args) {
        GUIHelloWorld guiHelloWorld = new GUIHelloWorld();
    }

    private void prepareGUI(){
        mainFrame = new Frame("JAVA GUI");
        mainFrame.setSize(400, 400);
        mainFrame.setLayout(new GridLayout(3,1));

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                mainFrame.dispose();
            }
        });

        headerPanel = new Panel();
        headerPanel.setSize(100,100);
        headerPanel.setLayout(new GridLayout(2, 1));
        Label titleLabel = new Label("SIGNUP");
        titleLabel.setAlignment(Label.CENTER);

        Panel formPanel = new Panel();
        Panel ButtonPanel = new Panel();
        ButtonPanel.setLayout(new FlowLayout());
        formPanel.setLayout(new GridLayout(3,1));
        username = new TextField("", 10);
        password = new TextField("", 20);
        Button send = new Button("Send");
        Button clear = new Button("Clear");
        ButtonPanel.add(send);
        ButtonPanel.add(clear);

        // Adding commands
        clear.setActionCommand("CLEAR");
        send.setActionCommand("SEND");
        ButtonClickHandler buttonClickHandler = new ButtonClickHandler();
        send.addActionListener(buttonClickHandler);
        clear.addActionListener(buttonClickHandler);

        //  Adding buttons to the container
        formPanel.add(username);
        formPanel.add(password);
        formPanel.add(ButtonPanel);

        headerPanel.add(titleLabel);
        headerPanel.add(formPanel);


        //Adding to the mainFrame
        mainFrame.add(headerPanel);
        mainFrame.setVisible(true);
    }

}
