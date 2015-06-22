package org.agecraft;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import net.minecraft.item.ItemBlock;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ItemBlockClass {

    public Class<? extends ItemBlock> value();
}
