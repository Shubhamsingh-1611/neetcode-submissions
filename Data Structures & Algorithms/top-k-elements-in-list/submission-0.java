class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
         
        for(int x:nums) {
            map.put(x,map.getOrDefault(x,0)+1);

        }
         List<int[]> arr = new ArrayList<>();
       for(Map.Entry<Integer,Integer> entry:map.entrySet()) {
            arr.add(new int[]{entry.getKey(),entry.getValue()});
       }
       Collections.sort(arr,(a,b)->b[1]-a[1]);
       int ans[] = new int[k];
       for(int i=0;i<k;i++) {
        ans[i] = arr.get(i)[0];
       }
  return ans;
    }
}
