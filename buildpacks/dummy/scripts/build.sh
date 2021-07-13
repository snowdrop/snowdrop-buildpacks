#!/usr/bin/env bash

set -exuo pipefail

echo "Generate an executable of the project"
mvn clean package -Pnative \
    -Dquarkus.native.container-build=true \
    -Dquarkus.banner.enabled=false \
    -Dquarkus.package.output-name=main \
    -f main/pom.xml

echo "Move the file created under bin/ folder"
mkdir -p bin
mv main/target/main-runner bin/main

echo "Create the symbolic links for detect and build"
ln -fs main bin/build
ln -fs main bin/detect