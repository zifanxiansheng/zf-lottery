package top.zifanxiansheng.zf_lottery.infrastructure.po;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * @author 
 * 用户活动参与次数表
 */
@Data
public class UserTakeActivityCount implements Serializable {
    /**
     * 自增ID
     */
    private Long id;

    /**
     * 用户ID
     */
    private String uId;

    /**
     * 活动ID
     */
    private Long activityId;

    /**
     * 可领取次数
     */
    private Integer totalCount;

    /**
     * 已领取次数
     */
    private Integer leftCount;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    private static final long serialVersionUID = 1L;
}