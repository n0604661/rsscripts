package LootnCook.tasks;

import LootnCook.Task;
import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Component;
import org.powerbot.script.rt4.GameObject;
import org.powerbot.script.rt4.Item;

import java.util.concurrent.Callable;

/**
 * Created by Me on 19/06/2017.
 */
public class Cook extends Task {

    GameObject fire = ctx.objects.select().id(26185).nearest().poll();

    public Cook(ClientContext arg0) {
        super(arg0);
    }

    @Override
    public boolean activate() {
        return ctx.inventory.select().id(331).count() > 27;
    }

    @Override
    public void execute() {
        cookfish();
    }


    private void cookfish() {

        Item itemToCook = ctx.inventory.select().id(331).poll();
        GameObject fire = ctx.objects.select().id(26185).nearest().poll();
        final Component cookoptions = ctx.widgets.component(307, 6);
        final Component levelup = ctx.widgets.component(233,2);
        if (fire.inViewport()) {
            itemToCook.interact("Use");
            //fire.click();
            fire.interact("Fire");
            fire.interact("Use");

            Condition.wait(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    return cookoptions.visible();
                }
            }, 200, 20);

            if (cookoptions.visible()) {
                cookoptions.interact("Cook All");

                Condition.sleep(50000);

            }
            if(levelup.visible()){
                cookfish();
            }
            //use fish on fire 26185


        } else {
            ctx.camera.turnTo(fire);
        }

    }
}

