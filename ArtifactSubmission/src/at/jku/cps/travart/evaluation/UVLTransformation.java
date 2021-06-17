package at.jku.cps.travart.evaluation;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import at.jku.cps.travart.core.common.exc.NotSupportedVariablityTypeException;
import at.jku.cps.travart.core.io.FeatureModelReader;
import at.jku.cps.travart.core.io.FeatureModelUVLWriter;
import at.jku.cps.travart.dopler.decision.IDecisionModel;
import at.jku.cps.travart.dopler.io.DecisionModelReader;
import at.jku.cps.travart.dopler.transformation.DecisionModeltoFeatureModelConverter;
import at.jku.cps.travart.evaluation.standalone.util.Constants;
import at.jku.cps.travart.evaluation.standalone.util.Utils;
import at.jku.cps.travart.ovm.io.OvModelReader;
import at.jku.cps.travart.ovm.model.IOvModel;
import at.jku.cps.travart.ovm.transformation.OvModelToFeatureModelConverter;
import de.ovgu.featureide.fm.core.base.IFeatureModel;

public class UVLTransformation {

	public static final String PROJECT_RESOURCE_FOLDER = "models";

	private static Logger logger;

	public static void main(final String[] args) {
		try {
			logger = Utils.getSimpleLogger(UVLTransformation.class.getName(), PROJECT_RESOURCE_FOLDER);

			Path baseFolder = Paths.get(PROJECT_RESOURCE_FOLDER);
			Path outputFolder = Paths.get(PROJECT_RESOURCE_FOLDER + "_" + Constants.OUTPUT_FOLDER_NAME);
			if (!outputFolder.toFile().exists()) {
				outputFolder.toFile().mkdir();
			}

			FeatureModelUVLWriter writer = new FeatureModelUVLWriter();
			Map<String, IFeatureModel> featureModels = new HashMap<>();

			// load all feature models
			logger.log(Level.INFO, String.format("Load all feature models for project %s...", PROJECT_RESOURCE_FOLDER));
			FeatureModelReader fmReader = new FeatureModelReader();
			Set<Path> fmModelPaths = Utils.getPathSetForLevel(baseFolder, Constants.FM_XML_EXTENSION, 4);
			for (Path fmPath : fmModelPaths) {
				IFeatureModel fm = fmReader.read(fmPath);
				featureModels.put("fm_" + fmPath.getFileName().toString(), fm);
			}
			// load all decision models and transform to feature model
			logger.log(Level.INFO,
					String.format("Load all decision models for project %s and transform to a feature model...",
							PROJECT_RESOURCE_FOLDER));
			DecisionModelReader dmReader = new DecisionModelReader();
			DecisionModeltoFeatureModelConverter dmTofmConverter = new DecisionModeltoFeatureModelConverter();
			Set<Path> dmModelPaths = Utils.getPathSetForLevel(baseFolder, Constants.DOPLER_DM_FILE_EXTENSION, 4);
			for (Path dmPath : dmModelPaths) {
				IDecisionModel dm = dmReader.read(dmPath);
				IFeatureModel fm = dmTofmConverter.transform(dm);
				featureModels.put("dm_" + dmPath.getFileName().toString(), fm);
			}

			// load all ovm models and transform to feature model
			logger.log(Level.INFO, String.format(
					"Load all ovm models for project %s and transform to a feature model...", PROJECT_RESOURCE_FOLDER));
			OvModelReader ovmReader = new OvModelReader();
			OvModelToFeatureModelConverter ovmTofmConverter = new OvModelToFeatureModelConverter();
			Set<Path> ovmModelPaths = Utils.getPathSetForLevel(baseFolder, Constants.OVM_FILE_EXTENSION, 4);
			for (Path ovmPath : ovmModelPaths) {
				IOvModel ovm = ovmReader.read(ovmPath);
				IFeatureModel fm = ovmTofmConverter.transform(ovm);
				featureModels.put("ovm_" + ovmPath.getFileName().toString(), fm);
			}

			logger.log(Level.INFO, String.format("Write all loaded feature models as %s...", Constants.UVL_EXTENSION));
			for (Map.Entry<String, IFeatureModel> entry : featureModels.entrySet()) {
				Path outputPath = outputFolder.resolve(entry.getKey() + Constants.UVL_EXTENSION);
				logger.log(Level.INFO, String.format("Write file %s...", outputPath.getFileName()));
				writer.write(entry.getValue(), outputPath);
				double kBytes = Utils.getFileSizeKiloBytes(outputPath);
				logger.log(Level.INFO,
						String.format("File size of file %s: %s kBytes", outputPath.getFileName(), kBytes));
			}

		} catch (IOException | NotSupportedVariablityTypeException e) {
			e.printStackTrace();
		}
	}
}
