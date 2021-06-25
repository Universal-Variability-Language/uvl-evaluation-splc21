# Evaluation for SPLC Submission on UVL

## General Information
This repository can be used to reproduce the results of the empirical evaluation for the SPLC'21 submission `Yet Another Textual Variability Language?
A Community Effort Towards a Unified Language`. The repository consists of:
* the required source code
* necessarry dependencies as .jars 
* the models to translate 
* the resulting models. 

## How to build

The project uses maven as the build engine. We depend on the FeatureIDE library and the TraVarT approach, which both are not available through the standard repositories. Therefore before you run the build for the first time, you need to install the dependencies in your local maven repository. You can do that by either running the `setup.sh` for Linux systems or `setup.bat` for Windows. Alternatively head to the root folder of the project in a shell and run:

* `mvn install:install-file -Dfile="lib/uvl-parser-0.1.0-standalone.jar" -DgroupId="de.neominik" -DartifactId="uvl" -Dversion="0.1.0-SNAPSHOT" -Dpackaging="jar"`

* `mvn install:install-file -Dfile="lib/de.ovgu.featureide.lib.fm-v3.7.0.jar" -DgroupId="de.ovgu.featureide" -DartifactId="de.ovgu.featureide" -Dversion="3.7.0" -Dpackaging="jar"`
 
* `mvn install:install-file -Dfile="lib/travart.core-0.0.1.jar" -DgroupId="at.jku.cps.travart" -DartifactId="travart.core" -Dversion="0.0.1" -Dpackaging="jar"`

* `mvn install:install-file -Dfile="lib/travart.dopler-decision-0.0.1.jar" -DgroupId="at.jku.cps.travart" -DartifactId="travart.dopler-decision" -Dversion="0.0.1" -Dpackaging="jar"`

* `mvn install:install-file -Dfile="lib/travart.ovm-0.0.1.jar" -DgroupId="at.jku.cps.travart" -DartifactId="travart.ovm" -Dversion="0.0.1" -Dpackaging="jar"`

After you installed the dependencies, you can build the evaluation project using the follwing command:

* `mvn clean package`

This will build two packages (default maven build and the full dependency build).

We tested the script with the `maven-compiler-plugin` version `3.8.1` and the `maven-assembly-plugin` version `3.3.0`. If you want to use different settings, change them in the `pom.xml`.


## How to use and execute the evaluation (and create the UVL models)

After you built the project you can execute the evaluation and create the UVL models using the following commands (bash/powershell):

1. `cp -r models target`

2. `java -jar target/uvl-evaluation-splc21-artifact-0.0.1-SNAPSHOT-jar-with-dependencies.jar`

This results in a `models.log` file, containing the evaluation data and a `models_output/` folder, containing all UVL models.

## Dependencies
All required dependencies are provided as jars in /lib.



 


