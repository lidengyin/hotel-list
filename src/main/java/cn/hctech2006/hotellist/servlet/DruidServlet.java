package cn.hctech2006.hotellist.servlet;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/druid/*",
    initParams = {
        //IP白名单, 没有配置或者为空则默认全部允许访问
        @WebInitParam(name = "allow", value = ""),
        @WebInitParam(name = "deny", value = ""),
            @WebInitParam(name = "loginUsername", value = "admin"),
            @WebInitParam(name = "loginPassword", value = "admin")

    }
    )
public class DruidServlet  extends StatViewServlet {
}
