package fauxsoup;

import java.util.ArrayList;
import java.util.List;
import eu.bitwalker.useragentutils.*;
import net.sf.json.JSONSerializer;
import net.sf.json.JSONObject;
import net.sf.json.JSONArray;
import java.io.*;

public class Extract {
    public static void main(String[] args) throws IOException {
        JSONArray browsers = new JSONArray();
        for (Browser b : Browser.getBrowsers()) {
            browsers.element(b.toJSON());
        }

        JSONArray operating_systems = new JSONArray();
        for (OperatingSystem os : OperatingSystem.getOperatingSystems()) {
            operating_systems.element(os.toJSON());
        }

        write_file("browsers.json", browsers.toString(4));
        write_file("operating_systems.json", operating_systems.toString(4));
    }

    private static void write_file(String file, String contents) throws IOException {
        FileWriter fw = new FileWriter(file, false);
        PrintWriter pw = new PrintWriter(fw);

        pw.print(contents);

        pw.close();
    }
}
