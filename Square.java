import java.awt.Dimension;

public class Square {
    public Dimension d;
    public Square[] neighbors = new Square[4];
    public double g_score;
    public double f_score;
    public Coordinate position;
    public Square came_from;
    
    public Square (int i, int j) {
        position = new Coordinate(i,j);
        }
    
    public double findHeuristic (Square goal) {
        return Math.abs(goal.position.x - this.position.x) + Math.abs(goal.position.y - this.position.y);
    }
    
}
