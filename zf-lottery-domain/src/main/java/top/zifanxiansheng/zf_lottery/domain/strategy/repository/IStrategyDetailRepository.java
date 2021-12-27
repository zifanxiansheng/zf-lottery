package top.zifanxiansheng.zf_lottery.domain.strategy.repository;

import java.util.List;

/**
 * @Author 梓樊先生
 * @Date 2021/12/24 16:55
 **/
public interface IStrategyDetailRepository {


    int deductStock(Long strategyId, String awardId);

    List<String> queryNoStockAwards(Long strategyId);

}
