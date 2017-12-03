package entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class Orc extends BaseEvil {
    private Color color;
    private Long force;

    public Orc(Long id, String name, Long helth, Color color, Long force) {
        super(id, name, helth);
        this.color = color;
        this.force = force;
    }

    @Override
    public String toString() {
        return "Orc{" +
                "color=" + color +
                ", force=" + force +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", helth=" + helth +
                '}';
    }
}
