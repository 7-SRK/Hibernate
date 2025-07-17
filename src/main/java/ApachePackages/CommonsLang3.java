package ApachePackages;

import org.apache.commons.lang3.*;
import org.apache.commons.lang3.math.NumberUtils;


public class CommonsLang3 {
    public static void main(String[] args) {

        //String Utils
        String s = "Apache Common Lang3";
        System.out.println("Is Empty ?" + StringUtils.isBlank(s));
        System.out.println("Trimmed ?" + StringUtils.trim(s) + " ' ");
        System.out.println("Capitalized: " + StringUtils.capitalize("apache"));
        System.out.println("Reversed: " + StringUtils.reverse("apache"));

        //ArrayUtils

        String[] arr = {"a","b","c"};
        arr = ArrayUtils.add(arr,"d");
        System.out.println("Array Length: " + arr.length);
        System.out.println("Array Contains ? " + ArrayUtils.contains(arr,"b"));


        //Objectutils

        String defaultStr = ObjectUtils.defaultIfNull(null,"default");
        System.out.println("Default Value: " + defaultStr);

        //NumberUtils

        int intValue = NumberUtils.toInt("123",0);
        System.out.println("Parsed int: " + intValue);

        //BooleanUtils

        boolean bool = BooleanUtils.toBoolean("yes");
        System.out.println("Boolean value of 'yes': " + bool);

        //RandomStringUtils
        String rand = RandomStringUtils.randomAlphanumeric(8);
        System.out.println("Random String: " + rand);

        //Validate
        try{
            Validate.notEmpty("test", "String Cannot be Empty");
            Validate.isTrue(5 > 3,"Must be True");
            System.out.println("Validation Passed");
        } catch (IllegalArgumentException e) {
            System.err.println("Validation Failed: " + e.getMessage());
        }
    }
}
