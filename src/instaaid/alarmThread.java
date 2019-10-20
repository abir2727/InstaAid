 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instaaid;

import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class alarmThread implements Runnable {

    int hour, minutes, days;
    String time, medicinename;

    public alarmThread(int hour, int minutes, String time, int days, String medicinename) {

        if (time == "pm" && hour!=12 ) {
            this.hour = hour + 12;
        }
        
        else if(time == "am" && hour == 12){
            this.hour = 0;
        }
        
        else{
            this.hour = hour;
        }

        this.minutes = minutes;
        this.days = days;
        this.time = time;
        this.medicinename = medicinename;

    }

    @Override
    public void run() {

        int i = 0;
        while (i <= days) {
            try {
                Thread.sleep(1000);
                if (LocalTime.now().getHour() == hour && LocalTime.now().getMinute() == minutes && LocalTime.now().getSecond() == 0) {
                    showReminderform sRF = new showReminderform(hour, minutes, time, medicinename);
                    sRF.setVisible(true);
                    i++;
                }

            } catch (InterruptedException ex) {
                Logger.getLogger(reminderframe.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        Thread.interrupted();

    }

}
