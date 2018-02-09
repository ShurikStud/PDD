package com.example.shurik.pdd.users_PDD;

import com.example.shurik.pdd.exam.Exam;
import com.example.shurik.pdd.exam.Exams;
import com.example.shurik.pdd.test.TestObject;
import com.example.shurik.pdd.test.TestObjectList;

import java.util.ArrayList;

/**
 * Created by shurik on 11.11.2017.
 */

public class UserPDD {

    //private int id;
    private String name;
    private String login;
    private String password;

    private Exams   exams; // результаты экзаменов и сервисные функции

//    public UserPDD(int id, String name, String login, String password) {
    public UserPDD(String name, String login, String password) {
        //this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;

        this.exams  = new Exams();
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() { return password; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean existCurrentExam(){

        if (exams.getCurrentExam() == null){
            return false;
        } else {
            return true;
        }
    }

    public void startNewExam(TestObjectList testObjectList){
        ArrayList<TestObject> testObjectArrayList = (ArrayList<TestObject>) testObjectList.generateNewTestList();
        exams.startNewExam(testObjectArrayList);
    }

    public Exam getCurrentExam(){
        return exams.getCurrentExam();
    }

    public void completeCurrentExam(){exams.completeCurrentExam();}

    public ArrayList<Exam> getCompleteExams(){

        return exams.getCompleteExams();

    }

    @Override
    public String toString() {
//        return "UserPDD{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", login='" + login + '\'' +
//                ", password='" + password + '\'' +
//                '}';
        return "UserPDD{" +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
