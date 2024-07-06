import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerCountdown extends JFrame implements ActionListener {
    private JLabel scrollTimer,  originalTimer ;
    private JButton stopButton, cancelButton;
    private CircularLabel scrollTimerCoutdown;
    private JSpinner hourSpinner, minSpinner, secSpinner;
    private TimerThread timerThread;

    TimerCountdown(JLabel scrollTimer, JSpinner hourSpinner, JSpinner minSpinner, JSpinner secSpinner) {
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
        stopButton = new RoundedButton("Pause");
        stopButton.setFont(new Font("Arial", Font.PLAIN, 12));
        stopButton.setForeground(Color.WHITE);
        stopButton.setBackground(Color.RED);
        stopButton.setBounds(170, 270, 90, 40);
        stopButton.setBorderPainted(false);
        stopButton.setFocusPainted(false);
        stopButton.addActionListener(this);
        add(stopButton);

        cancelButton = new RoundedButton("Remove");
        cancelButton.setFont(new Font("Arial", Font.PLAIN, 12));
        cancelButton.setForeground(Color.GRAY);
        cancelButton.setBackground(new Color(223, 220, 220));
        cancelButton.setBounds(20, 270, 90, 40);
        cancelButton.setBorderPainted(false);
        cancelButton.setFocusPainted(false);
        cancelButton.addActionListener(this);
        add(cancelButton);


        scrollTimerCoutdown = new CircularLabel();
        scrollTimerCoutdown.setBounds(50, 50, 180, 180);
        scrollTimerCoutdown.setFont(new Font("Arial", Font.BOLD, 20));
        scrollTimerCoutdown.setForeground(Color.BLACK);
        scrollTimerCoutdown.setText(scrollTimer.getText());
        add(scrollTimerCoutdown);

        originalTimer = new JLabel(scrollTimer.getText());
        originalTimer.setFont(new Font("Arial", Font.ITALIC, 10));
        originalTimer.setBounds(0, 34, 180, 50);
        originalTimer.setForeground(Color.GRAY);
        originalTimer.setHorizontalAlignment(JLabel.CENTER);
        add(originalTimer);
        scrollTimerCoutdown.add(originalTimer);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == stopButton) {
                if ( stopButton.getText().equals("Pause")) {
                    timerThread.stopCountdown();
                    stopButton.setText("Conti.");
                    stopButton.setBackground(new Color(89, 34, 195));
                } else if (stopButton.getText().equals("Conti.")) {
                    timerThread.resumeCountdown();
                    stopButton.setText("Pause");
                    stopButton.setBackground(Color.RED);
                }
        }

        if (e.getSource() == cancelButton) {
            new Timer();
            dispose();
        }
    }

    public void startCountdown(){
        int hours = (Integer) hourSpinner.getValue();
        int minutes = (Integer) minSpinner.getValue();
        int seconds = (Integer) secSpinner.getValue();
        int totalSeconds = hours * 3600 + minutes * 60 + seconds;
        if (totalSeconds > 0) {
            timerThread = new TimerThread(scrollTimerCoutdown, hours, minutes, seconds);
            timerThread.startCountdownThread();
            timerThread.start();
        }
    }


}
