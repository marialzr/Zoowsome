package javasmmr.zoowsome.views;

import javasmmr.zoowsome.controllers.AquaticController;
import javasmmr.zoowsome.models.animals.Animal;
import javasmmr.zoowsome.services.factories.constants.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class AddFrame extends ZooFrame {
    JComboBox<String> comboBox;
    public AddFrame(String title){
        super(title);
        comboBox=new JComboBox<>();

        super.contentPanel.setLayout(new GridLayout(6, 0, 0, 0));
        contentPanel.setBackground(Color.blue);

        JPanel panel=new JPanel();
        contentPanel.add(panel);
        GridLayout slpanel=new GridLayout(2, 2, 0, 0);
        panel.setLayout(slpanel);

        JLabel label=new JLabel("Choose the type of animal you wanna add");

        panel.setBackground(Color.CYAN);
        panel.add(label);
        panel.add(comboBox);
        comboBox.addItem("javasmmr.zoowsome.models.animals.Aquatic");
        comboBox.addItem("javasmmr.zoowsome.models.animals.Bird");
        comboBox.addItem("javasmmr.zoowsome.models.animals.Insect");
        comboBox.addItem("javasmmr.zoowsome.models.animals.Mammal");
        comboBox.addItem("javasmmr.zoowsome.models.animals.Reptile");
    }

    public void setComboboxItemListener(ItemListener a){
        comboBox.addItemListener(a);
    }

    public String getValueOfCombobox(){
        return this.comboBox.getSelectedItem().toString();
    }
}
