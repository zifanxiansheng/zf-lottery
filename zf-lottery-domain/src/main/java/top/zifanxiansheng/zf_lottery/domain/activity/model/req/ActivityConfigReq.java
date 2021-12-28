package top.zifanxiansheng.zf_lottery.domain.activity.model.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.zifanxiansheng.zf_lottery.domain.activity.model.bo.ActivityConfigRich;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActivityConfigReq {


    private Long activityId;

    private ActivityConfigRich activityConfigRich;

}
