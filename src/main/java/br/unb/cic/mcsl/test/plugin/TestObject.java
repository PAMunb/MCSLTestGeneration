package br.unb.cic.mcsl.test.plugin;
import org.apache.commons.io.FilenameUtils;


public class TestObject {
	private String name;
	private String path;
	private String filePath;
	
    public TestObject(String name, String path) {
        this.name = FilenameUtils.removeExtension(name);
        this.path = path;
        this.filePath = name;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }
    
    public String getFilePath() {
    	return filePath;
    }
}
