package org.launchcode.controllers;
import java.io.*;
import java.util.*;

import org.launchcode.models.*;
import org.launchcode.models.data.JobFieldData;
import org.launchcode.models.forms.JobForm;
import org.launchcode.models.data.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping(value = "job")
public class JobController {

    private JobData jobData = JobData.getInstance();

    // The detail display for a given Job at URLs like /job?id=17
    @RequestMapping(value = "", method = RequestMethod.GET) //@RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model, int id) {
        // TODO #1 - get the Job with the given ID and pass it into the view

        Job jobById = jobData.findById(id);

        model.addAttribute("jobById",jobById);

        return "job-detail";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(new JobForm());
        return "new-job";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @Valid JobForm jobForm, Errors errors) {//validating and model binding at work.

        // TODO #6 - Validate the JobForm model, and if valid, create a
        // new Job and add it to the jobData data store. Then
        // redirect to the job detail view for the new Job (/job?id=X)


         if (errors.hasErrors()) {//if errors then display the new-job form again.

         return "new-job";//display template.
         }
         else {//if all goes well then proceed to create objects.

        String name1 = jobForm.getName();
        Employer anEmployer = jobData.getEmployers().findById(jobForm.getEmployerId()); //preparing objects for Job constructor to use.
        Location aLocation = jobData.getLocations().findById(jobForm.getLocationId());
        CoreCompetency aCoreCompetency = jobData.getCoreCompetencies().findById(jobForm.getCoreCompetencyId());
        PositionType aPositionType = jobData.getPositionTypes().findById(jobForm.getPositionTypeId());


        Job newJob = new Job(name1 , anEmployer, aLocation, aPositionType, aCoreCompetency);  //Job constructor in use.

        jobData.add(newJob); // create a new Job object and add it to the data layer by calling jobData.add(newJob).

        return "redirect:?id=" + newJob.getId();} //Upon creating a new job, its sent to a screen
        // displaying the data for only the new job. The URL for this new job is of the form /job?id=X
        // where X is the numeric ID of the new job.
    }
}
