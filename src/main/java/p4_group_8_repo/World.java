package p4_group_8_repo;

import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;


public abstract class World extends Pane {
    private AnimationTimer timer;

    //constructor
    public World() {
    	
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

    public <ActorClass extends Actor> List<ActorClass> getObjects(Class<ActorClass> cls) {
        ArrayList<ActorClass> someArray = new ArrayList<>();
        for (Node n: getChildren()) {
            if (cls.isInstance(n)) {
                someArray.add((ActorClass)n);
            }
        }
        return someArray;
    }

    public void start() {
    	createTimer();
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    public void add(Actor actor) {
        getChildren().add(actor);
    }

    public void remove(Actor actor) {
        getChildren().remove(actor);
    }

    public abstract void act(long now);
    //--------------------------------------------------------/Methods----------------------------------------------------------------------




}
