package com.mohism.pudding.mp.entity;

    import java.time.LocalDateTime;
    import com.baomidou.ant.common.BaseEntity;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 健康知识信息表 健康知识信息表
    * </p>
*
* @author real earth
* @since 2019-06-18
*/
    @Data
        @EqualsAndHashCode(callSuper = true)
    @Accessors(chain = true)
    public class HycCmsHealthInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

            /**
            * knowledge_title 健康知识标题
            */
    private String knowledgeTitle;

            /**
            * knowledge_cover 健康知识封面图片
            */
    private String knowledgeCover;

            /**
            * key_word 关键词
            */
    private String keyWord;

            /**
            * remark 0:启用,1:禁用
            */
    private Integer remark;

            /**
            * knowledge_content 健康知识内容
            */
    private String knowledgeContent;

            /**
            * apply_range 0:大众用户，1：医生
            */
    private Integer applyRange;

            /**
            * label 慢病标签
            */
    private String label;

            /**
            * summary 健康知识内容摘要
            */
    private String summary;

            /**
            * status 1.提交保存(已保存)  2.发布(已发布)
            */
    private Integer status;

            /**
            * push_time 发布时间
            */
    private LocalDateTime pushTime;

            /**
            * push_user_name 发布人姓名
            */
    private String pushUserName;

            /**
            * push_user_id 发布人id
            */
    private String pushUserId;

            /**
            * overdue_time 过期时间
            */
    private LocalDateTime overdueTime;

            /**
            * fk_platform_id 关联平台
            */
    private String fkPlatformId;

            /**
            * create_by 创建人唯一标识
            */
    private String createBy;

            /**
            * create_time 创建时间
            */
    private LocalDateTime createTime;

            /**
            * update_by 更新人唯一标识
            */
    private String updateBy;

            /**
            * update_time 更新时间
            */
    private LocalDateTime updateTime;


}
