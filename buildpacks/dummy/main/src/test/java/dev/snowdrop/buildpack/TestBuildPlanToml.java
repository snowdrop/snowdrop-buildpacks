package dev.snowdrop.buildpack;

import dev.snowdrop.buildpack.model.*;

import org.junit.jupiter.api.Test;

import static dev.snowdrop.buildpack.utils.TomlHandler.convertPOJOToString;
import static dev.snowdrop.buildpack.utils.TomlHandler.convertStringToPOJO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestBuildPlanToml {

    @Test
    public void testConvertBuildPlanToTomlString() throws Exception {
        String result = "requires = [{metadata = {version = '3.6.4'}, name = 'maven'}]\n" +
                "provides = [{name = 'maven'}]\n";
        BuildPlan bp = ImmutableBuildPlan.builder()
                .addProvides(
                        ImmutableBuildPlanProvide.builder()
                                .Name("maven")
                                .build()
                )
                .addRequires(
                        ImmutableBuildPlanRequire.builder()
                                .Name("maven")
                                .putMetadata("version","3.6.4")
                                .build()
                )
                .build();

        String toml = convertPOJOToString(bp);
        assertNotNull(toml);
        assertEquals(result,toml);
    }

    @Test
    public void testConvertTomlStringToBuildPlan() throws Exception {
        String toml = "requires = [{name = 'maven'}]\n" +
                "provides = [{name = 'maven'}]";

       BuildPlan bp = convertStringToPOJO(toml, ImmutableBuildPlan.class);
       assertNotNull(bp);
       assertEquals("maven",bp.requires().get(0).Name());
       assertEquals("maven",bp.provides().get(0).Name());
    }

}
