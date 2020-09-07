package cn.example.mp.test.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.context.annotation.Lazy;

/**
 * <p>
 * 
 * </p>
 *
 * @author xianpei.qin
 * @since 2020-09-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
//返回json字段为null不显示
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class TEnum extends Model<TEnum> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("enumType")
    private Integer enumType;

    @TableField("enumName")
    private String enumName;

    //一对多关系
    private List<TEnumValue> enumValueList;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEnumType() {
        return enumType;
    }

    public void setEnumType(Integer enumType) {
        this.enumType = enumType;
    }

    public String getEnumName() {
        return enumName;
    }

    public void setEnumName(String enumName) {
        this.enumName = enumName;
    }

    public List<TEnumValue> getEnumValueList() {
        return enumValueList;
    }

    public void setEnumValueList(List<TEnumValue> enumValueList) {
        this.enumValueList = enumValueList;
    }
}
