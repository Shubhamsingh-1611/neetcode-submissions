class Solution {

    public void solve(int idx,int sum,int target,List<List<Integer>> list,int nums[],List<Integer> l){
        if(sum>target || idx>=nums.length){
            return;
        }
        if(sum==target) {
            list.add(new ArrayList<>(l));
            return;
        }
        l.add(nums[idx]);
        solve(idx,sum+nums[idx],target,list,nums,l);
        l.remove(l.size()-1);
        solve(idx+1,sum,target,list,nums,l);
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        solve(0,0,target,list,nums,new ArrayList<>());
        return list;
    }
}
