package top.zifanxiansheng.zf_lottery.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author 梓樊先生
 * @Date 2021/12/29 11:09
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Result {


    private String code;
    private String info;


    public static Result buildSuccess() {

        return Result.builder().code(Constants.ResponseTypeEnum.SUCCESS.getCodeStr())
                .info(Constants.ResponseTypeEnum.SUCCESS.value())
                .build();
    }

    public static Result buildSuccess(String info) {

        return Result.builder().code(Constants.ResponseTypeEnum.SUCCESS.getCodeStr())
                .info(info)
                .build();
    }

    public static Result buildFailure() {

        return Result.builder()
                .code(Constants.ResponseTypeEnum.UN_ERROR.getCodeStr())
                .info(Constants.ResponseTypeEnum.UN_ERROR.value())
                .build();
    }

    public static Result buildFailure(String message) {

        return Result.builder()
                .code(Constants.ResponseTypeEnum.UN_ERROR.getCodeStr())
                .info(message)
                .build();
    }
}
