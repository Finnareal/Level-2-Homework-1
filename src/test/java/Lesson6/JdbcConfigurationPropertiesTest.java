package Lesson6;

import Lesson6.Resourses.JdbcConfigurationProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JdbcConfigurationPropertiesTest {

    @Test
    public void setJdbcConfPropTest(){
        JdbcConfigurationProperties jdbcConfigProperties = new JdbcConfigurationProperties();
        jdbcConfigProperties.load();
    }


}
