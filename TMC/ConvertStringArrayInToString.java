package tmc;

// CREDITS: https://stackoverflow.com/questions/5283444/convert-array-of-strings-into-a-string-in-java/5283753

public class ConvertStringArrayInToString {
    
    public static String convert(String[] names) {
        StringBuilder builder = new StringBuilder();
        for(String s : names) {
            builder.append(s);
        }
        return builder.toString();
    }

}
