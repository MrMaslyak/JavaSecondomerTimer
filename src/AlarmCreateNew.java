import javax.swing.*;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AlarmCreateNew extends JFrame implements ActionListener {
    private JLabel timeAlarm, daysAlarm, volumeAlarmLabel, alarmBixby, vibrationLabel, basicCall, pauseLabel, descriptionPause;
    private ToggleSwitch switchVolume, switchVibration, switchPause;
    private JSpinner hourSpinner, minSpinner;
    private JPanel allCreateAlarm, volumeAlarm, vibration, pause, panelForAlarm;
    private JCheckBox m, t, w, th, f, sat, sun;
    private JTextField nameAlarm;
    private JButton save, cancel;
    private Alarm alarmMain;


    AlarmCreateNew(JPanel panelForAlarm, Alarm alarmMain) {
        this.panelForAlarm = panelForAlarm;
        this.alarmMain = alarmMain;
        setSize(325, 525);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Create New Alarm");
        setLayout(null);
        ui();
        setVisible(true);
    }

    private void ui() {

        timeAlarm = new JLabel("00   :   00");
        timeAlarm.setBounds(70, 50, 200, 70);
        timeAlarm.setFont(new Font("Arial", Font.BOLD, 40));
        timeAlarm.setOpaque(true);
        timeAlarm.setForeground(Color.black);
        add(timeAlarm);

        hourSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 23, 1));
        hourSpinner.setBounds(65, 125, 50, 30);
        hourSpinner.addChangeListener(e -> updateScrollTimer());
        add(hourSpinner);

        minSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 59, 1));
        minSpinner.setBounds(190, 125, 50, 30);
        minSpinner.addChangeListener(e -> updateScrollTimer());
        add(minSpinner);

        allCreateAlarm = new JPanel();
        allCreateAlarm.setLayout(null);
        allCreateAlarm.setBounds(0, 175, getWidth(), 270);
        allCreateAlarm.setBackground(Color.WHITE);
        allCreateAlarm.setBorder(BorderFactory.createLineBorder(new Color(89, 34, 195), 2));
        add(allCreateAlarm);

        m = new JCheckBox("M");
        m.setBackground(new Color(237, 237, 237));
        m.setBounds(5, 30, 35, 25);
        m.setFocusPainted(false);
        m.setBorderPainted(false);
        m.addActionListener(this);
        allCreateAlarm.add(m);

        t = new JCheckBox("T");
        t.setBackground(new Color(237, 237, 237));
        t.setBounds(45, 30, 35, 25);
        t.setFocusPainted(false);
        t.setBorderPainted(false);
        t.addActionListener(this);
        allCreateAlarm.add(t);

        w = new JCheckBox("W");
        w.setBackground(new Color(237, 237, 237));
        w.setBounds(85, 30, 40, 25);
        w.setFocusPainted(false);
        w.setBorderPainted(false);
        w.addActionListener(this);
        allCreateAlarm.add(w);

        th = new JCheckBox("TH");
        th.setBackground(new Color(237, 237, 237));
        th.setBounds(130, 30, 40, 25);
        th.setFocusPainted(false);
        th.setBorderPainted(false);
        th.addActionListener(this);
        allCreateAlarm.add(th);

        f = new JCheckBox("F");
        f.setBackground(new Color(237, 237, 237));
        f.setBounds(175, 30, 35, 25);
        f.setFocusPainted(false);
        f.setBorderPainted(false);
        f.addActionListener(this);
        allCreateAlarm.add(f);

        sat = new JCheckBox("SA");
        sat.setBackground(new Color(237, 237, 237));
        sat.setBounds(215, 30, 43, 25);
        sat.addActionListener(this);
        sat.setFocusPainted(false);
        sat.setBorderPainted(false);
        allCreateAlarm.add(sat);

        sun = new JCheckBox("SU");
        sun.setBounds(263, 30, 43, 25);
        sun.setBackground(new Color(237, 237, 237));
        sun.addActionListener(this);
        sun.setFocusPainted(false);
        sun.setBorderPainted(false);
        allCreateAlarm.add(sun);

        daysAlarm = new JLabel("Repeat on:");
        daysAlarm.setBounds(5, 5, getWidth(), 25);
        allCreateAlarm.add(daysAlarm);

        nameAlarm = new JTextField() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (getText().isEmpty() && !isFocusOwner()) {
                    g.setColor(new Color(150, 150, 150));
                    g.drawString("Name Alarm", 5, 15);
                }
                g.drawLine(0, 25, getWidth(), 25);
            }
        };
        nameAlarm.setOpaque(false);
        nameAlarm.setBorder(null);
        nameAlarm.setBounds(5, 55, getWidth(), 35);
        allCreateAlarm.add(nameAlarm);

        volumeAlarm = new JPanel();
        volumeAlarm.setLayout(null);
        volumeAlarm.setBounds(10, 100, 300, 40);
        volumeAlarm.setBackground(Color.WHITE);
        allCreateAlarm.add(volumeAlarm);

        volumeAlarmLabel = new JLabel("Volume Alarm");
        volumeAlarmLabel.setBounds(5, 0, 150, 25);
        volumeAlarm.add(volumeAlarmLabel);

        alarmBixby = new JLabel("Alarm Bixby");
        alarmBixby.setBounds(5, 18, 150, 25);
        alarmBixby.setFont(new Font("Arial", Font.PLAIN, 10));
        alarmBixby.setForeground(new Color(89, 34, 195));
        volumeAlarm.add(alarmBixby);

        switchVolume = new ToggleSwitch();
        switchVolume.setBounds(250, 17, 40, 25);
        switchVolume.addActionListener(this);
        volumeAlarm.add(switchVolume);

        vibration = new JPanel();
        vibration.setLayout(null);
        vibration.setBounds(10, 150, 300, 40);
        vibration.setBackground(Color.WHITE);
        allCreateAlarm.add(vibration);

        vibrationLabel = new JLabel("Vibration");
        vibrationLabel.setBounds(5, 0, 150, 25);
        vibration.add(vibrationLabel);

        basicCall = new JLabel("Basic Call");
        basicCall.setBounds(5, 18, 150, 25);
        basicCall.setFont(new Font("Arial", Font.PLAIN, 10));
        basicCall.setForeground(new Color(89, 34, 195));
        vibration.add(basicCall);

        switchVibration = new ToggleSwitch();
        switchVibration.setBounds(250, 17, 40, 25);
        switchVibration.addActionListener(this);
        vibration.add(switchVibration);

        pause = new JPanel();
        pause.setLayout(null);
        pause.setBounds(10, 200, 300, 40);
        pause.setBackground(Color.WHITE);
        allCreateAlarm.add(pause);

        pauseLabel = new JLabel("Pause");
        pauseLabel.setBounds(5, 0, 150, 25);
        pause.add(pauseLabel);

        descriptionPause = new JLabel("5 min, 3 times");
        descriptionPause.setBounds(5, 18, 150, 25);
        descriptionPause.setFont(new Font("Arial", Font.PLAIN, 10));
        descriptionPause.setForeground(new Color(89, 34, 195));
        pause.add(descriptionPause);

        switchPause = new ToggleSwitch();
        switchPause.setBounds(250, 17, 40, 25);
        switchPause.addActionListener(this);
        pause.add(switchPause);

        save = new JButton("Save");
        save.setBounds(170, 450, 120, 30);
        save.setFont(new Font("Arial", Font.PLAIN, 14));
        save.setFocusPainted(false);
        save.setBackground(new Color(237, 237, 237));
        save.setBorderPainted(false);
        save.addActionListener(this);
        save.setForeground(Color.BLACK);
        add(save);

        cancel = new JButton("Cancel");
        cancel.setBounds(15, 450, 120, 30);
        cancel.setFont(new Font("Arial", Font.PLAIN, 14));
        cancel.setForeground(Color.BLACK);
        cancel.setBackground(new Color(237, 237, 237));
        cancel.setFocusPainted(false);
        cancel.setBorderPainted(false);
        cancel.addActionListener(this);
        add(cancel);


    }

    private void updateScrollTimer() {
        int hours = (Integer) hourSpinner.getValue();
        int minutes = (Integer) minSpinner.getValue();
        timeAlarm.setText(String.format("%02d   :   %02d", hours, minutes));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == save) {
            int hour = (int) hourSpinner.getValue();
            int minute = (int) minSpinner.getValue();
            ArrayList<String> days = new ArrayList<>();
            if (m.isSelected()) days.add("M");
            if (t.isSelected()) days.add("T");
            if (w.isSelected()) days.add("W");
            if (th.isSelected()) days.add("TH");
            if (f.isSelected()) days.add("F");
            if (sat.isSelected()) days.add("SA");
            if (sun.isSelected()) days.add("SU");
            String name = nameAlarm.getText();

            CurrentInfoAlarm newAlarm = new CurrentInfoAlarm(hour, minute, days, name);
            alarmMain.setNewAlarm(newAlarm);
            dispose();
            alarmMain.setVisible(true);
        } else if (e.getSource() == cancel) {
            dispose();
            new Alarm();
        }


        if (e.getSource() instanceof JCheckBox) {
            JCheckBox source = (JCheckBox) e.getSource();
            String dayText = "";
            switch (e.getActionCommand()) {
                case "M" -> dayText = " Mn,";
                case "T" -> dayText = " Tue,";
                case "W" -> dayText = " Wed,";
                case "TH" -> dayText = " Thu,";
                case "F" -> dayText = " Fri,";
                case "SA" -> dayText = " Sat,";
                case "SU" -> dayText = " Sun,";
            }
            String currentText = daysAlarm.getText();
            if (source.isSelected()) {
                if (!currentText.contains(dayText)) {
                    daysAlarm.setText(currentText + dayText);
                }
            } else {
                daysAlarm.setText(currentText.replace(dayText, ""));
            }
        }
    }
}

