package ir.sample.JFR.hello;

import ir.sampleJFR.annotation.TransactionBlocked;
import ir.sampleJFR.datatype.PersistFieldTypesSample;
import ir.sampleJFR.dynamicevent.DynamicSample;
import ir.sampleJFR.enabledevent.WillSeeMe;
import ir.sampleJFR.enabledevent.WontSeeMe;
import ir.sampleJFR.event.HelloWorldSample;
import ir.sampleJFR.eventmetadata.SetMetadataSample;
import ir.sampleJFR.eventtime.MeasureTimeSample;
import ir.sampleJFR.periodic.StartedThreadCount;
import ir.sampleJFR.threshold.RandomSleep;
import ir.sampleJFR.threshold.ShouldCommitEvent;
import jdk.jfr.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Random;

public class EventJFRSampleTest {

    @Test
    public void eventJFRSample() {
        HelloWorldSample helloWorldSample = new HelloWorldSample();

        helloWorldSample.begin();
        helloWorldSample.message = "Bebinim che khabare";
        helloWorldSample.commit();
    }

    @Test
    public void eventMetadataJFRSample(){
        SetMetadataSample setMetadataSample = new SetMetadataSample();
        setMetadataSample.begin();
        setMetadataSample.message = "Az SetMetadataSample che khabar";
        setMetadataSample.commit();
    }

    @Test
    public void eventMeasureTimeJFRSample() throws InterruptedException {
        MeasureTimeSample measureTimeSample = new MeasureTimeSample();
        measureTimeSample.begin();
        Thread.sleep(42);
        measureTimeSample.commit();
    }

    @Test
    public void eventDataTypeJFRSample() throws InterruptedException {
        PersistFieldTypesSample persistFieldTypesSample = new PersistFieldTypesSample();
        persistFieldTypesSample.begin();
        persistFieldTypesSample.setClazz(Math.class);
        persistFieldTypesSample.setThreadValue(Thread.currentThread());
        persistFieldTypesSample.setStringValue("Hello DataType");
        persistFieldTypesSample.setByteValue((byte) 42);
        persistFieldTypesSample.setShortValue((short) 4711);
        persistFieldTypesSample.setIntValue(42);
        persistFieldTypesSample.setLongValue(42L);
        int[] arr = {1,2,3};
        persistFieldTypesSample.setInts(arr);
        var a = new ArrayList<Integer>();
        a.add(1);
        a.add(2);
        persistFieldTypesSample.setIntegerList(a);
        persistFieldTypesSample.commit();
    }

    @Test
    public void dynamicEventJFRSample(){
//        DynamicSample dynamicSample = new DynamicSample();
        String[] categories = {"Demonstration", "Tutorial"};
        var eventAnnotations = new ArrayList<AnnotationElement>();
        eventAnnotations
                .add(new AnnotationElement(Name.class, "ir.sampleJFR.dynamicevent.DynamicSample"));
        eventAnnotations
                .add(new AnnotationElement(Label.class, "Field Named with Random String"));
        eventAnnotations.add(new AnnotationElement(Description.class,
                "Demonstrates how to create a dynamic event"));
        eventAnnotations.add(new AnnotationElement(
                Category.class, categories));

        var fieldAnnotations = new ArrayList<ValueDescriptor>();
        var messageAnnotations = Collections
                .singletonList(new AnnotationElement(Label.class, "Message"));

        var randomFieldName = DynamicSample.randomString(8);

        fieldAnnotations.add(new ValueDescriptor(String.class, randomFieldName,
                messageAnnotations));

        var numberAnnotations = Collections
                .singletonList(new AnnotationElement(Label.class, "Number"));
        fieldAnnotations.add(new ValueDescriptor(
                int.class, "number", numberAnnotations));

        var eventFactory = EventFactory.create(eventAnnotations, fieldAnnotations);
        Event dynamicSample  = eventFactory.newEvent();
        dynamicSample.set(0, "hello, world!");
        dynamicSample.set(1, 100);
        dynamicSample.commit();

    }

    @Test
    public void customAnnotationsEventJFRSample(){
        TransactionBlocked transactionBlocked = new TransactionBlocked();
        transactionBlocked.begin();

        transactionBlocked.setTransaction(1111);
        transactionBlocked.setTransactionBlocker(222);

        transactionBlocked.commit();
    }

    @Test
    public void enabledEventJFRSample(){
        WontSeeMe event1 = new WontSeeMe();
        event1.commit();
        WillSeeMe event2 = new WillSeeMe();
        event2.commit();
    }

    @Test
    public void thresholdEventJFRSample() throws InterruptedException {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            RandomSleep event = new RandomSleep();
            event.begin();
            event.setRandomValue(Math.abs(random.nextInt() % 100));
            event.setEventNumber(i);
            System.out.println("Event #" + i + ": " + event.getRandomValue());
            Thread.sleep(event.getRandomValue());
            event.commit();
        }
    }

    @Test
    public void shouldCommitEventJFRSample() throws InterruptedException {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            ShouldCommitEvent event = new ShouldCommitEvent();
            event.begin();
            event.setId(i);
            int value = random.nextInt();
            System.out.println("ID " + i + ": " + value);
            Thread.sleep(value);
            event.end();
            if (event.shouldCommit()) {
// Format message outside timing of event
                if (value < 10) {
                    event.setValueKind("It was a low value of "+ value + "!");
                } else if (value < 20) {
                    event.setValueKind("It was a normal value of "+ value + "!");
                } else {
                    event.setValueKind("It was a high value of "+ value + "!");
                }
                event.commit();
            }
        }
    }

    private static ThreadMXBean tBean =
            ManagementFactory.getThreadMXBean();
    @Test
    public void periodicEventJFRSample() throws InterruptedException {
        Runnable hook = () -> {
            StartedThreadCount event = new StartedThreadCount();
            event.setTotalStartedThreadCount(tBean.getTotalStartedThreadCount());

            event.commit();
        };

        FlightRecorder.addPeriodicEvent(StartedThreadCount.class, hook);

        for (int i = 0; i < 4; i++) {
            Thread.sleep(1500);
            Thread t = new Thread();
            t.start();
        }

        FlightRecorder.removePeriodicEvent(hook);
    }
    @Test
    void outOfMemory(){
        var list = new ArrayList<Object>();
        try {
            while (true){
                list.add(new Object());
                Thread.sleep(500);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
