package cn.example.mp.test.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 机构表
 * </p>
 *
 * @author qin
 * @since 2020-03-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SystemOrg extends Model<SystemOrg> {

    private static final long serialVersionUID=1L;

    /**
     * id
     */
    private String id;

    /**
     * 内部机构代码
     */
    private String orgId;

    /**
     * 机构名称
     */
    private String orgName;

    /**
     * 上级机构
     */
    private String uporg;

    /**
     * 机构所在地区代码
     */
    private String areaCode;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 邮政编码
     */
    private String postCode;

    /**
     * 联系人
     */
    private String linkMan;

    /**
     * 联系方式
     */
    private String linkMode;

    /**
     * 其他联系方式
     */
    private String otherLinkMode;

    /**
     * 说明
     */
    private String remark;

    /**
     * 启停标志:1:停用,0:启用 用于数据是否有效
     */
    private String recordStopFlag;

    /**
     * 启停时间
     */
    private LocalDateTime recordStopTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 操作员
     */
    private String operator;

    /**
     * 操作员的昵称
     */
    private String oprNickname;

    /**
     * 是否是法人机构:0:非法人机构，1:法人机构
     */
    private String corporateFlag;

    /**
     * 法人机构的id
     */
    private String corporateId;

    /**
     * 扩展字段1
     */
    private String ext1;

    /**
     * 扩展字段2
     */
    private String ext2;

    /**
     * 扩展字段3
     */
    private String ext3;

    /**
     * 扩展字段4
     */
    private String ext4;

    /**
     * 扩展字段5
     */
    private String ext5;

    /**
     * 扩展字段6
     */
    private String ext6;

    /**
     * 扩展字段7
     */
    private String ext7;

    /**
     * 扩展字段8
     */
    private String ext8;

    /**
     * 扩展字段9
     */
    private String ext9;

    /**
     * 扩展字段10
     */
    private String ext10;

    /**
     * 扩展字段11
     */
    private String ext11;

    /**
     * 扩展字段12
     */
    private String ext12;

    /**
     * 扩展字段13
     */
    private String ext13;

    /**
     * 扩展字段14
     */
    private String ext14;

    /**
     * 扩展字段15
     */
    private String ext15;

    /**
     * 扩展字段16
     */
    private String ext16;

    /**
     * 扩展字段17
     */
    private String ext17;

    /**
     * 扩展字段18
     */
    private String ext18;

    /**
     * 扩展字段19
     */
    private String ext19;

    /**
     * 扩展字段20
     */
    private String ext20;

    /**
     * 扩展字段21
     */
    private String ext21;

    /**
     * 扩展字段22
     */
    private String ext22;

    /**
     * 扩展字段23
     */
    private String ext23;

    /**
     * 扩展字段24
     */
    private String ext24;

    /**
     * 扩展字段25
     */
    private String ext25;

    /**
     * 扩展字段26
     */
    private String ext26;

    /**
     * 扩展字段27
     */
    private String ext27;

    /**
     * 扩展字段28
     */
    private String ext28;

    /**
     * 扩展字段29
     */
    private String ext29;

    /**
     * 扩展字段30
     */
    private String ext30;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
