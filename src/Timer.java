import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Timer extends JFrame implements ActionListener {
    private JButton speedometer, start, circleTen, circleFifteen, circleThirty, scrollTimer;
    private JLabel hourLabel, minLabel, secLabel;

    Timer() {
        setSize(300, 380);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Timer");
        ui();
        setVisible(true);
    }

    private void ui() {
        speedometer = new JButton("Speedometer");
        speedometer.setFont(new Font("Arial", Font.BOLD, 10));
        speedometer.setBounds(95, 5, 110, 30);
        speedometer.addActionListener(this);
        add(speedometer);

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

        hourLabel = new JLabel("h.");
        hourLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        hourLabel.setBounds(108, 70, 20, 40);
        hourLabel.setForeground(Color.gray);
        add(hourLabel);

        minLabel = new JLabel("min.");
        minLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        minLabel.setBounds(150, 70, 35, 40);
        minLabel.setForeground(Color.gray);
        add(minLabel);

        secLabel = new JLabel("sec.");
        secLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        secLabel.setBounds(210, 70, 35, 40);
        secLabel.setForeground(Color.gray);
        add(secLabel);

        scrollTimer = new JButton("00:00:00");
        scrollTimer.setFont(new Font("Arial", Font.PLAIN, 30));
        scrollTimer.setForeground(Color.WHITE);
        scrollTimer.setBackground(new Color(243, 240, 240));
        scrollTimer.setBounds(50, 100, 200, 80);
        scrollTimer.addActionListener(this);
        scrollTimer.setBorderPainted(false);
        scrollTimer.setFocusPainted(false);
        add(scrollTimer);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == speedometer) {
            new Speedometer();
            dispose();
        }
    }
}