package utils;

import org.ini4j.Ini;

import java.io.File;
import java.io.IOException;

public class Utils {
    public String readUrlFromFile() throws IOException {
        File fileToParse = new File("src/test/java/utils/config.ini");
        Ini ini = new Ini(fileToParse);
        return ini.get("info","URL");
    }
}
