package dev.snowdrop.buildpack;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.toml.TomlMapper;
import dev.snowdrop.buildpack.model.BuildPlan;
import dev.snowdrop.buildpack.model.BuildPlanRequire;

import java.io.File;
import java.io.IOException;

import static dev.snowdrop.buildpack.App.LOG;
import static dev.snowdrop.buildpack.utils.ProcessHandler.runtimeCmd;
import static dev.snowdrop.buildpack.utils.TomlHandler.readTomlFile;

public class Build extends BuildPacks {
    // A directory that may contain subdirectories representing each layer created by the buildpack in the final image or build cache.
    private String LAYERS_DIR = "";
    // A directory containing platform provided configuration, such as environment variables.
    private String PLATFORM_DIR = "";
    // A path to a file containing the Build Plan.
    private String BUILD_PLAN = "";

    public Build(String[] args) {
        super();
        if (args.length < 3) {
            LOG.errorf("expected 3 arguments and received %d", args.length);
        }
        this.LAYERS_DIR = args[0];
        this.PLATFORM_DIR = args[1];
        this.BUILD_PLAN = args[2];
    }

    public int call() throws Exception {
        LOG.infof("## Build called :: Buildpack :: %s",getBuildpackDir());
        LOG.infof("## Layers dir: %s", this.LAYERS_DIR);
        LOG.infof("## Platform dir: %s", this.PLATFORM_DIR);
        LOG.infof("## Build plan: %s", this.BUILD_PLAN);
        LOG.infof("## Working dir: %s", getWorkingDir());

        LOG.info("## Calling step to read the TOML plan");
        BuildPlan bp = readTomlFile(this.BUILD_PLAN);
        LOG.info("## Reading TOML plan executed");

        // TODO : Implement the logic to perform a maven build
        /**
        LOG.infof("## Execute bash cmd: %s", cmd);
        runtimeCmd("whoami; id; cat /etc/passwd");
        runtimeCmd("microdnf install -y perlx");
        LOG.info("## Command bash executed");
        **/
        return 0;
    }
}
