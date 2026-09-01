class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;

        int oddCount = 0;
        char midChar = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                oddCount++;
                midChar = (char) ('a' + i);
            }
        }
        if (oddCount > 1) return "";

        int[] half = new int[26];
        for (int i = 0; i < 26; i++) half[i] = freq[i] / 2;
        int halfLen = n / 2;
        char finalMid = midChar;

        char[] halfArr = new char[halfLen];
        int idx = 0;
        int[] tmp = half.clone();
        for (int c = 0; c < 26 && idx < halfLen; c++) {
            while (tmp[c] > 0 && idx < halfLen) {
                halfArr[idx++] = (char) ('a' + c);
                tmp[c]--;
            }
        }

        String smallestPalin = buildPalin(halfArr, finalMid);
        if (smallestPalin.compareTo(target) > 0) return smallestPalin;

        String best = null;
        int[] pool = half.clone();

        for (int i = 0; i < halfLen; i++) {
            char tc = target.charAt(i);

            for (int c = tc - 'a' + 1; c < 26; c++) {
                if (pool[c] > 0) {
                    pool[c]--;
                    char[] newHalf = new char[halfLen];
                    for (int k = 0; k < i; k++) newHalf[k] = halfArr[k];
                    newHalf[i] = (char) ('a' + c);
                    int pos = i + 1;
                    int[] rem = pool.clone();
                    for (int d = 0; d < 26 && pos < halfLen; d++) {
                        while (rem[d] > 0 && pos < halfLen) {
                            newHalf[pos++] = (char) ('a' + d);
                            rem[d]--;
                        }
                    }
                    pool[c]++;
                    String candidate = buildPalin(newHalf, finalMid);
                    if (candidate.compareTo(target) > 0) {
                        if (best == null || candidate.compareTo(best) < 0)
                            best = candidate;
                    }
                    break;
                }
            }

            if (pool[tc - 'a'] > 0) {
                halfArr[i] = tc;
                pool[tc - 'a']--;
            } else {
                break;
            }

            if (i == halfLen - 1) {
                String fullMatch = buildPalin(halfArr, finalMid);
                if (fullMatch.compareTo(target) > 0) {
                    if (best == null || fullMatch.compareTo(best) < 0)
                        best = fullMatch;
                }
            }
        }

        return best == null ? "" : best;
    }

    private String buildPalin(char[] half, char mid) {
        StringBuilder sb = new StringBuilder();
        for (char c : half) sb.append(c);
        if (mid != 0) sb.append(mid);
        for (int i = half.length - 1; i >= 0; i--) sb.append(half[i]);
        return sb.toString();
    }
}
