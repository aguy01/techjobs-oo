package org.launchcode.models.forms;
import java.io.*;
import org.launchcode.models.CoreCompetency;
import org.launchcode.models.Employer;
import org.launchcode.models.Location;
import org.launchcode.models.PositionType;
import org.launchcode.models.data.JobData;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;

/**
 * Created by LaunchCode
 */
public class JobForm {

    @NotNull
    @Size(min=1, message = "Name may not be empty")
    private String name;

    @NotNull
    private int employerId;

    /*
        TODO #3 - Included other fields needed to create a job,
        with correct validation attributes and display names.
        Don't forget to add getters and setters
     */

    //to-do#3 begins adding other fields needed to create a job

    @NotNull
    private int locationId;
    @NotNull
    private int coreCompetencyId;

    @NotNull
    private int positionTypeId;
    //to-do#3 ends adding other fields needed to create a job


    private ArrayList<Employer> employers;
    private ArrayList<Location> locations;
    private ArrayList<CoreCompetency> coreCompetencies;
    private ArrayList<PositionType> positionTypes;

    public JobForm() {

        JobData jobData = JobData.getInstance();

        /*
            TODO #4 - populate the other ArrayList collections needed in the view
        */

        employers = jobData.getEmployers().findAll();// initialize the list of Employer objects

        //to-do#4 begins populating other ArrayList collections needed in the view
        locations = jobData.getLocations().findAll(); // initialize the list of locations objects
        coreCompetencies = jobData.getCoreCompetencies().findAll();// initialize the list of skill objects
        positionTypes = jobData.getPositionTypes().findAll(); // initialize the list of positiontypes objects


        //to-do#4 ends populating other ArrayList collections needed in the view

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployerId() {

        return employerId;
    }

    public void setEmployerId(int employerId) {
        this.employerId = employerId;
    }

    //to-do#3 getters and setters begins
    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public int getCoreCompetencyId() {
        return coreCompetencyId;
    }

    public void setCoreCompetencyId(int coreCompetencyId) {
        this.coreCompetencyId = coreCompetencyId;
    }

    public int getPositionTypeId() {
        return positionTypeId;
    }

    public void setPositionTypeId(int positionTypeId) {
        this.positionTypeId = positionTypeId;
    }
    //to-do#3 getters and setters ends.

    public ArrayList<Employer> getEmployers() {
        return employers;
    }

    public void setEmployers(ArrayList<Employer> employers) {
        this.employers = employers;
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }

    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }

    public ArrayList<CoreCompetency> getCoreCompetencies() {
        return coreCompetencies;
    }

    public void setCoreCompetencies(ArrayList<CoreCompetency> coreCompetencies) {
        this.coreCompetencies = coreCompetencies;
    }

    public ArrayList<PositionType> getPositionTypes() {
        return positionTypes;
    }

    public void setPositionTypes(ArrayList<PositionType> positionTypes) {
        this.positionTypes = positionTypes;
    }
}
