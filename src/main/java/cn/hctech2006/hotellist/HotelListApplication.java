package cn.hctech2006.hotellist;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
@MapperScan("cn.hctech2006.hotellist.mapper")
public class HotelListApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelListApplication.class, args);
    }

}
