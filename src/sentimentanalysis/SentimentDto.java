/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sentimentanalysis;

/**
 *
 * @author luya
 */
public class SentimentDto {
    
    private Integer MessageId;

    /**
     * Get the value of MessageId
     *
     * @return the value of MessageId
     */
    public Integer getMessageId() {
        return MessageId;
    }

    /**
     * Set the value of MessageId
     *
     * @param MessageId new value of MessageId
     */
    public void setMessageId(Integer MessageId) {
        this.MessageId = MessageId;
    }

        private Integer Score;

    /**
     * Get the value of Score
     *
     * @return the value of Score
     */
    public Integer  getScore() {
        return Score;
    }

    /**
     * Set the value of Score
     *
     * @param Score new value of Score
     */
    public void setScore(Integer Score) {
        this.Score = Score;
    }

        private String Sentence;

    /**
     * Get the value of Sentence
     *
     * @return the value of Sentence
     */
    public String getSentence() {
        return Sentence;
    }

    /**
     * Set the value of Sentence
     *
     * @param Sentence new value of Sentence
     */
    public void setSentence(String Sentence) {
        this.Sentence = Sentence;
    }
    private String Sentiment;

    /**
     * Get the value of Sentiment
     *
     * @return the value of Sentiment
     */
    public String getSentiment() {
        return Sentiment;
    }

    /**
     * Set the value of Sentiment
     *
     * @param Sentiment new value of Sentiment
     */
    public void setSentiment(String Sentiment) {
        this.Sentiment = Sentiment;
    }
      private double veryNegative;

    /**
     * Get the value of veryNegative
     *
     * @return the value of veryNegative
     */
    public double getVeryNegative() {
        return veryNegative;
    }

    /**
     * Set the value of veryNegative
     *
     * @param veryNegative new value of veryNegative
     */
    public void setVeryNegative(double veryNegative) {
        this.veryNegative = veryNegative;
    }
    private double negative;

    /**
     * Get the value of negative
     *
     * @return the value of negative
     */
    public double getNegative() {
        return negative;
    }

    /**
     * Set the value of negative
     *
     * @param negative new value of negative
     */
    public void setNegative(double negative) {
        this.negative = negative;
    }
    private double neutral;

    /**
     * Get the value of neutral
     *
     * @return the value of neutral
     */
    public double getNeutral() {
        return neutral;
    }

    /**
     * Set the value of neutral
     *
     * @param neutral new value of neutral
     */
    public void setNeutral(double neutral) {
        this.neutral = neutral;
    }
    private double positive;

    /**
     * Get the value of positive
     *
     * @return the value of positive
     */
    public double getPositive() {
        return positive;
    }

    /**
     * Set the value of positive
     *
     * @param positive new value of positive
     */
    public void setPositive(double positive) {
        this.positive = positive;
    }
    private double veryPositive;

    /**
     * Get the value of veryPositive
     *
     * @return the value of veryPositive
     */
    public double getVeryPositive() {
        return veryPositive;
    }

    /**
     * Set the value of veryPositive
     *
     * @param veryPositive new value of veryPositive
     */
    public void setVeryPositive(double veryPositive) {
        this.veryPositive = veryPositive;
    }


}
