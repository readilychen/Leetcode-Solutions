class Solution1{
    //List<Integer[][]> combination = new ArrayList<>();
    public double largestTriangleArea(int[][] points) {
        double max = Double.MIN_VALUE;
        for(int i = 0;i<points.length;i++){
            for(int j = i+1;j<points.length;j++){
                for(int k = j+1;k<points.length;k++){
                    double area = getArea(points[i][0],points[i][1],points[j][0],points[j][1],points[k][0],points[k][1]);
                    max = max>area?max:area;
                }
            }
        }
        return max;
    }
    public double getArea(int p1x,int p1y,int p2x,int p2y,int p3x, int p3y){
        //System.out.println(p1x+" "+p1y+" "+p2x+" "+p2y+" "+p3x+" "+p3y+" ");
        double edge;
        double height;
        if(p1x == p2x){
            edge = Math.abs(p1y-p2y);
            height = Math.abs(p3x - p2x);
        }else if(p1y == p2y){
            edge = Math.abs(p1x - p2x);
            height = Math.abs(p3y - p2y);
        }else{
            edge = distance(p1x,p1y,p2x,p2y);
            double k1 = (double)(p2y - p1y)/(p2x - p1x);
            double b1 = p2y - p2x * k1;
            //System.out.println("b1 "+b1);
            double k2 = - 1 / k1;  
            //System.out.println("k2 "+k2); 
            double b2 = p3y - p3x * k2;
            //System.out.println("b2 "+b2); 
            double newX = (b2-b1)/(k1-k2);
            //System.out.println("newx "+newX);
            double newY = k1 * newX + b1;
            //System.out.println("newy "+newY);
            height = distance(newX,newY,p3x,p3y);
            //System.out.println(height);
        }
        return edge * height * 0.5;
    }
    // public void recursivelyFindPoint(int[][] points,int index,List<Integer[][]> pointSet, int selectNum){
    //     if(selectNum == 0){
    //         Integer[][] triangle = new Integer[pointSet.size()][2];
    //         for(int i = 0;i<pointSet.size();i++){
    //             triangle[i][0] = pointSet.get(i)[0][0];
    //             triangle[i][1] = pointSet.get(i)[0][1];
    //             combination.add(triangle);
    //         }
    //     }
    //     for(int i =index ;i< points.length;i++){
    //         Integer[][] addPoint = new Integer[1][2];
    //         addPoint[0][0] = points[i][0];
    //         addPoint[0][1] = points[i][1];
    //         pointSet.add(addPoint);
    //         recursivelyFindPoint(points,index+1,pointSet,selectNum-1);
    //         pointSet.remove(pointSet.size());
    //     }
    // }
    public double distance(double p1x, double p1y, double p2x, double p2y){
        double disX = p1x - p2x;
        double disY = p1y - p2y;
        return Math.sqrt(Math.pow(disX,2)+Math.pow(disY,2));
    }
    public static void main(String[] args) {
        int[][] points = {{4,6},{6,5},{3,1}};
        Solution1 s1 = new Solution1();
        System.out.println(s1.largestTriangleArea(points));

    }
}