package ir.sampleJFR.periodic;

import jdk.jfr.Event;
import jdk.jfr.Label;
import jdk.jfr.Name;
import jdk.jfr.Period;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

@Name("com.oracle.StartedThreadCount")
@Label("Total number of started threads")
@Period("1 s")
public class StartedThreadCount extends Event {
     private long totalStartedThreadCount;

    public long getTotalStartedThreadCount() {
        return totalStartedThreadCount;
    }

    public void setTotalStartedThreadCount(long totalStartedThreadCount) {
        this.totalStartedThreadCount = totalStartedThreadCount;
    }
}
