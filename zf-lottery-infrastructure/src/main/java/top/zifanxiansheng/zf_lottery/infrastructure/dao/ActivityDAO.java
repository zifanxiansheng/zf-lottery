package top.zifanxiansheng.zf_lottery.infrastructure.dao;

import org.apache.ibatis.annotations.Mapper;
import top.zifanxiansheng.zf_lottery.infrastructure.dao.base.MyBatisBaseDao;
import top.zifanxiansheng.zf_lottery.infrastructure.po.Activity;

/**
 * ActivityDAO继承基类
 */
@Mapper
public interface ActivityDAO extends MyBatisBaseDao<Activity, Long> {
}