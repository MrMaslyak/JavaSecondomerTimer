import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Alarm  extends JFrame implements ActionListener{
    private JButton taimer, speedometer, alarmNow, plusCreateAlarm;
    private JLabel titleLabel;
    private JPanel panelForAlarm;
    private int y = 175;
    private ToggleSwitch switchOnOffAlarm;
    private ArrayList <CurrentInfoAlarm> alarms = new ArrayList<>();

    Alarm () {
        setSize(300, 400);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Alarm");
        ui();
        setVisible(true);
    }
    private void ui() {

        alarmNow = new JButton("<html><u>Alarm</u></html>");
        alarmNow.setFont(new Font("Arial", Font.BOLD, 14));
        alarmNow.setBounds(0, 5, 90, 30);
        alarmNow.addActionListener(this);
        alarmNow.setBorderPainted(false);
        alarmNow.setFocusPainted(false);
        alarmNow.setForeground(Color.black);
        alarmNow.setBackground(new Color(241, 239, 239));
        add(alarmNow);

        speedometer = new JButton("Speedometer");
        speedometer.setFont(new Font("Arial", Font.BOLD, 14));
        speedometer.setBounds(75, 5, 130, 30);
        speedometer.addActionListener(this);
        speedometer.setBorderPainted(false);
        speedometer.setFocusPainted(false);
        speedometer.setForeground(Color.gray);
        speedometer.setBackground( new Color(237, 237, 237));
        add(speedometer);

        taimer = new JButton("Timer");
        taimer.setFont(new Font("Arial", Font.BOLD, 14));
        taimer.setBounds(190, 5, 90, 30);
        taimer.addActionListener(this);
        taimer.setBorderPainted(false);
        taimer.setFocusPainted(false);
        taimer.setForeground(Color.gray);
        taimer.setBackground(new Color(241, 239, 239));
        add(taimer);

        titleLabel = new JLabel("<html><div style='text-align: center;'>All alarms<br>off</div></html>", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.black);
        titleLabel.setBounds(60, 45, 150, 60);
        add(titleLabel);

        plusCreateAlarm = new JButton("+");
        plusCreateAlarm.setFont(new Font("Arial", Font.PLAIN, 30));
        plusCreateAlarm.setBounds(200, 100, 60, 60);
        plusCreateAlarm.addActionListener(this);
        plusCreateAlarm.setBorderPainted(false);
        plusCreateAlarm.setFocusPainted(false);
        plusCreateAlarm.setForeground(Color.black);
        plusCreateAlarm.setBackground(new Color(241, 239, 239));
        add(plusCreateAlarm);




    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == speedometer) {
            dispose();
            new Speedometer();
        }
        if (e.getSource() == taimer) {
            setVisible(false);
            dispose();
        }

        if (e.getSource() == plusCreateAlarm) {
            dispose();
            new AlarmCreateNew(panelForAlarm, this);
        }

        if (e.getSource() == switchOnOffAlarm) {
            updateTitleLabel();
        }


    }
    private void updateTitleLabel() {
        if (switchOnOffAlarm.isSelected()) {
            titleLabel.setText("<html><div style='text-align: center;'>All alarms<br>on</div></html>");
        } else {
            titleLabel.setText("<html><div style='text-align: center;'>All alarms<br>off</div></html>");
        }
    }
    public void setNewAlarm(CurrentInfoAlarm  currentInfo) {
        alarms.add(currentInfo);
        JLabel label = new JLabel(currentInfo.toString());
        panelForAlarm = new JPanel();
        panelForAlarm.setBounds(15, y, 250, 40);
        panelForAlarm.setBackground(new Color(237, 237, 237));
        panelForAlarm.setBorder(BorderFactory.createLineBorder(new Color(89, 34, 195), 2));
        add(panelForAlarm);
        panelForAlarm.add(currentInfo.getLabel());
        panelForAlarm.add(label);

        switchOnOffAlarm = new ToggleSwitch();
        switchOnOffAlarm.setBounds(225, y + 8, 50, 30);
        switchOnOffAlarm.addActionListener(this);

        panelForAlarm.add(switchOnOffAlarm);
        panelForAlarm.revalidate();
        panelForAlarm.repaint();
        y += 50;
        setVisible(true);


    }

}
