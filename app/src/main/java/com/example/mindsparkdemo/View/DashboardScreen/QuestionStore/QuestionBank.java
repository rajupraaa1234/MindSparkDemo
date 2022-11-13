package com.example.mindsparkdemo.View.DashboardScreen.QuestionStore;

import com.example.mindsparkdemo.QuestionSet.MCQ;
import com.example.mindsparkdemo.R;

import java.util.ArrayList;

public class QuestionBank {

    ArrayList<MCQ> questionLit;
    QuestionBank(){
        questionLit = new ArrayList<>();
        loadQuestion();
    }

    private void loadQuestion(){
        MCQ mcq = new MCQ();
        mcq.setQuestion_num(1);
        mcq.setQuestion_body("What is ON the table?");
        //mcq.setQuestion_img("https://d2tl1spkm4qpax.cloudfront.net/content_images/WNC/WNC_qcode_23204_1.png");
        mcq.setQuestion_img(R.drawable.p1);
        mcq.setTotal_mcq_options(2);
        mcq.setMcq_1("book");
        mcq.setMcq_2("cat");
        mcq.setResult(1);
        questionLit.add(mcq);

        MCQ mcq2 = new MCQ();
        mcq2.setQuestion_num(2);
        mcq2.setQuestion_body("What is ON the chair?");
        mcq2.setQuestion_img(R.drawable.p2);
        //mcq2.setQuestion_img("https://d2tl1spkm4qpax.cloudfront.net/content_images/WNC/WNC_qcode_23230_1.png");
        mcq2.setTotal_mcq_options(2);
        mcq2.setMcq_1("ball");
        mcq2.setMcq_2("books");
        mcq2.setResult(1);
        questionLit.add(mcq2);


        MCQ mcq3 = new MCQ();
        mcq3.setQuestion_num(3);
        mcq3.setQuestion_body("What is UNDER the umbrella?");
        mcq3.setQuestion_img(R.drawable.p3);
        //mcq3.setQuestion_img("https://d2tl1spkm4qpax.cloudfront.net/content_images/WNC/WNC_qcode_23233_1.png");
        mcq3.setTotal_mcq_options(2);
        mcq3.setMcq_1("ball");
        mcq3.setMcq_2("frog");
        mcq3.setResult(2);
        questionLit.add(mcq3);


        MCQ mcq4 = new MCQ();
        mcq4.setQuestion_num(4);
        mcq4.setQuestion_body("Look at the number chart below.");
        mcq4.setQuestion_img(R.drawable.p4);
        //mcq4.setQuestion_img("https://d2tl1spkm4qpax.cloudfront.net/content_images/WNC/WNC_qcode_4351_1.png");
        mcq4.setTotal_mcq_options(4);
        mcq4.setQuestion_desc("Which is the number missing in the number chart above?");
        mcq4.setMcq_1("20");
        mcq4.setMcq_2("32");
        mcq4.setMc1_3("42");
        mcq4.setMcq_4("52");
        mcq4.setResult(2);
        questionLit.add(mcq4);


        MCQ mcq5 = new MCQ();
        mcq5.setQuestion_num(5);
        mcq5.setQuestion_body("Look at the number chart below.");
        mcq5.setQuestion_img(R.drawable.p5);
        //mcq5.setQuestion_img("https://d2tl1spkm4qpax.cloudfront.net/content_images/WNC/WNC_qcode_4357_1.png");
        mcq5.setTotal_mcq_options(4);
        mcq5.setQuestion_desc("Which are the numbers missing in the number chart above?");
        mcq5.setMcq_1("37 and 38");
        mcq5.setMcq_2("47 and 48");
        mcq5.setMc1_3("50 and 51");
        mcq5.setMcq_4("67 and 68");
        mcq5.setResult(2);
        questionLit.add(mcq5);

        MCQ mcq6 = new MCQ();
        mcq6.setQuestion_num(6);
        mcq6.setQuestion_body("");
        mcq6.setQuestion_img(-1);
        mcq6.setTotal_mcq_options(4);
        mcq6.setQuestion_desc("");
        mcq6.setMcq_1("it");
        mcq6.setMcq_2("ib");
        mcq6.setMc1_3("in");
        mcq6.setMcq_4("ic");
        mcq6.setResult(1);
        mcq6.setQuesInst(true);
        mcq6.setQuesVoice(true);
        mcq6.setQuesInstUrl("https://mindspark-lang.s3.amazonaws.com/qtypes/sounds_english/Listen%20and%20choose%20the%20correct%20option.mp3");
        mcq6.setGetVoiceUrl("https://mindspark-lang.s3.amazonaws.com/qtypes/sounds_english/it.mp3");
        questionLit.add(mcq6);


        MCQ mcq7 = new MCQ();
        mcq7.setQuestion_num(7);
        mcq7.setQuestion_body("Look at the picture and choose the first letter of the word.");
        mcq7.setQuestion_img(R.drawable.p7);
        //mcq7.setQuestion_img("https://mindspark-lang.s3.amazonaws.com/qtypes/images/water_n.png");
        mcq7.setTotal_mcq_options(4);
        mcq7.setQuestion_desc("");
        mcq7.setMcq_1("w");
        mcq7.setMcq_2("f");
        mcq7.setMc1_3("r");
        mcq7.setMcq_4("y");
        mcq7.setResult(1);
        mcq7.setQuesInst(true);
        mcq7.setQuesVoice(true);
        mcq7.setQuesInstUrl("https://mindspark-lang.s3.amazonaws.com/qtypes/sounds_english/Look%20at%20the%20picture%20and%20choose%20the%20first%20letter%20of%20the%20word.mp3");
        mcq7.setGetVoiceUrl("https://mindspark-lang.s3.amazonaws.com/qtypes/sounds_english/water.mp3");
        questionLit.add(mcq7);


        MCQ mcq8 = new MCQ();
        mcq8.setQuestion_num(8);
        mcq8.setQuestion_body("");
        mcq8.setQuestion_img(-1);
        mcq8.setTotal_mcq_options(4);
        mcq8.setQuestion_desc("");
        mcq8.setMcq_1("rub");
        mcq8.setMcq_2("pun");
        mcq8.setMc1_3("lit");
        mcq8.setMcq_4("cut");
        mcq8.setResult(4);
        mcq8.setQuesInst(true);
        mcq8.setQuesVoice(true);
        mcq8.setQuesInstUrl("https://mindspark-lang.s3.amazonaws.com/qtypes/sounds_english/Listen%20to%20the%20word%20and%20choose%20the%20correct%20option.mp3");
        mcq8.setGetVoiceUrl("https://mindspark-lang.s3.amazonaws.com/qtypes/sounds_english/cut.mp3");
        questionLit.add(mcq8);


        MCQ mcq9 = new MCQ();
        mcq9.setQuestion_num(9);
        mcq9.setQuestion_body("b_____");
        mcq9.setQuestion_img(-1);
        mcq9.setTotal_mcq_options(4);
        mcq9.setQuestion_desc("");
        mcq9.setMcq_1("ut");
        mcq9.setMcq_2("un");
        mcq9.setMc1_3("in");
        mcq9.setMcq_4("an");
        mcq9.setResult(2);
        mcq9.setQuesInst(true);
        mcq9.setQuesVoice(true);
        mcq9.setQuesInstUrl("https://mindspark-lang.s3.amazonaws.com/qtypes/sounds_english/Choose%20the%20correct%20option%20to%20make%20the%20word.mp3");
        mcq9.setGetVoiceUrl("https://mindspark-lang.s3.amazonaws.com/qtypes/sounds_english/bun.mp3");
        questionLit.add(mcq9);


        MCQ mcq10 = new MCQ();
        mcq10.setQuestion_num(10);
        mcq10.setQuestion_img(R.drawable.p10);
        mcq10.setQuestion_body("This is a tall _____.");
        //mcq10.setQuestion_img("https://mindspark-lang.s3.amazonaws.com/qtypes/images/horse_n.png");
        mcq10.setTotal_mcq_options(4);
        mcq10.setQuestion_desc("");
        mcq10.setMcq_1("horse");
        mcq10.setMcq_2("cow");
        mcq10.setMc1_3("zebra");
        mcq10.setMcq_4("lion");
        mcq10.setResult(1);
        mcq10.setQuesInst(true);
        mcq10.setQuesVoice(false);
        mcq10.setQuesInstUrl("https://mindspark-lang.s3.amazonaws.com/qtypes/sounds_english/Look%20at%20the%20picture%20and%20choose%20the%20correct%20word.mp3");
        mcq10.setGetVoiceUrl("");
        questionLit.add(mcq10);




    }

}
