package com.kitesurfing.ab4challenge;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Ab4challengeApplicationTests {

	@Test
	public void getAllSpots() throws JSONException, IOException {
		StringBuilder response = new StringBuilder();
		try {
			URL url = new URL("http://0.0.0.0:8080/api/spots");
			HttpURLConnection c = (HttpURLConnection)  url.openConnection();
			c.setRequestProperty("Accept", "application/json");


			InputStreamReader in = new InputStreamReader(c.getInputStream(), "UTF-8");
			BufferedReader br = new BufferedReader(in);
			String inputLine;
			while ((inputLine = br.readLine()) != null)
				response.append(inputLine);
			c.disconnect();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		JSONArray array = new JSONArray(response.toString());
		System.out.println(array);

		Assert.assertEquals(17, array.length());
	}

	@Test
	public void getSpotById() throws JSONException, IOException {
		StringBuilder response = new StringBuilder();
		try {
			URL url = new URL("http://0.0.0.0:8080/api/spots/5fbfacd6fee866d65e6b74cc");
			HttpURLConnection c = (HttpURLConnection)  url.openConnection();
			c.setRequestProperty("Accept", "application/json");


			InputStreamReader in = new InputStreamReader(c.getInputStream(), "UTF-8");
			BufferedReader br = new BufferedReader(in);
			String inputLine;
			while ((inputLine = br.readLine()) != null)
				response.append(inputLine);
			c.disconnect();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		JSONObject array = new JSONObject(response.toString());
		String actual_obj = "{\"country\":\"Spain\",\"mainWindDir\":\"South\",\"prefWind\":null,\"mainWindKts\":6,\"latitude\":2.248431811259025,\"airTemp\":[\"11\",\"11\",\"13\",\"15\",\"18\",\"23\",\"26\",\"25\",\"22\",\"20\",\"15\",\"12\"]," +
				"\"windProbability\":\"79\",\"waveHeightMeter\":\"1\",\"shortDescription\":\"A favourite summer haunt in Garbí, " +
				"which blows even stronger here than on the beaches of central Barcelona or further north. Outside of high-season kiting is allowed on this wide sandy beach, the best launch is in front of Club Natació on " +
				"'Platja dels Pescadors' or 500m north at Club Bétulo on 'Platja del Pont d'en Botifarreta'. \",\"waveDirection\":\"East\",\"cleanWater\":\"very, very nasty\"," +
				"\"waterTemp\":[\"9\",\"9\",\"11\",\"13\",\"16\",\"21\",\"24\",\"23\",\"20\",\"18\",\"13\",\"10\"],\"imageUrls\":[\"https:\\/\\/www.wispsports.com\\/wp-content\\/uploads\\/2016\\/03\\/Kiteboarding.jpg\"," +
				"\"https:\\/\\/cdn11.bigcommerce.com\\/s-cam6oqe\\/product_images\\/uploaded_images\\/womens-kiteboards.png\",\"https:\\/\\/lh3.googleusercontent.com\\/proxy\\/iR_A2BErYlS0_lzxZKss4utN8msnrxB7HQyOuaQezg4yj6jU-Vbw4VcAFSmP7zY8MohmRvaDZ2KC3dFNFK3dsOpc_gh9RMbS9Dnmi8oxjUMMBHwTg_6jHfNrL8D7R5DCr5yFTQ\"]," +
				"\"name\":\"Vilanova\",\"temperature\":\"18\",\"locationCatalonianCoast\":\"Central\",\"location\":\"Central\",\"_id\":\"5fbfacd6fee866d65e6b74cc\",\"windDirection\":\"South\",\"windSpeed\":6,\"averageAirTemp\":\"18\",\"whenToGo\":\"April\",\"longitude\":41.44347600813171}";

		Assert.assertEquals(actual_obj, array.toString());
	}

	@Test
	public void similarSpots() throws JSONException, IOException {
		StringBuilder response = new StringBuilder();
		try {
			URL url = new URL("http://0.0.0.0:8080/api/similar-spots/5fbfacd6fee866d65e6b74cc");
			HttpURLConnection c = (HttpURLConnection)  url.openConnection();
			c.setRequestProperty("Accept", "application/json");


			InputStreamReader in = new InputStreamReader(c.getInputStream(), "UTF-8");
			BufferedReader br = new BufferedReader(in);
			String inputLine;
			while ((inputLine = br.readLine()) != null)
				response.append(inputLine);
			c.disconnect();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		JSONArray array = new JSONArray(response.toString());

		Assert.assertTrue(array.length() == 3);

	}

	@Test
	public void search() throws JSONException {
		StringBuilder response = new StringBuilder();
		try {
			URL url = new URL("http://192.168.65.129:8080/api/search?temperature=20&location=South&windSpeed=20&windDirection=North");
			HttpURLConnection c = (HttpURLConnection)  url.openConnection();
			c.setRequestProperty("Accept", "application/json");


			InputStreamReader in = new InputStreamReader(c.getInputStream(), "UTF-8");
			BufferedReader br = new BufferedReader(in);
			String inputLine;
			while ((inputLine = br.readLine()) != null)
				response.append(inputLine);
			c.disconnect();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		JSONArray array = new JSONArray(response.toString());
		Assert.assertTrue(array.length() == 13);
	}



}
