package top.zifanxiansheng.zf_lottery.common;

/**
 * @Author 梓樊先生
 * @Date 2021/12/24 16:10
 **/
public class Constants {


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