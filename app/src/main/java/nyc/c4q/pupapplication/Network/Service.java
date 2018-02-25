package nyc.c4q.pupapplication.Network;

import nyc.c4q.pupapplication.model.Dogs;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by AmyRivera on 2/25/18.
 */

public interface Service {
    @GET("api/breed/{breed-name}/image/random")
    Call<Dogs> getPuppy();

}
