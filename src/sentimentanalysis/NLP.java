/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sentimentanalysis;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.ejml.simple.SimpleMatrix;

public class NLP {

    static StanfordCoreNLP pipeline;

    public static void init() {
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, parse,sentiment");       
        //props.put("sentiment.model", "english.all.3class.distsim.crf.ser.gz");       
        pipeline = new StanfordCoreNLP(props);
    }

    public static List<SentimentDto> findSentiment(Message msg) {

        List<SentimentDto> results = new ArrayList<SentimentDto>();
        int mainSentiment = 0;
        if (msg != null && msg.Content.length() > 0) {
            int longest = 0;
            Annotation annotation = pipeline.process(msg.Content);
            for (CoreMap sentence : annotation
                    .get(CoreAnnotations.SentencesAnnotation.class)) {
                Tree tree = sentence
                        .get(SentimentCoreAnnotations.SentimentAnnotatedTree.class);
                int sentimentScore = RNNCoreAnnotations.getPredictedClass(tree);
                String sentiment = sentence.get(SentimentCoreAnnotations.SentimentClass.class);
                SimpleMatrix sentimentCoefficients = RNNCoreAnnotations.getPredictions(tree);
                double veryNegative = sentimentCoefficients.get(0);
                double negative = sentimentCoefficients.get(1);
                double neutral = sentimentCoefficients.get(2);
                double positive = sentimentCoefficients.get(3);
                double veryPositive = sentimentCoefficients.get(4);
                SentimentDto sdto = new SentimentDto();
                sdto.setMessageId(msg.MessageId);
                sdto.setScore(sentimentScore);
                sdto.setSentence(sentence.toString());
                sdto.setSentiment(sentiment);
                sdto.setNegative(negative);
                sdto.setNeutral(neutral);
                sdto.setPositive(positive);
                sdto.setVeryPositive(veryPositive);
                sdto.setVeryNegative(veryNegative);
                results.add(sdto);
            }
        }
        return results;
    }
}
