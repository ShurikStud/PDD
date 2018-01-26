package com.example.shurik.pdd.test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shurik on 11.12.2017.
 */

public class TestObject {

    class Question {
        private int id;
        private String value;

        public Question(int id, String value) {
            this.id = id;
            this.value = value;
        }
    }

    private String description;
    private int id;

    private List<Question> variants;

    private List<Integer> true_variants;

    public TestObject() {}

    public TestObject(int id, String description) {
        this.id = id;
        this.description = description;
        variants    = new ArrayList<Question>();
        true_variants   = new ArrayList<Integer>();
    }

    public void addVariant(int id, String variant){
        if (!(variant == null))
            variants.add(new Question(id, variant));
    }

    public void addTrueVariant(int id){
        if (!(true_variants == null))
            true_variants.add(id);
    }

    public String getDescription() {
        // возвращает описание вопроса
        return description;
    }

    public int getVariantCount(){
        // возвращает количество вариантов ответов на вопрос

        if (!(variants == null)){
            return variants.size();
        } else {
            return 0;
        }
    }

    public String getVariant(int position){

        if (position >= 0 && position < variants.size()){
            return variants.get(position).value;
        }else{
            return "";
        }

    }

    public boolean isTrueAllAnswers(List<Integer> answers){

        if ( (answers.containsAll(true_variants)) && (true_variants.containsAll(answers)) ){
            return true;
        } else {
            return false;
        }

    }

    public String getImagePath(){
        return "@drawable/test" + id;
    }

}

