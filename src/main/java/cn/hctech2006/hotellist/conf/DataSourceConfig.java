//package cn.hctech2006.hotellist.conf;
//
//import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class DataSourceConfig {
//    @Bean
//    @ConfigurationProperties("spring.datasource.one.druid")
//
//    DataSource dsOne(){
//        return DruidDataSourceBuilder.create().build();
//    }
//    @Bean
//    @ConfigurationProperties("spring.datasource.two.druid")
//    DataSource dsTwo(){
//        return DruidDataSourceBuilder.create().build();
//    }
//}
