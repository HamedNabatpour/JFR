package ir.sampleJFR.enabledevent;

import jdk.jfr.Enabled;
import jdk.jfr.Event;
import jdk.jfr.Label;
import jdk.jfr.Name;

@Name("com.oracle.WontSeeMe")
@Label("Won't See Me")
@Enabled(false)
public class WontSeeMe extends Event {
}
