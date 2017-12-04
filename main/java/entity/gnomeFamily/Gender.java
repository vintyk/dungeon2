package entity.gnomeFamily;

public enum Gender {
    MALE("Гном"), FEMALE("Гномиха");
    private String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
}
