package com.chaomeis.sparrowbeauty.api.controller.user;

import com.chaomeis.sparrowbeauty.api.service.account.ApiAccountService;
import com.chaomeis.sparrowbeauty.api.service.integral.ApiIntegralService;
import com.chaomeis.sparrowbeauty.api.service.order.ApiOrderService;
import com.chaomeis.sparrowbeauty.api.service.user.ApiUserService;
import com.chaomeis.sparrowbeauty.config.CmsSysProperties;
import com.chaomeis.sparrowbeauty.entity.TbApiUser;
import com.chaomeis.sparrowbeauty.response.ResultInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/user")
public class ApiUserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiUserController.class);

    @Resource
    private CmsSysProperties cmsSysProperties;

    @Resource
    private ApiUserService apiUserService;

    @Resource
    private ApiOrderService apiOrderService;

    @Resource
    private ApiIntegralService apiIntegralService;

    @Resource
    private ApiAccountService apiAccountService;
    /**
     * 登陆接口只获取了用户的openId 该接口小程序前端上报用户的昵称和头像
     * @param params 请求参数
     * @return 返回是否上报成功
     */
    @RequestMapping("/reportApiUserInfo")
    public ResultInfo reportApiUserInfo(@RequestBody Map<String,String> params){

        if (params == null){
            return ResultInfo.newEmptyParamsResultInfo();
        }
        String openId = params.get("openId");
        String nickName = params.get("nickName");
        String userHeadImage = params.get("userHeadImage");
        String userBindPhoneNum =  params.get("userBindPhoneNum"); // 用户绑定电话号码
        String wechatPhoneNum = params.get("wechatPhoneNum"); // 微信关联电话号码
        LOGGER.info("reportApiUserInfo current user openId : {}, nickName: {},userHeadImage : {}",openId,nickName,userHeadImage);
        try {
            ResultInfo resultInfo = ResultInfo.newSuccessResultInfo();
            // TODO: 2019/9/28 小程序上报用户的昵称和头像，根据openid更新数据库中的记录
            TbApiUser record = new TbApiUser();
            record.setOpenId(openId);
            record.setNickName(nickName);
            record.setUserHeadImage(userHeadImage);
            record.setUserBindPhoneNum(userBindPhoneNum);
            record.setWechatPhoneNum(wechatPhoneNum);
           apiUserService.updateApiUserInfo(record);
            return resultInfo;
        }catch (Exception e){
            LOGGER.error("calculateGoodsOrderPrice GoodsOrderParamVo : {}",params,e);
            return ResultInfo.newExceptionResultInfo();
        }
    }

    /**
     * 用户点击小程序新人礼包 调用该接口返回新人礼包的静态图片
     * @param params 请求参数
     * @return 返回是否上报成功
     */
    @RequestMapping("/getNewUserGiftImage")
    public ResultInfo getNewUserGiftImage(@RequestBody Map<String,String> params){

        if (params == null){
            return ResultInfo.newEmptyParamsResultInfo();
        }
        try {
            ResultInfo resultInfo = ResultInfo.newSuccessResultInfo();
            String newUserGiftImage = cmsSysProperties.getImageUrlPrefix()+"page/newUserGiftImage.png";
            Map<String,Object> resultMap = new HashMap<>();
            resultMap.put("newUserGiftImage",newUserGiftImage);
            resultInfo.setData(resultMap);
            return resultInfo;
        }catch (Exception e){
            LOGGER.error("calculateGoodsOrderPrice GoodsOrderParamVo : {}",params,e);
            return ResultInfo.newExceptionResultInfo();
        }
    }

    /**
     * 用户点击小程序新人礼包 调用该接口返回新人礼包的静态图片
     * @param params 请求参数
     * @return 返回是否上报成功
     */
    @RequestMapping("/receiveNewUserGift")
    public ResultInfo receiveNewUserGift(@RequestBody Map<String,String> params){

        if (params == null){
            return ResultInfo.newEmptyParamsResultInfo();
        }
        try {
            ResultInfo resultInfo = ResultInfo.newSuccessResultInfo();
            TbApiUser userInfo = apiUserService.findApiUserByOpenId(params.get("openId"));
            if (userInfo == null){
                LOGGER.error("receiveNewUserGift findApiUserByOpenId userInfo is null openId : {}",params.get("openId"));
                return ResultInfo.newEmptyResultInfo();
            }
            if (userInfo.getGiftReceiveStatus() == 1){
                resultInfo.setData(0);
                return resultInfo;
            }
            boolean flag = apiUserService.receiveNewUserGift(userInfo);
            if (!flag){
                return ResultInfo.newFailResultInfo();
            }
            return resultInfo;
        }catch (Exception e){
            LOGGER.error("calculateGoodsOrderPrice GoodsOrderParamVo : {}",params,e);
            return ResultInfo.newExceptionResultInfo();
        }
    }

    /**
     * 用户点击小程序新人礼包 调用该接口返回新人礼包的静态图片
     * @param params 请求参数
     * @return 返回是否上报成功
     */
    @RequestMapping("/getUserInfo")
    public ResultInfo getUserInfo(@RequestBody Map<String,String> params){

        if (params == null){
            return ResultInfo.newEmptyParamsResultInfo();
        }
        try {
            ResultInfo resultInfo = ResultInfo.newSuccessResultInfo();
            String openId = params.get("openId");
            TbApiUser userInfo = apiUserService.findApiUserByOpenId(openId);
            if (userInfo == null){
                LOGGER.error("getUserInfo findApiUserByOpenId userInfo is null openId : {}", openId);
                return ResultInfo.newEmptyResultInfo();
            }
            Map<String,Object> resultMap = new HashMap<>();
            resultMap.put("userInfo",userInfo);
            //统计订单各状态数量,
            apiOrderService.orderStatisticalByStatus(openId);
            //查询用户积分 返回可使用积分和冻结积分
            apiIntegralService.countUserIntegralByOpenId(openId);
            //查询用户账户信息 返回可提现金额和冻结金额
            if (userInfo.getIsDealer() == 1){
                apiAccountService.findUserAccountInfoByOpenId(openId);
            }
            //todo 需要将后续查询的信息装载到resultMap中
            resultInfo.setData(resultMap);
            return resultInfo;
        }catch (Exception e){
            LOGGER.error("calculateGoodsOrderPrice GoodsOrderParamVo : {}",params,e);
            return ResultInfo.newExceptionResultInfo();
        }
    }
}
