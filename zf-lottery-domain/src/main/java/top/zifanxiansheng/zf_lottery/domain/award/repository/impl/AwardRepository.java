package top.zifanxiansheng.zf_lottery.domain.award.repository.impl;

import org.springframework.stereotype.Repository;
import top.zifanxiansheng.zf_lottery.domain.award.repository.IAwardRepository;
import top.zifanxiansheng.zf_lottery.domain.award.service.asserbler.AwardMapping;
import top.zifanxiansheng.zf_lottery.domain.strategy.model.bo.AwardInfo;
import top.zifanxiansheng.zf_lottery.infrastructure.dao.AwardDAO;
import top.zifanxiansheng.zf_lottery.infrastructure.po.Award;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class AwardRepository implements IAwardRepository {
    @Resource
    AwardDAO awardDAO;
    @Resource
    AwardMapping awardMapping;

    @Override
    public void addAwardList(List<AwardInfo> awardInfoList) {
        List<Award> awards = awardMapping.targetToSource(awardInfoList);
        for (Award award : awards) awardDAO.insert(award);
    }
}
