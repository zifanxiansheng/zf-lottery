package top.zifanxiansheng.zf_lottery.common;

import lombok.Data;

/**
 * @Author 梓樊先生
 * @Date 2021/12/24 16:10
 **/
public class Constants {


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


    public enum AwardType implements BaseEnumInterface {
        //（1:文字描述、2:兑换码、3:优惠券、4:实物奖品）
        DESC(1, "文字描述"),
        CODE(2, "兑换码"),
        COUPON(2, "兑换码"),
        MATERIAL(2, "兑换码");

        @Override
        public int getCode() {
            return code;
        }

        @Override
        public String getInfo() {
            return info;
        }

        private final int code;
        private final String info;

        AwardType(int code, String info) {
            this.code = code;
            this.info = info;
        }


    }
}
