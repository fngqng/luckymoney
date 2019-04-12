package com.fq.luckymoney.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
/**
 * @Author:fngqng1211@gmail.com
 * @Created:2019/4/11 16:25
 **/
/**
 * swagger配置信息
 */
@Component
@ConfigurationProperties(prefix = "swagger")
public class SwaggerInfo {
    /**
     * 分组名称
     */
    private String groupName="controller";
    /**
     * 根据包选择接口
     */
    private String basePackage;
    /**
     * 根据路径选择接口
     */
    private String antPath;
    /**
     * 文档标题
     */
    private String title="项目API文档";
    /**
     * 文档描述
     */
    private String description;
    /**
     * 许可人
     */
    private String license;
    /**
     * url
     */
    private String licenseUrl;
    /**
     * 项目服务器地址
     */
    private String serviceUrl;
    /**
     * 项目版本
     */
    private String version;

    public SwaggerInfo() {
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public String getAntPath() {
        return antPath;
    }

    public void setAntPath(String antPath) {
        this.antPath = antPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getLicenseUrl() {
        return licenseUrl;
    }

    public void setLicenseUrl(String licenseUrl) {
        this.licenseUrl = licenseUrl;
    }
}
