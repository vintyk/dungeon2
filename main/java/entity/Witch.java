package entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor

public class Witch extends BaseEvil {
    private Long manna;

    public Witch(Long id, String name, Long manna, Long helth) {
        super(id, name, helth);
        this.manna = manna;

    }

    @Override
    public String toString() {
        return "Witch{" +
                "manna=" + manna +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", helth=" + helth +
                '}';
    }
}
