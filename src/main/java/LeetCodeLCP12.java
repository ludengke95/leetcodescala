/**
 * 描述:
 *
 * @author ludengke
 * @create 2020-09-29 11:42
 */
public class LeetCodeLCP12 {
    public int minTime(int[] time, int m) {
        int left = 0;
        int right = 0;
        if(time.length <= m){
            return 0;
        }
        for(int i = 0;i < time.length; i++){
            right += time[i];
        }
        while (left <= right){
            int mid = (left + right) >> 1;
            int num = split(mid,time,m);
            if(num > m){
                left = mid + 1;
            }else if(num == m && left == right) {
                break;
            }else {
                right = mid;
            }
        }
        return left;
    }

    public int split(int num,int[] time,int m){
        int sum = 0;
        int max = 0;
        int day = 0;
        for (int i = 0; i < time.length; i++) {
            if(time[i] > max){
                max = time[i];
            }
            sum += time[i];
            if(sum - max > num){
                day += 1;
                sum = time[i];
                max = time[i];
            }
            if(i == time.length-1 && sum - max <= num){
                day +=1;
            }
        }
        return day;
    }

    public static void main(String[] args) {
        LeetCodeLCP12 s = new LeetCodeLCP12();
//        System.out.println(s.minTime(new int[]{1,2,10,9,8,7,6,5,9,10},5));
//        System.out.println(s.minTime(new int[]{1,2,3,3},2));
//        System.out.println(s.minTime(new int[]{999,999,999},4));
        System.out.println(s.minTime(new int[]{73,26,15,33,65,95,5,7,73,4,42,39,73,25,7,59,1,29,95,71,2,22,63,54,65,5,79,40,99,53,51,37,94,5,34,35,97,42,49,19,13,14,39,79,9,52,67,70,56,65,43,49,16,86,81,3,43,43,75,51,75,85,87,66,69,47,95,69,91,28,81,51,8,16,27,51,91,65,18,16,29,74,65,11,93,95,38,49,17,100,83,12,6,9,14,62,37,53,76,1},57));
    }
}
