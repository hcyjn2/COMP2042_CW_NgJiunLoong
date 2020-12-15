package p4_group_8_repo;

import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;


public abstract class Actor extends ImageView{

    //---------------------------------------------------------Methods----------------------------------------------------------------------
    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }

    public World getWorld() {
        return (World) getParent();
    }

    public <ActorClass extends Actor> List<ActorClass> getIntersectingObjects(java.lang.Class<ActorClass> cls){
        ArrayList<ActorClass> someArray = new ArrayList<>();
        for (ActorClass actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
            }
        }
        return someArray;
    }
    //---------------------------------------------------------/Methods----------------------------------------------------------------------

    //abstract method
    public abstract void act(long now);

}
