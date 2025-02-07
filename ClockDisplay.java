
/**
 * The ClockDisplay class implements a digital clock display for a
 * European-style 24 hour clock. The clock shows hours and minutes. The 
 * range of the clock is 00:00 (midnight) to 23:59 (one minute before 
 * midnight).
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;    // simulates the actual display
    /* 
     * Answer to extra chaper questions
     * 
     * 29)
     * It would take 60 calls to go from 00:00 to 1 min
     * We can also use set time method to change it to 1 min
     * 
     * 30) private Rectangle window;
     * 
     *          window = new rectangle(5,4) ;
     *          
     * 31)
     * The second constructor accepts two parameters ( hour and minute) and 
     * initializes the clock with these values.
     * It directly sets hours and minutes fields to the provided values
     * 
     * 32)
     * The first constructor sets time to 00:0
     * The second constructor initializes time with provided hour and minute 
     * values
     * updateDisplay() is not called in the second constructor if it directly
     * sets the displayString without additional processing
     * 
     * 33) Printer P1, p2;
     * 
     *         p1.print("xxxxx",true)
     *         
     *         p2.print("xxxxx", false)
     *         
     *         int status = p1.getStatus(3);
     *         
     * 34)
     * The picture class creates objects of Square, Triangle, and Circle.
     * 
     * 35)
     * roof.changeSize(60, 180);
     * roof.moveHorizontal(20);
     * roof.moveVertical(-60);
     * roof.makeVisible();
     * 
     * 36)
     * Yes, the draw() method likely calls other methods within the Picture 
     * class.
     *         
     */
    
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 00:00.
     */
    public ClockDisplay()
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplay(int hour, int minute)
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        setTime(hour, minute);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {  // it just rolled over!
            hours.increment();
        }
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        updateDisplay();
    }

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getTime()
    {
        return displayString;
    }
    
    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay()
    {
        displayString = hours.getDisplayValue() + ":" + 
                        minutes.getDisplayValue();
    }
    
}
