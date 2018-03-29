package Lesson6.Resourses;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class JdbcConfigurationProperties implements JdbcConfiguration {

    private ArrayList<String> properties;

    public JdbcConfigurationProperties(){}

    public Configuration load(){
        Configuration config = new Configuration();
        properties = new ArrayList<>();
        try {
            BufferedReader br = Files.newBufferedReader(Paths.get("src/main/java/Lesson6/Resourses/Properties1.txt"));
            String line;
            while ((line = br.readLine()) != null){
                properties.add(line.split("=")[1]);
            }

            config.setDataBase(properties.get(0));
            config.setHost(properties.get(1));
            config.setPort(properties.get(2));
            config.setUserName(properties.get(3));
            config.setPassword(properties.get(4));

            System.out.println(config.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return config;
    }
}
