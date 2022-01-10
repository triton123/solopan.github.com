
package config;

import org.springframework.jdbc.datasource.DriverManagerDataSource;


public class Conexion {
    
    public DriverManagerDataSource Conectar(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(com.mysql.jdbc.Driver.class.getName());
        dataSource.setUrl("jdbc:mysql://localhost:3306/software");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        return dataSource;
    }
}
