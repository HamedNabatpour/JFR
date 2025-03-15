package ir.sampleJFR.threshold;

import jdk.jfr.Event;
import jdk.jfr.Label;
import jdk.jfr.Name;
import jdk.jfr.Threshold;


@Name("ir.sampleJFR.threshold.RandomSleep")
@Label("Random Sleep")
@Threshold("50 ms")
public class RandomSleep extends Event {

    @Label("Event number")
    private int eventNumber;
    @Label("Random Value")
    private int randomValue;

    public void setEventNumber(int eventNumber) {
        this.eventNumber = eventNumber;
    }

    public void setRandomValue(int randomValue) {
        this.randomValue = randomValue;
    }


    public int getEventNumber() {
        return eventNumber;
    }

    public int getRandomValue() {
        return randomValue;
    }
}
