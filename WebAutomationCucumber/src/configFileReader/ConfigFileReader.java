package configFileReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader 
{
	public String getReportConfigPath()
	{
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("").getAbsolutePath()+"\\src\\configFileReader\\Configuration.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String reportConfigPath = prop.getProperty("reportConfigPath");
		if(reportConfigPath!= null) return new File("").getAbsolutePath()+ reportConfigPath;
		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
	}
}
