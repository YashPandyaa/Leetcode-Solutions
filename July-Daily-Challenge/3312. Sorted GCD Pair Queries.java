class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int m = 0;
        for(int num : nums)
            m = Math.max(m, num);
        long count[] = new long[m+1];
        for(int num : nums) {
            count[num]++;
        }
        long gcdPairs[] = new long[m+1];
        for(int i=1; i<=m; i++) {
            for(int j=i; j<=m; j+=i) {
                gcdPairs[i] += count[j];
            }
            gcdPairs[i] = (gcdPairs[i]*(gcdPairs[i]-1))/2;
        }
        for(int i=m; i>=1; i--) {
            for(int j=2*i; j<=m; j+=i) {
                gcdPairs[i] -= gcdPairs[j];
            }
        }
        long presum[] = new long[m+1];
        for(int i=1; i<=m; i++) {
            presum[i] = presum[i-1] + gcdPairs[i];
        }

        int ans[] = new int[queries.length];

        for(int i=0; i<queries.length; i++) {
            long k = queries[i] + 1;
            int left = 1, right = m;
            while(left < right) {
                int mid = left  + (right-left)/2;
                if(presum[mid]>=k)
                    right = mid;
                else left = mid+1;
            }
            ans[i] = left;
        }

        return ans;
    }
}
