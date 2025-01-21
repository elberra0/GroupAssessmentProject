import com.example.groupassessmentproject.models.remote.WorkoutPlan
import com.example.groupassessmentproject.models.DataApp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("AppData")
    fun getData(): Call<DataApp>
    @GET("GetPlanById")
    suspend fun getPlanById(@Query("id") planId: Int): WorkoutPlan
}
