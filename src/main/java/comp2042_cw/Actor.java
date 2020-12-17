package comp2042_cw;

import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;


/**
 * This is an abstract class of Actor where other game elements like Frogger, Turtle, Log... will inherit from it.
 */
public abstract class Actor extends ImageView{

    //---------------------------------------------------------Methods----------------------------------------------------------------------

    /**
     * This method is used to move Actor(Game Object Element).
     * @param dx    This parameter determine how far the element would travel in X axis.
     * @param dy    This parameter determine how far the element would travel in Y axis.
     */
    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }

    /**
     * This method is used to check if 2 objects are intersected.
     * @param cls   This parameter is the sub-classes of Actor abstract class.
     * @param <ActorClass> Sub-class of Actor
     * @return  This method returns a list of ActorClass.
     */
    public <ActorClass extends Actor> List<ActorClass> getIntersectingObjects(java.lang.Class<ActorClass> cls){
        ArrayList<ActorClass> someArray = new ArrayList<>();
        for (ActorClass actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal()))
                someArray.add(actor);
        }
        return someArray;
    }

    public World getWorld() {
        return (World) getParent();
    }
    //---------------------------------------------------------/Methods----------------------------------------------------------------------

    /**
     * This is an abstract method that all sub-classes should implement.
     * This method will determine the main function of the sub-class.
     * @param now Current game time
     */
    public abstract void act(long now);

}
