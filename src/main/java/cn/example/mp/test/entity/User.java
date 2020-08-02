package cn.example.mp.test.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * @Description: TODO
 * @Author: xianpei.qin
 * @Date: 2020/4/29 10:39
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User extends Model<User> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @Size(message = "用户名不能为空")
    private String userName;

    @NotNull(message = "密码不能为空")
    @Length(min = 6,message = "密码长度必须是6位数字")
    private String passWord;

    private String realName;

    private String address;

    private String phone;

    private String state;

    private String rank;

    public User(Integer id, String userName, String passWord) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
