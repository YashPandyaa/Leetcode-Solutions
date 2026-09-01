class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int i = 0;

        while (i < n) {
            int j = i;

            while (j + 1 < n && sorted[j + 1] - sorted[j] <= limit) {
                j++;
            }

            List<Integer> group = new ArrayList<>();
            for (int k = i; k <= j; k++) {
                group.add(sorted[k]);
            }

            Collections.sort(group);

            i = j + 1;
        }

        Map<Integer, Queue<Integer>> map = new HashMap<>();

        i = 0;
        while (i < n) {
            int j = i;

            while (j + 1 < n && sorted[j + 1] - sorted[j] <= limit) {
                j++;
            }

            Queue<Integer> q = new LinkedList<>();
            for (int k = i; k <= j; k++) {
                q.add(sorted[k]);
            }

            for (int k = i; k <= j; k++) {
                map.put(k, q);
            }

            i = j + 1;
        }

        Map<Integer, Integer> groupMap = new HashMap<>();
        i = 0;
        int group = 0;

        while (i < n) {
            int j = i;

            while (j + 1 < n && sorted[j + 1] - sorted[j] <= limit) {
                j++;
            }

            for (int k = i; k <= j; k++) {
                groupMap.put(sorted[k], group);
            }

            group++;
            i = j + 1;
        }

        Map<Integer, PriorityQueue<Integer>> pq = new HashMap<>();

        for (int x : nums) {
            int g = groupMap.get(x);
            pq.computeIfAbsent(g, k -> new PriorityQueue<>()).add(x);
        }

        for (i = 0; i < n; i++) {
            int g = groupMap.get(nums[i]);
            nums[i] = pq.get(g).poll();
        }

        return nums;
    }
}
