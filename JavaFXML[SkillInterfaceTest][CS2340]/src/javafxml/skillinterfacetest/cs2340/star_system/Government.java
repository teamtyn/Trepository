package javafxml.skillinterfacetest.cs2340.star_system;

import java.util.Random;

/**
 *
 * @author David Purcell
 */
public class Government {
    private enum Type{ANARCHY, CAPITALIST, COMMUNIST,
                        CONFEDERACY, CORPORATE, CYBERNETIC,
                        DEMOCRACY, DICTATORSHIP, FASCIST,
                        FEUDAL, MILITARY, MONARCHY,
                        PACIFIST, SOCIALIST, STATEOFSATORI,
                        TECHNOCRACY, THEOCRACY};
    private Type type;
    private String leader;
    private int anger;
    private Random random = new Random();
    
    public Government(){
        type = Type.values()[random.nextInt(Type.values().length)];
        leader = "David";
        anger = 0;
    }
    
    public void VIVALAREVOLUTION(){
        type = Type.ANARCHY;
        leader = null;
        anger = Integer.MAX_VALUE;
    }
    
    public String toString(){
        StringBuilder str = new StringBuilder("Government Type: ")
            .append(type)
            .append("\nLeader: ")
            .append(leader)
            .append("\nAnger Level: ")
            .append(anger);
        return str.toString();
    }
}
