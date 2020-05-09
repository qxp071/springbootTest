package cn.example.mp.test.vo;

/**
 * @author: xianpei.qin
 * @create: 2020-04-12 12:46
 **/
public class AuthorizedVo {

    private String authorType;

    private String authorNum;

    private String authorizedURL;

    private AuthorizedFileVo authorizedFile;

    public String getAuthorType() {
        return authorType;
    }

    public void setAuthorType(String authorType) {
        this.authorType = authorType;
    }

    public String getAuthorNum() {
        return authorNum;
    }

    public void setAuthorNum(String authorNum) {
        this.authorNum = authorNum;
    }

    public String getAuthorizedURL() {
        return authorizedURL;
    }

    public void setAuthorizedURL(String authorizedURL) {
        this.authorizedURL = authorizedURL;
    }

    public AuthorizedFileVo getAuthorizedFile() {
        return authorizedFile;
    }

    public void setAuthorizedFile(AuthorizedFileVo authorizedFile) {
        this.authorizedFile = authorizedFile;
    }
}