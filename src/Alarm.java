import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class Alarm extends JFrame implements ActionListener {

    private JComboBox year;
    private JComboBox months;
    private JComboBox days;
    private JComboBox hour;
    private JComboBox minute;
    private JPanel panel;
    private JButton save;

    public Integer getSelectedYear() {
        return selectedYear;
    }

    public void setSelectedYear(Integer selectedYear) {
        this.selectedYear = selectedYear;
    }

    public String getSelectedMonth() {
        return selectedMonth;
    }

    public void setSelectedMonth(String selectedMonth) {
        this.selectedMonth = selectedMonth;
    }

    public Integer getSelectedDay() {
        return selectedDay;
    }

    public void setSelectedDay(Integer selectedDay) {
        this.selectedDay = selectedDay;
    }

    public Integer getSelectedHour() {
        return selectedHour;
    }

    public void setSelectedHour(Integer selectedHour) {
        this.selectedHour = selectedHour;
    }

    public Integer getSelectedMinutes() {
        return selectedMinutes;
    }

    public void setSelectedMinutes(Integer selectedMinutes) {
        this.selectedMinutes = selectedMinutes;
    }

    private Integer selectedYear;
    private String selectedMonth;
    private Integer selectedDay;
    private Integer selectedHour;
    private Integer selectedMinutes;





    public Alarm(){
        panel= new JPanel();

        Integer[] y={2023,2024,2025,2026};
        year= new JComboBox<>(y);
        year.setBorder(BorderFactory.createTitledBorder("Year"));
        String[] m={"January","February","March","April","May","June","July","August",
        "September","October","November","December"};
        months= new JComboBox<>(m);
        months.setBorder(BorderFactory.createTitledBorder("Months"));

        Integer[] d={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};

        days= new JComboBox<>(d);
        days.setBorder(BorderFactory.createTitledBorder("Days"));


        Integer[] h={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23};
        hour=new JComboBox<>(h);
        hour.setBorder(BorderFactory.createTitledBorder("Hours"));
        Integer[] min={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,
                       25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,
                        51,52,53,54,56,56,57,58,59};
        minute=new JComboBox<>(min);
        minute.setBorder(BorderFactory.createTitledBorder("Minutes"));


        save= new JButton("Save");
        save.addActionListener(this);



        panel.add(year);
        panel.add(months);
        panel.add(days);
        panel.add(hour);
        panel.add(minute);
        panel.add(save);

        add(panel);
        setTitle("Alarm");
        setDefaultCloseOperation(3);
        setSize(500,500);


        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==save){

            setSelectedYear((Integer) year.getSelectedItem());
            System.out.println(year.getSelectedItem());

            setSelectedMonth((String) months.getSelectedItem());
            System.out.println(months.getSelectedItem());

            setSelectedDay((Integer)days.getSelectedItem());
            System.out.println(days.getSelectedItem());
            setSelectedHour((Integer)hour.getSelectedItem());
            System.out.println(hour.getSelectedItem());
            setSelectedMinutes((Integer)minute.getSelectedItem());
            System.out.println(minute.getSelectedItem());

            setTime();


        }
    }

    public  void setTime(){

        java.util.Timer timer= new Timer();
        TimerTask task= new TimerTask() {
            int counter=20;
            @Override

            public void run() {



                if(counter>0){
                    System.out.print("\r Alarm will be off "+counter + " seconds");
                    counter--;
                }else{
                    System.out.print("off");
                    timer.cancel();
                }



            }
        };

        Calendar date=Calendar.getInstance();
        date.set(Calendar.YEAR,2023);
        date.set(Calendar.MONTH,Calendar.JANUARY);
        date.set(Calendar.DAY_OF_MONTH,getSelectedDay());
        date.set(Calendar.HOUR_OF_DAY,getSelectedHour());
        date.set(Calendar.MINUTE,getSelectedMinutes());
        date.set(Calendar.SECOND,0);



        timer.scheduleAtFixedRate(task,date.getTime(),1000);


    }
}
