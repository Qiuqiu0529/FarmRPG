package Player;

public static class PlayerVisualBuilder {
    HairStyleType hairColor;
    ColorType eyesColor;
    ColorType gender;
    ColorType skin;


    public PlayerVisualBuilder() {
    }

    public PlayerVisualBuilder withHairType(HairType hairType) {
      this.hairType = hairType;
      return this;
    }

    public PlayerVisualBuilder withHairColor(HairColor hairColor) {
      this.hairColor = hairColor;
      return this;
    }

    public PlayerVisualBuilder withArmor(Armor armor) {
      this.armor = armor;
      return this;
    }

    public PlayerVisualBuilder withWeapon(Weapon weapon) {
      this.weapon = weapon;
      return this;
    }

    public PlayerVisual build() {
      return new PlayerVisual(this);
    }
  }
}
