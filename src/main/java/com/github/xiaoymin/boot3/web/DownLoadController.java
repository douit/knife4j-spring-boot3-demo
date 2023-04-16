/*
 * Copy right © 2022 浙江力石科技股份有限公司 All Rights Reserved.
 * Official Web Site: http://lishiots.com
 */
package com.github.xiaoymin.boot3.web;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.extra.servlet.JakartaServletUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @since:knife4j-springdoc-openapi-demo
 * @auth <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2022/8/6 17:18
 */
@RestController
@RequestMapping("download")
@Tag(name = "文件下载")
public class DownLoadController {


    @Operation(summary = "图片预览" )
    @GetMapping(value = "/image",produces = "image/jpg")
    public void image(HttpServletResponse response) throws IOException {
        //创建临时文件
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(150, 40, 4, 80);
        response.addHeader("Content-Type",MediaType.IMAGE_PNG_VALUE);
        lineCaptcha.write(response.getOutputStream());
    }




    @Operation(summary = "下载txt文件" )
    @GetMapping(value = "/text" )
    public void text(HttpServletResponse response) throws IOException {
        //创建临时文件
        File tmpFile=File.createTempFile(RandomUtil.randomString(5),".txt");
        try{
            FileUtil.writeString(RandomUtil.randomString(128),tmpFile, StandardCharsets.UTF_8.name());
            //响应流
            response.addHeader("Content-Type", MediaType.TEXT_PLAIN_VALUE);
            JakartaServletUtil.write(response,tmpFile);
        }finally {
            FileUtil.del(tmpFile);
        }
    }


    @Operation(summary = "下载excel文件" )
    @GetMapping(value = "/xlsx" )
    public void pdf(HttpServletResponse response) throws IOException {
        //创建临时文件
        File tmpFile=new File("/Users/xiaoyumin/Downloads/test/test1.docx");
        try{
            //响应流
            JakartaServletUtil.write(response,tmpFile);
        }finally {
            //FileUtil.del(tmpFile);
        }
    }
}
