public class TowerDefense {
    
    Square goal = new Square(9,9);
    Square [][] mainGrid = new Square[10][10];
    
    public TowerDefense() {
        
        //initialise the grid with all the squares
        //we need it to attribute the neighborgs later
        for(int i = 0; i<10; i++){
            for(int j = 0; j<10; j++){
                mainGrid[i][j] = new Square(i,j);
            }
        }
        
        
        //attributing neighbors
        for(int i = 0; i<10; i++){
            for(int j = 0; j<10; j++){
                if(i-1>=0) {
                    mainGrid[i][j].neighbors[0] = mainGrid[i-1][j];
                }
                
                if(i+1<=9) {
                    mainGrid[i][j].neighbors[2] = mainGrid[i+1][j];
                }
                
                if(j-1>=0) {
                    mainGrid[i][j].neighbors[3] = mainGrid[i][j-1];
                }
                
                if(j+1<=9) {
                    mainGrid[i][j].neighbors[1] = mainGrid[i][j+1];
                }
            }
        }
    }
        
    
    public static void main(String[] args) {
        TowerDefense towerDefense = new TowerDefense();
        Square goal = towerDefense.getMainGrid(9,9);
        Square start = towerDefense.getMainGrid(0,0);
        
        Enemy Thomas = new Enemy();
        
        System.out.println(Thomas.findPath( start, goal));
    }
    
    public Square getMainGrid (int i, int j) {
        return mainGrid[i][j];
    }
}

