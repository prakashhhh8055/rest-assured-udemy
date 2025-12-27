package SampleTests;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TFMSignup {

		    @Test
		    public void createUserSignUp() {

		        // Base URI
		        RestAssured.baseURI = "https://api.trulyfreehome.dev";

		        // Request Body
		        String requestBody = "{\n" +
		                "  \"deviceId\": \"f87ac372f5935b08d4eae62809e1829e_1765513993021\",\n" +
		                "  \"appVersion\": \"143.0.0.0\",\n" +
		                "  \"deviceMake\": \"Chrome\",\n" +
		                "  \"deviceModel\": \"143.0.0.0\",\n" +
		                "  \"deviceOsVersion\": \"Windows-10\",\n" +
		                "  \"deviceType\": 3,\n" +
		                "  \"deviceTime\": \"2025-12-17 11:12:03\",\n" +
		                "  \"termsAndCond\": 1,\n" +
		                "  \"ipAddress\": \"2401:4900:8813:cbcc:213e:760a:f109:401a\",\n" +
		                "  \"latitude\": 0,\n" +
		                "  \"longitude\": 0,\n" +
		                "  \"city\": \"\",\n" +
		                "  \"country\": \"\",\n" +
		                "  \"countryCode\": \"+91\",\n" +
		                "  \"sortCountryCode\": \"in\",\n" +
		                "  \"mobile\": \"9881211212\",\n" +
		                "  \"email\": \"abc1234567890@yopmail.com\",\n" +
		                "  \"firstName\": \"Vamsi\",\n" +
		                "  \"password\": \"\",\n" +
		                "  \"lastName\": \"Raaj\",\n" +
		                "  \"customerType\": 1,\n" +
		                "  \"googleId\": \"\",\n" +
		                "  \"facebookId\": \"\",\n" +
		                "  \"otpCode\": \"1111\",\n" +
		                "  \"otpId\": \"69424015c6f959d87f7e09b4\",\n" +
		                "  \"subSignUpType\": 2,\n" +
		                "  \"signUpType\": 1,\n" +
		                "  \"userType\": 1,\n" +
		                "  \"utm_data\": {},\n" +
		                "  \"sourceType\": 0\n" +
		                "}";

		        // API Call
		        Response response =
		                given()  // -------- GIVEN (Request setup)
		                    .contentType(ContentType.JSON)
		                    .accept(ContentType.JSON)

		                    // Headers
		                    .header("authorization", "Bearer eyJhbGciOiJSU0EtT0FFUCIsImN0eSI6IkpXVCIsImVuYyI6IkExMjhHQ00iLCJ0eXAiOiJKV1QifQ.RXK2aqz-VekNXMtYF-n0DA3fnEFgv9ruLZ-IjAksatrSiClot15ncL0si1WJauAk47RY81g2Smgv_uvq-tlZQNw1S8dV6NCS-jqN7VngBh7K1nQKRvRXJUH7Vu6kT1095yeyTRgxPeF1ECzQKz3j0b5LszAvfjPQL-r4rOv-p9c.L19BsyRqzn_qvAhe.I5z4Boe0vL1l7elXJMSgAJ5BKlBooMxkcKd2dnO67iaWmSczWp10w1iRf1a8qxLwA1H2uck-BuS7LdosjgHqPZW0lgYAB9BdmxY_mSlSUgYrUiRHGT2SNKkPf5jlMYzGC30NWMexwp4iVw4OfrsJdFm7S-0s1MdIg88_J5XcIHYdlThKWqU8RFz7Lknd_D_CJldcOFnvvnOTw7xds4rD04WZg5mqURq9NIK3ug3fDDnWCsWb1sTPDAxdTHK9nUK9_IqyFkXFO4OUdOPZfVw4rCq8lApGQbXkaN0ODvDZPH3q8FUMCyAzBWTH_7qA8q9hOtbFdag6Lt9agrZvWL7H1jSnFBQCBHIK1Rjp6FbuKEl0i7ZwKWuwS7lYx67mV8O_ALdsWGH0iofbEUpMK7axriFeD2mfFgcLrKYhP-ANYPpsL1xVjbeFG6SqqLbeld1Pe6GkMKz4lzwun1G9VgBotT7Gg5LNsO2oyKTJ68yw_TqS8ukRHUWD8ugpGTOsWy33fpEm1clFNwt7S5ApRrmK2QUx3PhterAUH6Eal6QnVnqCCwrF2n6iEpDHO0sUkXN03mgE8WJMfxD1Via4D4WOeodLBfbxaWoUcDo8XbV4YqjfGUTxuhgbuZT5MEShHdgjpRtLUFgcHgcNHP9Q2JisjAv5f53ZEhcPc6i-_-DRLH4GW0QpASexpcG1E1JuSwIASRNpUk84D48m59oAtEZCPYaHU7HT0G1hwOENwM911CQt35P0Qx3ArtsGM-CEyRo8N3ZhTOAU4DN654dnbOS17BkpmTNqIzHQIOAuHtD7soL0RnozgWwdUgyeZWI2T9CZWyEZQJeFY4voHAk8pLQ1d2VD5_L8D2qMJApMZNw5IDlNf8O4whm5oK9hcl22xZovbCi9Hfr1FtnZybvlnXY9QueIBzKFVsvjIFHZ_0bzHOs9Pdwa4ut-SEAS9u2a0vsSh7UHCYNLblomWL8cUSyJC6yclVFsD9YIJEcduaW82dbxji9pPudDYFwB_xubl8i54MrDvSjrr4x9KifdqpnwhFnxAaCpQEiw1iUu6V8AdZ4rZQRDodX_yeHstUMmK6VgN2kPBfnIu-7vosN2PWB7v4Tu0qTs9dPopjHLPZvErBNBHBbRV5XQfaP7xs1vKMOSLhU9A_ARE4PuoljHfCnzh0dzyu9gxDK9jKjts5ShOy2n7ixcSRSeuv_8ZYLYT4peq3-xwg0WI7uIYIwAE_Lt5H1CbTo_nDPS5udUpSgkjGwmDKt7ngNuNAFbIxGutS5EBHdz0UV6ZHZiK93R_qeQoRMI1LNWSfn-vEuMYu2WhHYAODEv4j2RIq-gifYsd8ofkNfddvvLTEda70dn9AfXUZs5_fpunN6nUBCngCSAMREoOq_iX8rfceXbMsPKtpE6rQ-H13d3myoJcPUB1Hqh87BLZejDxX8FrSWqBPC-Ylw4KjQW07hWMI5QoF0a6FhIGeR3IwSoJyNLX0Vxy4hfcLAXI_i_8EWf4wDzGsNRwEHHV9uxSbV4yJkxg7H69Kc9C4ghHAsGYRL6zNN9XSn-HgyjFQVfGqiuqMreYjHdDx0kJifOPa9uoAP6U74XuRfbRKqHqvSEh70GF9kDGJ5StREpUmCiKjn7YaaYA1njfz0q8-KH0Ge8HIs_tCAp_PaOOdqqlahZEqh7QHjtVop9GNJB1CGbcJL-3AO-CDCVDwppSQl9Ezq-UbDf18cmVJRdQIcMpBvGJdM6MERg_hSWlyohrqcHsXnW6Xkdcno6WstysBR01mDzzVwibKlmUV6-5gdI6fsC4rZeLbYV3zglMmEtb0f86tnZQfvsSwyO8ObQq-0.UBaK_rd8Wpe0mwGt3vyypQ")
		                    .header("currencycode", "USD")
		                    .header("currencysymbol", "JA==")
		                    .header("language", "en")
		                    .header("platform", "3")
		                    .header("origin", "https://trulyfreehome.dev")

		                    .body(requestBody)

		                .when() // -------- WHEN (Action)
		                    .post("/v1/signUp")

		                .then() // -------- THEN (Validation)
		                    .log().all()
		                    .statusCode(200)
		                    .extract().response();

		        // Assertion
		        Assert.assertNotNull(response);
		        System.out.println("Signup Response: " + response.asString());

		
		

	}

}
