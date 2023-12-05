/*
Liam Fortin, Kyle Pasta, Micah Ridler
A class containing a question and its corresponding answer. One is able to edit and obtain the question and answer, clone, and compare for equality between instances.
 */
package unit6studynote;

public class Question {
    //attributes
    public String answer;
    public String question;


    /**
     * primary constructor
     * @param answer - the correct answer
     * @param question - the question
     */
    public Question(String answer, String question) {
        this.question = question;
        this.answer = answer;
    }

    /**
     * mutate the question
     * @param q - the new question
     */
    public void setQuestion(String q) {
        this.question = q;
    }

    /**
     * mutate the answer
     * @param a - the new answer
     */
    public void setAnswer(String a) {
        this.answer = a;
    }

    /**
     * access and return the answer
     * @return the answer
     */
    public String getAnswer() {
        return this.answer;
    }

    /**
     * access and return the question
     * @return the question
     */
    public String getQuestion() {
        return this.question;
    }

    /**
     * return an identical question
     * @return an identical question
     */
    public Question clone() {
        return new Question(answer, question);
    }

    /**
     * determine if the question is the same
     * @param q the question being compared
     * @return if the question is the same
     */
    public boolean equals(Question q) {
        return this.answer.equals(q.answer) && this.question.equals(q.question);
    }

    /**
     * return a string containing the contents of the class
     * @return -  the class represented as a string
     */
    public String toString() {
        return "Question: " + this.question + "\nAnswer: "+ this.question;
    }
}
