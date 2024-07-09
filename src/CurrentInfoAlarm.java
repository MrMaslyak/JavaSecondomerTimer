import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CurrentInfoAlarm {
    private int hour;
    private int minute;
    private ArrayList<String> days;
    private String name;
    private JLabel label;

    public CurrentInfoAlarm(int hour, int minute, ArrayList<String> days, String name) {
        this.hour = hour;
        this.minute = minute;
        this.days = days;
        this.name = name;
        this.label = createLabel();
    }

    private JLabel createLabel() {
        JLabel label = new JLabel();
        label.setText(String.format("%02d:%02d ", hour, minute));
        label.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 20));
        label.setForeground(Color.BLACK);
        label.setLocation(0, 10);
        label.setSize(50, 30);
        return label;
    }

    public JLabel getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return String.format("%s %s",  days.toString(), name);
    }
}




