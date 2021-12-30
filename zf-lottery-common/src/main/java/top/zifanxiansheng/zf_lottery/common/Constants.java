package top.zifanxiansheng.zf_lottery.common;


/**
 * @Author 梓樊先生
 * @Date 2021/12/24 16:10
 **/
public class Constants {

    public enum ResponseTypeEnum implements IPair {
        //
        SUCCESS(1, "0000", "成功"),
        UN_ERROR(2, "0001", "未知失败"),
        ILLEGAL_PARAMETER(3, "0002", "非法参数"),
        INDEX_DUP(4, "0003", "主键冲突"),
        NO_UPDATE(5, "0004", "SQL操作无更新"),
        LOSING_DRAW(6, "D001", "未中奖"),
        RULE_ERR(7, "D002", "量化人群规则执行失败");

        private final int code;
        private final String codeStr;
        private final String info;

        ResponseTypeEnum(int code, String codeStr, String info) {
            this.code = code;
            this.info = info;
            this.codeStr = codeStr;
        }

        public String getCodeStr() {
            return codeStr;
        }

        @Override
        public ResponseTypeEnum get() {
            return this;
        }

        @Override
        public String value() {
            return info;
        }

        @Override
        public Integer key() {
            return code;
        }
    }

    public enum AwardTypeEnum implements IPair {
        //（1:文字描述、2:兑换码、3:优惠券、4:实物奖品）
        DESC(1, "文字描述"), CODE(2, "兑换码"), COUPON(3, "优惠券"), MATERIAL(2, "实物奖品");

        private final int code;
        private final String info;

        AwardTypeEnum(int code, String info) {
            this.code = code;
            this.info = info;
        }

        @Override
        public AwardTypeEnum get() {
            return this;
        }

        @Override
        public String value() {
            return info;
        }

        @Override
        public Integer key() {
            return code;
        }
    }

    public enum StrategyModelEnum implements IPair {
        //
        SINGLE(1, "单项概率"), OVERALL(2, "总体概率");

        private final int code;
        private final String info;

        StrategyModelEnum(int code, String info) {
            this.code = code;
            this.info = info;
        }

        @Override
        public StrategyModelEnum get() {
            return this;
        }

        @Override
        public String value() {
            return info;
        }

        @Override
        public Integer key() {
            return code;
        }

    }

    public enum AwardStateEnum implements IPair {
        /**
         * 等待发奖
         */
        WAIT(0, "等待发奖"),

        /**
         * 发奖成功
         */
        SUCCESS(1, "发奖成功"),

        /**
         * 发奖失败
         */
        FAILURE(2, "发奖失败");

        private final int code;
        private final String info;

        AwardStateEnum(int code, String info) {
            this.code = code;
            this.info = info;
        }

        @Override
        public AwardStateEnum get() {
            return this;
        }

        @Override
        public String value() {
            return info;
        }

        @Override
        public Integer key() {
            return code;
        }
    }

    public enum GrantStateEnum implements IPair {
        //
        INIT(0, "初始"),
        COMPLETE(1, "完成"),
        FAIL(2, "失败");

        private final int code;
        private final String info;

        GrantStateEnum(int code, String info) {
            this.code = code;
            this.info = info;
        }

        @Override
        public GrantStateEnum get() {
            return this;
        }

        @Override
        public String value() {
            return info;
        }

        @Override
        public Integer key() {
            return code;
        }
    }

    public enum DrawStateEnum implements IPair {
        //
        SUCCESS(1, "中奖"),
        FAILURE(2, "未中奖"),
        COVER(3, "兜底奖");

        private final int code;
        private final String info;

        DrawStateEnum(int code, String info) {
            this.code = code;
            this.info = info;
        }

        @Override
        public DrawStateEnum get() {
            return this;
        }

        @Override
        public String value() {
            return info;
        }

        @Override
        public Integer key() {
            return code;
        }

    }

    public enum GrantTypeEnum implements IPair {
        //
        TIMELY(1, "及时发放"),
        TIME_TASK(2, "定时发放"),
        MAINTAIN(3, "人工");

        private final int code;
        private final String info;

        GrantTypeEnum(int code, String info) {
            this.code = code;
            this.info = info;
        }


        @Override
        public GrantTypeEnum get() {
            return this;
        }

        @Override
        public String value() {
            return info;
        }

        @Override
        public Integer key() {
            return code;
        }
    }

    public enum ActivityStateEnum implements IPair {
        // 活动状态：编辑、提审、撤审、通过、运行、拒绝、关闭、开启
        EDIT(1, "编辑"),
        ARRAIGNMENT(2, "提审"),
        ROLLBACK(3, "撤销审核"),
        PASS(4, "通过"),
        RUNNING(5, "运行"),
        REJECT(6, "拒绝"),
        CLOSE(7, "关闭"),
        OPEN(8, "开启"),
        ;
        private final int code;
        private final String info;

        ActivityStateEnum(int code, String info) {
            this.code = code;
            this.info = info;
        }


        @Override
        public ActivityStateEnum get() {
            return this;
        }

        @Override
        public String value() {
            return info;
        }

        @Override
        public Integer key() {
            return code;
        }
    }


    public enum IdsEnum implements IPair {
        //
        SnowFlake(1, "雪花算法"),
        ShortCode(2, "日期算法"),
        RandomNumeric(3, "随机数算法"),
        ;
        private final int code;
        private final String info;

        IdsEnum(int code, String info) {
            this.code = code;
            this.info = info;
        }


        @Override
        public IdsEnum get() {
            return this;
        }

        @Override
        public String value() {
            return info;
        }

        @Override
        public Integer key() {
            return code;
        }
    }


    public interface IPair {

        /**
         * 返回枚举类自身
         *
         * @param <E>
         * @return
         */
        <E> E get();

        <V> V value();

        <K> K key();
    }
}