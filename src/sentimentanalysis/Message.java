/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sentimentanalysis;

/**
 *
 * @author luya
 */
public class Message {
    
        public Integer MessageId;

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
       public String Content;

    /**
     * Get the value of Content
     *
     * @return the value of Content
     */
    public String getContent() {
        return Content;
    }

    /**
     * Set the value of Content
     *
     * @param Content new value of Content
     */
    public void setContent(String Content) {
        this.Content = Content;
    }

    
}
