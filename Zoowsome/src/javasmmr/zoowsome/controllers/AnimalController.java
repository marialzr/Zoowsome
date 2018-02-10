package javasmmr.zoowsome.controllers;
import javasmmr.zoowsome.models.animals.Animal;
import javasmmr.zoowsome.views.AnimalFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class AnimalController extends AbstractController {
    AnimalFrame f;  //a reference to current frame; I keep this because if not, I couldn't use this in actionPerformed
    Class c=null;  //I need the class to create an object after I know the values from fields
    public AnimalController(AnimalFrame frame, boolean hasBackButton, String type) {
        super(frame, hasBackButton);
        f=frame;
        try {
            ArrayList<String> fieldNames=new ArrayList<String>();

            //!!!! here appears REFLECTION
            c = Class.forName(type);   //get the type of the class(of type of animal)

            Class baseClass=Class.forName("javasmmr.zoowsome.models.animals.Animal"); //I need to know the superclass ->
            Field[] ff=baseClass.getDeclaredFields(); //->to take from there all the fields->
            String name;
            for (Field f:ff) {  //->because I need to know which field I complete in view(user input)
                name = f.getName();
                fieldNames.add(name);
            }

            Field[] fields=c.getDeclaredFields();  //get the fields from this class
            for (Field f:fields){
                name=f.getName();
                fieldNames.add(name);
            }
            frame.buildView(fieldNames);
            frame.setAddButtonActionListener(new AdButtonActionListener());
            /*set the action listener
            implement the action listener in controller because the view contains ONLY the things that I am seeing; all functionalities are in other modules;
            just a little part of them(those that are in close connection with view), the other part are in others(in services or repository)*/

        } catch (ClassNotFoundException e) {
            //System.out.println(e.getMessage());
            System.out.println("error in AnimalController");
        }
    }
    private class AdButtonActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<String> values= f.getValues();
            Object[] objects=new Object[6];
            Class[] classes=new Class[6];
            /*fields of Animal class: these are always the first fields; there is an error: when you input the name of animal, you MUST input one of the
            derived classes from class Animal
             */
            objects[0]=Integer.parseInt(values.get(0));
            classes[0]=Integer.class;
            objects[1]=values.get(1);
            classes[1]=String.class;
            objects[2]=Double.parseDouble(values.get(2));
            classes[2]=Double.class;
            objects[3]=Double.parseDouble(values.get(3));
            classes[3]=Double.class;
            objects[4]=Boolean.parseBoolean(values.get(4));
            classes[4]=Boolean.class;
            int nr;
            double d;
            boolean b;
            /*
            you have to test also if is enum, and other types of attributes that exists for every type of animal(aquatic, bird ...)
             */
            for (int i=5; i<values.size(); i++){
                try {
                    nr = Integer.parseInt(values.get(i));
                    objects[i]=nr;
                    classes[i]=Integer.class;
                    i++;
                    continue;
                }catch (NumberFormatException ee){
                }
                try{
                    d=Double.parseDouble(values.get(i));
                    objects[i]=d;
                    classes[i]=Double.class;
                    i++;
                    continue;
                }catch (NumberFormatException e2){
                }

                try{
                    b=Boolean.valueOf(values.get(i));
                    objects[i]=b;
                    classes[i]=Boolean.class;
                    i++;
                    continue;
                }catch (NumberFormatException e3){
                }
                objects[i]=values.get(i);
                classes[i]=String.class;
                i++;
            }
            /*always the name of the animal is values[1]
            the name=the class that we must instantiate and to set the attributes to create the object and to add it to repository*/
            String s=values.get(1);
            try {
                Class<?> cl=Class.forName(s);  //give the name together with its package
                Constructor<?> cons=cl.getConstructor(classes);  //problem HERE!!!!
                Object obj=cons.newInstance(objects);
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            } catch (IllegalAccessException e1) {
                e1.printStackTrace();
            } catch (InstantiationException e1) {
                e1.printStackTrace();
            } catch (NoSuchMethodException e1) {
                e1.printStackTrace();
            } catch (InvocationTargetException e1) {
                e1.printStackTrace();
            }

            /*here also appears reflection because I don't know which type of animal I should call to create an object of that type
            but I can instantiate an object from that class*/
        }
    }

}
