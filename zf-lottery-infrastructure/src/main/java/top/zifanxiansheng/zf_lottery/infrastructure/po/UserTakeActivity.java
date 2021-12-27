package top.zifanxiansheng.zf_lottery.infrastructure.po;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * @author 
 * 用户参与活动记录表
 */
@Data
public class UserTakeActivity implements Serializable {
    /**
     * 自增ID
     */
    private Long id;

    /**
     * 用户ID
     */
    private String uId;

    /**
     * 活动领取ID
     */
    private Long takeId;

    /**
     * 活动ID
     */
    private Long activityId;

    /**
     * 活动名称
     */
    private String activityName;

    /**
     * 活动领取时间
     */
    private LocalDateTime takeDate;

    /**
     * 领取次数
     */
    private Integer takeCount;

    /**
     * 抽奖策略ID
     */
    private Integer strategyId;

    /**
     * 活动单使用状态 0未使用、1已使用
     */
    private Byte state;

    /**
     * 防重ID
     */
    private String uuid;

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