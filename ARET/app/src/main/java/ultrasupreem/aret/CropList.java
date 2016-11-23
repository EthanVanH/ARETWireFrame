package ultrasupreem.aret;


import org.json.*;

import java.io.InputStream;
import java.util.ArrayList;

public class CropList {
    ArrayList<Crop> crops;

    public CropList() {
        crops = new ArrayList<>();
    }

    public void parseCrops(InputStream getResponse){ // should be a JSONObject
        try {
            JSONArray arr = getResponse.getJSONObject("Crop").getString("CropName");
        }
        catch(JSONException e) {
            //response didnt parse so were putting in garbage data
            for (int i =0; i<10; i++) {
                Crop temp = new Crop(String.valueOf(i), "Crop type", "Crop Description: filler crop ","Crop instructions");
                crops.add(temp);
            }
        }
    }
}
