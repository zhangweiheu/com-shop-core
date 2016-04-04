/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.shop.core.alipay.demo;

import com.alipay.api.AlipayApiException;
import com.alipay.api.response.AlipayPassInstanceAddResponse;
import com.alipay.api.response.AlipayPassInstanceUpdateResponse;
import com.alipay.api.response.AlipayPassTemplateAddResponse;
import com.alipay.api.response.AlipayPassTemplateUpdateResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.core.alipay.enums.PassStatus;
import com.shop.core.alipay.enums.RecognitionTypeEnum;
import com.shop.core.alipay.model.request.BaseAddRequest;
import com.shop.core.alipay.model.request.instance.AddPassInstanceRequest;
import com.shop.core.alipay.model.request.instance.UpdatePassInstanceRequest;
import com.shop.core.alipay.model.request.template.TemplateCreateRequest;
import com.shop.core.alipay.model.request.template.TemplateModifyRequest;
import com.shop.core.alipay.service.AlipassTransferV2Service;
import com.shop.core.alipay.service.impl.AlipassTransferV2ServiceOpenAPIImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Alipass demo 2.0版本，对alipass的open api做简易封装。
 * 原生版本{@link com.alipay.alipass.sdk.demo.AlipassSDKTest}
 *
 * @author mingqiu.gmq
 * @version $Id: AlipassSDKOpenAPIV2Test.java, v 0.1 2015年6月25日 下午3:26:38
 *          mingqiu.gmq Exp $
 */
public class AlipassSDKOpenAPIV2Test {
    private static ObjectMapper JSON = new ObjectMapper();

    private static AlipassTransferV2Service transferService;
    private static String templateId = "2016040311340376412786805";

    // 设置app_auth_token参数，当isv代替商户发起接口调用时，需要传此参数；商户自主调用接口时，不需要传此参数
    private String appAuthToken = "";

    public static void main(String[] args) throws Exception {
        transferService = new AlipassTransferV2ServiceOpenAPIImpl();
        transferService.init(AlipassSDKConstants.ALIPAY_GATEWAY, AlipassSDKConstants.APP_ID, AlipassSDKConstants.PRIVATE_KEY, AlipassSDKConstants.FORMAT, AlipassSDKConstants.CHARSET, AlipassSDKConstants.ALIPAY_PUBLIC_KEY);

        AlipassSDKOpenAPIV2Test demo = new AlipassSDKOpenAPIV2Test();

        String templateId = "2016040311340376412786805";

        //         创建模板
        //                templateId = demo.createTemplate();
        System.out.println("templateId = " + templateId);

        // 修改模板
        //        demo.modifyTemplate(templateId);

        // 添加卡券实例
            demo.addPassInstance(templateId);

        //        demo.updatePassInstance("1073603201765620");
        //        demo.closePassInstance("1073603201765620");
        // 修改卡券实例
    }

