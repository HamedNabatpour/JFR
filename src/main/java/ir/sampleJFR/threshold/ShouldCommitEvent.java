package ir.sampleJFR.threshold;

import jdk.jfr.Event;
import jdk.jfr.Label;
import jdk.jfr.Name;
import jdk.jfr.Threshold;

@Name("ir.sampleJFR.threshold.ShouldCommitEvent")
@Label("Random Sleep")
@Threshold("20 ms")
public class ShouldCommitEvent extends Event {
    @Label("ID")
    private int id;
    @Label("Value Kind")
    private String valueKind;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValueKind() {
        return valueKind;
    }

    public void setValueKind(String valueKind) {
        this.valueKind = valueKind;
    }
}
