package ir.sampleJFR.eventtime;

import jdk.jfr.Event;
import jdk.jfr.Label;
import jdk.jfr.Name;

@Name(value = "ir.sampleJFR.eventtime.MeasureTimeSample")
@Label(value = "Measure Duration")
public class MeasureTimeSample extends Event {
}
