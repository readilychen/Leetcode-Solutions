class SurfaceAreaof3DShapes {
    public int surfaceArea(int[][] grid) {
        int[][] surroundArea = {{0,1},{0,-1},{1,0},{-1,0}};
        int finalValue = 0;
        for(int i = 0 ; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                int value = grid[i][j];
                if(value == 0){
                    continue;
                }
                int sideArea = 0;
                for(int k = 0; k<surroundArea.length; k++){
                    int xOffset = surroundArea[k][0];
                    int yOffset = surroundArea[k][1];
                    int afterxOffset = i+xOffset;
                    int afteryOffset =  j+yOffset;
                    if(afterxOffset < 0 || afterxOffset >= grid.length || afteryOffset <0 || afteryOffset >= grid[0].length){
                        sideArea += value;
                        continue;
                    }
                    int sideValue = grid[afterxOffset][afteryOffset];
                    if(sideValue < value){
                        int addValue = value-sideValue;
                        sideArea += addValue;
                    }
                }
                //System.out.println("i "+i + " j "+j );
                //System.out.println("sideArea "+sideArea);
                finalValue += sideArea + 2;
            }
        }
        return finalValue;
    }
}