package ir.sampleJFR.eventmetadata;

import jdk.jfr.*;

@Name(value = "ir.sampleJFR.eventmetadata.SetMetadataSample")
@Label("Set Metadata Example")
@Description("Demonstrates how to set the annotations "
        + "@Name, @Description, @Label, and @Category")
@Category(value = {"Demonstration", "Tutorial"})
public class SetMetadataSample extends Event {
    @Label("Message")
    public String message;

}
