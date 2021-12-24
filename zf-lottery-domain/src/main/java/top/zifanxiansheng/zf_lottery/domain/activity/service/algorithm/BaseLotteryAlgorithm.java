package top.zifanxiansheng.zf_lottery.domain.activity.service.algorithm;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import top.zifanxiansheng.zf_lottery.domain.activity.model.bo.AwardRateInfo;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author 梓樊先生
 * @Date 2021/12/24 15:50
 **/
public abstract class BaseLotteryAlgorithm implements LotteryAlgorithm{

    @Resource
    private LotteryAlgorithmSupport lotteryAlgorithmSupport;

    protected List<AwardRateInfo> getAwardRateList(Long strategyId) {

        return lotteryAlgorithmSupport.queryAwardRateList(strategyId);
    }



    @Override
    public String calc(Long strategyId, List<String> excludeAwardIds) {
        throw new NotImplementedException();
    }




}
