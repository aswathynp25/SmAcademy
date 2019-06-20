package com.v1.sm.utilities;

public class DriverFactory {
private static  String chromeDriverExePath;
private static String geckoDriverExePath;
private static  String ieDriverExePath;
private static String configPropertyFile;
private static String gridpath;
private static boolean isRemote;



public static boolean isRemote() {
	return isRemote;
}
public static void setRemote(boolean isRemote) {
	DriverFactory.isRemote = isRemote;
}
public static String getChromeDriverExePath() {
	return chromeDriverExePath;
}
public static void setChromeDriverExePath(String chromeDriverExePath) {
	DriverFactory.chromeDriverExePath = chromeDriverExePath;
}
public static String getGeckoDriverExePath() {
	return geckoDriverExePath;
}
public static void setGeckoDriverExePath(String geckoDriverExePath) {
	DriverFactory.geckoDriverExePath = geckoDriverExePath;
}
public static String getIeDriverExePath() {
	return ieDriverExePath;
}
public static void setIeDriverExePath(String ieDriverExePath) {
	DriverFactory.ieDriverExePath = ieDriverExePath;
}
public static String getConfigPropertyFile() {
	return configPropertyFile;
}
public static void setConfigPropertyFile(String configPropertyFile) {
	DriverFactory.configPropertyFile = configPropertyFile;
}
public static String getGridpath() {
	return gridpath;
}
public static void setGridpath(String gridpath) {
	DriverFactory.gridpath = gridpath;
}


}
