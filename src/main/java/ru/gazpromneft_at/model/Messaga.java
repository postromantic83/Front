package ru.gazpromneft_at.model;

public class Messaga {
    private Long id;
    private String messageText;

    public Messaga(Long id, String messageText) {
        this.id = id;
        this.messageText = messageText;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    @Override
    public String toString() {
        return "Messaga{" +
                "id=" + id +
                ", messageText='" + messageText + '\'' +
                '}';
    }
}