    /**
     * 2.0版本创建卡券模板
     *
     * @return
     * @throws Exception
     */
    private String createTemplate() throws Exception {
        String content = "{\"evoucherInfo\":{" +
                //                "\"goodsId\": \"\"," +
                "\"title\":\"$title$\"," +
                "\"type\":\"eventTicket\"," +
                "\"product\":\"free\"," +
                "\"startDate\":\"$startDate$\"," +
                "\"endDate\": \"$endDate$\"," +
                "\"operation\": [{\"format\": \"barcode\"," +
                "\"message\": \"$ackCode$\"," +
                "\"messageEncoding\": \"utf-8\"," +
                "\"altText\": \"$ackCode$\"}]," +
                "\"einfo\":{" +
                "\"logoText\": \"$title$\"," +
                "\"secondLogoText\": \"$secondLogoText$\"," +
                "\"headFields\":[" +
                "{\"key\": \"status\"," +
                "\"label\": \"状态：\"," +
                "\"value\": \"$status$\"," +
                "\"type\": \"text\"" +
                "}]," +
                "\"primaryFields\": [" +
                "{\"key\": \"strip\"," +
                "\"label\": \"\"," +
                "\"value\": \"$strip$\"," +
                "\"type\": \"text\"" +
                "}]," +
                "\"secondaryFields\": [" +
                "{\"key\": \"validDate\"," +
                "\"label\": \"有效期至：\"," +
                "\"value\": \"$validDate$\"," +
                "\"type\": \"text\"" +
                "}]," +
                "\"auxiliaryFields\": [" +
                "{\"key\": \"serialNumber\"," +
                "\"label\": \"优惠券序列号：\"," +
                "\"value\": \"$serialNumber$\"," +
                "\"type\": \"text\"" +
                "}]," +
                "\"backFields\": [" +
                "{\"key\": \"description\"," +
                "\"label\": \"详情描述\"," +
                "\"value\": \"1.该优惠有效期：截止至2016年03月18日；\n2.凭此券可以享受以下优惠：\n享免单优惠\n不与其他优惠同享。详询商家。\"," +
                "\"type\": \"text\"" +
                "},{" +
                "\"key\": \"disclaimer\"," +
                "\"label\": \"免责声明\"," +
                "\"value\": \"除特殊注明外，本优惠不能与其他优惠同时享受； 本优惠最终解释权归商家所有，如有疑问请与商家联系。 提示：为了使您得到更好的服务，请在进店时出示本券。\"," +
                "\"type\": \"text\"" +
                "}]" +
                "}," +
                "\"locations\": []" +
                "}," +
                "\"merchant\": {" +
                "\"mname\": \"张伟\"," +
                "\"mtel\": \"\"," +
                "\"minfo\": \"\"" +
                "},\"platform\": {" +
                "\"channelID\": \"$channelID$\"," +
                "\"webServiceUrl\": \"$webServiceUrl$\"" +
                "},\"style\": {" +
                "\"backgroundColor\": \"rgb(246,150,219)\"" +
                "},\"fileInfo\": {" +
                "\"formatVersion\": \"2\"," +
                "\"canShare\": true," +
                "\"canBuy\": false," +
                "\"canPresent\": true," +
                "\"serialNumber\": \"$serialNumber$\"," +
                "\"supportTaxi\": \"false\"," +
                "\"taxiSchemaUrl\": \"$taxiSchemaUrl$\"" +
                "},\"appInfo\": null," +
                "\"alipayVerify\": []" +
                "}";
        String logo = "http://7xo04n.com1.z0.glb.clouddn.com/mz.png";

        // 组装接口入参参数
        TemplateCreateRequest templateReq = new TemplateCreateRequest();
        templateReq.setAppAuthToken(appAuthToken);

        templateReq.setLogo(logo);
        templateReq.setContent(content);
        templateReq.setUniqueId(String.valueOf(System.currentTimeMillis()));// 外部唯一标识

        // 调用请求
        AlipayPassTemplateAddResponse response = transferService.createTemplate(templateReq);

        // 解析templateId
        String templateId = null;
        if (response.isSuccess()) {
            templateId = (String) JSON.readValue(response.getResult(), Map.class).get("tpl_id");
            // TODO 具体业务处理
        } else {
            // TODO 异常业务处理
        }
        System.out.println(
                "新增卡券模板结果：success=" + response.isSuccess() + "\r\n,result=" + response.getResult() + "\r\n,subCode=" + response.getSubCode()
                        + "\r\n,subMsg=" + response.getSubMsg());
        return templateId;
    }

