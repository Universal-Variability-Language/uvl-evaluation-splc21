#!/bin/bash

call mvn install:install-file -Dfile="lib/uvl-parser-0.1.0-standalone.jar" -DgroupId="de.neominik" -DartifactId="uvl" -Dversion="0.1.0-SNAPSHOT" -Dpackaging="jar"
call mvn install:install-file -Dfile="lib/de.ovgu.featureide.lib.fm-v3.7.0.jar" -DgroupId="de.ovgu.featureide" -DartifactId="de.ovgu.featureide" -Dversion="3.7.0" -Dpackaging="jar"
call mvn install:install-file -Dfile="lib/travart.core-0.0.1.jar" -DgroupId="at.jku.cps.travart" -DartifactId="travart.core" -Dversion="0.0.1" -Dpackaging="jar" 
call mvn install:install-file -Dfile="lib/travart.dopler-decision-0.0.1.jar" -DgroupId="at.jku.cps.travart" -DartifactId="travart.dopler-decision" -Dversion="0.0.1" -Dpackaging="jar" 
call mvn install:install-file -Dfile="lib/travart.ovm-0.0.1.jar" -DgroupId="at.jku.cps.travart" -DartifactId="travart.ovm" -Dversion="0.0.1" -Dpackaging="jar"
