package entity;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class BaseEvil {
    protected Long id;
    protected String name;
    protected Long helth;

    public BaseEvil(Long id, String name, Long helth) {
        this.id = id;
        this.name = name;
        this.helth = helth;
    }

    //    public Long getId() {
//        return id;
//    }
}
