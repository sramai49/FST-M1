package RestAssuredProject;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GitHubAPITest {

    String keyValue = "";
    int keyId;
    String baseURI = "https://api.github.com";
    String path = "/user/keys";
    String accessToken = "Bearer ghp_k8VM9NJLun2jfiq3OC9FbMGviaTQyq3f....";
    String apiVersion = "2022-11-28";
    RequestSpecification requestSpec;

    @BeforeClass
    public void setup()
    {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.addHeader("Authorization",accessToken)
                .addHeader("x-GitHub-Api-Version",apiVersion)
                .setBaseUri(baseURI)
                .setAccept("application/vnd.github+json")
                .setContentType(ContentType.JSON);
        requestSpec = RestAssured.given().spec(requestSpecBuilder.build());

    }
    @Test(priority = 1)
    public void createSSHKey()
    {

        JSONObject requestParams = new JSONObject();
        requestParams.put("title", "asthaPers");
        requestParams.put("key", keyValue);
        requestSpec.body(requestParams);

        Response response = requestSpec.post(path);
        Reporter.log(response.prettyPrint());
        Assert.assertEquals(response.statusCode(), 201);
        Reporter.log("Key created successfully");

        keyId = response.getBody().jsonPath().getInt("id");

    }

    @Test(priority = 2)
    public void getSSHKey()
    {
        Response response = requestSpec.get(path + "/" +keyId);
        Reporter.log(response.prettyPrint());
        Assert.assertEquals(response.statusCode(), 200);
        Reporter.log("Key retrieved successfully");
    }

    @Test(priority = 3)
    public void deleteSSHKey()
    {
        Response response = requestSpec.delete(path + "/" + keyId);
        Reporter.log(response.prettyPrint());
        Assert.assertEquals(response.statusCode(), 204);
        Reporter.log("Key deleted successfully");
    }

}
