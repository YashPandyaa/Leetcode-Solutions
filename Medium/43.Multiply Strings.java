class Solution {
    public String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int ans[] = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i >= 0; i--) {

            int n1 = num1.charAt(i) - '0';

            for (int j = num2.length() - 1; j >= 0; j--) {

                int n2 = num2.charAt(j) - '0';

                int mul = n1 * n2;

                int p1 = i + j;
                int p2 = i + j + 1;

                int sum = mul + ans[p2];

                ans[p2] = sum % 10;
                ans[p1] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < ans.length; i++) {
            if (!(sb.length() == 0 && ans[i] == 0)) {
                sb.append(ans[i]);
            }
        }

        return sb.toString();
    }
}
