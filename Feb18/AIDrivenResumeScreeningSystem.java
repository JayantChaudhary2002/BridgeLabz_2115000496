import java.util.ArrayList;
import java.util.List;

abstract class JobRole {
    public abstract String getRoleName();
}

class SoftwareEngineer extends JobRole {
    @Override
    public String getRoleName() {
        return "Software Engineer";
    }
}

class DataScientist extends JobRole {
    @Override
    public String getRoleName() {
        return "Data Scientist";
    }
}

class ProductManager extends JobRole {
    @Override
    public String getRoleName() {
        return "Product Manager";
    }
}

class Resume<T extends JobRole> {
    private String candidateName;
    private T jobRole;

    public Resume(String candidateName, T jobRole) {
        this.candidateName = candidateName;
        this.jobRole = jobRole;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public T getJobRole() {
        return jobRole;
    }

    public void displayResume() {
        System.out.println("Candidate Name: " + candidateName);
        System.out.println("Applying for: " + jobRole.getRoleName());
    }
}

class ResumeScreening {

    public void screenResumes(List<? extends JobRole> jobRoles) {
        for (JobRole jobRole : jobRoles) {
            System.out.println("Screening resumes for: " + jobRole.getRoleName());
            
        }
    }
}


public class AIDrivenResumeScreeningSystem {
    public static void main(String[] args) {
        
        Resume<SoftwareEngineer> softwareEngineerResume = new Resume<>("Alice", new SoftwareEngineer());
        Resume<DataScientist> dataScientistResume = new Resume<>("Bob", new DataScientist());
        Resume<ProductManager> productManagerResume = new Resume<>("Charlie", new ProductManager());

        
        softwareEngineerResume.displayResume();
        dataScientistResume.displayResume();
        productManagerResume.displayResume();

        
        List<JobRole> jobRoles = new ArrayList<>();
        jobRoles.add(new SoftwareEngineer());
        jobRoles.add(new DataScientist());
        jobRoles.add(new ProductManager());

        
        ResumeScreening screening = new ResumeScreening();
        screening.screenResumes(jobRoles);
    }
}
