import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerCountdown extends JFrame implements ActionListener {
    private JLabel scrollTimer;
    private JButton startButton, cancelButton;
    private JSpinner hourSpinner, minSpinner, secSpinner;
    TimerCountdown(JLabel scrollTimer, JSpinner hourSpinner,JSpinner minSpinner,JSpinner secSpinner){
        this.scrollTimer = scrollTimer;
        this.hourSpinner = hourSpinner;
        this.minSpinner = minSpinner;
        this.secSpinner = secSpinner;
        setSize(300, 380);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Timer Countdown");
        ui();
        setVisible(true);
    }

    private void ui() {

        startButton = new JButton("Start");
        startButton.setFont(new Font("Arial", Font.PLAIN, 12));
        startButton.setForeground(Color.WHITE);
        startButton.setBackground(new Color(89, 34, 195));
        startButton.setBounds(200, 300, 110, 30);
        startButton.addActionListener(this);
        add(startButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setFont(new Font("Arial", Font.PLAIN, 12));
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setBackground(new Color(237, 9, 27));
        cancelButton.setBounds(20, 300, 110, 30);
        cancelButton.addActionListener(this);
        add(cancelButton);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if ( e.getSource() == startButton) {
            int hours = (Integer) hourSpinner.getValue();
            int minutes = (Integer) minSpinner.getValue();
            int seconds = (Integer) secSpinner.getValue();
            int totalSeconds = hours * 3600 + minutes * 60 + seconds;
            if (totalSeconds > 0) {
                new TimerThread(scrollTimer, hours, minutes, seconds).start();
            }
        }
        if (e.getSource() == cancelButton) {
            new Timer();
            dispose();
        }
    }
}


