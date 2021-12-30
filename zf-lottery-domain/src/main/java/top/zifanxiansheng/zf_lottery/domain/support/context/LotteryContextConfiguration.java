package top.zifanxiansheng.zf_lottery.domain.support.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.zifanxiansheng.zf_lottery.domain.activity.annotation.ActivityState;
import top.zifanxiansheng.zf_lottery.domain.award.annotation.GoodType;
import top.zifanxiansheng.zf_lottery.domain.strategy.annotation.StrategyModel;
import top.zifanxiansheng.zf_lottery.domain.support.ids.annotation.Ids;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 梓樊先生
 * @Date 2021/12/30 10:49
 **/

@Configuration
public class LotteryContextConfiguration {


    private final List<Class> annotationListClass = new ArrayList<Class>() {
        private static final long serialVersionUID = -326294547784818971L;

        {
            add(StrategyModel.class);
            add(ActivityState.class);
            add(GoodType.class);
            add(Ids.class);
        }
    };


    @Bean
    public AutoRegisterStrategyProcessor autoRegisterStrategyProcessor() {

        return new AutoRegisterStrategyProcessor(annotationListClass);
    }


}
