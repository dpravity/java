package java01.algorithm.ibm;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        String components = "abcdeab";
        int minLength = 2;
        int maxLength = 3;
        int maxUnique = 3;
        System.out.println(getMaxOccurrences(components, minLength, maxLength, maxUnique));
        // Expected output: 1
    }

    private static int getMaxOccurrences(String components, int minLength, int maxLength, int maxUnique) {
        HashMap<String, Integer> map = new HashMap<>();
        int count = 0;

        for(int i=0; i < components.length(); i ++){
            for(int j=i+minLength; j <= i+maxLength && j <= components.length(); j++){
                String sub = components.substring(i,j);
                if(valid(sub, maxUnique)){
                    map.put(sub, map.getOrDefault(sub,0)+1);
                    count = Math.max(count, map.get(sub));
                }
            }
        }
        return count;
    }

    private static boolean valid(String sub, int maxUnique) {
        int[] charArray = new int[26];
        int uniqueCount = 0;
        for(char c : sub.toCharArray()){
            if(charArray[c-'a'] == 0){
                uniqueCount++;
            }
            charArray[c-'a']++;
        }
        return uniqueCount <= maxUnique;
    }

}
