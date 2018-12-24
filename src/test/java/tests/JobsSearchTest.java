package tests;

import model.Job;
import model.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.JobDetailsPage;
import page.JobsPage;
import page.SignInPage;
import page.TopBarComponent;
import tests.common.TestBase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class JobsSearchTest extends TestBase {
    private static final String NO_JOBS_MSG = "No jobs found";
    private User user;
    private Job job;

    TopBarComponent topBarComponent;
    SignInPage signInPage;
    JobsPage jobsPage;

    @BeforeMethod
    public void setUp() {
        user = User.builder()
                .email("test@ubaranqa.pl")
                .password("i90FGpLGfj@6")
                .build();

        job = job.builder()
                .skillSet("Creative Director")
                .location("Remote")
                .build();

        signInPage = new SignInPage(getDriver(), getConfig().getBaseUrl() + "/session/new");
        signInPage.setLogin(user.getEmail())
                .setPassword(user.getPassword())
                .clickSignIn();
    }

    @Test
    public void testSearchForARemoteJob() {
        jobsPage = new JobsPage(getDriver(), getConfig().getBaseUrl() + "/jobs")
        .searchForAJob(job);
        if (jobsPage.getJobsList().size() == 0) {
            assertEquals(jobsPage.getNoJobsMsg().getText(), NO_JOBS_MSG);
        }
        jobsPage.viewJobDetails();
        assertTrue(new JobDetailsPage(getDriver())
                .getTagsList().get(0).getText().contains("Remote"));
    }
}
