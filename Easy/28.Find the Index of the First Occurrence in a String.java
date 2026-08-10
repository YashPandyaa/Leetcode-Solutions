class Solution {
    public int strStr(String haystack, String needle) {
        int diff = haystack.length() - needle.length();

        for (int i = 0; i <= diff; i++) {
            boolean match = true;

            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    match = false;
                    break;
                }
            }

            if (match) {
                return i;
            }
        }

        return -1;
    }
}
