//imports
import java.awt.*;                      //want we gebruiken AWT als layout
import java.awt.event.*;                //want we gebruiken AWT event handeing
import javax.swing.*;                   //en we gebruiken Swing voor de rest
import javax.swing.GroupLayout;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

//hier is de start van de class, waarin we alles callen
public class FirePopUp extends JFrame {
    private JTextField ammoField;       //we gebruiken namelijk het Swing textfield
    private JButton fireButton;         //we gebruiken namelijk de  Swing button
    private int Ammo = 20;              //hier callen we de integer om de ammo bij te houden

    //hier is de werkelijke constructor van de GUI
    public FirePopUp() extends JFrame implements ItemListener {
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());

        //the text field
        cp.add(new JLabel("Ammo"));
        ammoField = new JTextField("20", 3);
        ammoField.setEditable(false);
        cp.add(ammoField);

        //the firerate selector
        ButtonGroup fireRateGroup = new ButtonGroup();
        JRadioButton rb1 = new JRadioButton("Manual", true);
        JRadioButton rb2 = new JRadioButton("Semi-Auto");
        JRadioButton rb3 = new JRadioButton("Full-Auto");

            fireRateGroup.add(rb1);
            fireRateGroup.add(rb2);
            fireRateGroup.add(rb3);

            rb1.addItemListener(this);
            rb2.addItemListener(this);
            rb3.addItemListener(this);


        //the fire button
        fireButton = new JButton("Fire");
        cp.add(fireButton);

        fireButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                --Ammo;
                ammoField.setText(Ammo + "");
            }
        });

        //frame attributes, visibilty, title, etc
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Ammo Counter");
        setSize(300, 100);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FirePopUp();
            }
        });
    }
}