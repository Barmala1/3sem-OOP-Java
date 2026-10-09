public class AquariumFish extends Fish {
    public static boolean livesInTank = true;
    public static boolean needsAerator = true;
    public static String defaultWaterType = "freshwater";

    private int tankSize; // объем аквариума, л
    private String waterType; // тип воды
    private String temperament; // характер

    public AquariumFish(String name, int age, String species,
                        int depthMin, int depthMax, int weight,
                        int tankSize, String waterType, String temperament) {
    super(name, age, "аквариум", species, depthMin, depthMax, weight);
    setTankSize(tankSize);
    setWaterType(waterType);
    setTemperament(temperament);
    }

    public int getTankSize() { return tankSize; }

    public void setTankSize(int tankSize) {
        if (tankSize <= 0) {
            throw new IllegalArgumentException("Объем сосуда должен быть положительным");
        }
        this.tankSize = tankSize;
    }

    public String getWaterType() { return waterType; }

    public void setWaterType(String waterType) {
        if (waterType == null || !(waterType.equals("пресная")
                            || waterType.equals("солёная")
                            || waterType.equals("загрязнённая"))) {
            throw new IllegalArgumentException("тип воды должен быть: пресная, солёная, загрязнённая");
        }
        this.waterType = waterType;
    }

    public String getTemperament() { return temperament; }

    public void setTemperament(String temperament) {
        if (temperament == null || !(temperament.equals("мирная")
                                || temperament.equals("агрессивная"))) {
            throw new IllegalArgumentException("Характер должен быть: мирная или агрессивная");
        }
        this.temperament = temperament;
    }

    public String feed(String food) {
        return getName() + " съедает " + food;
    }

    public String cleanTank() {
        return "Чистка завершена";
    }

    public String checkCompatibility(AquariumFish other) {
        if (other == null)
            return "Совместимость можно проверить только с другой аквариумной рыбой.";
        if (temperament.equals("агрессивная") || other.temperament.equals("агрессивная"))
            return getName() + " и " + other.getName() + " НЕ совместимы.";
        return getName() + " и " + other.getName() + " совместимы.";
    }

    @Override public String describe() {
        return super.describe()
                + "  Аквариум: " + tankSize + " л, вода: " + waterType
                + ", характер: " + temperament + ".";
    }
}