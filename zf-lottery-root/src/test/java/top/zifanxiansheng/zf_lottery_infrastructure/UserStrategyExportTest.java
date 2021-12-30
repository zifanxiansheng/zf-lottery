package top.zifanxiansheng.zf_lottery_infrastructure;

import org.junit.Test;
import top.zifanxiansheng.zf_lottery.infrastructure.dao.UserStrategyExportDAO;
import top.zifanxiansheng.zf_lottery.infrastructure.po.UserStrategyExport;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @Author 梓樊先生
 * @Date 2021/12/30 17:13
 **/
public class UserStrategyExportTest extends BaseTest {

    @Resource
    UserStrategyExportDAO userStrategyExportDAO;

    @Test
    public void insert_strategy_export() {

        UserStrategyExport userStrategyExport = UserStrategyExport.builder()
                .uId("1000231")
                .activityId(10001L)
                .orderId(23000L)
                .strategyId(10001L)
                .strategyMode(1)
                .grantType(1)
                .grantDate(LocalDateTime.now())
                .grantState(1)
                .awardId("1")
                .awardType(1)
                .awardName("MAC PRO")
                .awardContent("Mac Pro")
                .mqState(1)
                .build();

        userStrategyExportDAO.insert(userStrategyExport);


    }
}
