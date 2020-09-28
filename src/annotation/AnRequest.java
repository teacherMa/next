package annotation;

@Retrofit
public interface AnRequest {

    @Request
    void requestUserID(@Query("123") String key, String value);

}
