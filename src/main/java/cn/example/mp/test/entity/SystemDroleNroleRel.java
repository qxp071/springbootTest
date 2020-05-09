package cn.example.mp.test.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author xianpei.qin
 * @since 2020-04-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SystemDroleNroleRel extends Model<SystemDroleNroleRel> {

    private static final long serialVersionUID=1L;

    /**
     * 关联Id
     */
    @TableId(value = "REL_ID", type = IdType.AUTO)
    private String relId;

    /**
     * 南方电网Id
     */
    private String nroleId;

    /**
     * 东华角色Id
     */
    private String droleId;

    /**
     * 菜单名
     */
    private String roleName;

    /**
     * 菜单级别
     */
    private String roleclassifyid;


    @Override
    protected Serializable pkVal() {
        return this.relId;
    }

}
