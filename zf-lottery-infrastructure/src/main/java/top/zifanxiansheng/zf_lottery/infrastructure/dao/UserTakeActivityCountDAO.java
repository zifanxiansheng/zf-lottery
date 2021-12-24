package top.zifanxiansheng.zf_lottery.infrastructure.dao;

import org.apache.ibatis.annotations.Mapper;
import top.zifanxiansheng.zf_lottery.infrastructure.dao.base.MyBatisBaseDao;
import top.zifanxiansheng.zf_lottery.infrastructure.po.UserTakeActivityCount;

/**
 * UserTakeActivityCountDAO继承基类
 */
@Mapper
public interface UserTakeActivityCountDAO extends MyBatisBaseDao<UserTakeActivityCount, Long> {
}