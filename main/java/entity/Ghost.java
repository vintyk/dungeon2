package entity;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class Ghost extends BaseEvil {
    private Long transparency;

    public Ghost(Long transparency) {
        this.transparency = transparency;
    }

    public Ghost(Long id, String name, Long transparency, Long helth) {
        super(id, name, helth);
        this.transparency = transparency;
    }

    @Override
    public String toString() {
        return "Ghost{" +
                "transparency=" + transparency +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", helth=" + helth +
                '}';
    }
}
