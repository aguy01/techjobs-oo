package org.launchcode.models;

/**
 * Created by LaunchCode
 */
public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;//<--one of the Job Class properties; also a field. Employer employer is now an Object.
    // Also it represents the Employer header of the datafile, a column in Excel file with all employers listed underneath.
    // same goes for 3 fields below.
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    public Job() {//a default constructor.
        id = nextId;
        nextId++;
    }

    public Job(String aName, Employer aEmployer, Location aLocation, //<-- a constructor. a method.
               PositionType aPositionType, CoreCompetency aSkill) {

        this();//calls a default constructor, which is Job() above.

        name = aName; //same as this.name=name. this.name<->aName
        employer = aEmployer;
        location = aLocation;
        positionType = aPositionType;
        coreCompetency = aSkill;

    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public int getId() {

        return id;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Job job = (Job) o;

        return id == job.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
