package springboot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import springboot.dao.CityDao;
import springboot.domain.City;
import springboot.redis.RedisClient;
import springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 城市业务逻辑实现类
 *
 * Created by bysocket on 07/02/2017.
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    @Autowired
    private RedisClient redisClient;

    public PageInfo findCityByName(Map map) {
        System.out.println( "redis="+redisClient.getRedisString("key"));
        PageHelper.startPage((Integer)map.get("pageNo"),(Integer)map.get("rowCount"));
        List<City> list = cityDao.findByName(map);
        PageInfo page = new PageInfo(list);
        return page;
    }

}
