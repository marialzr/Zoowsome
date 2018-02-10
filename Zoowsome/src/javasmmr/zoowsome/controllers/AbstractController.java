package javasmmr.zoowsome.controllers;

import javasmmr.zoowsome.views.ZooFrame;
import javasmmr.zoowsome.views.utilities.FrameStack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AbstractController {
    protected ZooFrame frame;
    public AbstractController(ZooFrame frame, boolean hasBackButton){
        this.frame=frame;
        if (hasBackButton)
            frame.setBackButtonActionListener(new BackButtonActionListener());
    }
    private class BackButtonActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            FrameStack.getInstance().pop();
        }
    }
}
