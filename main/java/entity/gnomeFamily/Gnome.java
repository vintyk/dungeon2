package entity.gnomeFamily;

import entity.BaseEvil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Gnome extends BaseEvil {
    private Gender gender;
    private Armor armor;
}
