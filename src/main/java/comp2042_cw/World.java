package comp2042_cw;

import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;


/**
 * This is abstract class World where it handles mostly animation and generation of game assets.
 */
public abstract class World extends Pane {
    private AnimationTimer timer;

    //constructor
    public World() {

        //execute the animation(switch image) of the actor.
    	sceneProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                newValue.setOnKeyReleased(event -> {
                    if(getOnKeyReleased() != null)
                        getOnKeyReleased().handle(event);

                    List<Actor> myActors = getObjects(Actor.class);

                    for (Actor anActor: myActors) {
                        if (anActor.getOnKeyReleased() != null)
                            anActor.getOnKeyReleased().handle(event);
                    }
                });

                newValue.setOnKeyPressed(event -> {
                    if(getOnKeyPressed() != null)
                        getOnKeyPressed().handle(event);

                    List<Actor> myActors = getObjects(Actor.class);

                    for (Actor anActor: myActors) {
                        if (anActor.getOnKeyPressed() != null)
                            anActor.getOnKeyPressed().handle(event);
                    }
                });

            }

        });
    }



    //---------------------------------------------------------Methods----------------------------------------------------------------------

    /**
     * This method will create a animation timer for actor to switch image.
     */
    public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                act(now);

                List<Actor> actors = getObjects(Actor.class);
                
                for (Actor anActor: actors) {
                	anActor.act(now);
                }
      
            }
        };
    }

    /**
     * This method will return the number of elements of Actor sub-class List.
     * @param cls Sub-classes of Actor
     * @return The number of elements of Actor sub-class List
     */
    public <ActorClass extends Actor> List<ActorClass> getObjects(Class<ActorClass> cls) {
        ArrayList<ActorClass> someArray = new ArrayList<>();
        for (Node n: getChildren()) {
            //if the actor is the same class with current one, then add it into the list.
            if (cls.isInstance(n)) {
                someArray.add((ActorClass)n);
            }
        }
        return someArray;
    }

    /**
     * This method will start the timer.
     */
    public void start() {
    	createTimer();
        timer.start();
    }

    //stops the timer.
    public void stop() {
        timer.stop();
    }

    //add actor to the world.
    public void add(Actor actor) {
        getChildren().add(actor);
    }

    //remove actor to the world.
    public void remove(Actor actor) {
        getChildren().remove(actor);
    }

    /**
     * This is an abstract method that all sub-classes should implement.
     * This method will determine the main function of the sub-class.
     * @param now
     */
    public abstract void act(long now);
    //--------------------------------------------------------/Methods----------------------------------------------------------------------




}
