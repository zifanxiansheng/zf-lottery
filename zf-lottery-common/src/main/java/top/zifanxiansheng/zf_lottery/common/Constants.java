package top.zifanxiansheng.zf_lottery.common;

/**
 * @Author 梓樊先生
 * @Date 2021/12/24 16:10
 **/
public class Constants {


    public enum AwardTypeEnum implements IPair {
        //（1:文字描述、2:兑换码、3:优惠券、4:实物奖品）
        DESC(1, "文字描述"), CODE(2, "兑换码"), COUPON(2, "兑换码"), MATERIAL(2, "兑换码");

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