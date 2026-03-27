package za.ac.cput.util;

import java.util.UUID;

public class helper {
    public static String generatedUUI(){

        return UUID.randomUUID().toString();
    }
    public static boolean isNullOrEmpty(String str){
        return(str == null ||str.trim().isEmpty());

    }

}
