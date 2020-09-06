package cn.hctech2006.hotellist.mapper;

import cn.hctech2006.hotellist.bean.Inventory;
import java.util.List;

public interface InventoryMapper {
    int insert(Inventory record);

    List<Inventory> selectAll();
}