    /**
     * Alipass模版更新接口测试
     *
     * @throws AlipayApiException
     */
    private void modifyTemplate(String templateId) throws Exception {
        String content = "{\"evoucherInfo\":{" +
                //                "\"goodsId\": \"\"," +
                "\"title\":\"$title$\"," +
                "\"type\":\"eventTicket\"," +
                "\"product\":\"free\"," +
                "\"startDate\":\"$startDate$\"," +
                "\"endDate\": \"$endDate$\"," +
                "\"operation\": [{\"format\": \"barcode\"," +
                "\"message\": \"$ackCode$\"," +
                "\"messageEncoding\": \"utf-8\"," +
                "\"altText\": \"$ackCode$\"}]," +
                "\"einfo\":{" +
                "\"logoText\": \"$title$\"," +
                "\"secondLogoText\": \"$secondLogoText$\"," +
                "\"headFields\":[" +
                "{\"key\": \"status\"," +
                "\"label\": \"状态：\"," +
                "\"value\": \"$status$\"," +
                "\"type\": \"text\"" +
                "}]," +
                "\"primaryFields\": [" +
                "{\"key\": \"strip\"," +
                "\"label\": \"\"," +
                "\"value\": \"$strip$\"," +
                "\"type\": \"text\"" +
                "}]," +
                "\"secondaryFields\": [" +
                "{\"key\": \"validDate\"," +
                "\"label\": \"有效期至：\"," +
                "\"value\": \"$validDate$\"," +
                "\"type\": \"text\"" +
                "}]," +
                "\"auxiliaryFields\": [" +
                "{\"key\": \"serialNumber\"," +
                "\"label\": \"优惠券序列号：\"," +
                "\"value\": \"$serialNumber$\"," +
                "\"type\": \"text\"" +
                "}]," +
                "\"backFields\": [" +
                "{\"key\": \"description\"," +
                "\"label\": \"详情描述\"," +
                "\"value\": \"1.该优惠有效期：截止至2016年03月18日；\n2.凭此券可以享受以下优惠：\n享免单优惠\n不与其他优惠同享。详询商家。\"," +
                "\"type\": \"text\"" +
                "},{" +
                "\"key\": \"disclaimer\"," +
                "\"label\": \"免责声明\"," +
                "\"value\": \"除特殊注明外，本优惠不能与其他优惠同时享受； 本优惠最终解释权归商家所有，如有疑问请与商家联系。 提示：为了使您得到更好的服务，请在进店时出示本券。\"," +
                "\"type\": \"text\"" +
                "}]" +
                "}," +
                "\"locations\": []" +
                "}," +
                "\"merchant\": {" +
                "\"mname\": \"张伟\"," +
                "\"mtel\": \"\"," +
                "\"minfo\": \"\"" +
                "},\"platform\": {" +
                "\"channelID\": \"$channelID$\"," +
                "\"webServiceUrl\": \"$webServiceUrl$\"" +
                "},\"style\": {" +
                "\"backgroundColor\": \"rgb(246,150,219)\"" +
                "},\"fileInfo\": {" +
                "\"formatVersion\": \"2\"," +
                "\"canShare\": true," +
                "\"canBuy\": false," +
                "\"canPresent\": true," +
                "\"serialNumber\": \"$serialNumber$\"," +
                "\"supportTaxi\": \"false\"," +
                "\"taxiSchemaUrl\": \"\"" +
                "},\"appInfo\": null," +
                "\"alipayVerify\": []" +
                "}";
        String logo = "http://7xo04n.com1.z0.glb.clouddn.com/mz.png";

        TemplateModifyRequest templateReq = new TemplateModifyRequest();
        templateReq.setAppAuthToken(appAuthToken);
        templateReq.setContent(content);
        templateReq.setLogo(logo);
        templateReq.setTemplateId(templateId);

        AlipayPassTemplateUpdateResponse res = transferService.modifyTemplate(templateReq);
        if (res.isSuccess()) {
            // TODO 具体业务处理
        } else {
            // TODO 异常业务处理
        }
        System.out.println(
                "修改卡券模板结果：success=" + res.isSuccess() + ",result=" + res.getResult() + ",subCode=" + res.getSubCode() + ",subMsg=" + res.getSubMsg());
    }

