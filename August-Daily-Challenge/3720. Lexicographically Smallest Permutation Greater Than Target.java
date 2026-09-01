class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (char c : s.toCharArray())
            map.merge(c, 1, Integer::sum);

        int lastValid = -1;
        TreeMap<Character, Integer> temp = new TreeMap<>(map);

        for (int i = 0; i < n; i++) {
            char t = target.charAt(i);
            if (temp.higherKey(t) != null)
                lastValid = i;
            if (temp.containsKey(t)) {
                temp.merge(t, -1, Integer::sum);
                if (temp.get(t) == 0) temp.remove(t);
            } else break;
        }

        if (lastValid == -1) return "";

        TreeMap<Character, Integer> avail = new TreeMap<>(map);
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < lastValid; i++) {
            char t = target.charAt(i);
            res.append(t);
            avail.merge(t, -1, Integer::sum);
            if (avail.get(t) == 0) avail.remove(t);
        }

        char t = target.charAt(lastValid);
        char ch = avail.higherKey(t);
        avail.merge(ch, -1, Integer::sum);
        if (avail.get(ch) == 0) avail.remove(ch);
        res.append(ch);

        for (Map.Entry<Character, Integer> e : avail.entrySet())
            for (int k = 0; k < e.getValue(); k++)
                res.append(e.getKey());

        return res.toString();
    }
}
