package pojo;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName TestResult
 * @Description TODO
 * @Author hou
 * @Date 2020/5/6 5:01 下午
 * @Version 1.0
 **/
@Data
public class TestResult {
    private String rowKey;
    private Integer month;
    private Date createTime;
    private String seqNum;
    private String bid;
    private Integer status;
    private Integer useTime;
    private String prodInparam;
}

