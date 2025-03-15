package ir.sample.JFR.hello;

import ir.sampleJFR.annotation.TransactionBlocked;
import ir.sampleJFR.datatype.PersistFieldTypesSample;
import ir.sampleJFR.dynamicevent.DynamicSample;
import ir.sampleJFR.event.HelloWorldSample;
import ir.sampleJFR.eventmetadata.SetMetadataSample;
import ir.sampleJFR.eventtime.MeasureTimeSample;
import jdk.jfr.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

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
    public void annotationsEventJFRSample(){
        TransactionBlocked transactionBlocked = new TransactionBlocked();
        transactionBlocked.begin();

        transactionBlocked.setTransaction(1111);
        transactionBlocked.setTransactionBlocker(222);

        transactionBlocked.commit();
    }
}
