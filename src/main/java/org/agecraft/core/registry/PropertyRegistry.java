package org.agecraft.core.registry;

import java.util.Collection;

import com.google.common.collect.ImmutableSet;

import net.minecraft.block.properties.PropertyHelper;

public class PropertyRegistry<T extends RegistryObject> extends PropertyHelper<String> {

    private ImmutableSet<String> allowedValues;
    private Registry<T> registry;

    public PropertyRegistry(String name, Registry<T> registry) {
        super(name, String.class);
        this.allowedValues = ImmutableSet.copyOf(registry.names());
        this.registry = registry;
    }

    @Override
    public Collection<String> getAllowedValues() {
        return allowedValues;
    }

	@Override
    public String getName(String value) {
        return (String) value;
    }

    public int getID(String value) {
        return registry.get(getName(value)).id;
    }

    public T get(String value) {
        return registry.get(getName(value));
    }
}
