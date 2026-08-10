class Solution {
    public int romanToInt(String s) {
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            int val = 0;

            if (s.charAt(i) == 'I') val = 1;
            if (s.charAt(i) == 'V') val = 5;
            if (s.charAt(i) == 'X') val = 10;
            if (s.charAt(i) == 'L') val = 50;
            if (s.charAt(i) == 'C') val = 100;
            if (s.charAt(i) == 'D') val = 500;
            if (s.charAt(i) == 'M') val = 1000;

            if (i < s.length() - 1) {
                int next = 0;

                if (s.charAt(i + 1) == 'I') next = 1;
                if (s.charAt(i + 1) == 'V') next = 5;
                if (s.charAt(i + 1) == 'X') next = 10;
                if (s.charAt(i + 1) == 'L') next = 50;
                if (s.charAt(i + 1) == 'C') next = 100;
                if (s.charAt(i + 1) == 'D') next = 500;
                if (s.charAt(i + 1) == 'M') next = 1000;

                if (val < next)
                    ans -= val;
                else
                    ans += val;
            } else {
                ans += val;
            }
        }

        return ans;
    }
}
