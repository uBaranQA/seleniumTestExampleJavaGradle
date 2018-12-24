package tests;

import model.Bucket;
import model.User;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.*;
import tests.common.TestBase;

import static org.junit.Assert.assertNotNull;

public class InspirationSearchTest extends TestBase {

    private User user;
    private Bucket bucket;

    private HomePage homePage;
    private SignInPage signInPage;
    private TopBarComponent topBarComponent;
    private SingleShotPage singleShotPage;
    private SaveToBucketComponent saveToBucketComponent;
    private BucketsListPage bucketsListPage;

    @BeforeMethod
    public void setUp() {
        user = User.builder()
                .email("test@ubaranqa.pl")
                .password("i90FGpLGfj@6")
                .username("STester")
                .build();

        bucket = Bucket.builder()
                .name("Cajon")
                .description("Cajon-related inspirations")
                .build();

        homePage = new HomePage(getDriver(), getConfig().getBaseUrl());
        topBarComponent = new TopBarComponent(getDriver());

        topBarComponent.clickSignInLink();
        signInPage = new SignInPage(getDriver());
        signInPage.setLogin(user.getEmail())
                .setPassword(user.getPassword())
                .clickSignIn();
    }

    @AfterMethod
    public void tearDown() {
        bucketsListPage
                .clickBucketName();
        new BucketPage(getDriver())
                .deleteBucket();
    }

    @Test
    public void testSearchForAnInspiration() {
        topBarComponent.searchShots(bucket.getName());
        singleShotPage = new SingleShotPage(getDriver());
        singleShotPage.clickSaveShotToBucket();
        saveToBucketComponent = new SaveToBucketComponent(getDriver());
        saveToBucketComponent.createNewBucket(bucket.getName(), bucket.getDescription());
        saveToBucketComponent.saveToBucket(bucket.getName());
        bucketsListPage = new BucketsListPage(getDriver(), getConfig().getBaseUrl() + "/" + user.getUsername() + "/buckets");
        assertNotNull(bucketsListPage.getSavedBucketsNames()
                .stream()
                .filter(a -> a.getText().equals(bucket.getName()))
                .findFirst());
    }
}
