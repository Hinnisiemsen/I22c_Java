import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class Kata {
    public Kata() {

    }
    public static Map<Character, Integer> count(String str) {
        // Happy coding!
        Map<Character, Integer> result = new HashMap<>();
        char[] characters = str.toCharArray();

        for (int i = 0; i < characters.length; i++) {
            if (!result.containsKey(characters[i])) {
                result.put(characters[i], 1);
            } else {
                result.replace(characters[i], result.get(characters[i])+1);
            }
        }
        return result;
    }
    public static String maskify(String str) {
        char[] characters = str.toCharArray();
        String result = new String();

        if (characters.length > 4) {
            for (int i = characters.length - 4; i > 0; i--) {
                characters[i] = '#';
            }
            return characters.toString();
        } else {
            return str;
        }
    }
    public static String rgb(int r, int g, int b) {
        String result = new String();
        int[] rgb = {r,g,b};

        for (int einzel: rgb) {
            if (einzel <= 0) {
                result = result.concat("00");
            } else if (einzel >= 255) {
                result = result.concat("FF");
            } else {
                int ersteStelle = 0;
                int zwischenstand = einzel;

                while (zwischenstand > 16) {
                    zwischenstand -= 16;
                    ersteStelle++;
                }
                String zweiteStelleHex = Integer.toHexString(zwischenstand);
                String ersteStelleHex = Integer.toHexString(ersteStelle);

                result = result.concat(ersteStelleHex).concat(zweiteStelleHex);
            }
        }
        return result.toUpperCase();
    }
    public static int bouncingBall(double h, double bounce, double window) {
        if (window > h || h < 0 || bounce < 0 || bounce > 1) {return -1;}

        int bounces = 1;
        do {
            h *= bounce;
            bounces += 2;
        } while (h > window);

        return bounces;
    }
    public static int ConvertBinaryArrayToInt(List<Integer> binary) {
        int result = 0;
        for (int i = 0; i < binary.size(); i++) {
            result = binary.get(i)* (int) Math.pow(2, i);
        }
        return result;
    }
    public static String factors(int n) {
        String result = new String();
        ArrayList<Integer> primeFactors = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                primeFactors.add(i);
                n /= i;
            }
        }

        for (int primeFactor: primeFactors) {
            int exponent = 0;
            for (int j = 0; j < primeFactors.size(); j++) {
                if (primeFactor == primeFactors.get(j)) {
                    exponent++;
                }
            }
            if ((exponent > 1) && !result.contains("(" + primeFactor + "**" + exponent + ")")) {
                result = result.concat("(" + primeFactor + "**" + exponent + ")");
            } else if (exponent <= 1) {
                result = result.concat("(" + primeFactor + ")");
            }
        }
        return result;
    }
    public static String expandedForm(int num)
    {
        String result = "";
        for (int i = 0; i < Integer.toString(num).length(); i++) {
            int v = Integer.parseInt(Character.toString(Integer.toString(num).charAt(i))) * (int) Math.pow(10, Integer.toString(num).length()-1-i);
            if (v != 0) {
                result = result.concat(Integer.toString(v)).concat(" + ");
            }
        }
        return result.substring(0,result.length()-3);
    }
    public static List<String> top3(String s) {
        List<String> result = new ArrayList<>();
        HashMap<String, Integer> zwischenstand = new HashMap<>();
        String[] words = s.replaceAll("[^A-Za-z']", " ").split("\\s");


        // Leere Strings entfernen
        words = Arrays.stream(words).filter(str -> !str.isEmpty()).toArray(String[]::new);
        if (words.length != 0) {
        // wörter ablegen und zählen
        for (String word: words) {
            if (!zwischenstand.containsKey(word)) {
                zwischenstand.put(word, 1);
            } else {
            int counter = zwischenstand.get(word);
            zwischenstand.remove(word);
            zwischenstand.put(word, counter+1);
            }
        }
        // maximum value rausfinden und zu result hinzufügen
            while (result.size() < 3 && !zwischenstand.isEmpty()) {
                String maxWord = words[0];
                int maxCount = Integer.MIN_VALUE;

                for (Map.Entry<String, Integer> entry : zwischenstand.entrySet()) {
                    String word = entry.getKey();
                    int count = entry.getValue();
                    if (count > maxCount) {
                        maxCount = count;
                        maxWord = word;
                    }
                }
                zwischenstand.remove(maxWord);
                if (maxWord != null & (!maxWord.replaceAll("'", "").isEmpty())) {
                    result.add(maxWord.toLowerCase());
                }
            }

        }
        return result;
    }
    public static String[] dirReduc(String[] arr) {
        HashMap<String, String> contra = new HashMap<>();
        contra.put("NORTH", "SOUTH");
        contra.put("SOUTH", "NORTH");
        contra.put("WEST", "EAST");
        contra.put("EAST", "WEST");
        List<String> directions = new ArrayList<>(Arrays.stream(arr).toList());

        for (int i = 0; i < directions.size()-1; i++) {
            if (directions.get(i) == null) {
                directions.remove(i);
                i = -1;

            } else if (Objects.equals(directions.get(i + 1), contra.get(directions.get(i)))) {
                directions.remove(i);
                directions.remove(i);
                i = -1;
            }
        }
        return directions.toArray(new String[0]);
    }

    public static String add(String a, String b) {
        int[] numbersA;
        String[] result;
        int[] numbersB;
        int uebertrag = 0;
        int groeßer;

        if (a.length() >= b.length()) {
            groeßer = a.length();
            numbersA = new int[groeßer];
            numbersB = new int[groeßer];
            result = new String[groeßer+1];

            for (int i = 0; i < groeßer-1; i--) {
                numbersB[numbersB.length-1-i] = Character.getNumericValue(b.charAt(b.length()-1-i));
                numbersA[i] = Character.getNumericValue(a.charAt(i));
            }
        } else {
            groeßer = b.length();
            numbersB = new int[groeßer+1];
            numbersA = new int[groeßer+1];
            result = new String[groeßer+2];

            for (int i = groeßer-1; i >= 0; i--) {
                numbersA[i] = Character.getNumericValue(a.charAt(i));
                numbersB[i] = Character.getNumericValue(b.charAt(i));
            }
        }

        for (int i = groeßer-1; i >= 0; i--) {
            result[i+1] = Integer.toString((numbersA[i] + numbersB[i] + uebertrag)%10);
            uebertrag = (numbersA[i] + numbersB[i])/10;
        }
        result[0] = Integer.toString(uebertrag);



        return Arrays.toString(result);
    }
    public static String[] whoEatsWho(final String zoo) {
        TreeMap<String, List<String>> fressen = new TreeMap<>();
        fressen.put("antelope", Arrays.asList("grass"));
        fressen.put("big-fish", Arrays.asList("little-fish"));
        fressen.put("bug", Arrays.asList("leaves"));
        fressen.put("bear", Arrays.asList("big-fish", "bug", "chicken", "cow", "leaves", "sheep"));
        fressen.put("chicken", Arrays.asList("bug"));
        fressen.put("cow", Arrays.asList("grass"));
        fressen.put("fox", Arrays.asList("chicken", "sheep"));
        fressen.put("giraffe", Arrays.asList("leaves"));
        fressen.put("lion", Arrays.asList("antelope", "cow"));
        fressen.put("panda", Arrays.asList("leaves"));
        fressen.put("sheep", Arrays.asList("grass"));

        ArrayList<String> result = new ArrayList<>();
        result.add(zoo);
        String[] tiere = zoo.split(",");
        ArrayList<String> tiereList = new ArrayList<>();
        tiereList.addAll(Arrays.asList(tiere));

        while (tiereList.size() > 1) {
            for (int i = 0; i < tiereList.size(); i++) {
                if (fressen.containsKey(tiereList.get(i))) {
                    for (String s : fressen.get(tiereList.get(i))) {
                        if (i > 0 && Objects.equals(tiereList.get(i - 1), s)) {
                            result.add(tiereList.get(i) + " eats " + s);
                            tiereList.remove(i-1);
                            i = -1;
                            break;
                        }
                        else if (tiereList.size()-1 != i && Objects.equals(tiereList.get(i + 1), s)) {
                            result.add(tiereList.get(i) + " eats " + s);
                            tiereList.remove(i+1);
                            i = -1;
                        }
                    }
                }
            }
        }
        result.add(tiereList.get(0));
        return result.toArray(new String[0]);

    }


}
