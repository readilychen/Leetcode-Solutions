import java.util.List;
import java.util.ArrayList;
class Solution {
    public int rectangleArea(int[][] rectangles) {
        long repeatArea = 0;
        Map<Rectangle,List<Rectangle>> regions = new HashMap<>();
        //List<List<Rectangle>> indexList = new ArrayList<>();
        for(int i = 0; i < resctangles.length;i++){
            int[] rectangle = rectangles[i];
            boolean flag = false;
            List<Rectangle> combinedRegion = new ArrayList<>();
            for(Rectangle key : regions.keySet()){
                Rectangle processedRec = new Rectangle(rectangle);
                if(key.isIntersection(processedRec)){
                    flag = true;
                    combinedRegion.add(key);
                    for(Rectangle r : regions.get(key)){
                        repeatArea += r.getRepeatedArea(processedRec);
                    }
                }
            }
            // if it didn't have intersection with any region, then create a region based on that
            if(!flag){
                Rectangle newRegion = new Rectangle(rectangle);
                List<Rectangle> addList = new ArrayList<>();
                addList.add(newRegion);
                regions.put(newRegion,addList);
            }else{
                // if flag is true means it at least intersect with a region, then we need to combine these regions together
                for(Rectangle region : combinedRegion){
                    

                }
            }
        }
    }
}
class Rectangle{
    Point topRightPoint;
    Point bottomLeftPoint;
    Rectangle(topRightPoint,bottomLeftPoint){
        this.topRightPoint = topRightPoint;
        this.bottomLeftPoint = bottomLeftPoint;
    }
    Rectangle(int[] rectangle){
        this.bottomLeftPoint.x = rectangle[0];
        this.bottomLeftPoint.y = rectangle[1];
        this.topRightPoint.x = rectangle[2];
        this.topRightPoint.y = rectangel[3];
    }
    boolean isIntersection(Rectangle r){
        if((this.topRightPoint.x > r.bottomLeftPoint.x && this.topRightPoint.y > r.bottomLeftPoint.y) ||
          (r.topRightPoint.x > this.bottomLeftPoint.x && r.topRightPoint.y > this.bottomLeftPoint.y)){
            return true;
        }else{
            return false;
        }   
    }
    long getRepeatedArea(Rectangle r){
        if(this.isIntersection(r)){
            long bottomLeftx = this.bottomLeftPoint.x > r.bottomLeftPoint.x ? this.bottomLeftPoint.x : r.bottomLeftPoint.x;
            long bottomLefty = this.bottomLeftPoint.y > r.bottomLeftPoint.y ? this.bottomLeftPoint.y : r.bottomLeftPoint.y;
            long topRightx = this.topRightPoint.x > r.topRightPoint.x ? r.topRightPoint.x : this.topRightPoint.x;
            long topRighty = this.topRightPoint.y > r.topRightPoint.y ? r.topRightPoint.y : this.topRightPoint.y;
            return (topRightx - bottomLeftx) * (topRighty - topRighty);
        }else{
            return 0;
        }
    }
}
class Point{
    long x;
    long y;
    Point(long x, long y){
        this.x = x;
        this.y = y;
    }
}