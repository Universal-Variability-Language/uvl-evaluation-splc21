# Evaluation for SPLC Submission on UVL


## How to use

The project comes with the required .classpath and .project to run the projects in recent Eclipse and VS-Code Versions.
The setup was tested with Eclipse for Java Developers 2021-06 and Visual Studio Code with 1.57 with recommended Java extensions.

In order to reproduce the results the main method in src/at/jku/cps/travart/evaluation/UVLTransformation.java needs to be invoked.
The resulting models will all be stored in models_output.
The results of our empirical evaluation are based on these files.



## Dependencies
All requires jars are provided in /lib and added to .classpath.
The evaluation is dependent on the following tools/.jars:

* UVL parser 0.1.0: The parser library is used to read/write UVL
* TraVart 0.0.1: TraVart is used to handle the different transformations and wraps multiple functionalities of FeatureIDE
* FeatureIDE 3.7.0: FeatureIDE provides support for reading/writing the different formats used for the evaluation
* antlr 3.5.2: Antlr parser is required for the FeatureIDE dependency
* commons-csv 1.8: Used to write csv files


 


