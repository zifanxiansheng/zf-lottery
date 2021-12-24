package top.zifanxiansheng.zf_lottery.domain.strategy.model.res;

import lombok.Data;
import top.zifanxiansheng.zf_lottery.common.Constants;
import top.zifanxiansheng.zf_lottery.domain.strategy.model.bo.AwardInfo;

@Data
public class DrawExecRes {

    private String uId;
    private String awardId;
    private Long strategyId;

    private String awardName;
    private Integer drawState = Constants.DrawStateEnum.FAILURE.getCode();

    private AwardInfo awardInfo;
}
