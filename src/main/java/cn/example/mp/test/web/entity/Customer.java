package cn.example.mp.test.web.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
 * 
 * </p>
 *
 * @author xianpei.qin
 * @since 2021-01-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_customer")
public class Customer extends Model<Customer> {

    private static final long serialVersionUID=1L;

    private Long id;

    private String userName;

    private String userPassword;

    private LocalDateTime birth;

    private String sex;

    private String email;

    private String mobile;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    private String description;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
