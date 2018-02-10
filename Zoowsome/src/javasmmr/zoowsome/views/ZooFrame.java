package javasmmr.zoowsome.views;
import javax.swing.JFrame;
import javasmmr.zoowsome.services.factories.constants.*;
import javasmmr.zoowsome.views.utilities.FrameStack;
import org.omg.CORBA.PUBLIC_MEMBER;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class ZooFrame extends JFrame implements ZooFrame_I {
    protected JPanel contentPanel;  //it contains all items from the frame except the little bar with back button

    public ZooFrame(String title){
        FrameStack.getInstance().push(this);
        setTitle(title);
        setSize(Constants.Frames.WIDTH, Constants.Frames.HEIGHT);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);  //put the layer to the center
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPanel=new JPanel();
        contentPanel.setBorder(new EmptyBorder(5,5,5,5));
        contentPanel.setBackground(Color.red);
        add(contentPanel, BorderLayout.CENTER);
    }

    public void setBackButtonActionListener(ActionListener a){
        JPanel buttonPanel=new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); //The position of back button
        JButton backButton=new JButton("Back");
        buttonPanel.add(backButton);
        this.add(buttonPanel, BorderLayout.NORTH);
        backButton.addActionListener(a);
    }

    @Override
    public void goBack() {

    }
}
