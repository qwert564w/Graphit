package platform.client.features.modules.render;

import static platform.api.module.Interface.aM_;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import net.minecraft.network.protocol.game.ClientboundEntityEventPacket;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import platform.api.event.events.client.PacketEvent;
import platform.api.event.events.client.TickEvent;
import platform.api.event.events.render.WorldRenderEvent;
import platform.api.event.interfaces.EventTarget;
import platform.api.module.Category;
import platform.api.module.Module;
import platform.api.module.ModuleRegister;
import platform.api.module.setting.ColorSetting;
import platform.api.module.setting.SliderSetting;
import platform.client.utils.render.effects.BloodKillEffect;

@ModuleRegister(a="KillEffect", b="Брызги крови на месте смерти", c=Category.Render)
public final class KillEffect extends Module {
    private final ColorSetting bloodColor = new ColorSetting("Цвет", 0xFF8A0303);
    private final SliderSetting bloodAmount = new SliderSetting("Количество", 70f, 10f, 250f, 5f);
    private final SliderSetting bloodPower = new SliderSetting("Сила разлёта", 1.0f, 0.3f, 2.5f, 0.1f);
    private final SliderSetting bloodSize = new SliderSetting("Размер", 1.0f, 0.3f, 3.0f, 0.1f);
    private final SliderSetting bloodTime = new SliderSetting("Время", 6.0f, 1.0f, 30.0f, 0.5f);
    private final BloodKillEffect blood = new BloodKillEffect();

    private final Set<Integer> processed = new HashSet<>();
    private final ArrayBlockingQueue<ClientboundEntityEventPacket> pending = new ArrayBlockingQueue<>(64);
    private Object level;

    public KillEffect(){
        a(bloodColor, bloodAmount, bloodPower, bloodSize, bloodTime);
    }

    private void reset(){
        blood.clear();
        processed.clear();
        pending.clear();
    }

    @Override public void c(){
        reset();
        level=null;
        super.c();
    }

    @EventTarget public void a(PacketEvent event){
        if(!event.c() || aM_.level==null || !(event.d() instanceof ClientboundEntityEventPacket packet) || packet.getEventId()!=3) return;
        if(!pending.offer(packet)){
            pending.poll();
            pending.offer(packet);
        }
    }

    @EventTarget public void a(TickEvent event){
        if(aM_.level==null || aM_.player==null){
            reset();
            level=null;
            return;
        }
        if(level!=aM_.level){
            reset();
            level=aM_.level;
        }

        blood.tick(bloodTime.c());

        for(int i=0;i<64;i++){
            ClientboundEntityEventPacket packet=pending.poll();
            if(packet==null) break;
            Entity entity=packet.getEntity(aM_.level);
            if(entity instanceof LivingEntity living && living!=aM_.player && processed.add(entity.getId())){
                spawn(living);
            }
        }

        Set<Integer> active=new HashSet<>();
        for(Entity entity:aM_.level.entitiesForRendering()){
            if(entity instanceof LivingEntity living && living!=aM_.player){
                active.add(entity.getId());
                if(living.getHealth()<=0.0f && processed.add(entity.getId())){
                    spawn(living);
                }
            }
        }
        processed.removeIf(id -> !active.contains(id));
    }

    @EventTarget public void a(WorldRenderEvent event){
        if(aM_.gameRenderer == null || aM_.gameRenderer.mainCamera() == null || blood.isEmpty()) return;
        blood.render(aM_.gameRenderer.mainCamera(), event.b(), bloodTime.c());
    }

    private void spawn(LivingEntity entity){
        Vec3 pos = entity.position();
        float width = Math.clamp(entity.getBbWidth(), 0.3f, 1.6f);
        float height = Math.clamp(entity.getBbHeight(), 0.3f, 2.6f);
        Vec3 center = new Vec3(pos.x, pos.y + height * 0.6, pos.z);
        blood.burst(center, width, height, Math.round(bloodAmount.c()), bloodPower.c(), bloodSize.c(), bloodColor.c() | 0xFF000000);
    }
}
