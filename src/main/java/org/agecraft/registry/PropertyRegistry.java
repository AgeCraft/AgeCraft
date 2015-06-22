package org.agecraft.registry;

import java.util.Collection;

import net.minecraft.block.properties.PropertyHelper;

import com.google.common.collect.ImmutableSet;

public class PropertyRegistry<T extends RegistryObject> extends PropertyHelper {

    private ImmutableSet allowedValues;
    private Registry<T> registry;

    public PropertyRegistry(String name, Registry<T> registry) {
        super(name, String.class);
        this.allowedValues = ImmutableSet.copyOf(registry.names());
        this.registry = registry;
    }

    @Override
    public Collection getAllowedValues() {
        return allowedValues;
    }

    @Override
    public String getName(Comparable value) {
        return (String) value;
    }

    public int getID(Comparable value) {
        return registry.get(getName(value)).id;
    }

    public T get(Comparable value) {
        return registry.get(getName(value));
    }
}
