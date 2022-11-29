package gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class User {

    public void creatorInfo(){

        JsonObject obj = new JsonObject();
        obj.addProperty("id",11);
        obj.addProperty("name","David Onel");
        obj.addProperty("username","David_New_@");
        obj.addProperty("email","google@gmail.com");

        JsonObject infoAboutAddress = new JsonObject();
        infoAboutAddress.addProperty("street", "Mitchael");
        infoAboutAddress.addProperty("suite", "Apr. 222");
        infoAboutAddress.addProperty("city", "Boston");
        infoAboutAddress.addProperty("zipcode", "12345-6789");

        JsonObject geo = new JsonObject();
        geo.addProperty("lat", "-38.2764848");
        geo.addProperty("Ing", "32.1341451");

        JsonObject infoAboutWebsite = new JsonObject();
        infoAboutWebsite.addProperty("phone", "554-2131-312");
        infoAboutWebsite.addProperty("website","google.com");

        JsonObject company = new JsonObject();
        company.addProperty("name", "Google");
        company.addProperty("catchPhrase", "Example");
        company.addProperty("bs", "e-enable extensible e-trailers");

        obj.add("address",infoAboutAddress);
        obj.add("geo", geo);
        infoAboutWebsite.add("company", company);


        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Gson gsonOne = new GsonBuilder().setPrettyPrinting().create();
        String jsonOne = gsonOne.toJson(infoAboutWebsite);

        String json = gson.toJson(obj);
        String together = json + jsonOne;


        try {
            OutputStream fos = new FileOutputStream("user.json");
            fos.write(together.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
