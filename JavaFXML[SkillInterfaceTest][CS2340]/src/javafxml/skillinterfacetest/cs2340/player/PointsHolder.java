/*
 * The PointsHolder class is here to help me distribute points during skill setup.
 */

package javafxml.skillinterfacetest.cs2340.player;

/**
 *
 * @author Local Clayton
 */
public class PointsHolder {
    private int total; //the total number of points a user is allowed to allocate
    int[] points;
    public PointsHolder(int newTotal, int[] newPoints) {
        total = newTotal;
        points = newPoints;
    }
    
}
