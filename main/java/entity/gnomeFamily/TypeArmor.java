package entity.gnomeFamily;

public enum TypeArmor {
    MITHRIL("Мифрил"), STEEL("Сталь"), IRON("Железо");

    private String typeArmor;

    TypeArmor(String typeArmor) {
        this.typeArmor = typeArmor;
    }

    public String getTypeArmor() {
        return typeArmor;
    }

    public void setTypeArmor(String typeArmor) {
        this.typeArmor = typeArmor;
    }
}
