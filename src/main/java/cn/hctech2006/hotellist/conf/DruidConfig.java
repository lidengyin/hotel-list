package cn.hctech2006.hotellist.conf;

import cn.hctech2006.hotellist.util.PropertiesUtil;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import javax.validation.Valid;
import java.sql.SQLException;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "spring.datasource.one.druid")
@PropertySource(value = "mmall.properties", ignoreResourceNotFound = true)
@Component
public class DruidConfig {
    //@Value()
    private String dbUrl = PropertiesUtil.getProperty("spring.datasource.one.druid.url");
    //@Value("${spring.datasource.one.druid.username}")
    private String username = PropertiesUtil.getProperty("spring.datasource.one.druid.username");
    //@Value("${spring.datasource.one.druid.password}")
    private String password= PropertiesUtil.getProperty("spring.datasource.one.druid.password");
    //@Value("${spring.datasource.one.druid.driverClassName}")
    private String driverClassName= PropertiesUtil.getProperty("spring.datasource.one.druid.driverClassName");
    //@Value("${spring.datasource.one.druid.initialSize}")
    private int initialSize= Integer.parseInt(PropertiesUtil.getProperty("spring.datasource.one.druid.initialSize"));
    //@Value("${spring.datasource.one.druid.minIdle}")
    private int minIdle= Integer.parseInt(PropertiesUtil.getProperty("spring.datasource.one.druid.minIdle"));
    @Value("${spring.datasource.one.druid.maxActive}")
    private int maxActive=Integer.parseInt( PropertiesUtil.getProperty("spring.datasource.one.druid.maxActive"));
    @Value("${spring.datasource.one.druid.maxWait}")
    private long maxWait= Long.parseLong(PropertiesUtil.getProperty("spring.datasource.one.druid.maxWait"));
    @Value("${spring.datasource.one.druid.timeBetweenEvictionRunsMillis}")
    private long timeBetweenEvictionRunsMillis= Long.parseLong(PropertiesUtil.getProperty("spring.datasource.one.druid.timeBetweenEvictionRunsMillis"));
    @Value("${spring.datasource.one.druid.minEvictableIdleTimeMillis}")
    private long minEvictableIdleTimeMillis= Long.parseLong(PropertiesUtil.getProperty("spring.datasource.one.druid.minEvictableIdleTimeMillis"));
    @Value("${spring.datasource.one.druid.vaildationQuery}")
    private String vaildationQuery= PropertiesUtil.getProperty("spring.datasource.one.druid.vaildationQuery");
    @Value("${spring.datasource.one.druid.testWhileIdle}")
    private String testWhileIdle = PropertiesUtil.getProperty("spring.datasource.one.druid.testWhileIdle");
    @Value("${spring.datasource.one.druid.testOnBorrow}")
    private boolean testOnBorrow= Boolean.getBoolean(PropertiesUtil.getProperty("spring.datasource.one.druid.testOnBorrow"));
    @Value("${spring.datasource.one.druid.testOnReturn}")
    private boolean testOnReturn= Boolean.getBoolean(PropertiesUtil.getProperty("spring.datasource.one.druid.testOnReturn"));
    @Value("${spring.datasource.one.druid.poolPreparedStatements}")
    private boolean poolPreparedStatements= Boolean.getBoolean(PropertiesUtil.getProperty("spring.datasource.one.druid.poolPreparedStatements"));
    @Value("${spring.datasource.one.druid.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize= Integer.parseInt(PropertiesUtil.getProperty("spring.datasource.one.druid.maxPoolPreparedStatementPerConnectionSize"));
    @Value("${spring.datasource.one.druid.filters}")
    private String filters= PropertiesUtil.getProperty("spring.datasource.one.druid.filters");
    //@Value("${spring.datasource.one.druid.connectionProperties}")
    //private String connectionProperties= PropertiesUtil.getProperty("spring.datasource.one.druid.connectionProperties");

    @Bean
    @Primary
    public DataSource dsOne(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(this.dbUrl);
        dataSource.setUsername(this.username);
        dataSource.setPassword(this.password);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setInitialSize(this.initialSize);
        dataSource.setMinIdle(this.minIdle);
        dataSource.setMaxActive(this.maxActive);
        dataSource.setMaxWait(this.maxWait);
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        dataSource.setValidationQuery(vaildationQuery);
        dataSource.setTestOnBorrow(testOnBorrow);
        dataSource.setTestOnReturn(testOnReturn);
        dataSource.setPoolPreparedStatements(poolPreparedStatements);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        try {
            dataSource.setFilters(filters);
        }catch (SQLException e){
            e.printStackTrace();
        }
        //dataSource.setConnectionProperties(connectionProperties);
        return dataSource;

    }
    @Bean
    //@Primary
    public DataSource dsTwo(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(this.dbUrl);
        dataSource.setUsername(this.username);
        dataSource.setPassword(this.password);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setInitialSize(this.initialSize);
        dataSource.setMinIdle(this.minIdle);
        dataSource.setMaxActive(this.maxActive);
        dataSource.setMaxWait(this.maxWait);
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        dataSource.setValidationQuery(vaildationQuery);
        dataSource.setTestOnBorrow(testOnBorrow);
        dataSource.setTestOnReturn(testOnReturn);
        dataSource.setPoolPreparedStatements(poolPreparedStatements);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        try {
            dataSource.setFilters(filters);
        }catch (SQLException e){
            e.printStackTrace();
        }
        //dataSource.setConnectionProperties(connectionProperties);
        return dataSource;

    }


}
