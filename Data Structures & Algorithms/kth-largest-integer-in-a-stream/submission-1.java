class KthLargest {
    Queue<Integer> pq;
    int size;

    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>();
        this.size = k;
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > size) {
                pq.poll();
            }
        }    
    }
    
    public int add(int val) {
        pq.add(val);
        if (pq.size() > size) {
            pq.poll();
        }
        return pq.peek();
    }
}
