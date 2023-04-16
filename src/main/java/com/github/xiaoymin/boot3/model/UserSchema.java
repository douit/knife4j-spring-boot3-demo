/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.github.xiaoymin.boot3.model;

import io.swagger.v3.oas.annotations.media.Schema;

/***
 *
 * @since:knife4j-springdoc-openapi-demo 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2020/03/15 20:53
 */
@Schema(description = "用户信息")
public class UserSchema {

    @Schema(description = "主键id",defaultValue = "1",title = "注解id-title")
    private String id;

    @Schema(description = "名称",defaultValue = "张飞")
    private String name;

    @Schema(description = "part实体信息")
    private PartSchema partSchema;

    public PartSchema getPartSchema() {
        return partSchema;
    }

    public void setPartSchema(PartSchema partSchema) {
        this.partSchema = partSchema;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
