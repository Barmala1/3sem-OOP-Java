public class Animal {
    public static final String KINGDOM = "Animalia";
    public static boolean needsOxygen = true;
    public static boolean isMulticellular = true;

    private String name;
    private int age;
    private String habitat;

    public Animal(String name, int age, String habitat) {
        setName(name);
        setAge(age);
        setHabitat(habitat);
    }

    public String getName() {return name; }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Имя должно быть непустой строкой");
        }
        this.name = name;
    }

    public int getAge() {return age; }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст должен быть неотрицательный");
        }
        this.age = age;
    }

    public String getHabitat() {return habitat; }

    public void setHabitat(String habitat) {
        if (habitat == null) {
            throw new IllegalArgumentException("Среда должны быть непустой строкой");
        }
        this.habitat = habitat;
    }

    public String breathe() {
        return name + " дышит кислородом.";
    }

    public String move() {
        return name + " перемещается.";
    }

    public String describe() {
        return name + " представитель царства " + KINGDOM
        + ", возраст " + age + ", среда обитания " + habitat + '.';
    }
}