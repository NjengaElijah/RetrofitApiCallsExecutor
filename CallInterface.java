

import com.apps.muthoka.retailer.Models.ServerResponse;

/**
 * Created by NE on 18/02/2019.
 */

public interface CallInterface {
    void onStart();

    void onError(Exception error);

    void onComplete(ServerResponse response);
}
