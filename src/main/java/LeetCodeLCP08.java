/**
 * 描述:
 *
 * @author ludengke
 * @create 2020-09-29 11:42
 */
public class LeetCodeLCP08 {
    public int[] getTriggerTime(int[][] increase, int[][] requirements) {
        for (int i = 1; i < increase.length; i++) {
            increase[i][0] += increase[i-1][0];
            increase[i][1] += increase[i-1][1];
            increase[i][2] += increase[i-1][2];
        }
        int[] result = new int[requirements.length];
        for (int i = 0; i < requirements.length; i++) {
            if(increase[increase.length-1][0] < requirements[i][0] || increase[increase.length-1][1] < requirements[i][1] || increase[increase.length-1][2] < requirements[i][2]){
                result[i] = -1;
            }else{
                int start = 0,end = increase.length-1;
                while(start < end){
                    if(increase[start][0] >= requirements[i][0] && increase[start][1] >= requirements[i][1] && increase[start][2] >= requirements[i][2]){
                        result[i] = start + 1;
                        break;
                    }
                    if(start + 1 == end){
                        result[i] = end + 1;
                        break;
                    }
                    int mid = (start + end) / 2;
                    if(increase[mid][0] >= requirements[i][0] && increase[mid][1] >= requirements[i][1] && increase[mid][2] >= requirements[i][2]){
                        end = mid;
                    }else {
                        start = mid;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCodeLCP08 l = new LeetCodeLCP08();
//        System.out.println(l.getTriggerTime());
    }
}
