package plus.hideaway.mod.mixins.accessors;

import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.screen.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Screen.class)
public interface ScreenAccessor {
    @Accessor("width")
    int getWidth();
    @Accessor("height")
    int getHeight();

    @Invoker("addDrawableChild")
    <T extends Element & Drawable> T addDrawableChild(T drawableElement);
}
