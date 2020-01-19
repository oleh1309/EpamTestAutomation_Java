package epam.task_2.plant_properties;

public enum Color {

    COLOR_YELLOW("Yellow"),
    COLOR_RED("Red"),
    COLOR_GREEN("Green");

    private String code;

    Color(String code){
        this.code = code;
    }

    public String getCode(){ return code;}

}
