import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Area
 * @Description TODO
 * @Author hou
 * @Date 2020/7/24 11:27 上午
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Area {
    private String id;
    private String parentId;
    private String name;
    private String code;
    private String province;
    private String city;
    private String district;
}