package awt_demo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuDemo extends JFrame{
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JMenuBar mb = new JMenuBar();
        ImageIcon imageIcon= new ImageIcon(new ImageIcon("src/awt_demo/nice-place.jpg").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        JMenu m1 = new JMenu("M1");
        m1.setIcon(imageIcon);

        JMenu m2 = new JMenu("M2");

        JMenu subm1 = new JMenu("subM1");
        JMenuItem mit1 = new JMenuItem("m item 1");

        JFrame jFrame1 = new JFrame("My frame");
        jFrame1.setLayout(new FlowLayout());
        jFrame1.setBounds(20, 20, 100, 100);
        mit1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               jFrame1.setVisible(true);
            }
        });
        JMenuItem mit2 = new JMenuItem("m item 2");
        JMenuItem subitem1 = new JMenuItem("submitem1");
        JMenuItem subitem2 = new JMenuItem("submitem2");

        subm1.add(subitem1);
        subm1.add(subitem2);
        m1.add(subm1);
        m1.add(mit1);
        m1.add(mit2);

        mb.add(m1);
        mb.add(m2);

        frame.add(mb);
        frame.setVisible(true);
        frame.setLayout(new FlowLayout());
        frame.setBounds(100, 100, 400, 400);
    }
}
