import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {

        new Alarm();

        Timer timer= new Timer();
        TimerTask task= new TimerTask() {
            int counter=20;
            @Override

            public void run() {



                if(counter>0){
                    System.out.print("\r"+counter + " ");
                    counter--;
                }else{
                    System.out.print("happy new year");
                    timer.cancel();
                }



            }
        };

        Calendar date=Calendar.getInstance();
        date.set(Calendar.YEAR,2023);
        date.set(Calendar.MONTH,0);
        date.set(Calendar.DAY_OF_MONTH,13);
        date.set(Calendar.HOUR_OF_DAY,23);
        date.set(Calendar.MINUTE,23);
        date.set(Calendar.SECOND,0);



        timer.scheduleAtFixedRate(task,0,1000);


    }
}