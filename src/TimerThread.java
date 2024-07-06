import javax.swing.*;

public class TimerThread extends Thread {
    private JLabel scrollTimer;
    private int hours, minutes, seconds;

    TimerThread(JLabel scrollTimer, int hours, int minutes, int seconds) {
        this.scrollTimer = scrollTimer;
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public void run() {
        while (true) {

            if (hours == 0 && minutes == 0 && seconds == 0) {
                break;
            }


            if (seconds > 0) {
                seconds--;
            } else {
                if (minutes > 0) {
                    minutes--;
                    seconds = 59;
                } else {
                    if (hours > 0) {
                        hours--;
                        minutes = 59;
                        seconds = 59;
                    }
                }
            }


            String hour = hours < 10 ? "0" + hours : String.valueOf(hours);
            String min = minutes < 10 ? "0" + minutes : String.valueOf(minutes);
            String sec = seconds < 10 ? "0" + seconds : String.valueOf(seconds);


            scrollTimer.setText(hour + " : " + min + " : " + sec);


            try {
                sleep(1000 );
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
