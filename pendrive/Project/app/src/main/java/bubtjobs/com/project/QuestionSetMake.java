package bubtjobs.com.project;

/**
 * Created by Murtuza on 3/14/2016.
 */
public class QuestionSetMake {
    private String question;
    private String op1;
    private String op2;
    private String op3;
    private String op4;
    private String answer;
    private String qustionId;

    public QuestionSetMake(){}

    public QuestionSetMake(String question,  String op1, String op2, String op3, String op4,String answer) {
        this.question = question;
        this.answer = answer;
        this.op4 = op4;
        this.op3 = op3;
        this.op2 = op2;
        this.op1 = op1;
    }

    public QuestionSetMake(String question, String op1, String op2, String op3, String op4, String answer,String qustionId) {
        this.question = question;

        this.op4 = op4;
        this.op3 = op3;
        this.op2 = op2;
        this.op1 = op1;
        this.answer = answer;
        this.qustionId=qustionId;
    }

    public String getQustionId() {
        return qustionId;
    }

    public void setQustionId(String qustionId) {
        this.qustionId = qustionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOp1() {
        return op1;
    }

    public void setOp1(String op1) {
        this.op1 = op1;
    }

    public String getOp2() {
        return op2;
    }

    public void setOp2(String op2) {
        this.op2 = op2;
    }

    public String getOp3() {
        return op3;
    }

    public void setOp3(String op3) {
        this.op3 = op3;
    }

    public String getOp4() {
        return op4;
    }

    public void setOp4(String op4) {
        this.op4 = op4;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
