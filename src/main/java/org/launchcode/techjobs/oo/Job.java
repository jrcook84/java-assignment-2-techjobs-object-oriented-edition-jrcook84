package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job extends JobField {
    public Job(String value) {
        super(value);
    }
    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;



    public Job () {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location,
               PositionType positionType,CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;


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
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        String employerDisplay = this.getEmployer().getValue();
        String locationDisplay = this.getLocation().getValue();
        String positionTypeDisplay = this.getPositionType().getValue();
        String coreCompetencyDisplay = this.getCoreCompetency().getValue();
        String nameDisplay = this.name;
        if(nameDisplay.equals("")){
           nameDisplay ="Data not available";
       }
        if(employerDisplay.equals("")){
            employerDisplay = "Data not available";
        }
        if(locationDisplay.equals("")){
            locationDisplay = "Data not available";
        }
        if(coreCompetencyDisplay.equals("")){
            coreCompetencyDisplay = "Data not available";
        }
        if(positionTypeDisplay.equals("")){
            positionTypeDisplay = "Data not available";
        }

        return
                "\n"+
                "ID: " + id +"\n"+
                "Name: " + nameDisplay + "\n" +
                "Employer: " + employerDisplay +"\n"+
                "Location: " + locationDisplay + "\n"+
                "Position Type: " + positionTypeDisplay + "\n"+
                "Core Competency: " + coreCompetencyDisplay + "\n"
                ;


    }


}
