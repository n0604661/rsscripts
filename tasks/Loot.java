package LootnCook.tasks;

import LootnCook.Task;
import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GroundItem;

import java.util.concurrent.Callable;

/**
 * Created by Me on 19/06/2017.
 */
public class Loot extends Task {

int fishIds[] = {331};
    GroundItem fishOnGround = ctx.groundItems.select().id(331).nearest().poll();
    public Loot(ClientContext arg0) {
        super(arg0);
    }

    @Override
    public boolean activate() {
        return ctx.inventory.select().count()!=28;
    }

    @Override
    public void execute() {
        Loot();
    }

private void Loot() {

    GroundItem fishOnGround = ctx.groundItems.select().id(331).nearest().poll();

    if (fishOnGround.inViewport()){
        fishOnGround.interact("Take");
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.inventory.select().count()!=28;
            }
        }, 200, 20);
    } else { ctx.camera.turnTo(fishOnGround);}





}







}

