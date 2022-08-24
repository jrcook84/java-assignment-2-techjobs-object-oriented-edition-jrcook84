package org.launchcode.techjobs.oo.test;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.Test;
import org.junit.Before;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {




    @Test
/* because of the this() method every new job gets a new id, jobs are compared according to id test checks if jobs have the same id
    instantiated new jobs of the Job type and verifies they are not the same  */
public void testSettingJobId (){
        Job jobOne = new Job();
        Job jobTwo = new Job();
        assertNotEquals(jobOne.getId(),jobTwo.getId());
    }

    @Test
/*verifies that all the fields are set by the constructor does this by instantiating a new Job and comparing the
field to the actual value */
public void testJobConstructorSetsAllFields(){
        Job jobThree = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        assertEquals(jobThree.getName(),"Product tester" );
        assertEquals(jobThree.getEmployer().getValue(),"ACME");
        assertEquals(jobThree.getLocation().getValue(), "Desert");
        assertEquals(jobThree.getPositionType().getValue(), "Quality control");
        assertEquals(jobThree.getCoreCompetency().getValue(), "Persistence");
        assertTrue(jobThree.getName() instanceof String );
        assertTrue(jobThree.getEmployer() instanceof Employer);
        assertTrue(jobThree.getLocation() instanceof Location);
        assertTrue(jobThree.getPositionType() instanceof PositionType);
        assertTrue(jobThree.getCoreCompetency() instanceof CoreCompetency);
    }
    @Test
    /*jobs are equal only if the ids are the same therefore 2 Jobs with the same values arent the same unless they share the same id
    each new job gets a new id so they are different */
    public void testJobsForEquality(){
        Job jobThree = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        Job jobFour = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        assertFalse(jobThree.equals(jobFour));
    }
    @Test
    /*makes sure the tostring starts with new lines for formatting */
    public void testToStringStartsAndEndsWithNewLine() {
        Job jobThree = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        char charStart = jobThree.toString().charAt(0);
        char charLast = jobThree.toString().charAt(jobThree.toString().length() - 1);
        assertEquals(charStart, '\n');
        assertEquals(charLast, '\n');
    }

    @Test
    /*test to make sure the toString isnt all goofy and has the correct data */
    public void testToStringContainsCorrectLabelsAndData() {
        Job jobThree = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        String toStringCheck = "\n"+
                "ID: " +jobThree.getId() +"\n"+
                "Name: " +jobThree.getName() + "\n" +
                "Employer: " + jobThree.getEmployer() +"\n"+
                "Location: " + jobThree.getLocation() + "\n"+
                "Position Type: " + jobThree.getPositionType() + "\n"+
                "Core Competency: " + jobThree.getCoreCompetency() + "\n"
                ;
        assertEquals(toStringCheck, jobThree.toString());
    }
    @Test
    public void testToStringHandlesEmptyField(){
        Job jobThree = new Job("", new Employer("ACME"),
                new Location("Desert"), new PositionType(""),
                new CoreCompetency("Persistence"));
        String toStringCheck = "\n"+
                "ID: " +jobThree.getId() +"\n"+
                "Name: " + "Data not available" + "\n" +
                "Employer: " + jobThree.getEmployer() +"\n"+
                "Location: " + jobThree.getLocation() + "\n"+
                "Position Type: " + "Data not available" + "\n"+
                "Core Competency: " + jobThree.getCoreCompetency() + "\n"
                ;
    assertEquals(toStringCheck, jobThree.toString());
    }












}
