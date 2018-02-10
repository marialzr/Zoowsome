package javasmmr.zoowsome.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AnimalFrame extends ZooFrame{
    private JButton addButton;
    private ArrayList<JTextField> fieldsReferences;

    public AnimalFrame(String title){
            super(title);
    }

    public void buildView(ArrayList<String> list) {
        //modify the base panel
        super.contentPanel.setLayout(new GridLayout(2, 0, 0, 0));
        contentPanel.setBackground(Color.blue);

        //I need one more panel to put here the corresponding fields for an animal of which I don't know its type
        JPanel panel=new JPanel();
        contentPanel.add(panel);
        GridLayout slpanel=new GridLayout(10, 0, 0, 0);
        panel.setLayout(slpanel);
        panel.setBackground(Color.CYAN);

        //I need to keep a reference for each field because these haven't proper names because I don't know that until at runtime
        fieldsReferences=new ArrayList<JTextField>();
        for (String s:list){
            JTextField f=new JTextField(s);
            panel.add(f);
            fieldsReferences.add(f);
        }

        //the panel that contains the add button
        JPanel panel1 =new JPanel();
        GridLayout sl=new GridLayout(1, 1, 0, 0);
        panel1.setLayout(sl);
        addButton=new JButton("add");
        panel1.add(addButton);
        contentPanel.add(panel1);

    }

    public void setAddButtonActionListener(ActionListener a){
        this.addButton.addActionListener(a);
    }

    //returns an array of values from those JTextFields
    public ArrayList<String> getValues(){
        String s="";
        ArrayList<String> strings=new ArrayList<>();
        for (JTextField f:fieldsReferences){
            s=f.getText().toString();
            strings.add(s);
        }
        return strings;
    }
}
