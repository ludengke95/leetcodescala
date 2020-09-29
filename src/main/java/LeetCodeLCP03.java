/**
 * 描述:
 *
 * @author ludengke
 * @create 2020-09-29 11:42
 */
public class LeetCodeLCP03 {
    public boolean robot(String command, int[][] obstacles, int x, int y) {
        int[] pointX = new int[command.length()];
        int[] pointY = new int[command.length()];
        int startX = 0, startY = 0, xMax = 0, yMax = 0;
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i)=='U'){
                startY += 1;
            }else if(command.charAt(i)=='R'){
                startX += 1;
            }
            pointX[i] = startX;
            pointY[i] = startY;
            xMax = pointX[i] > xMax?pointX[i]:xMax;
            yMax = pointY[i] > yMax?pointY[i]:yMax;
        }
        for (int i = 0; i < obstacles.length; i++) {
            if(obstacles[i][0] <= x && obstacles[i][1] <= y){
                int num = obstacles[i][0] / xMax;
                for(int k = num-1;k <= num+1;k++){
                    for (int j = 0; j < command.length(); j++) {
                        if(startX * k + pointX[j] == obstacles[i][0] && startY * k + pointY[j] == obstacles[i][1]){
                            return false;
                        }
                    }
                }
            }
        }
        int num = x / xMax;
        for(int k = num-1;k <= num+1;k++){
            for (int j = 0; j < command.length(); j++) {
                if(startX * k + pointX[j] == x && startY * k + pointY[j] == y){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCodeLCP03 l = new LeetCodeLCP03();
//        System.out.println(l.robot());
    }
}
