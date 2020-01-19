package epam.task_2.plant_properties;

public enum Type {

    TYPE_SEEDS("Seeds"),
    TYPE_CONIFERS("Conifers");

    private String code;

    Type (String code){
        this.code = code;
    }

    public String getCode(){ return code;}

}
