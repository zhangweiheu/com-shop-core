package com.shop.core.alipay.demo;

import com.alipay.api.response.AlipayPassInstanceAddResponse;
import com.alipay.api.response.AlipayPassInstanceUpdateResponse;
import com.shop.core.alipay.enums.PassStatus;
import com.shop.core.alipay.enums.RecognitionTypeEnum;
import com.shop.core.alipay.model.request.BaseAddRequest;
import com.shop.core.alipay.model.request.instance.AddPassInstanceRequest;
import com.shop.core.alipay.model.request.instance.UpdatePassInstanceRequest;
import com.shop.core.alipay.service.AlipassTransferV2Service;
import com.shop.core.alipay.service.impl.AlipassTransferV2ServiceOpenAPIImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhang on 2016/4/3.
 */
public class PassUtil {
    private static AlipassTransferV2Service transferService;
    private String appAuthToken = "";

    public Boolean addPassInstance(String phoneNumber){
        String templateId = "2016040311340376412786805";
        String serialNumber = GenerateNumber.generateNumber(16);

        transferService = new AlipassTransferV2ServiceOpenAPIImpl();
        transferService.init(AlipassSDKConstants.ALIPAY_GATEWAY, AlipassSDKConstants.APP_ID, AlipassSDKConstants.PRIVATE_KEY, AlipassSDKConstants.FORMAT, AlipassSDKConstants.CHARSET, AlipassSDKConstants.ALIPAY_PUBLIC_KEY);

        Map<String, String> paramValuePair = new HashMap<>();
        paramValuePair.put("title", "i美妆优惠券");
        paramValuePair.put("startDate", "2015-03-18 23:59:59");
        paramValuePair.put("endDate", "2016-09-18 23:59:59");
        paramValuePair.put("ackCode", serialNumber);
        paramValuePair.put("serialNumber", serialNumber);
        paramValuePair.put("secondLogoText", "");
        paramValuePair.put("status", "可使用");
        paramValuePair.put("strip", "凭此券即可免单一次");
        paramValuePair.put("validDate", "2016-09-18 23:59:59");
        paramValuePair.put("channelID", AlipassSDKConstants.APP_ID);
        paramValuePair.put("webServiceUrl", "");

        Map<String, String> userParams = new HashMap<>();
        userParams.put(BaseAddRequest.MOBILE, phoneNumber);
        userParams.put("ackCode", serialNumber);
        userParams.put("verify_code", serialNumber);
        userParams.put("serialNumber", serialNumber);

        AddPassInstanceRequest addReq = new AddPassInstanceRequest();
        addReq.setAppAuthToken(appAuthToken);
        addReq.setTemplateId(templateId);
        addReq.setTemplateParamValuePair(paramValuePair);
        addReq.setUserType(RecognitionTypeEnum.MOBILE);
        addReq.setUserTypeParams(userParams);

        try {
            AlipayPassInstanceAddResponse res = transferService.addPassInstance(addReq);
            if (res.isSuccess()) {
                return true;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return false;
    }

    /**
     * 更新卡券实例
     *
     * @param serialNumber
     * @throws Exception
     */
    public Boolean updatePassInstance(String serialNumber) {
        transferService = new AlipassTransferV2ServiceOpenAPIImpl();
        transferService.init(AlipassSDKConstants.ALIPAY_GATEWAY, AlipassSDKConstants.APP_ID, AlipassSDKConstants.PRIVATE_KEY, AlipassSDKConstants.FORMAT, AlipassSDKConstants.CHARSET, AlipassSDKConstants.ALIPAY_PUBLIC_KEY);

        UpdatePassInstanceRequest request = new UpdatePassInstanceRequest();
        request.setAppAuthToken(appAuthToken);

        request.setSerialNumber(serialNumber);
        request.setChannelId(AlipassSDKConstants.APP_ID);
        Map<String, String> templateParamValuePair = new HashMap<>();
        templateParamValuePair.put("status", "已使用");
        templateParamValuePair.put("endDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        templateParamValuePair.put("validDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        request.setTemplateParamValuePair(templateParamValuePair);
        request.setStatus(PassStatus.PASS_STATUS_CLOSED);
        request.setVerifyType("barcode");
        request.setVerifyCode(serialNumber);
        try {
            AlipayPassInstanceUpdateResponse res = transferService.updatePassInstance(request);
            if (res.isSuccess()) {
                return true;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return false;
    }
}
