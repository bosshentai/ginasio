package sample.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    public static boolean onlyDigits(String str){
        String regex = "[0-9]+";
        Pattern p = Pattern.compile(regex);

        if (str == null){
            return false;
        }

        Matcher m = p.matcher(str);
        return m.matches();
    };
}
