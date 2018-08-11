import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
class Solution2 {
    public int calDist(int x, int y){
        return (int)(Math.pow(x, 2) + Math.pow(y, 2));
    }
    public int robotSim(int[] commands, int[][] obstacles) {
        int maxDistance = Integer.MIN_VALUE;
        Map<Integer,List<Integer>> xIndex = new HashMap<>();
        Map<Integer,List<Integer>> yIndex = new HashMap<>();
        for(int i = 0 ; i < obstacles.length;i++){
            int x = obstacles[i][0];
            int y = obstacles[i][1];
            if(xIndex.containsKey(x)){
                List<Integer> ylist = xIndex.get(x);
                ylist.add(y);
            }else{
                List<Integer> ylist = new ArrayList<>();
                ylist.add(y);
                xIndex.put(x,ylist);
            }
            if(yIndex.containsKey(y)){
                List<Integer> xlist = yIndex.get(y);
                xlist.add(x);
            }else{
                List<Integer> xlist = new ArrayList<>();
                xlist.add(x);
                yIndex.put(y,xlist);
            }
        }
        System.out.println("xindex "+xIndex);
        System.out.println("yIndex "+yIndex);
        int currentX = 0;
        int currentY = 0;
        // 1 , 2, 3, 4 
        int direction = 1;
        for(int i = 0; i<commands.length ; i++){
            if(commands[i] == -2){
                if(direction == 1){
                    direction = 4;
                }else{
                    direction -= 1;
                }
            }else if(commands[i] == -1){
                if(direction == 4){
                    direction = 1;
                }else{
                    direction += 1;
                }
            }else{
                if(direction == 1 || direction == 3){
                    if(xIndex.containsKey(currentX)){
                        List<Integer> ylist = xIndex.get(currentX);
                        if(direction == 1){
                            int smallY = Integer.MAX_VALUE;
                            for(Integer y : ylist){
                                if(y > currentY){
                                    smallY = smallY <= y-currentY? smallY: y-currentY;
                                }
                            }
                            if(smallY <= commands[i]){
                                currentY += smallY;
                                currentY -= 1;
                            }else{
                                currentY += commands[i];
                            }
                        }else{
                            int smallY = Integer.MAX_VALUE;
                            for(Integer y : ylist){
                                if(y < currentY){
                                    smallY = smallY <= currentY-y ? smallY: currentY-y;
                                }
                            }

                            if(smallY <= commands[i]){
                                currentY -= smallY;
                                currentY += 1;
                            }else{
                                currentY -= commands[i]; 
                            }  
                        }
                    }else{
                        if(direction == 1){
                            currentY += commands[i];
                        }else{
                            currentY -= commands[i];
                        }
                    }
                }
                if(direction == 2 || direction == 4 ){
                    if(yIndex.containsKey(currentY)){
                        List<Integer> xlist = yIndex.get(currentY);
                        if(direction == 2){
                            int smallX = Integer.MAX_VALUE;
                            for(Integer x : xlist){
                                if(x>currentX){
                                    smallX = smallX <= x - currentX ? smallX : x - currentX;
                                }
                            }
                            if(smallX <= commands[i]){
                                currentX += smallX; 
                                currentX -= 1;
                            }else{
                                currentX += commands[i];
                            }
                        }else{
                            int smallX = Integer.MAX_VALUE;
                            for(Integer x : xlist){
                                if(x<currentX){
                                    smallX = smallX <= currentX - x ? smallX : currentX - x;
                                }
                            }
                            if(smallX <= commands[i]){
                                currentX -= smallX;
                                currentX += 1;
                            }else{
                                currentX -= commands[i];
                            }
                        }
                    }else{
                        if(direction == 2){
                            currentX += commands[i];
                        }else{
                            currentX -= commands[i];
                        }
                    }
                }
                int tempDist = calDist(currentX,currentY);
                maxDistance = maxDistance > tempDist ? maxDistance : tempDist;
            }
            System.out.println("direction = "+direction);
            System.out.println("X position = "+currentX);
            System.out.println("Y position = "+ currentY);
        }
        return maxDistance;
    }
    public static void main(String[] args) {
        Solution2 s2 = new Solution2();
        int[] commands = {7,-2,-2,7,5};
        int[][] obstacles = {{-3,2},{-2,1},{0,1},{-2,4},{-1,0}
        ,{-2,-3},{0,-3},{4,4},{-3,3},{2,2}};
        System.out.println(s2.robotSim(commands,obstacles));

    }
}