package top.zifanxiansheng.zf_lottery.common;

/**
 * @Author 梓樊先生
 * @Date 2021/12/24 16:10
 **/
public class Constants {


    public enum AwardTypeEnum implements BaseEnumInterface {
        //（1:文字描述、2:兑换码、3:优惠券、4:实物奖品）
        DESC(1, "文字描述"), CODE(2, "兑换码"), COUPON(2, "兑换码"), MATERIAL(2, "兑换码");

        private final int code;
        private final String info;

        AwardTypeEnum(int code, String info) {
            this.code = code;
            this.info = info;
        }

        @Override
        public int getCode() {
            return code;
        }

        @Override
        public String getInfo() {
            return info;
        }

    }

    public enum StrategyModelEnum implements BaseEnumInterface {
        SINGLE(1, "单项概率"), OVERALL(2, "总体概率");

        private final int code;
        private final String info;

        StrategyModelEnum(int code, String info) {
            this.code = code;
            this.info = info;
        }

        @Override
        public int getCode() {
            return code;
        }

        @Override
        public String getInfo() {
            return info;
        }
    }

    public enum DrawStateEnum implements BaseEnumInterface {
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
        public int getCode() {
            return code;
        }

        @Override
        public String getInfo() {
            return info;
        }
    }


    public interface BaseEnumInterface {
        /**
         * getCode
         *
         * @return code
         */
        int getCode();

        /**
         * getInfo
         *
         * @return 描述信息
         */
        String getInfo();
    }
}
