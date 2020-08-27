package cn.example.mp.test.web.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
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


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getUporg() {
        return uporg;
    }

    public void setUporg(String uporg) {
        this.uporg = uporg;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }

    public String getLinkMode() {
        return linkMode;
    }

    public void setLinkMode(String linkMode) {
        this.linkMode = linkMode;
    }

    public String getOtherLinkMode() {
        return otherLinkMode;
    }

    public void setOtherLinkMode(String otherLinkMode) {
        this.otherLinkMode = otherLinkMode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRecordStopFlag() {
        return recordStopFlag;
    }

    public void setRecordStopFlag(String recordStopFlag) {
        this.recordStopFlag = recordStopFlag;
    }

    public LocalDateTime getRecordStopTime() {
        return recordStopTime;
    }

    public void setRecordStopTime(LocalDateTime recordStopTime) {
        this.recordStopTime = recordStopTime;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOprNickname() {
        return oprNickname;
    }

    public void setOprNickname(String oprNickname) {
        this.oprNickname = oprNickname;
    }

    public String getCorporateFlag() {
        return corporateFlag;
    }

    public void setCorporateFlag(String corporateFlag) {
        this.corporateFlag = corporateFlag;
    }

    public String getCorporateId() {
        return corporateId;
    }

    public void setCorporateId(String corporateId) {
        this.corporateId = corporateId;
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
