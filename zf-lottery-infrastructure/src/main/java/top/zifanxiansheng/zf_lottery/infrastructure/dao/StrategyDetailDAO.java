package top.zifanxiansheng.zf_lottery.infrastructure.dao;

import org.apache.ibatis.annotations.Mapper;
import top.zifanxiansheng.zf_lottery.infrastructure.dao.base.MyBatisBaseDao;
import top.zifanxiansheng.zf_lottery.infrastructure.po.StrategyDetail;

/**
 * StrategyDetailDAO继承基类
 */
@Mapper
public interface StrategyDetailDAO extends MyBatisBaseDao<StrategyDetail, Long> {

    int deductStock(StrategyDetail req);
}