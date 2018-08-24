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
    private int Ammo = 20;

    //hier is de werkelijke constructor van de GUI
    public FirePopUp() {

        //frame attributes, visibilty, title, etc
        JFrame guiFrame = new JFrame();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setTitle("");
        guiFrame.setSize(200, 200);
        guiFrame.setLocationRelativeTo(null);

        //the text field
        final JPanel ammoCounter = new JPanel();
        ammoCounter.add(new JLabel("Ammo"));
        JTextField ammoField = new JTextField("20", 3);
        ammoField.setEditable(false);
        ammoCounter.add(ammoField);

        //the fire button
        JButton fireButton = new JButton("Fire");
        ammoCounter.add(fireButton);

        fireButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                --Ammo;
                ammoField.setText(Ammo + "");
            }
        });

        //the firerate selector
        final JPanel fireratePanel = new JPanel();
        JLabel firerateLabel = new JLabel("Select Fire Rate");
        JRadioButton manualFire = new JRadioButton("Manual Fire");
        JRadioButton semiautoFire = new JRadioButton("Semi-Auto Fire");
        JRadioButton fullautoFire = new JRadioButton("Full-Auto Fire");

        fireratePanel.add(firerateLabel);

        ButtonGroup fireRatesGroup = new ButtonGroup();
        fireRatesGroup.add(manualFire);
        fireRatesGroup.add(semiautoFire);
        fireRatesGroup.add(fullautoFire);

        fireratePanel.add(manualFire);
        fireratePanel.add(semiautoFire);
        fireratePanel.add(fullautoFire);

        //the layout
        guiFrame.add(ammoCounter, BorderLayout.NORTH);
        guiFrame.add(fireratePanel, BorderLayout.CENTER);
        guiFrame.setVisible(true);
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