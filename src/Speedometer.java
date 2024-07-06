import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Speedometer extends JFrame implements ActionListener {
    private JButton taimer, start, interval;
    private JLabel speed, speedInterval;
    private SpeedometerThread speedometerThread;

    public Speedometer() {
        setSize(300, 300);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Speedometer");
        ui();
        setVisible(true);
        speedometerThread = new SpeedometerThread(speed);
        speedometerThread.start();
    }

    private void ui() {
        taimer = new JButton("Timer");
        taimer.setFont(new Font("Arial", Font.BOLD, 10));
        taimer.setBounds(105, 5, 90, 30);
        taimer.addActionListener(this);
        add(taimer);

        start = new RoundedButton("Start");
        start.setFont(new Font("Arial", Font.PLAIN, 12));
        start.setForeground(Color.WHITE);
        start.setBackground(new Color(89, 34, 195));
        start.setBounds(180, 200, 80, 35);
        start.addActionListener(this);
        start.setBorderPainted(false);
        start.setFocusPainted(false);
        add(start);

        interval = new RoundedButton("Interval");
        interval.setFont(new Font("Arial", Font.PLAIN, 12));
        interval.setForeground(Color.WHITE);
        interval.setBackground(new Color(207, 204, 204));
        interval.setBounds(25, 200, 80, 35);
        interval.addActionListener(this);
        interval.setBorderPainted(false);
        interval.setFocusPainted(false);
        add(interval);

        speed = new JLabel("00:00:00");
        speed.setFont(new Font("Arial", Font.BOLD, 30));
        speed.setBounds(73, 100, 150, 50);
        speed.setHorizontalAlignment(JLabel.CENTER);
        speed.setVerticalAlignment(JLabel.CENTER);
        speed.setForeground(Color.BLACK);
        speed.setOpaque(true);
        add(speed);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == taimer) {
            new Timer();
            dispose();
        }
        if (e.getSource() == start) {
            if (start.getText().equals("Start")) {
                speedometerThread.startRunning();
                start.setText("Stop");
                start.setBackground(Color.RED);
            } else if (start.getText().equals("Stop")) {
                speedometerThread.stopRunning();
                start.setText("Next");
                interval.setText("Clear");
                interval.setForeground(Color.BLACK);
                start.setBackground(new Color(89, 34, 195));
            } else if (start.getText().equals("Next")) {
                speedometerThread.startRunning();
                start.setText("Stop");
                start.setBackground(Color.RED);
                interval.setText("Interval");
            }
        } else if (e.getSource() == interval && interval.getText().equals("Clear")) {
            speedometerThread.clearRunning();
            start.setText("Start");
            interval.setText("Interval");
            start.setBackground(new Color(89, 34, 195));
            if (speedInterval != null) {
                speedInterval.setText("");
                repaint();
            }
        } else if (e.getSource() == interval && interval.getText().equals("Interval")) {
            if (speedInterval == null) {
                speedInterval = new JLabel("");
                speedInterval.setFont(new Font("Arial", Font.ITALIC, 10));
                speedInterval.setBounds(73, 140, 150, 50);
                speedInterval.setHorizontalAlignment(JLabel.CENTER);
                speedInterval.setVerticalAlignment(JLabel.CENTER);
                speedInterval.setForeground(Color.GRAY);
                speedInterval.setOpaque(true);
                add(speedInterval);
            }
            speedInterval.setText(speedometerThread.getIntervalTime());
            repaint();
        }
    }
}
