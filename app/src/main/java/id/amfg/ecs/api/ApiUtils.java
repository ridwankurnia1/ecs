package id.amfg.ecs.api;

public class ApiUtils {
    private ApiUtils(){
    };

    public static final String BASE_URL = "http://172.18.44.66/apicore/";

    public static CoreApiInterface getCoreApi() {
        return CoreApi.getClient(BASE_URL).create(CoreApiInterface.class);
    }
}
