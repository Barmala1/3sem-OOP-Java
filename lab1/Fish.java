public class Fish extends Animal{
    public static boolean coldBlooded = true;
    public static boolean breathesWithGills = true;
    public static boolean hasFins = true;

    private String species;
    private int depthMin;
    private int depthMax;
    private int weight;

    public Fish(String name, int age, String habitat,
                String species, int depthMin, int depthMax, int weight) {
        super(name, age, habitat);
        setSpecies(species);
        setDepthRange(depthMin, depthMax);
        setWeight(weight);
    }
    
    public String getSpecies() { return species; }

    public void setSpecies(String species) {
        if (species == null) {
            throw new IllegalArgumentException("Вид должен быть непустой строкой");
        }
        this.species = species;
    }

    public int getDepthMin() { return depthMin; }
    public int getDepthMax() { return depthMax; }

    public void setDepthRange(int depthMin, int depthMax) {
        if (depthMin > depthMax) {
            throw new IllegalArgumentException("Минимальная глубина не должна быть ниже максимальной");
        }
        this.depthMin = depthMin;
        this.depthMax = depthMax;
    }

    public int getWeight() { return weight; }

    public void setWeight(int weight) {
        if (weight <= 0) {
            throw new IllegalArgumentException("Вес должен быть положительным");
        }
        this.weight = weight;
    }

    public String swim() {
        return getName() + " плывет на глубине " + depthMin + '-' + depthMax + "м.";
    }

    @Override public String breathe() {
        return getName() + " дышит жабрами, извлекая кислород из воды";
    }

    public String spawn() {
        return getName() + " (вид: " + species + ") откладывает икру.";
    }

    @Override
    public String describe() {
        return super.describe()
                + "\n  Вид: " + species + ", хладнокровная: " + coldBlooded + ".";
    }
}