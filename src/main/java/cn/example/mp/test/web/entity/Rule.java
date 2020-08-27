package cn.example.mp.test.web.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;

/**
 * @author: xianpei.qin
 * @create: 2019-11-26 17:39
 **/
public class Rule extends Model<Rule> {

    private String ruleNo;

    private String ruleName;

    private String ruleDesc;

    private String rulePath;

    public String getRuleNo() {
        return ruleNo;
    }

    public void setRuleNo(String ruleNo) {
        this.ruleNo = ruleNo;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRuleDesc() {
        return ruleDesc;
    }

    public void setRuleDesc(String ruleDesc) {
        this.ruleDesc = ruleDesc;
    }

    public String getRulePath() {
        return rulePath;
    }

    public void setRulePath(String rulePath) {
        this.rulePath = rulePath;
    }
}