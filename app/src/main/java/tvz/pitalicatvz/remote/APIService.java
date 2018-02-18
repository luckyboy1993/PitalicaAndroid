package tvz.pitalicatvz.remote;

import org.json.JSONArray;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import tvz.pitalicatvz.models.Exam;
import tvz.pitalicatvz.models.Question;
import tvz.pitalicatvz.models.QuestionResult;
import tvz.pitalicatvz.models.User;
import tvz.pitalicatvz.models.UserExamTaken;

/**
 * Created by Ivan on 2/3/2018.
 */

public interface APIService {

//region UserAPI
    @POST("/api/Users/TryGetUser")
    Call<User> tryGetUser(@Body User user);

    @GET("/api/Users")
    Call<List<User>> getUsers();

    @GET("/api/Users/{id}")
    Call<User> getUser(@Path("id") int id);

    @PUT("/api/Users/{id}")
    Call<User> putUser(@Path("id") int id, @Body User user);

    @POST("/api/Users")
    Call<User> postUser(@Body User user);

    @DELETE("/api/Users/{id}")
    Call<User> deleteUser(@Path("id") int id);
//endregion

//region ExamAPI
   /* @GET("/api/Exams")
    Call<List<Exam>> getExams();*/


    @GET("/api/Exams")
    Call<JSONArray> getExams();

    @GET("/api/Exams/{id}")
    Call<Exam> getExam(@Path("id") int id);

    @PUT("/api/Exams/{id}")
    Call<Exam> putExam(@Path("id") int id, @Body Exam exam);

    @POST("/api/Exams")
    Call<Exam> postExam(@Body Exam exam);

    @DELETE("/api/Exams/{id}")
    Call<Exam> deleteExam(@Path("id") int id);

    @GET("/api/Exams/getExamsTakenByUserId/{id}")
    Call<List<Exam>> getExamsTakenByUserId(@Path("id") int id);

//endregion

//region QuestionResultAPI
    @GET("/api/QuestionResults")
    Call<List<QuestionResult>> getQuestionResults();

    @GET("/api/QuestionResults/{id}")
    Call<QuestionResult> getQuestionResult(@Path("id") int id);

    @PUT("/api/QuestionResults/{id}")
    Call<QuestionResult> putQuestionResult(@Path("id") int id, @Body QuestionResult questionResult);

    @POST("/api/QuestionResults")
    Call<QuestionResult> postQuestionResult(@Body QuestionResult questionResult);

    @DELETE("/api/QuestionResults/{id}")
    Call<QuestionResult> deleteQuestionResult(@Path("id") int id);
//endregion

//region QuestionAPI
    @GET("/api/Questions")
    Call<List<Question>> getQuestions();

    @GET("/api/Questions/{id}")
    Call<Question> getQuestion(@Path("id") int id);

    @PUT("/api/Questions/{id}")
    Call<Question> putQuestion(@Path("id") int id, @Body Question question);

    @POST("/api/Questions")
    Call<Question> postQuestion(@Body Question question);

    @DELETE("/api/Questions/{id}")
    Call<Question> deleteQuestion(@Path("id") int id);
//endregion

//region UserExamTakenAPI
    @GET("/api/UserExamTakens")
    Call<List<UserExamTaken>> getUserExamTakens();

    @GET("/api/UserExamTakens/{id}")
    Call<UserExamTaken> getUserExamTaken(@Path("id") int id);

    @PUT("/api/UserExamTakens/{id}")
    Call<UserExamTaken> putUserExamTaken(@Path("id") int id, @Body UserExamTaken userExamTaken);

    @POST("/api/UserExamTakens")
    Call<UserExamTaken> postUserExamTaken(@Body UserExamTaken userExamTaken);

    @DELETE("/api/UserExamTakens/{id}")
    Call<UserExamTaken> deleteUserExamTaken(@Path("id") int id);
//endregion
}