package javasmmr.zoowsome.controllers;
import javasmmr.zoowsome.views.AddFrame;
import javasmmr.zoowsome.views.AnimalFrame;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class AddController extends AbstractController {
    AddFrame addframe;
    public AddController(AddFrame addFrame, boolean hasBackButton){
        super(addFrame, hasBackButton);
        this.addframe=addFrame;
        addFrame.setComboboxItemListener(new AddBoxItemListener());
    }

    private class AddBoxItemListener implements ItemListener {
        public AddBoxItemListener(){}
        @Override
        public void itemStateChanged(ItemEvent e) {
            String type=addframe.getValueOfCombobox();
            new AnimalController(new AnimalFrame("Animals"), true, type);
        }
    }
}
