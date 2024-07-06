import javax.swing.*;

class SpeedometerThread extends Thread {
    private int speedNow = 0;
    private JLabel speed;
    private boolean isRunning;

    public SpeedometerThread(JLabel speed) {
        this.speed = speed;
        this.isRunning = false;
    }

    public void startRunning() {
        isRunning = true;
    }

    public void stopRunning() {
        isRunning = false;
    }

    public void clearRunning() {
        isRunning = false;
        speedNow = 0;
        speed.setText("00:00:00");
    }

    public String getIntervalTime() {
        int hours = speedNow / 3600;
        int minutes = (speedNow % 3600) / 60;
        int seconds = speedNow % 60;

        String hour = hours < 10 ? "0" + hours : String.valueOf(hours);
        String min = minutes < 10 ? "0" + minutes : String.valueOf(minutes);
        String sec = seconds < 10 ? "0" + seconds : String.valueOf(seconds);

        return hour + ":" + min + ":" + sec;
    }
    @Override
    public void run() {
        while (true) {
            if (isRunning) {
                int hours = speedNow / 3600;
                int minutes = (speedNow % 3600) / 60;
                int seconds = speedNow % 60;

                String hour = hours < 10 ? "0" + hours : String.valueOf(hours);
                String min = minutes < 10 ? "0" + minutes : String.valueOf(minutes);
                String sec = seconds < 10 ? "0" + seconds : String.valueOf(seconds);

                speed.setText(hour + ":" + min + ":" + sec);
                speedNow++;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}