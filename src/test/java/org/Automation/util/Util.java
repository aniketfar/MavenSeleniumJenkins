package org.Automation.util;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Util {

    public static String getPropertyValue(String key) throws FileNotFoundException {

            String value = "";
            try {
                FileInputStream fileInputStream = new FileInputStream("Environment.properties");
                Properties property = new Properties();
                property.load(fileInputStream);
                value = property.getProperty(key);
                    fileInputStream.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
    return value;
    }


    public static Process runRemoteDebuggingPortCommandSession() throws IOException, InterruptedException {
        File ChromeSessionDir = new File(Util.getPropertyValue("ChromeSessionDirectory"));
        FileUtils.cleanDirectory(ChromeSessionDir);
        String ChromeSessionpath = Util.getPropertyValue("ChromeSessionpathtest");
        String run_remote_debugging_port_command = Util.getPropertyValue("ChromeSessionCommand");
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", run_remote_debugging_port_command).directory(new File(ChromeSessionpath));
        System.out.println(text);
        Process p = builder.start();
        p.waitFor(2, TimeUnit.SECONDS);
        return p;
    }

    public static void printCmdResults(Process process) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String text = "";
        while ((line = reader.readLine()) !=null){
            System.out.println(text);
        }
    }



}
