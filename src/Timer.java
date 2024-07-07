import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Timer extends JFrame implements ActionListener {
    private JButton speedometer, start, circleTen, circleFifteen, circleThirty, timerNow, alarm;
    private JLabel scrollTimer, hLab, mLab, sLab;
    private JSpinner hourSpinner, minSpinner, secSpinner;


    Timer() {
        setSize(300, 380);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Timer");
        ui();
        setVisible(true);
    }

    private void ui() {

        alarm = new JButton("Alarm");
        alarm.setFont(new Font("Arial", Font.BOLD, 14));
        alarm.setBounds(0, 5, 90, 30);
        alarm.addActionListener(this);
        alarm.setBorderPainted(false);
        alarm.setFocusPainted(false);
        alarm.setForeground(Color.gray);
        alarm.setBackground(new Color(241, 239, 239));
        add(alarm);

        speedometer = new JButton("Speedometer");
        speedometer.setFont(new Font("Arial", Font.BOLD, 14));
        speedometer.setBounds(75, 5, 130, 30);
        speedometer.addActionListener(this);
        speedometer.setBorderPainted(false);
        speedometer.setFocusPainted(false);
        speedometer.setForeground(Color.gray);
        speedometer.setBackground( new Color(237, 237, 237));
        add(speedometer);

        timerNow = new JButton("<html><u>Timer</u></html>");
        timerNow.setFont(new Font("Arial", Font.BOLD, 14));
        timerNow.setBounds(190, 5, 90, 30);
        timerNow.addActionListener(this);
        timerNow.setBorderPainted(false);
        timerNow.setFocusPainted(false);
        timerNow.setForeground(Color.black);
        timerNow.setBackground(new Color(241, 239, 239));
        add(timerNow);


        start = new RoundedButton("Start");
        start.setFont(new Font("Arial", Font.PLAIN, 12));
        start.setForeground(Color.WHITE);
        start.setBackground(new Color(89, 34, 195));
        start.setBounds(100, 270, 90, 35);
        start.addActionListener(this);
        start.setBorderPainted(false);
        start.setFocusPainted(false);
        add(start);

        circleTen = new CircleButton("00:10:00");
        circleTen.setFont(new Font("Arial", Font.PLAIN, 7));
        circleTen.setForeground(Color.black);
        circleTen.setBackground(new Color(241, 239, 239));
        circleTen.setBounds(20, 180, 70, 70);
        circleTen.addActionListener(this);
        circleTen.setBorderPainted(false);
        circleTen.setFocusPainted(false);
        add(circleTen);

        circleFifteen = new CircleButton("00:15:00");
        circleFifteen.setFont(new Font("Arial", Font.PLAIN, 7));
        circleFifteen.setForeground(Color.black);
        circleFifteen.setBackground(new Color(241, 239, 239));
        circleFifteen.setBounds(110, 180, 70, 70);
        circleFifteen.addActionListener(this);
        circleFifteen.setBorderPainted(false);
        circleFifteen.setFocusPainted(false);
        add(circleFifteen);

        circleThirty = new CircleButton("00:30:00");
        circleThirty.setFont(new Font("Arial", Font.PLAIN, 7));
        circleThirty.setForeground(Color.black);
        circleThirty.setBackground(new Color(241, 239, 239));
        circleThirty.setBounds(200, 180, 70, 70);
        circleThirty.addActionListener(this);
        circleThirty.setBorderPainted(false);
        circleThirty.setFocusPainted(false);
        add(circleThirty);

        hourSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 23, 1));
        hourSpinner.setBounds(47, 130, 50, 30);
        add(hourSpinner);

        minSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 59, 1));
        minSpinner.setBounds(125, 130, 50, 30);
        add(minSpinner);

        secSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 59, 1));
        secSpinner.setBounds(200, 130, 50, 30);
        add(secSpinner);

        scrollTimer = new JLabel("00 : 00 : 00");
        scrollTimer.setFont(new Font("Arial", Font.BOLD, 40));
        scrollTimer.setBounds(23, 80, 250, 50);
        scrollTimer.setHorizontalAlignment(JLabel.CENTER);
        scrollTimer.setVerticalAlignment(JLabel.CENTER);
        scrollTimer.setForeground(Color.BLACK);
        scrollTimer.setOpaque(true);
        add(scrollTimer);

        hourSpinner.addChangeListener(e -> updateScrollTimer());
        minSpinner.addChangeListener(e -> updateScrollTimer());
        secSpinner.addChangeListener(e -> updateScrollTimer());

        hLab = new JLabel("h.");
        hLab.setFont(new Font("Arial", Font.PLAIN, 12));
        hLab.setBounds(65, 50, 25, 30);
        add(hLab);

        mLab = new JLabel("m.");
        mLab.setFont(new Font("Arial", Font.PLAIN, 12));
        mLab.setBounds(145, 50, 25, 30);
        add(mLab);

        sLab = new JLabel("s.");
        sLab.setFont(new Font("Arial", Font.PLAIN, 12));
        sLab.setBounds(220, 50, 25, 30);
        add(sLab);

    }

    private void updateScrollTimer() {
        int hours = (Integer) hourSpinner.getValue();
        int minutes = (Integer) minSpinner.getValue();
        int seconds = (Integer) secSpinner.getValue();
        scrollTimer.setText(String.format("%02d : %02d : %02d", hours, minutes, seconds));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == alarm) {
            new Alarm();
            dispose();
        }

        if (e.getSource() == speedometer) {
            new Speedometer();
            dispose();
        }

        if (e.getSource() == start) {
            dispose();
            TimerCountdown countdownTimer = new TimerCountdown(scrollTimer, hourSpinner, minSpinner, secSpinner);
            countdownTimer.startCountdown();
        }

        if (e.getSource() == circleTen) {
            hourSpinner.setValue(0);
            minSpinner.setValue(10);
            secSpinner.setValue(0);
        }

        if (e.getSource() == circleFifteen) {
            hourSpinner.setValue(0);
            minSpinner.setValue(15);
            secSpinner.setValue(0);
        }

        if (e.getSource() == circleThirty) {
            hourSpinner.setValue(0);
            minSpinner.setValue(30);
            secSpinner.setValue(0);
        }
    }

}


