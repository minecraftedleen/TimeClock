/**
 * This class represents a Time object
 *
 * @author Edmund Chow
 */
public class Time {
    /** the seconds */
    private int seconds;
    /** the minutes */
    private int minutes;
    /** the hours */
    private int hours;

    /**
     * Constructor, sets the instance variables seconds, minutes, and hours.
     *
     * @param h the hours
     * @param m the minutes
     * @param s the seconds
     */

    public Time(int h, int m, int s) {
        hours = h;
        minutes = m;
        seconds = s;
    }

    /**
     * Increments seconds by one and calls the adjust() method.
     */
    public void tick() {
        seconds++;
        adjust();
    }

    /**
     * Returns the hours, minutes, and seconds in the correct time format.
     *
     * @return      the time in the correct format, for example 00:00:00
     */
    public String info() {
        String strSec = seconds + "";
        String strMin = minutes + "";
        String strHour = hours + "";
        if (strSec.length() < 2) {
            strSec = 0 + strSec;
        }
        if (strMin.length() < 2) {
            strMin = 0 + strMin;
        }
        if (strHour.length() < 2) {
            strHour = 0 + strHour;
        }
        return strHour + ":" + strMin + ":" + strSec;
    }

    /**
     * Adds time from a String to this Time object.
     *
     * @param s the time in a String format, for example 00:00:00
     */

    public void add(String s) {
        hours += Integer.parseInt(s.substring(0, 2));
        minutes += Integer.parseInt(s.substring(3, 5));
        seconds += Integer.parseInt(s.substring(6, 8));
        adjust();
    }

    /**
     * Adds time from another Time object to the current Time object.
     *
     * @param t the Time object time is being added from
     */

    public void add(Time t) {
        String s = t.info();
        add(s);
    }

    /**
     * Adjusts the seconds, minutes, and hours to ensure the time stays in the correct format.
     */
    private void adjust() {
        if (seconds > 59) {
            minutes++;
            seconds -= 60;
        }
        if (minutes > 59) {
            hours++;
            minutes -= 60;
        }
        if (hours > 23) {
            hours -= 24;
        }
    }



}
