//imports
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionListener;

//hier is de start van de class, waarin we alles callen
public class FirePopUp extends JFrame implements ItemListener {
    int Ammo = 20;
    int fireType = 1;
    String typeManual;
    String typeSemi;
    String typeAuto;

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

        fireButton.addActionListener(new ActionListener());

        //the firerate selector
        final JPanel fireratePanel = new JPanel();
        JLabel firerateLabel = new JLabel("Select Fire Rate");
        JRadioButton manualFire = new JRadioButton("Manual Fire");
        manualFire.setActionCommand(1);
        JRadioButton semiautoFire = new JRadioButton("Semi-Auto Fire");
        semiautoFire.setActionCommand(3);
        JRadioButton fullautoFire = new JRadioButton("Full-Auto Fire");
        fullautoFire.setActionCommand(6);

        fireratePanel.add(firerateLabel);

        ButtonGroup fireRatesGroup = new ButtonGroup();
        fireRatesGroup.add(manualFire);
        fireRatesGroup.add(semiautoFire);
        fireRatesGroup.add(fullautoFire);

        fireratePanel.add(manualFire);
        fireratePanel.add(semiautoFire);
        fireratePanel.add(fullautoFire);

        manualFire.addItemListener(this);
        semiautoFire.addItemListener(this);
        fullautoFire.addItemListener(this);

        //the layout
        guiFrame.add(ammoCounter, BorderLayout.NORTH);
        guiFrame.add(fireratePanel, BorderLayout.CENTER);
        guiFrame.setVisible(true);

        public void fireGun() {
            Ammo = Ammo - evt.getActionCommand();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable());
        new FirePopUp() {
            @Override
            public void actionPerformed(ItemEvent e) {

            }
        };
    }
}