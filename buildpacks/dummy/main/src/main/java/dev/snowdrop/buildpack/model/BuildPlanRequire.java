package dev.snowdrop.buildpack.model;

import java.util.Map;

import org.immutables.value.Value;

@Value.Immutable
public interface BuildPlanRequire {
    String Name();
    Map<String, Object> Metadata();
}
