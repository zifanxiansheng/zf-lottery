package top.zifanxiansheng.zf_lottery.domain.award.repository;

import top.zifanxiansheng.zf_lottery.domain.strategy.model.bo.AwardInfo;

import java.util.List;

public interface IAwardRepository {
    void addAwardList(List<AwardInfo> awardInfoList);

}
