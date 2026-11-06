import java.util.*;
//user inputs words and then program should put them into anagram groups
//hopefully this is what the assignment is asking for lol
public class Main {

    public static List<List<String>> groupAnagrams(String[] strs) {
//using hashing
        HashMap<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] letters = word.toCharArray();
            Arrays.sort(letters);

            String key = new String(letters);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(word);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter words separated by commas:");
        String line = input.nextLine();

        String[] words = line.split(",");

        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].trim();
        }

        List<List<String>> result = groupAnagrams(words);

        System.out.println("Anagram groups:");
        System.out.println(result);

        input.close();
    }
}