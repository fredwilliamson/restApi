package com.fme;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Bean
    @ConfigurationProperties("app.datasource")
    public DataSource dataSource() {

        //Create the DataSource with integration-DB properties

        return DataSourceBuilder.create()
                .username("sa")
                .password("")
                .url("jdbc:h2:file:~/test;DB_CLOSE_ON_EXIT=FALSE")
                .driverClassName("org.h2.Driver")
                .build();
    }

    @Bean
    public JdbcTemplate jdbcTemplate(@Qualifier("dataSource")DataSource dataSource)

    {
        return new JdbcTemplate(dataSource);
    }

}
