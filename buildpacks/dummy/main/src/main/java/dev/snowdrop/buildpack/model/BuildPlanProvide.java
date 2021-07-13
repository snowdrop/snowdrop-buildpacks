package dev.snowdrop.buildpack.model;

import org.immutables.value.Value;

@Value.Immutable
public interface BuildPlanProvide {
    String Name();
}
