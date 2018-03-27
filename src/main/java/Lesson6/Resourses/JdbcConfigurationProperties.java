package Lesson6.Resourses;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class JdbcConfigurationProperties implements JdbcConfiguration {

    private List<String> properties;

    public JdbcConfigurationProperties(){}

    public Configuration load(){
        Configuration config = new Configuration();
        String[] dBaseName;
        String[] host;
        String[] port;
        String[] userName;
        String[] password;
        try {
            properties = Files.readAllLines(Paths.get("src/main/java/Lesson6/Resourses/Properties1.txt"));
            dBaseName = properties.get(0).split("=");
            host = properties.get(1).split("=");
            port = properties.get(2).split("=");
            userName = properties.get(3).split("=");
            password = properties.get(4).split("=");

            config.setDataBase(dBaseName[1]);
            config.setHost(host[1]);
            config.setPort(port[1]);
            config.setUserName(userName[1]);
            config.setPassword(password[1]);

            System.out.println(config.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return config;
    }
}
