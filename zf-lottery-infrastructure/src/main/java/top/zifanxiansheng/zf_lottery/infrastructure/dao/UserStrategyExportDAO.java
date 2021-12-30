package top.zifanxiansheng.zf_lottery.infrastructure.dao;

import org.apache.ibatis.annotations.Mapper;
import top.zifanxiansheng.middleware.db.router.annotation.DBRouter;
import top.zifanxiansheng.zf_lottery.infrastructure.dao.base.MyBatisBaseDao;
import top.zifanxiansheng.zf_lottery.infrastructure.po.UserStrategyExport;

/**
 * UserStrategyExportDAO继承基类
 *
 * @author luoyong
 */
@Mapper
@DBRouter(routerKey = "uId")
public interface UserStrategyExportDAO extends MyBatisBaseDao<UserStrategyExport, Long> {
}