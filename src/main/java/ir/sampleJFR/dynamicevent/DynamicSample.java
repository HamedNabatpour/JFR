package ir.sampleJFR.dynamicevent;

import jdk.jfr.Event;

public class DynamicSample extends Event {

    public static String randomString(int n){
        var ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        var builder = new StringBuilder();

        while (n-- != 0) {
            int character = (int) (Math.random()
                    * ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();

    }
}
