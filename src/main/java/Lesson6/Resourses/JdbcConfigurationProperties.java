package Lesson6.Resourses;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class JdbcConfigurationProperties implements JdbcConfiguration {

    public JdbcConfigurationProperties(){}

    public Configuration load(){
        Configuration config = new Configuration();
        ArrayList<String> properties = new ArrayList<>();
        try {
            BufferedReader br = Files.newBufferedReader(Paths.get("src/main/java/Lesson6/Resourses/Properties1.txt"));
            String line;
            while ((line = br.readLine()) != null){
                properties.add(line.split("=")[1]);
            }

            config.setUrl("jdbc:mysql://" + properties.get(1) + ":" + properties.get(2) + "/" + properties.get(0) + "?serverTimezone=UTC");
            config.setUserName(properties.get(3));
            config.setPassword(properties.get(4));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return config;
    }
}
