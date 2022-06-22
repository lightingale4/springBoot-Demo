package org.dingli.controller;

import org.dingli.common.Base64Util;
import org.dingli.common.FileUtil;
import org.dingli.common.HttpUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLEncoder;

/**
 * @author ding.li
 */
@RestController
@RequestMapping("/ocr")
public class OcrController {


    /**
     * 识别Demo识别
     *
     * @return
     */
    @PostMapping("/identifyBusinessLicense")
    public String identifyBusinessLicense() {
        String finaleResult = null;
        // iocr识别apiUrl
        String recogniseUrl = "https://aip.baidubce.com/rest/2.0/solution/v1/iocr/recognise";

        String filePath = "C:\\Users\\Administrator\\Desktop\\invoice.pdf";
        try {
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            // 请求模板参数
            String recogniseParams = "templateSign=176c56c08bbe123bb3ee28c02f23974c&pdf_file=" + URLEncoder.encode(imgStr, "UTF-8");
            // 请求分类器参数
            String classifierParams = "classifierId=your_classfier_id&pdf_file=" + URLEncoder.encode(imgStr, "UTF-8");

            String accessToken = "24.a8360362282da617ee7e01b85eff0b27.2592000.1657265088.282335-25697878";
            // 请求模板识别
            finaleResult = HttpUtil.post(recogniseUrl, accessToken, recogniseParams);
            // 请求分类器识别
            // String result = HttpUtil.post(recogniseUrl, accessToken, classifierParams);

            System.out.println(finaleResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return finaleResult;
    }
}
