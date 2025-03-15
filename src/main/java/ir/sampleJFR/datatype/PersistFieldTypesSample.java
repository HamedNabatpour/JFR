package ir.sampleJFR.datatype;

import jdk.jfr.Event;
import jdk.jfr.Label;
import jdk.jfr.Name;

import java.util.List;

@Name(value = "ir.sampleJFR.datatype.PersistFieldTypesSample")
@Label(value = "Allowed Field Types")
public class PersistFieldTypesSample extends Event {

    @Label(value = "Class Value")
    private Class<?> clazz;
    @Label(value = "Thread Value")
    private Thread threadValue;
    @Label(value = "String Value")
    private String stringValue;
    @Label(value = "byte value")
    private byte byteValue;
    @Label(value = "short value")
    private short shortValue;
    @Label("Int Value")
    int intValue;
    @Label("Long Value")
    long longValue;
    @Label("Float Value")
    float floatValue;
    @Label("Double Value")
    double doubleValue;
    @Label("Character Value")
    char characterValue;
    @Label("Boolean Value")
    boolean booleanValue;
    private int[] ints;
    private List<Integer> integerList;

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }

    public void setThreadValue(Thread threadValue) {
        this.threadValue = threadValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public void setByteValue(byte byteValue) {
        this.byteValue = byteValue;
    }

    public void setShortValue(short shortValue) {
        this.shortValue = shortValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    public void setLongValue(long longValue) {
        this.longValue = longValue;
    }

    public void setFloatValue(float floatValue) {
        this.floatValue = floatValue;
    }

    public void setDoubleValue(double doubleValue) {
        this.doubleValue = doubleValue;
    }

    public void setCharacterValue(char characterValue) {
        this.characterValue = characterValue;
    }

    public void setBooleanValue(boolean booleanValue) {
        this.booleanValue = booleanValue;
    }

    public void setInts(int[] ints) {
        this.ints = ints;
    }

    public void setIntegerList(List<Integer> integerList) {
        this.integerList = integerList;
    }
}
