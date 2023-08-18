import javax.swing.*;
import java.awt.event.*;

public class Swing extends JFrame{
    private JFrame jframe;
    private JButton ok;
    private JLabel disp;
    private boolean click;

    public Swing(){
        jframe = new JFrame("Hi from Swing");

        disp = new JLabel();
        disp.setText("First Enter this button . . .");
        disp.setBounds(0,50,360,50);

        click = false;

        ok = new JButton("Hi 👋");
        ok.setBounds(40,120,100,30);
        
        ok.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(click)
                    disp.setText("Hi");
                else disp.setText("Hello");

                click = !click;
            }
        });

        jframe.add(disp);
        jframe.add(ok);
        jframe.setSize(350,200);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setLayout(null);
        jframe.setVisible(true);
        jframe.setResizable(false);
    }

    public static void main(String []args){
        new Swing();
    }
}