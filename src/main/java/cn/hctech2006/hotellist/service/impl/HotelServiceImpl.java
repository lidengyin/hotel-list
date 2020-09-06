package cn.hctech2006.hotellist.service.impl;

import cn.hctech2006.hotellist.bean.NlHotel;
import cn.hctech2006.hotellist.bean.NlTemplate;
import cn.hctech2006.hotellist.common.ServerResponse;
import cn.hctech2006.hotellist.mapper.NlHotelMapper;
import cn.hctech2006.hotellist.util.FastDFSUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.OAuth2Definition;
import org.apache.catalina.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class HotelServiceImpl {
    @Autowired
    private NlHotelMapper hotelMapper;
//    @Autowired
//    private TemplateServiceImpl templateService;
    /**
     * 根据酒店编号获得酒店详细记录
     * @param hotelId
     * @return
     */

    public ServerResponse selectByHotelId(String hotelId){
        NlHotel hotel = hotelMapper.selectByHotelId(hotelId);
        if (hotel != null) return ServerResponse.createBySuccess(hotel);
        return ServerResponse.createByError();
    }

    /**
     * 酒店列表
     * @param pageNum
     * @param pageSize
     * @param hptelName
     * @param city
     * @return
     */
    public ServerResponse listHotel(int pageNum, int pageSize, String hptelName, String city, String cityStatus){
        PageHelper.startPage(pageNum, pageSize);
        List<NlHotel> hotels = hotelMapper.selectByKeyword(hptelName,city, cityStatus);
        PageInfo result = new PageInfo(hotels);
        return ServerResponse.createBySuccess(result);
    }


    /**
     * 查找所有酒店所在城市
     * @return
     */

    public ServerResponse selectHotelCityName(){

        List<String> hotelCitys =  hotelMapper.selectHotelCity();

        Set<String> allCity = AllCity(hotelCitys);

        return ServerResponse.createBySuccess(allCity);

    }

    /**
     * 去重算法
     * @param params
     * @return
     */
    private Set<String> AllCity(List<String> params){
        Set<String> citys = new HashSet<>();
        for (String param: params){
            citys.add(param);
        }
        return citys;
    }
    public ServerResponse updateHotel(NlHotel hotel){
        int result = hotelMapper.updateByHotelId(hotel);
        if (result > 0) return ServerResponse.createBySuccess("修改成功");
        return ServerResponse.createByError("修改失败");
    }

    /**
     * 酒店上传
     * @param hotel
     * @return
     */
    public ServerResponse uploadHotel(NlHotel hotel){
        hotel.setHotelId(UUID.randomUUID().toString());
        hotel.setHotelStatus("1");
        int result = hotelMapper.insert(hotel);
        if (result > 0) return ServerResponse.createBySuccess(hotel);
        return ServerResponse.createByError("上传失败");
    }

    /**
     * 合同上传
     * @param file
     * @return
     */
    public ServerResponse uploadContract(MultipartFile file){
        if (file == null ) return ServerResponse.createByError("合同文件不能为空");
        String url = FastDFSUtil.upload(file);
        System.out.println(url);
        return ServerResponse.createBySuccess(url);
    }

}
