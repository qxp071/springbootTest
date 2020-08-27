package cn.example.mp.test.web.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserSalt() {
        return userSalt;
    }

    public void setUserSalt(String userSalt) {
        this.userSalt = userSalt;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getWeichat() {
        return weichat;
    }

    public void setWeichat(String weichat) {
        this.weichat = weichat;
    }

    public String getOrgPhone() {
        return orgPhone;
    }

    public void setOrgPhone(String orgPhone) {
        this.orgPhone = orgPhone;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public LocalDateTime getPwdUpdateTime() {
        return pwdUpdateTime;
    }

    public void setPwdUpdateTime(LocalDateTime pwdUpdateTime) {
        this.pwdUpdateTime = pwdUpdateTime;
    }

    public String getResetFlag() {
        return resetFlag;
    }

    public void setResetFlag(String resetFlag) {
        this.resetFlag = resetFlag;
    }

    public String getStopFlag() {
        return stopFlag;
    }

    public void setStopFlag(String stopFlag) {
        this.stopFlag = stopFlag;
    }

    public LocalDateTime getStopTime() {
        return stopTime;
    }

    public void setStopTime(LocalDateTime stopTime) {
        this.stopTime = stopTime;
    }

    public String getStopReason() {
        return stopReason;
    }

    public void setStopReason(String stopReason) {
        this.stopReason = stopReason;
    }

    public String getLockFlag() {
        return lockFlag;
    }

    public void setLockFlag(String lockFlag) {
        this.lockFlag = lockFlag;
    }

    public String getShortcutFlag() {
        return shortcutFlag;
    }

    public void setShortcutFlag(String shortcutFlag) {
        this.shortcutFlag = shortcutFlag;
    }

    public String getIpBindFlag() {
        return ipBindFlag;
    }

    public void setIpBindFlag(String ipBindFlag) {
        this.ipBindFlag = ipBindFlag;
    }

    public String getMacBindFlag() {
        return macBindFlag;
    }

    public void setMacBindFlag(String macBindFlag) {
        this.macBindFlag = macBindFlag;
    }

    public String getIpBindNum() {
        return ipBindNum;
    }

    public void setIpBindNum(String ipBindNum) {
        this.ipBindNum = ipBindNum;
    }

    public String getMacBindNum() {
        return macBindNum;
    }

    public void setMacBindNum(String macBindNum) {
        this.macBindNum = macBindNum;
    }

    public String getRoleNames() {
        return roleNames;
    }

    public void setRoleNames(String roleNames) {
        this.roleNames = roleNames;
    }

    public String getCreateUsername() {
        return createUsername;
    }

    public void setCreateUsername(String createUsername) {
        this.createUsername = createUsername;
    }

    public String getCreateNickname() {
        return createNickname;
    }

    public void setCreateNickname(String createNickname) {
        this.createNickname = createNickname;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUsername() {
        return updateUsername;
    }

    public void setUpdateUsername(String updateUsername) {
        this.updateUsername = updateUsername;
    }

    public String getUpdateNickname() {
        return updateNickname;
    }

    public void setUpdateNickname(String updateNickname) {
        this.updateNickname = updateNickname;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getUserDesc1() {
        return userDesc1;
    }

    public void setUserDesc1(String userDesc1) {
        this.userDesc1 = userDesc1;
    }

    public String getUserDesc2() {
        return userDesc2;
    }

    public void setUserDesc2(String userDesc2) {
        this.userDesc2 = userDesc2;
    }

    public String getUserDesc3() {
        return userDesc3;
    }

    public void setUserDesc3(String userDesc3) {
        this.userDesc3 = userDesc3;
    }

    public String getUserDesc4() {
        return userDesc4;
    }

    public void setUserDesc4(String userDesc4) {
        this.userDesc4 = userDesc4;
    }

    public String getUserDesc5() {
        return userDesc5;
    }

    public void setUserDesc5(String userDesc5) {
        this.userDesc5 = userDesc5;
    }

    public String getUserDesc6() {
        return userDesc6;
    }

    public void setUserDesc6(String userDesc6) {
        this.userDesc6 = userDesc6;
    }

    public String getExt1() {
        return ext1;
    }

    public void setExt1(String ext1) {
        this.ext1 = ext1;
    }

    public String getExt2() {
        return ext2;
    }

    public void setExt2(String ext2) {
        this.ext2 = ext2;
    }

    public String getExt3() {
        return ext3;
    }

    public void setExt3(String ext3) {
        this.ext3 = ext3;
    }

    public String getExt4() {
        return ext4;
    }

    public void setExt4(String ext4) {
        this.ext4 = ext4;
    }

    public String getExt5() {
        return ext5;
    }

    public void setExt5(String ext5) {
        this.ext5 = ext5;
    }

    public String getExt6() {
        return ext6;
    }

    public void setExt6(String ext6) {
        this.ext6 = ext6;
    }

    public String getExt7() {
        return ext7;
    }

    public void setExt7(String ext7) {
        this.ext7 = ext7;
    }

    public String getExt8() {
        return ext8;
    }

    public void setExt8(String ext8) {
        this.ext8 = ext8;
    }

    public String getExt9() {
        return ext9;
    }

    public void setExt9(String ext9) {
        this.ext9 = ext9;
    }

    public String getExt10() {
        return ext10;
    }

    public void setExt10(String ext10) {
        this.ext10 = ext10;
    }

    public String getExt11() {
        return ext11;
    }

    public void setExt11(String ext11) {
        this.ext11 = ext11;
    }

    public String getExt12() {
        return ext12;
    }

    public void setExt12(String ext12) {
        this.ext12 = ext12;
    }

    public String getExt13() {
        return ext13;
    }

    public void setExt13(String ext13) {
        this.ext13 = ext13;
    }

    public String getExt14() {
        return ext14;
    }

    public void setExt14(String ext14) {
        this.ext14 = ext14;
    }

    public String getExt15() {
        return ext15;
    }

    public void setExt15(String ext15) {
        this.ext15 = ext15;
    }

    public String getExt16() {
        return ext16;
    }

    public void setExt16(String ext16) {
        this.ext16 = ext16;
    }

    public String getExt17() {
        return ext17;
    }

    public void setExt17(String ext17) {
        this.ext17 = ext17;
    }

    public String getExt18() {
        return ext18;
    }

    public void setExt18(String ext18) {
        this.ext18 = ext18;
    }

    public String getExt19() {
        return ext19;
    }

    public void setExt19(String ext19) {
        this.ext19 = ext19;
    }

    public String getExt20() {
        return ext20;
    }

    public void setExt20(String ext20) {
        this.ext20 = ext20;
    }

    public String getExt21() {
        return ext21;
    }

    public void setExt21(String ext21) {
        this.ext21 = ext21;
    }

    public String getExt22() {
        return ext22;
    }

    public void setExt22(String ext22) {
        this.ext22 = ext22;
    }

    public String getExt23() {
        return ext23;
    }

    public void setExt23(String ext23) {
        this.ext23 = ext23;
    }

    public String getExt24() {
        return ext24;
    }

    public void setExt24(String ext24) {
        this.ext24 = ext24;
    }

    public String getExt25() {
        return ext25;
    }

    public void setExt25(String ext25) {
        this.ext25 = ext25;
    }

    public String getExt26() {
        return ext26;
    }

    public void setExt26(String ext26) {
        this.ext26 = ext26;
    }

    public String getExt27() {
        return ext27;
    }

    public void setExt27(String ext27) {
        this.ext27 = ext27;
    }

    public String getExt28() {
        return ext28;
    }

    public void setExt28(String ext28) {
        this.ext28 = ext28;
    }

    public String getExt29() {
        return ext29;
    }

    public void setExt29(String ext29) {
        this.ext29 = ext29;
    }

    public String getExt30() {
        return ext30;
    }

    public void setExt30(String ext30) {
        this.ext30 = ext30;
    }
}
