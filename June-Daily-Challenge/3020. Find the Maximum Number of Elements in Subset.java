class Solution {
    public int maximumLength(int[] nums) {

        HashMap<Long, Integer> hmap = new HashMap<>();

        for (int num : nums) {
            hmap.put((long) num, hmap.getOrDefault((long) num, 0) + 1);
        }

        int ans = 0;

        if (hmap.containsKey(1L)) {
            int ones = hmap.get(1L);
            ans = (ones % 2 == 0) ? ones - 1 : ones;
            hmap.remove(1L);
        }

        for (long num : hmap.keySet()) {
            int count = 0;
            long curr = num;

            while (hmap.containsKey(curr)) {
                if (hmap.get(curr) >= 2) {
                    count += 2;
                } else {
                    count++;
                    break;
                }
                curr = curr * curr;
            }

            if (count % 2 == 0) {
                count--;
            }

            ans = Math.max(ans, count);
        }

        return ans;
    }
}
