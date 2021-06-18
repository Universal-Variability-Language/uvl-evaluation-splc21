# Evaluation for SPLC Submission on UVL

## General Information
This repository can be used to reproduce the results of the empirical evaluation for the SPLC'21 submission `Yet Another Textual Variability Language?
A Community Effort Towards a Unified Language`. The repository consists of:
* the required source code
* necessarry dependencies as .jars 
* the models to translate 
* the resulting models. 
* Invoking the main method in `src/at/jku/cps/travart/evaluation/UVLTransformation.java` generates the resulting models overwriting existing ones and also outputs the runtimes required for the translation.


## How to build

For building, the following classes need to be compiled:
* `src/at/jku/cps/travart/evaluation/UVLTransformation.java`
* `src/at/jku/cps/travart/evaluation/standalone/util/Constants.java`
* `src/at/jku/cps/travart/evaluation/standalone/util/Utils.java`

To build the files, all .jar files in /lib need to be included.

In addition, to compiling the classes yourself you can also use common IDEs for Java development. The project comes with the required .classpath and .project to compile and run the program.
The setup was tested with Eclipse for Java Developers 2021-06 and Visual Studio Code with 1.57 with recommended Java extensions.

## How to use

In order to reproduce the results the main method in `src/at/jku/cps/travart/evaluation/UVLTransformation.java` needs to be invoked.
The resulting models will all be stored in `models_output/`.
Furthermore, the standard output gives information on the file sizes and runtimes.
The standard output is stored in a file named `models.log`.
The results of our empirical evaluation are based on these files.



## Dependencies
All required dependencies are provided as jars in /lib and also added to .classpath for more simple building.



 


