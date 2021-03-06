package com.shop.core.util;

import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.shop.core.exception.BusinessExceptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Random;

/**
 * Created by zhang on 2016/3/23.
 */
public class PhotoUploadUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(PhotoUploadUtil.class);

    private static final String SECRET_KEY = "oq0F_m3TP1pXeKTuVUbC25fArMmGHwN9Z-I0Vzx0";
    private static final String ACCESS_KEY = "72bv1OHYgn4I8drbTFOr8e4-lv3Hu329VLnv8c6X";
    private static final String BUCKET_NAME = "space";
    private static final String DOMAIN = "http://7xo04n.com1.z0.glb.clouddn.com/";

    public static String uploadPhoto(MultipartFile file, HttpServletRequest request, int uid) {
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        String token = auth.uploadToken(BUCKET_NAME);
        UploadManager uploadManager = new UploadManager();
        String fileName = generateFileName(uid);
        if (!file.isEmpty()) {
            try {
                // 文件保存路径
                String filePath = request.getSession().getServletContext().getRealPath("") + file.getOriginalFilename();
                // 转存文件
                file.transferTo(new File(filePath));
                Response res = uploadManager.put(filePath, fileName, token);
                if (!res.isOK()) {
                    BusinessExceptionUtil.throwBusinessException("上传失败");
                }
            } catch (Exception e) {
                BusinessExceptionUtil.throwBusinessException("上传失败" + e.getMessage());
            }
        } else {
            LOGGER.warn("图片不存在");
        }
        return DOMAIN + fileName;
    }

    private static String generateFileName(int uid) {
        String filename = String.valueOf(uid);
        Random random = new Random();
        int ran = (int) (random.nextDouble() * uid * 100);
        filename += uid;
        filename += ran;
        return filename;
    }

}
