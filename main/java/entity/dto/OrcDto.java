package entity.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class OrcDto {
    protected Long id;
    protected String name;
    protected Long helth;
    private String color;
    private Long force;

}
