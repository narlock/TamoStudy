package io;

import java.io.File;

public abstract class JsonManager<T> {

	public static final String documentsPath = System.getProperty("user.home") + File.separatorChar + "Documents";
	public static final String directoryPath = System.getProperty("user.home") + File.separatorChar + "Documents" + File.separatorChar + "TamoStudy";
	
	/**
	 * @brief Reads the contents of the JSON and
	 * creates its representing model object
	 * @return T : the type of the model based on the JSON Manager
	 */
	public abstract T readJson();
	
	/**
	 * @brief Writes the contents of the model object
	 * to its respective JSON file
	 * @param obj : the model object
	 * @return true under the condition of successful IO process
	 */
	public abstract boolean writeJsonToFile(T obj);
}
