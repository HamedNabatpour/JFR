package ir.sampleJFR.event;

import jdk.jfr.Description;
import jdk.jfr.Event;
import jdk.jfr.Label;
import jdk.jfr.Name;

@Name(value = "ir.sampleJFR.event.HelloWorldSample")
@Label(value = "hello world")
@Description(value = "Learning how JFR works.")
public class HelloWorldSample extends Event {

    @Label(value = "message")
    public String message;

}
