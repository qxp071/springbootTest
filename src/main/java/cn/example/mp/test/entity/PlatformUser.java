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
 * 用户表
 * </p>
 *
 * @author qin
 * @since 2020-03-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PlatformUser extends Model<PlatformUser> {

    private static final long serialVersionUID=1L;

    /**
     * 用户Id
     */
    private String userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户姓名
     */
    private String nickName;

    /**
     * 用户密码
     */
    private String userPwd;

    /**
     * 加密因子
     */
    private String userSalt;

    /**
     * 用户类型
     */
    private String userType;

    /**
     * 邮箱
     */
    private String userEmail;

    /**
     * 机构代码
     */
    private String orgId;

    /**
     * 部门代码
     */
    private String deptId;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 手机
     */
    private String mobile;

    /**
     * 电话
     */
    private String telephone;

    /**
     * 微信号
     */
    private String weichat;

    /**
     * 单位电话
     */
    private String orgPhone;

    /**
     * 邮编
     */
    private String postCode;

    /**
     * 地址
     */
    private String address;

    /**
     * 备注
     */
    private String mark;

    /**
     * 密码修改时间
     */
    private LocalDateTime pwdUpdateTime;

    /**
     * 重置标志
     */
    private String resetFlag;

    /**
     * 启停标志
     */
    private String stopFlag;

    /**
     * 启停时间
     */
    private LocalDateTime stopTime;

    /**
     * 停用原因
     */
    private String stopReason;

    /**
     * 锁定标志
     */
    private String lockFlag;

    /**
     * 快捷方式刷新标志
     */
    private String shortcutFlag;

    /**
     * 是否绑定IP
     */
    private String ipBindFlag;

    /**
     * 是否绑定mac
     */
    private String macBindFlag;

    /**
     * 绑定IP个数
     */
    private String ipBindNum;

    /**
     * 绑定mac个数
     */
    private String macBindNum;

    /**
     * 角色名称
     */
    private String roleNames;

    /**
     * 创建用户名
     */
    private String createUsername;

    /**
     * 创建用户名称
     */
    private String createNickname;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改用户名
     */
    private String updateUsername;

    /**
     * 修改用户名称
     */
    private String updateNickname;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 原扩展字段1
     */
    private String userDesc1;

    /**
     * 原扩展字段2
     */
    private String userDesc2;

    /**
     * 原扩展字段3
     */
    private String userDesc3;

    /**
     * 原扩展字段4
     */
    private String userDesc4;

    /**
     * 原扩展字段5
     */
    private String userDesc5;

    /**
     * 原扩展字段6
     */
    private String userDesc6;

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
        return this.userId;
    }

}
