class Solution {
    public boolean isAnagram(String s, String t) {
        int Ls = s.length();
        int Lt = t.length();
        if (Ls != Lt) {
            return false;
        }

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (char c : s.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        if (map1.equals(map2)) {
            return true;
        } else {
            return false;
        }

    }
}