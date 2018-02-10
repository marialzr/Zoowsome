package javasmmr.zoowsome.views.utilities;
import javasmmr.zoowsome.views.ZooFrame;
import java.util.ArrayList;

public class FrameStack {
    private static FrameStack ourInstance = new FrameStack();
    private ArrayList<ZooFrame> stack;

    private FrameStack() {
        stack=new ArrayList<ZooFrame>();
    }
    public static FrameStack getInstance() {
        return ourInstance;
    }

    public ZooFrame peek(){
        return stack.get(0);
    }

    public void push(ZooFrame frame){
        if (!stack.isEmpty())
            peek().setVisible(true);
        frame.setVisible(true);
        stack.add(0, frame);
    }

    public void pop(){
        if (!stack.isEmpty()){
            peek().dispose();
            stack.remove(0);
            if (!stack.isEmpty())
                peek().setVisible(true);
        }
    }
}
