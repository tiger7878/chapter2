package com.smart.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 属性文件类
 * User: monkey
 * Date: 2018-08-21 11:00
 */
@Component
public class MySystemConf {

    @Value("${fileUploadServerUrl}")
    private String fileUploadServerUrl;

    @Value("${file.fileRelativePath}")
    private String fileRelativePath;

    @Value("${file.fileAbsolutePath}")
    private String fileAbsolutePath;

    @Value("${file.helpDocRelativePath}")
    private String helpDocRelativePath;

    @Value("${file.payeeRelativePath}")
    private String payeeRelativePath;

    public String getFileUploadServerUrl() {
        return fileUploadServerUrl;
    }

    public String getFileRelativePath() {
        return fileRelativePath;
    }

    public String getFileAbsolutePath() {
        return fileAbsolutePath;
    }

    public String getHelpDocRelativePath() {
        return helpDocRelativePath;
    }

    public String getPayeeRelativePath() {
        return payeeRelativePath;
    }


}
