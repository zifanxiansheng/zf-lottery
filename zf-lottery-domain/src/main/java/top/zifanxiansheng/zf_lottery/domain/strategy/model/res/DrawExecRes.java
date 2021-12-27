package top.zifanxiansheng.zf_lottery.domain.strategy.model.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.zifanxiansheng.zf_lottery.common.Constants;
import top.zifanxiansheng.zf_lottery.domain.strategy.model.bo.AwardInfo;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DrawExecRes {

    private String uId;
    private String awardId;
    private Long strategyId;

    private String awardName;
    private Constants.DrawStateEnum drawState = Constants.DrawStateEnum.FAILURE;

    private AwardInfo awardInfo;
}
