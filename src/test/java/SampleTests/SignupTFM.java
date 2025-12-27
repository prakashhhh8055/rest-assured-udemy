package SampleTests;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class SignupTFM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI="https://api.trulyfreehome.dev";
		given().headers("Content-Type","application/json","authorization","Bearer eyJhbGciOiJSU0EtT0FFUCIsImN0eSI6IkpXVCIsImVuYyI6IkExMjhHQ00iLCJ0eXAiOiJKV1QifQ.IEjm4yWLYei3jBTCfb2Vs4btzKtShk-Gq4ny1UnZ2Fy-KCs8U184Hz9SCAiSGPoJ8zmYuJza3aUDA1rxU4jhr1tDhg1FDN99WBTZOSGIdB06g_q0C2j9UZqIlZ6X5Df5VbuUzLGBk8pT3VRJR_G8Bi6o3SahuUb_cfR4ryCxhBg.7bibbSrCKPraPmXU.co0qrcrqkHu3-ywwvg6LcNuiofsTGG7j8LQxKFvHzUvnaFTjDX77bzaTuvAWIHl1ZwccNuK63xMaOpjayivlq4av6n7j1EEZGnuOX8ykIs3HrIXhq7hiJkZpbiuU830nzSOf3pq-t5RS_FPUopaTUhQHV4xDSaYt4fmkxeri7Dafb2QX8ZFhJCeVhnqw4o--RFy3BE4ux3bgu7TuXrycYTmw5KnFliW7unOgl-FyZ2cWohAz6qFytE_zobwdw3yIBrOTZ22NKa7ja67ur8OAwFfD0LPK9rRzPjCDDsN648-qiC6lL5PZLjOkG7UXOfOr3B_Am8FtCun0mSiiWO8v3ufJsYGWDspIF1zFM95LndRzdrQH8F5qiQ_CWcKS9j-UHMtUFjgAMzBjZE12ghNyjiuyEc_j2q-V1HCOSvZZin9XWQAtmMCSG-HyMG9oOXYFn83L17GpoafVvmjomAHuh2UkB23czyvs2WAvJh8QBYH3y8eLWq2t_x6UHRMW6TfuqwWmPZheB1VLUIq0vmoRhmudZCGlFdlnWs5GpEmU950urlQTBQ0bZQc21Y-qfmATan2coNDF3fZj3rAgEr7xdk-dA4VIP5lBiIiUu1d53zRmuRYS5Gk-m1dY7-y5UkacFIuVK-Oh8s8jIGfFsuv_poZWYNMPzqQJ7EUBX6tXKzxYE2S3f-0F8uL9f_UsknAZy8ec2qHTNt6EhKOJKEdQjbM-7Ylc706rIF-KY1BTvcg5rzr6RC95Pl67H8qIl1MW48iPcZNqIpFMo-zOhTQLevGsIkleJckO3RFWVeGoWWqNZ4pyqYqvWAZ9oy-TTxDHvxjuF1KCVoIJCaTa4M8KNAPI8qLM7B5Lrqyzp2HaK3_5HMmFRh-0hOoBloj6l2aXZVgNscCf0sa6ltJyhRjpbFPZVsYxhSYXRfeBzQ-5YRg8wdyNBCv4RivMY0RQtcXZRU0TX5NVnPF0k9elM3be8fzvx6Vfw3KVWP0m4OS_OnlYBHLSM4hC94l7nfO1jfu9gDHL-O0GjgrdeD1b9wC15gpb6pBxC5HGY4CypDnSIWFdDSPmeR1uWrGSFUEwqRvianFTwjm4RWU6yeIxmqBSYEusFfPQu9NCtH8vHdOlB6RIeDDJQQG38L59JyhT_rTQLAx0IaNRX5_VKANM1S7T9H7Y9V7hm2i24xkQGcrXYpiSTxNStjRjue9G3m8ZYL2TLM1_Lq2tLEuildM6k6M6LYgyGjkTbOyfjGwdA2tzPok3C2XJgo1u9AJrv_T_ow1Q5PfBgfGcYmm6AP40Wl-wzNVcuh0grxzASBpHdARKgpEhFsDPfqcWpaJczfecO3_1g5nUpjrRRHLuSMO_l1dNNPjQvKQD4DpQZO5BgllvkZsX4A4lUJhrrUzomXVEffSFFVRxdQTaTYNr115lhVkSllQJ2upGTClPyhy106mDhAcljEzVELSDT3ggZ1aRwtime5BBoqhI20h83-tqYbJ50Q83LZ_gkhx_XRKMBw1fjNXw5ZAGWU1dHhf7Y4BR1pzHAp-_1FYQ5PaoH7XPk4pHtPMFCFuYGss_KCDvPx7Dv4PB9v9OH6ATlq1FEq2oPpheTRCcKEBcaBVbTgywtiH-V2SvE4F5DjYdwfcTMBg5WhSvWTaR3mEReHhwiBH1NSVJ6CgCHouH8rmFffzfR44ODAnVruoq9oNMc_bCgWYI8_w_Zbr43ALgF3BA_g41jNJGTh9zdnwBnU96LvCvT8zSC0kdyj8wzEQ.9kvW07y4AYWojPyOwzKKJw").body("{\r\n"
				+ "    \"deviceId\": \"5e9e6f103229bd77766c0886e6f8024f_1743764138302\",\r\n"
				+ "    \"appVersion\": \"142.0.0.0\",\r\n"
				+ "    \"deviceMake\": \"Chrome\",\r\n"
				+ "    \"deviceModel\": \"142.0.0.0\",\r\n"
				+ "    \"deviceOsVersion\": \"Windows-10\",\r\n"
				+ "    \"deviceType\": 3,\r\n"
				+ "    \"deviceTime\": \"2025-12-07 12:12:50\",\r\n"
				+ "    \"termsAndCond\": 1,\r\n"
				+ "    \"ipAddress\": \"2401:4900:8813:cbcc:e1d7:ac0e:c17c:414b\",\r\n"
				+ "    \"latitude\": 0,\r\n"
				+ "    \"longitude\": 0,\r\n"
				+ "    \"city\": \"\",\r\n"
				+ "    \"country\": \"\",\r\n"
				+ "    \"countryCode\": \"+1\",\r\n"
				+ "    \"sortCountryCode\": \"us\",\r\n"
				+ "    \"mobile\": \"2025378901\",\r\n"
				+ "    \"email\": \"humankind1999@topmail.com\",\r\n"
				+ "    \"firstName\": \"Rehmaan\",\r\n"
				+ "    \"password\": \"Jackie@8055\",\r\n"
				+ "    \"lastName\": \"Raaj\",\r\n"
				+ "    \"customerType\": 1,\r\n"
				+ "    \"googleId\": \"\",\r\n"
				+ "    \"facebookId\": \"\",\r\n"
				+ "    \"subSignUpType\": 1,\r\n"
				+ "    \"signUpType\": 1,\r\n"
				+ "    \"userType\": 1,\r\n"
				+ "    \"utm_data\": {},\r\n"
				+ "    \"sourceType\": 0\r\n"
				+ "}")
		.when().post("v1/signUp")
		.then().log().all().assertThat().statusCode(200);

	}

}
