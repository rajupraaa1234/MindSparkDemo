package com.example.mindsparkdemo.QuestionSet;

import android.graphics.drawable.Drawable;

public class MCQ {

    private int question_num;
    private String question_body;
    private int question_img;
    private String question_desc;
    private int total_mcq_options;
    private String mcq_1;
    private String mcq_2;
    private String mc1_3;
    private String mcq_4;
    private boolean quesInst;
    private boolean quesVoice;

    public void setQuesInst(boolean quesInst) {
        this.quesInst = quesInst;
    }

    public void setQuesVoice(boolean quesVoice) {
        this.quesVoice = quesVoice;
    }

    public void setQuesInstUrl(String quesInstUrl) {
        this.quesInstUrl = quesInstUrl;
    }

    public void setGetVoiceUrl(String getVoiceUrl) {
        this.getVoiceUrl = getVoiceUrl;
    }

    private String quesInstUrl;
    private String getVoiceUrl;

    public boolean isQuesInst() {
        return quesInst;
    }

    public boolean isQuesVoice() {
        return quesVoice;
    }

    public String getQuesInstUrl() {
        return quesInstUrl;
    }

    public String getGetVoiceUrl() {
        return getVoiceUrl;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    private int result;

    public MCQ() {
        this.quesInst = false;
        this.quesVoice = false;
    }

    public int getQuestion_num() {
        return question_num;
    }

    public String getQuestion_body() {
        return question_body;
    }

    public int getQuestion_img() {
        return question_img;
    }

    @Override
    public String toString() {
        return "MCQ{" +
                "question_num=" + question_num +
                ", question_body='" + question_body + '\'' +
                ", question_img='" + question_img + '\'' +
                ", question_desc='" + question_desc + '\'' +
                ", total_mcq_options=" + total_mcq_options +
                ", mcq_1='" + mcq_1 + '\'' +
                ", mcq_2='" + mcq_2 + '\'' +
                ", mc1_3='" + mc1_3 + '\'' +
                ", mcq_4='" + mcq_4 + '\'' +
                '}';
    }

    public String getQuestion_desc() {
        return question_desc;
    }

    public int getTotal_mcq_options() {
        return total_mcq_options;
    }

    public String getMcq_1() {
        return mcq_1;
    }

    public String getMcq_2() {
        return mcq_2;
    }

    public String getMc1_3() {
        return mc1_3;
    }

    public String getMcq_4() {
        return mcq_4;
    }

    public MCQ(int question_num, String question_body, int question_img, String question_desc, int total_mcq_options, String mcq_1, String mcq_2, String mc1_3, String mcq_4) {
        this.question_num = question_num;
        this.question_body = question_body;
        this.question_img = question_img;
        this.question_desc = question_desc;
        this.total_mcq_options = total_mcq_options;
        this.mcq_1 = mcq_1;
        this.mcq_2 = mcq_2;
        this.mc1_3 = mc1_3;
        this.mcq_4 = mcq_4;
    }

    public void setQuestion_num(int question_num) {
        this.question_num = question_num;
    }

    public void setQuestion_body(String question_body) {
        this.question_body = question_body;
    }

    public void setQuestion_img(int question_img) {
        this.question_img = question_img;
    }

    public void setQuestion_desc(String question_desc) {
        this.question_desc = question_desc;
    }

    public void setTotal_mcq_options(int total_mcq_options) {
        this.total_mcq_options = total_mcq_options;
    }

    public void setMcq_1(String mcq_1) {
        this.mcq_1 = mcq_1;
    }

    public void setMcq_2(String mcq_2) {
        this.mcq_2 = mcq_2;
    }

    public void setMc1_3(String mc1_3) {
        this.mc1_3 = mc1_3;
    }

    public void setMcq_4(String mcq_4) {
        this.mcq_4 = mcq_4;
    }
}
