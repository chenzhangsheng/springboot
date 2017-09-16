package springboot.service;

import springboot.domain.City;

import java.util.List;
import java.util.Map;

/**
 * 城市业务逻辑接口类
 *
 * Created by bysocket on 07/02/2017.
 */
public interface CityService {

    /**
     * 根据城市名称，查询城市信息
     * @param cityName
     */
    Object findCityByName(Map<String, Object> map);
}
