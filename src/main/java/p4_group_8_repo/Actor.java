package p4_group_8_repo;

import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;


public abstract class Actor extends ImageView{

    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }

    //getters
    public World getWorld() {
        return (World) getParent();
    }
    public double getWidth() {
        return this.getBoundsInLocal().getWidth();
    }
    public double getHeight() {
        return this.getBoundsInLocal().getHeight();
    }

    //takes out the import part and put it at the top
    //A -> ActorClass for ease of understanding
    public <ActorClass extends Actor> List<ActorClass> getIntersectingObjects(java.lang.Class<ActorClass> cls){
        ArrayList<ActorClass> someArray = new ArrayList<>();
        for (ActorClass actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
            }
        }
        return someArray;
    }
    
    //remove manageInput (unused method)

    public <ActorClass extends Actor> ActorClass getOneIntersectingObject(java.lang.Class<ActorClass> cls) {
        ArrayList<ActorClass> someArray = new ArrayList<>();
        for (ActorClass actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
                break;
            }
        }
        return someArray.get(0);
    }

    public abstract void act(long now);

}
