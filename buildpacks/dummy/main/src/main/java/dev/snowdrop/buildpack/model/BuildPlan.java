package dev.snowdrop.buildpack.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.immutables.value.Value;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.List;

@RegisterForReflection
@JsonIgnoreProperties
@Value.Immutable
public interface BuildPlan {
    @JsonIgnore
    String path();

    List<BuildPlanRequire> requires();
    List<BuildPlanProvide> provides();
}
