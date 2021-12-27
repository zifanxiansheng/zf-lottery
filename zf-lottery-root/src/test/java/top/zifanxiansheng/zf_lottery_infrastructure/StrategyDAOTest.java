package top.zifanxiansheng.zf_lottery_infrastructure;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import top.zifanxiansheng.zf_lottery.domain.strategy.model.bo.StrategyRich;
import top.zifanxiansheng.zf_lottery.domain.strategy.repository.IStrategyRepository;
import top.zifanxiansheng.zf_lottery.infrastructure.dao.ActivityDAO;
import top.zifanxiansheng.zf_lottery.infrastructure.po.Activity;

import javax.annotation.Resource;

/**
 * @Author 梓樊先生
 * @Date 2021/12/24 14:28
 **/
@Slf4j
public class StrategyDAOTest extends BaseTest {

    @Resource
    IStrategyRepository strategyRepository;

    @Test
    public void test_strategyRich_query() {
        StrategyRich strategyRich = strategyRepository.queryStrategyRich(10001L);

        String strategyRichStr = JSON.toJSONString(strategyRich);

        log.info(strategyRichStr);
    }
}
