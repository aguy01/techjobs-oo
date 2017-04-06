package org.launchcode.models;

/**
 * Created by LaunchCode
 */
public enum JobFieldType {//enum is a listing type.

    EMPLOYER ("Employer"),//JobFieldType[] fields = JobFieldType.values() -> Employer
    LOCATION ("Location"),
    CORE_COMPETENCY ("Skill"),
    POSITION_TYPE ("Position Type"),
    ALL ("All");

    private final String name;

    JobFieldType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
