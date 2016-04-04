package com.shop.core.alipay.demo;

public class AlipassSDKConstants {

    /**
     * 商户在开放平台的应用的app_id，请确认应用有卡券包功能
     */
    public static final String APP_ID            = "2016032301235296";

    /**
     * 商户私钥 上述应用公钥对应的私钥
     */
    public static final String PRIVATE_KEY       = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAMPSAaC1pmnRFpPi7L9PTIFO5Z/KntNavHR/dqsNZBIle0xAetdVye8jBExpz8/3Ywe1HTccWxtAVn3zi9Z45v9oCuLe72LfkcF9ykEzAmNN5BC5+Fk7N7Op3r9hAa6Xq+wrmIxOMflMq2rMJNpNLcUcZGmB/gZW0ECTdWzINR7PAgMBAAECgYEAnsCDl1GM316majBfdN2KDY7z8+6lgn2eKOgpQZVymo+OfQwNSsP/GQMPeg+SbWyG+XmofMRdTCOFu0iWBsMvqVRywPPRtQZJurjfj0XPL0Yfz83rINWrzQGAOJ4HiWE0pMU3bRfA2US3mvCq5ULSUTIFU4KJQMofWRZFNuUDzyECQQD8tI/NMTaZmWrNHV6RCDTY2wO5+cbfslKqPVO8J5HJ9uHyO3PW/KI1+f535kU7i2ISPE+5XEi2Krdxt43M1UkfAkEAxl+VUpztdRqJ6klAkDSLfekDrscfx6Asxs63cGi7St3f/haWlBRr7gcDDGFwJdRreFQzKsWLNkmKDJLS31uEUQJAVFBCMmobF4Bye+Eyrh0Y1MmuIpzN19D9d8NibsKdB8+Rb2qaqb48uNmiJ4ryyn0kyYTJ7MR3liAGeLCPZSo8bQJBAL52z5w+aA/jpz93jbHngXcm3w5UycKVm+hWWfJn3EwJtCL19SXAZdBokxi0BUWNKpKh5W7PtNYuzYk8/5LM/8ECQAyC17c9Zg2zGbUbSlOzb3+A44FghzMgM1rM7audiuos1wIeY7YU+ch7riyR6GYgkvtwn41BcLqDng4CXo3fkH8=";
    /**
     * 支付宝公钥 在上述应用中查看
     */
    public static final String ALIPAY_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDI6d306Q8fIfCOaTXyiUeJHkrIvYISRcc73s3vF1ZT7XN8RNPwJxo8pWaJMmvyTn9N4HQ632qJBVHf8sxHi/fEsraprwCtzvzQETrNRwVxLO5jVmRGi60j8Ue1efIlzPXV9je9mkjzOmdssymZkh2QhUrCmZYI/FCEa3/cNMW0QIDAQAB";

    /**支付宝网关*/
    public static final String ALIPAY_GATEWAY    = "https://openapi.alipay.com/gateway.do";

    /**字符编码-传递给支付宝的数据编码*/
    public static final String CHARSET           = "utf-8";

    public static String       FORMAT            = "json";

}
