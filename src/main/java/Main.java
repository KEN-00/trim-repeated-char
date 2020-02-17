import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


public class Main {

    public static void main (String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input String: ");

        String inputStr = bufferedReader.readLine();
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = Arrays.asList(inputStr.split("")).iterator();
        Map<String, Integer> charMap = new HashMap<>();

        String prevChar = null;
        while (it.hasNext()) {
            String current = it.next();
            Integer count = charMap.get(current) == null ? 1 : charMap.get(current);

            if(prevChar != null && !prevChar.equals(current)) {
                sb.append(prevChar);
                charMap.remove(prevChar);
            }

            charMap.put(current, count);
            prevChar = current;

            if(!it.hasNext() && charMap.get(current) != null) {
                sb.append(current);
            }
        }


        System.out.println("Output String: ");
        System.out.println(sb.toString());
    }

}
