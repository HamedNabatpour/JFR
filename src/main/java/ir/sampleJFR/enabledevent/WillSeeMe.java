package ir.sampleJFR.enabledevent;

import jdk.jfr.Enabled;
import jdk.jfr.Event;
import jdk.jfr.Label;
import jdk.jfr.Name;

@Name("com.oracle.WillSeeMe")
@Label("Will See Me")
@Enabled(true)
public class WillSeeMe extends Event {
}
