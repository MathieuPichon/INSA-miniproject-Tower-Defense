import java.util.LinkedList;

public class Enemy {
    public LinkedList <Square> path;
    
    
    public Enemy() {
    }
    
    public boolean findPath (Square start, Square goal) {
        LinkedList <Square> closedset = new LinkedList<>();
        LinkedList<Square> openset = new LinkedList<>();
        openset.add(start);
        
        start.g_score = 0;
        //Find the total cost from start to goal
        double f_score = start.g_score + start.findHeuristic(goal);
        
        while(openset.isEmpty() == false) {
            Square current = findLowestF_score(openset, goal);
            System.out.println(current.position.toString());
            //this ugly thing above finds (like a douch) the smallest f score in the openset
            
            if(current == goal) {
                LinkedList <Square> totalPath = new LinkedList <> (); 
                totalPath = reconstructPath(current);
               /*
                pathReconstructed(totalPath); // to check if the path calculated is correct
                    a small problem : with this test the method doesn't return 
                    true anymore but we can see the entire path and it's correct, 
                    there is no aberration
                */
                return true;
            }
            
            closedset.add(current);
            openset.remove(current);
            for(int i = 0; i<4; i++) {
                //System.out.println(i);
                if(current.neighbors[i] != null) {
                    //System.out.println("testing neighbor " + i);
                    double tentative_g_score = current.g_score + 10; //!!!!!!!!!! things to understand
                    if(closedset.contains(current.neighbors[i]) == false) {
                        if(openset.contains(current) == false || tentative_g_score < current.neighbors[i].g_score) {
                            current.neighbors[i].came_from = current;
                            current.neighbors[i].g_score = tentative_g_score;
                            current.neighbors[i].f_score = tentative_g_score + current.neighbors[i].findHeuristic(goal);
                            if(openset.contains(current.neighbors[i]) == false) {
                                openset.add(current.neighbors[i]);
                            }
                        }
                    }
                }
            }
        }
        return false;
        
    }
    
    public Square findLowestF_score (LinkedList <Square> openset, Square goal) {
        Square[] opensetArray= new Square [openset.size()]; //#tracteur
        opensetArray = openset.toArray(opensetArray); // #je veux sauter par la fenètre
        
        double lowest_f_score = opensetArray[0].g_score + opensetArray[0].findHeuristic(goal);
        Square current = opensetArray[0];
        for(int i = 1; i<opensetArray.length; i++) {
            double tentative_f_score = opensetArray[i].g_score + opensetArray[i].findHeuristic(goal);
            if(tentative_f_score < lowest_f_score) {
                lowest_f_score = tentative_f_score;
                current = opensetArray[i];
            }
        }
        return current;
    }
    
    public LinkedList<Square> reconstructPath(Square current){
        LinkedList <Square> totalPath = new LinkedList<>();
        totalPath.add(current);
        while(current != null) {
            current = current.came_from;
            totalPath.add(current);
        }
        return totalPath; 
    }
    
    //just a little function to ckeck if the calculated path is correct
    public void pathReconstructed  ( LinkedList <Square> totalPath){
        Square [] pathArray = new Square[totalPath.size()];
        pathArray= totalPath.toArray(pathArray);
        System.out.println("position of the reconstructed path");
        for (int i=0; i< pathArray.length;i++ ){
            System.out.println(pathArray[i].position); 
        }
        System.out.println("end of the reconstructed path");
        
        
    }
}