    /**
     * 添加卡券实例
     *
     * @param appAuthToken
     * @param templateId
     * @throws Exception
     */
    private void addPassInstance(String templateId) throws Exception {
        //TODO: 注意：alipass的唯一标识，商户请使用外部交易号作为serialNumber
        //        String serialNumber = GenerateNumber.generateNumber(16);
        String serialNumber = "1073603201765620";
        System.out.println(serialNumber);

        Map<String, String> paramValuePair = new HashMap<String, String>();
        paramValuePair.put("title", "i美妆优惠券");
        paramValuePair.put("startDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        paramValuePair.put("endDate", "2016-09-18 23:59:59");
        paramValuePair.put("ackCode", serialNumber);
        paramValuePair.put("serialNumber", serialNumber);
        paramValuePair.put("secondLogoText", "");
        paramValuePair.put("status", "可使用");
        paramValuePair.put("strip", "凭此券即可免单一次");
        paramValuePair.put("validDate", "2016-09-18 23:59:59");
        paramValuePair.put("channelID", AlipassSDKConstants.APP_ID);
        paramValuePair.put("webServiceUrl", "");
        //        paramValuePair.put("description", "1.该优惠有效期：截止至2016年03月18日；\n2.凭此券可以享受以下优惠：\n享免单优惠\n不与其他优惠同享。详询商家。");
        //        paramValuePair.put("disclaimer", "除特殊注明外，本优惠不能与其他优惠同时享受； 本优惠最终解释权归商家所有，如有疑问请与商家联系。 提示：为了使您得到更好的服务，请在进店时出示本券。");

        Map<String, String> userParams = new HashMap<String, String>();
        userParams.put(BaseAddRequest.MOBILE, "15663461691");
        userParams.put("ackCode", serialNumber);
        userParams.put("verify_code", serialNumber);
        userParams.put("serialNumber", serialNumber);

        //        userParams.put(BaseAddRequest.PARTNER_ID, "2088802441917053");
        //        userParams.put(BaseAddRequest.OUT_TRADE_NO, "2016040300001000720089930634");

        AddPassInstanceRequest addReq = new AddPassInstanceRequest();
        addReq.setAppAuthToken(appAuthToken);
        addReq.setTemplateId(templateId);
        addReq.setTemplateParamValuePair(paramValuePair);
        addReq.setUserType(RecognitionTypeEnum.MOBILE);
        //        addReq.setUserType(RecognitionTypeEnum.TRADE);
        addReq.setUserTypeParams(userParams);

        AlipayPassInstanceAddResponse res = transferService.addPassInstance(addReq);
        if (res.isSuccess()) {
            // TODO 具体业务处理
            System.out.print("yes");
            //            updatePassInstance(serialNumber);
            //            closePassInstance(serialNumber);
        } else {
            // TODO 异常业务处理
            System.out.print("no");
        }
        System.out.println(
                "新增卡券实例结果：success=" + res.isSuccess() + ",result=" + res.getResult() + ",subCode=" + res.getSubCode() + ",subMsg=" + res.getSubMsg());

    }

    /**
     * 更新卡券实例
     *
     * @param appAuthToken
     * @param templateId
     * @throws Exception
     */
    private void updatePassInstance(String serialNumber) throws Exception {

        UpdatePassInstanceRequest request = new UpdatePassInstanceRequest();
        request.setAppAuthToken(appAuthToken);

        request.setSerialNumber(serialNumber);
        request.setChannelId(AlipassSDKConstants.APP_ID);
        Map<String, String> templateParamValuePair = new HashMap<>();
        templateParamValuePair.put("status", "已使用");
        templateParamValuePair.put("endDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        request.setTemplateParamValuePair(templateParamValuePair);
        request.setStatus(PassStatus.PASS_STATUS_USED);
        request.setVerifyType("barcode");
        request.setVerifyCode(serialNumber);

        AlipayPassInstanceUpdateResponse res = transferService.updatePassInstance(request);
        if (res.isSuccess()) {
            // TODO 具体业务处理
        } else {
            // TODO 异常业务处理
        }
        System.out.println(
                "修改卡券实例结果：success=" + res.isSuccess() + ",result=" + res.getResult() + ",subCode=" + res.getSubCode() + ",subMsg=" + res.getSubMsg());
    }

    private void closePassInstance(String serialNumber) throws Exception {
        //        String serialNumber = "4534744160077235";

        UpdatePassInstanceRequest request = new UpdatePassInstanceRequest();
        request.setAppAuthToken(appAuthToken);

        request.setSerialNumber(serialNumber);
        request.setChannelId(AlipassSDKConstants.APP_ID);
        Map<String, String> templateParamValuePair = new HashMap<>();
        templateParamValuePair.put("status", "已使用");
        templateParamValuePair.put("endDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        request.setTemplateParamValuePair(templateParamValuePair);
        request.setStatus(PassStatus.PASS_STATUS_CLOSED);
        request.setVerifyType("barcode");
        request.setVerifyCode(serialNumber);

        AlipayPassInstanceUpdateResponse res = transferService.updatePassInstance(request);
        if (res.isSuccess()) {
            // TODO 具体业务处理
        } else {
            // TODO 异常业务处理
        }
        System.out.println(
                "修改卡券实例结果：success=" + res.isSuccess() + ",result=" + res.getResult() + ",subCode=" + res.getSubCode() + ",subMsg=" + res.getSubMsg());
    }



}
