class Solution {
    public int largestRectangleArea(int[] h) {
        
        // Next Smaller Element (Right Limit)
        Stack<Integer[]> st=new Stack<>();
        int[] rightLimit=new int[h.length];
        Arrays.fill(rightLimit, h.length);

        for(int i=0;i<h.length;i++){
            while(!st.isEmpty() && st.peek()[0]>h[i]){
                rightLimit[st.pop()[1]]=i;
            }
            st.push(new Integer[]{h[i],i});
        }

        // Previous Smaller Element (Left Limit)
        st=new Stack<>();
        int[] leftLimit=new int[h.length];
        Arrays.fill(leftLimit, -1);

        for(int i=h.length-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()[0]>h[i]){
                leftLimit[st.pop()[1]]=i;
            }
            st.push(new Integer[]{h[i],i});
        }

        int res=0;
        for(int i=0;i<h.length;i++){
            int range=rightLimit[i]-leftLimit[i]-1;
            res=Math.max(res,range*h[i]);
        }
        return res;
    }
}