import com.example.groupassessmentproject.models.DataApp
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("AppData")
    fun getData(): Call<DataApp>
}
