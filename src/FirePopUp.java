//imports
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionListener;

//hier is de start van de class, waarin we alles callen
public abstract class FirePopUp extends JFrame implements ItemListener {
    private int Ammo = 20;
    private int fireType = 1;
    private String typeManual;
    private String typeSemi;
    private String typeAuto;

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
                Ammo = Ammo - fireType;
                ammoField.setText(Ammo + "");
            }
        });

        //the firerate selector
        final JPanel fireratePanel = new JPanel();
        JLabel firerateLabel = new JLabel("Select Fire Rate");
        JRadioButton manualFire = new JRadioButton("Manual Fire");
            manualFire.setActionCommand(typeManual);
        JRadioButton semiautoFire = new JRadioButton("Semi-Auto Fire");
            semiautoFire.setActionCommand(typeSemi);
        JRadioButton fullautoFire = new JRadioButton("Full-Auto Fire");
            fullautoFire.setActionCommand(typeAuto);

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

        for ( ; ; ) {
            switch (fireRatesGroup.getButtonCount()) {
                case 1:
                    fireType = 1;
                case 2:
                    fireType = 3;
                case 3:
                    fireType = 6;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FirePopUp() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {

                    }
                };
            }
        });
    }
}