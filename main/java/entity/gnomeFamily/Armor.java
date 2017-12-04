package entity.gnomeFamily;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class Armor {
    private Long id;
    private Long absorbDamage;
    private Long weight;
    private TypeArmor typeArmor;
    private String typeArmorStr;

    public Armor(Long id, Long absorbDamage, Long weight, TypeArmor typeArmor) {
        this.id = id;
        this.absorbDamage = absorbDamage;
        this.weight = weight;
        this.typeArmor = typeArmor;
    }

    public Armor(Long id, Long absorbDamage, Long weight, String typeArmorStr) {
        this.id = id;
        this.absorbDamage = absorbDamage;
        this.weight = weight;
        this.typeArmorStr = typeArmorStr;
    }
}
