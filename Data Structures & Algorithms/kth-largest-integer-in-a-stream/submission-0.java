class KthLargest {
    List<Integer> arr;
    int K;

    public KthLargest(int k, int[] nums) {
        this.K = k;
        arr = new ArrayList<>();
        for (int num : nums) {
            arr.add(num);
        }
    }
    
    public int add(int val) {
        arr.add(val);
        Collections.sort(arr);
        return arr.get(arr.size() - K);
    }
}
