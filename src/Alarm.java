import javax.swing.*;

public class Alarm extends JFrame {

    private JComboBox year;
    private JComboBox months;
    private JComboBox days;
    private JComboBox hour;
    private JComboBox minute;



    public Alarm(){

        Integer[] y={2023,2024,2025,2026};
        year= new JComboBox<>(y);
        String[] m={"January","February","March","April","May","June","July","August",
        "September","October","November","December"};
        months= new JComboBox<>(m);

        add(months);
        setTitle("Alarm");
        setDefaultCloseOperation(3);
        setSize(500,500);

        setVisible(true);


    }
}
