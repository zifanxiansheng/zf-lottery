package top.zifanxiansheng.zf_lottery.infrastructure.dao;

import org.apache.ibatis.annotations.Mapper;
import top.zifanxiansheng.zf_lottery.infrastructure.dao.base.MyBatisBaseDao;
import top.zifanxiansheng.zf_lottery.infrastructure.po.UserTakeActivity;

/**
 * UserTakeActivityDAO继承基类
 */
@Mapper
public interface UserTakeActivityDAO extends MyBatisBaseDao<UserTakeActivity, Long> {
}