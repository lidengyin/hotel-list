package cn.hctech2006.hotellist.filter;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * 过滤器,过滤静态文件
 */
@WebFilter(filterName = "druidWebStatFilter", urlPatterns = "/*",
initParams = {
        //忽略资源列表
        @WebInitParam(name = "exclusions", value = "*.js, *.gif, *.jpg, *.bmp, *.png, *.css, *.ico, /druid/*")
})
public class DruidFilter extends WebStatFilter {

}
