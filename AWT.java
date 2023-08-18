import java.awt.*;
import java.awt.event.*;

public class AWT extends WindowAdapter implements ActionListener {

    private Frame frame;
    private Button ok;
    private Label disp;
    private boolean click;

    public AWT(){
        frame = new Frame("Hi from AWT");

        disp = new Label();
        disp.setText("Enter this button");
        disp.setBounds(0,50,360,50);
        disp.setBackground(Color.blue);


        click = false;

        ok = new Button("Hi 👋");
        ok.setBounds(40,120,100,30);

        ok.addActionListener(this);    
        
        frame.addWindowListener(this);

        frame.add(disp);
        frame.add(ok);
        frame.setSize(360,200);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }
    public void windowClosing(WindowEvent e) {
        frame.dispose();
    }

    public void actionPerformed (ActionEvent e) {  
        if(e.getSource() == ok){  
        if(click)
            disp.setText("Hello");
        else disp.setText("Hi");
        click = !click;
        }
    }

    public static void main(String []args){
        AWT a = new AWT();
    }

}